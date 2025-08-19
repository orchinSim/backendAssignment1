package com.smartcity.ticketing.events;
public class TicketValidatedEvent {
  public String ticketId, vehicleId, stopId, ts;
  public Boolean ok;
}
