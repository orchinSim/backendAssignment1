package com.smartcity.ticketing.repo;

import com.smartcity.ticketing.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    List<Ticket> findByUserIdAndStatus(String userId, String status);
    List<Ticket> findByUserId(String userId);
}
