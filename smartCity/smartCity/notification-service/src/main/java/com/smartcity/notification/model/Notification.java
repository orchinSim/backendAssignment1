package com.smartcity.notification.model;

public class Notification {
    private String id;
    private String userId;
    private String message;
    private String channel; // EMAIL, SMS, CONSOLE

    // Manual getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
}
