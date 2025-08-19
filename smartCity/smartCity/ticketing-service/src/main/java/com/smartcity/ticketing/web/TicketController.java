package com.smartcity.ticketing.web;

import com.smartcity.ticketing.events.TicketPurchasedEvent;
import com.smartcity.ticketing.events.TicketValidatedEvent;
import com.smartcity.ticketing.model.Ticket;
import com.smartcity.ticketing.model.Validation;
import com.smartcity.ticketing.repo.TicketRepository;
import com.smartcity.ticketing.repo.ValidationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.NotBlank;

import java.net.URI;
import java.time.Instant;
import java.util.*;

@RestController
public class TicketController {

    private final TicketRepository ticketRepo;
    private final ValidationRepository validationRepo;
    private final KafkaTemplate<String,Object> kafka;

    // ✅ Constructor injection (manual, no Lombok)
    public TicketController(TicketRepository ticketRepo,
                            ValidationRepository validationRepo,
                            KafkaTemplate<String,Object> kafka) {
        this.ticketRepo = ticketRepo;
        this.validationRepo = validationRepo;
        this.kafka = kafka;
    }

    // Purchase (simple simulation)
    @PostMapping("/tickets/purchase")
    public ResponseEntity<?> purchase(@RequestBody PurchaseRequest req) {
        // simulate payment success (replace with real payment integration later)
        Ticket t = new Ticket();
        t.setId(UUID.randomUUID().toString());
        t.setUserId(req.getUserId());
        t.setRouteId(req.getRouteId());
        t.setIssuedAt(Instant.now());
        t.setFare(req.getFare());
        t.setCurrency(req.getCurrency()==null? "INR" : req.getCurrency());
        t.setStatus("purchased");
        ticketRepo.save(t);

        // publish event
        TicketPurchasedEvent ev = new TicketPurchasedEvent();
        ev.ticketId = t.getId(); ev.userId = t.getUserId(); ev.routeId = t.getRouteId();
        ev.fare = t.getFare(); ev.currency = t.getCurrency(); ev.ts = Instant.now().toString();
        kafka.send("ticket.purchased.v1", t.getId(), ev);

        return ResponseEntity.created(URI.create("/tickets/" + t.getId())).body(t);
    }

    // Idempotent validation
    @PostMapping("/tickets/{id}/validate")
    public ResponseEntity<?> validate(@PathVariable String id,
                                      @RequestHeader(name="Idempotency-Key", required=false) String idem,
                                      @RequestBody ValidatePayload body) {
        if (idem != null) {
            Optional<Validation> existing = validationRepo.findByRequestId(idem);
            if (existing.isPresent()) {
                Validation ex = existing.get();
                // compare payload for "same" check (ticketId,vehicle,stop,validator)
                boolean same = Objects.equals(ex.getTicketId(), id)
                        && Objects.equals(ex.getVehicleId(), body.getVehicleId())
                        && Objects.equals(ex.getStopId(), body.getStopId())
                        && Objects.equals(ex.getValidatorDeviceId(), body.getValidatorDeviceId());
                if (same) {
                    return ResponseEntity.ok(ex); // duplicate with same outcome
                } else {
                    return ResponseEntity.status(409).body("Duplicate idempotency key with different payload");
                }
            }
        }

        Validation v = new Validation();
        v.setId(UUID.randomUUID().toString());
        v.setRequestId(idem==null? UUID.randomUUID().toString() : idem);
        v.setTicketId(id);
        v.setVehicleId(body.getVehicleId());
        v.setStopId(body.getStopId());
        v.setValidatorDeviceId(body.getValidatorDeviceId());
        v.setValidatedAt(Instant.now());
        v.setOk(true);
        validationRepo.save(v);

        // publish event
        TicketValidatedEvent ev = new TicketValidatedEvent();
        ev.ticketId = id; ev.vehicleId = body.getVehicleId(); ev.stopId = body.getStopId();
        ev.ok = true; ev.ts = Instant.now().toString();
        kafka.send("ticket.validated.v1", id, ev);

        return ResponseEntity.accepted().location(URI.create("/validations/" + v.getId())).body(v);
    }

    @GetMapping("/users/{userId}/tickets")
    public List<Ticket> userTickets(@PathVariable String userId, @RequestParam(required=false) String status) {
        if (status == null) return ticketRepo.findByUserId(userId);
        return ticketRepo.findByUserIdAndStatus(userId, status);
    }

    // DTOs
    public static class PurchaseRequest {
        private String userId;
        private String routeId;
        private Double fare;
        private String currency;
        private String paymentToken;

        public String getUserId() {
            return userId;
        }
        public void setUserId(String userId) {
            this.userId = userId;
        }
        public String getRouteId() {
            return routeId;
        }
        public void setRouteId(String routeId) {
            this.routeId = routeId;
        }
        public Double getFare() {
            return fare;
        }
        public void setFare(Double fare) {
            this.fare = fare;
        }
        public String getCurrency() {
            return currency;
        }
        public void setCurrency(String currency) {
            this.currency = currency;
        }
        public String getPaymentToken() {
            return paymentToken;
        }
        public void setPaymentToken(String paymentToken) {
            this.paymentToken = paymentToken;
        }
    }

    public static class ValidatePayload {
        @NotBlank private String validatorDeviceId;
        @NotBlank private String vehicleId;
        @NotBlank private String stopId;

        public String getValidatorDeviceId() {
            return validatorDeviceId;
        }
        public void setValidatorDeviceId(String validatorDeviceId) {
            this.validatorDeviceId = validatorDeviceId;
        }
        public String getVehicleId() {
            return vehicleId;
        }
        public void setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
        }
        public String getStopId() {
            return stopId;
        }
        public void setStopId(String stopId) {
            this.stopId = stopId;
        }
    }
}
