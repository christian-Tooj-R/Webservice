package com.spring.demo.vehicule.service.notif;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.spring.demo.vehicule.model.notif.NotifUser;
import com.spring.demo.vehicule.model.notif.PushNotificationRequest;
import com.spring.demo.vehicule.model.phone.Peripherique;
import com.spring.demo.vehicule.repository.notif.NotifUserRepository;
import com.spring.demo.vehicule.repository.utilisateur.PeripheriqueRepository;

@Service
public class PushNotificationService {

    @Autowired
    FirebaseMessaging firebaseMessaging;
    @Autowired
    NotifUserRepository notifUserRepository;
    @Autowired
    PeripheriqueRepository peripheriqueRepository;


    
    public NotifUser createNotif(NotifUser notif) {
        return notifUserRepository.save(notif);
    }
    public List<NotifUser> getNotifByUser(int iduser){
        return notifUserRepository.getByUser(iduser);
    }


    public String sendNotificationBytoken(PushNotificationRequest pushNotificationRequest){
        Notification notification = Notification
            .builder()
            .setTitle(pushNotificationRequest.getSender()+" vous a envoyer un message. ")
            .setBody(pushNotificationRequest.getMessage())
            .build();
        
        Message message = Message
            .builder()
            .setToken(pushNotificationRequest.getTo())
            .setNotification(notification)
            .build();

        try {
            firebaseMessaging.send(message);
            Peripherique peripherique = peripheriqueRepository.getInstanceByToken(pushNotificationRequest.getTo());
            int iduser = peripherique.getIduser();

            NotifUser notifUser = new NotifUser();
            notifUser.setIduser(iduser);
            notifUser.setMessage(pushNotificationRequest.getSender()+": "+pushNotificationRequest.getMessage());
            createNotif(notifUser);

            return "Success sending Notification";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending Notification";
        }
    }   



}
