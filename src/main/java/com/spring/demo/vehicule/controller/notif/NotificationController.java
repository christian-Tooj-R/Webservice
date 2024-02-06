package com.spring.demo.vehicule.controller.notif;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.api.APIResponse;
import com.spring.demo.vehicule.model.annonce.Annonce;
import com.spring.demo.vehicule.model.notif.PushNotificationRequest;
import com.spring.demo.vehicule.service.notif.PushNotificationService;

@RestController
@RequestMapping("/notification")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    private PushNotificationService pushNotificationService;

    @PostMapping("/send")
    public ResponseEntity<APIResponse> sendPushNotification(@RequestBody PushNotificationRequest request) {
        try {
            pushNotificationService.sendPushNotification(request.getTo(), request.getTitle(), request.getMessage());
            return ResponseEntity.ok(new APIResponse("Notification sent successfully","coucou"));
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse("Erreur => " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

