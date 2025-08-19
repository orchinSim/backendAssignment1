package com.example.user_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
@Bean
public NewTopic userEnrolledTopic() {
	return TopicBuilder.name("user-enrolled")
						.build();
}

}	
