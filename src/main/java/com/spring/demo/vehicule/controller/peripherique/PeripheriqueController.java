package com.spring.demo.vehicule.controller.peripherique;

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
import com.spring.demo.vehicule.model.marque.Marque;
import com.spring.demo.vehicule.model.notif.PushNotificationRequest;
import com.spring.demo.vehicule.model.phone.Peripherique;
import com.spring.demo.vehicule.service.utilisateur.PeripheriqueService;
import com.spring.demo.vehicule.service.utilisateur.TokenService;

@RestController
@RequestMapping("/peripherique")
@CrossOrigin("*")
public class PeripheriqueController {
    @Autowired
    private PeripheriqueService peripheriqueService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getByIdUser")
    public ResponseEntity<APIResponse> findByUser(@RequestBody Peripherique periph,@RequestHeader("Authorization") String token) {
        try {
            tokenService.verifAuth(token);
            return ResponseEntity.ok(new APIResponse("", peripheriqueService.getByIduser(periph)));
        } catch (Exception e) {
            APIResponse response = new APIResponse("Erreur lors de la récupération des peripherique: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @PostMapping("/create")
    public ResponseEntity<APIResponse> createInstance(@RequestBody Peripherique periph,@RequestHeader("Authorization") String token) {
        try {
            tokenService.verifAuth(token);
            
            Peripherique p = peripheriqueService.createInstance(periph);
            return ResponseEntity.ok(new APIResponse("Instance créée avec succès", p));
        } catch (Exception e) {
            APIResponse response = new APIResponse("Erreur lors de la création de l instance appareil: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
