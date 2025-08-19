package com.example.notification_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification_service.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam String message) {
        return notificationService.sendNotification(message);
	
}
}