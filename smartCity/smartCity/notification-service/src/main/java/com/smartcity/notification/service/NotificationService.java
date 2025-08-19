package com.smartcity.notification.service;

import com.smartcity.notification.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(Notification notification) {
        // For now, just log the notification
        System.out.println("📢 Sending " + notification.getChannel() +
                           " notification to User " + notification.getUserId() +
                           ": " + notification.getMessage());
    }
}
