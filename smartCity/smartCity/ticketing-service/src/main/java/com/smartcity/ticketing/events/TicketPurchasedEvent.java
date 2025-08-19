package com.smartcity.ticketing.events;
public class TicketPurchasedEvent {
  public String ticketId, userId, routeId, currency, ts;
  public Double fare;
}
