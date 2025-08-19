package com.smartcity.ticketing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.Set;

@Document("pass")
public class Pass {
  @Id private String id;
  private String userId;
  private String type; // single, day, monthly
  private Instant validFrom;
  private Instant validTo;
  private Set<String> zones;
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
  public String getType() {
	return type;
  }
  public void setType(String type) {
	this.type = type;
  }
  public Instant getValidFrom() {
	return validFrom;
  }
  public void setValidFrom(Instant validFrom) {
	this.validFrom = validFrom;
  }
  public Instant getValidTo() {
	return validTo;
  }
  public void setValidTo(Instant validTo) {
	this.validTo = validTo;
  }
  public Set<String> getZones() {
	return zones;
  }
  public void setZones(Set<String> zones) {
	this.zones = zones;
  }
  
}
