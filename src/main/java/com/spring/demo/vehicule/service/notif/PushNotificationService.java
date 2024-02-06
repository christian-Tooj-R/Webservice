package com.spring.demo.vehicule.service.notif;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.spring.demo.vehicule.model.notif.PushNotificationRequest;

@Service
public class PushNotificationService {

    private final String FCM_API = "https://fcm.googleapis.com/fcm/send";
    private final String SERVER_KEY = "917572767805";

    public void sendPushNotification(String deviceToken, String title, String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "key=" + SERVER_KEY);

        PushNotificationRequest pushNotificationRequest = new PushNotificationRequest();
        pushNotificationRequest.setTo(deviceToken);
        pushNotificationRequest.setTitle(title);
        pushNotificationRequest.setMessage(message);

        HttpEntity<PushNotificationRequest> request = new HttpEntity<>(pushNotificationRequest, headers);
        new RestTemplate().postForObject(FCM_API, request, String.class);
    }
}
