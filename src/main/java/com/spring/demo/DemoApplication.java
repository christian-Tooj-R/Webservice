package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;


@SpringBootApplication
public class DemoApplication {
	@Bean
	FirebaseMessaging firebaseMessaging()throws Exception{
		GoogleCredentials googleCredentials = GoogleCredentials
		.fromStream(new ClassPathResource("pushnotification-75bd7-firebase-adminsdk-ck2lr-c052048796.json").getInputStream());
		FirebaseOptions firebaseOptions = FirebaseOptions.builder()
		.setCredentials(googleCredentials).build();
		FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions,"Vehicule");
		return FirebaseMessaging.getInstance(app);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
 