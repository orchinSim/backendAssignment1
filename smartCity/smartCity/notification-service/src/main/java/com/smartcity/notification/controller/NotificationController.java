package com.smartcity.notification.controller;

import com.smartcity.notification.model.Notification;
import com.smartcity.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public String send(@RequestBody Notification notification) {
        notificationService.sendNotification(notification);
        return "Notification sent!";
    }
}
