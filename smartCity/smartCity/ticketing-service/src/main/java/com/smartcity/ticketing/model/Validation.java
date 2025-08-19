package com.smartcity.ticketing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("validation")
public class Validation {
  @Id private String id;
  @Indexed(unique=true)
  private String requestId;
  private String ticketId;
  private String vehicleId;
  private String stopId;
  private Instant validatedAt;
  private String validatorDeviceId;
  private Boolean ok;
  public String getId() {
	return id;
  }
  public void setId(String id) {
	this.id = id;
  }
  public String getRequestId() {
	return requestId;
  }
  public void setRequestId(String requestId) {
	this.requestId = requestId;
  }
  public String getTicketId() {
	return ticketId;
  }
  public void setTicketId(String ticketId) {
	this.ticketId = ticketId;
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
  public Instant getValidatedAt() {
	return validatedAt;
  }
  public void setValidatedAt(Instant validatedAt) {
	this.validatedAt = validatedAt;
  }
  public String getValidatorDeviceId() {
	return validatorDeviceId;
  }
  public void setValidatorDeviceId(String validatorDeviceId) {
	this.validatorDeviceId = validatorDeviceId;
  }
  public Boolean getOk() {
	return ok;
  }
  public void setOk(Boolean ok) {
	this.ok = ok;
  }
  
}
