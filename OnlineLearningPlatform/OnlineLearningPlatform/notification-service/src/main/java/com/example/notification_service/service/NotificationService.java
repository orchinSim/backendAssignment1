package com.example.notification_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notification_service.model.Notification;
import com.example.notification_service.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
	public String sendNotification(String message) {
		System.out.println("Notification received: " + message);
		
		 Notification notification = new Notification();
	        notification.setMessage(message);
	        notificationRepository.save(notification);

	        return "Notification sent successfully!";
		
	}
	
}
