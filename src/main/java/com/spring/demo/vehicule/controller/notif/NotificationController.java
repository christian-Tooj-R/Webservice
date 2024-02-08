package com.spring.demo.vehicule.controller.notif;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.api.APIResponse;
import com.spring.demo.vehicule.model.notif.NotifUser;
import com.spring.demo.vehicule.model.notif.PushNotificationRequest;
import com.spring.demo.vehicule.service.notif.PushNotificationService;
import com.spring.demo.vehicule.service.utilisateur.TokenService;

@RestController
@RequestMapping("/notification")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    private PushNotificationService pushNotificationService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/send")
    public String sendPushNotification(@RequestBody PushNotificationRequest request) {
        return pushNotificationService.sendNotificationBytoken(request);
    }
    @GetMapping("/getNotif")
    public ResponseEntity<APIResponse> getNotif(@RequestHeader("Authorization") String token) {
        try {
            int iduser = tokenService.verifAuth(token);
            List<NotifUser> n = pushNotificationService.getNotifByUser(iduser);
            return ResponseEntity.ok(new APIResponse("Notif recuperé", n));
        } catch (Exception e) {
            APIResponse response = new APIResponse("Erreur lors de la rcuoeration  notif: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


}

