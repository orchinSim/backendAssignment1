package com.smartcity.ticketing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("ticket")
public class Ticket {
  @Id private String id;
  private String userId;
  private String routeId;
  private Instant issuedAt;
  private Double fare;
  private String currency;
  private String status; // purchased, used, refunded
  public String getId() {
	return id;
  }
  public void setId(String id) {
	this.id = id;
  }
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
  public Instant getIssuedAt() {
	return issuedAt;
  }
  public void setIssuedAt(Instant issuedAt) {
	this.issuedAt = issuedAt;
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
  public String getStatus() {
	return status;
  }
  public void setStatus(String status) {
	this.status = status;
  }
  
  
}
