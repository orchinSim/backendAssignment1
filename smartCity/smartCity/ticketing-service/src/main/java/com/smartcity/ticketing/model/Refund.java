package com.smartcity.ticketing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("refund")
public class Refund {
  @Id private String id;
  private String ticketId;
  private String reason;
  private Instant requestedAt;
  private String status; // pending, approved, rejected
  
  public String getId() {
	return id;
  }
  public void setId(String id) {
	this.id = id;
  }
  public String getTicketId() {
	return ticketId;
  }
  public void setTicketId(String ticketId) {
	this.ticketId = ticketId;
  }
  public String getReason() {
	return reason;
  }
  public void setReason(String reason) {
	this.reason = reason;
  }
  public Instant getRequestedAt() {
	return requestedAt;
  }
  public void setRequestedAt(Instant requestedAt) {
	this.requestedAt = requestedAt;
  }
  public String getStatus() {
	return status;
  }
  public void setStatus(String status) {
	this.status = status;
  }
}
