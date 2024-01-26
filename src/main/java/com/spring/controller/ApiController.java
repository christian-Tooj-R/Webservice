package com.spring.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.connexion.Connect;
import com.spring.models.Categorie;
import com.spring.models.Marque;
import com.spring.models.Token;
import com.spring.models.Utilisateur;
import com.spring.services.AuthService;
import com.spring.utility.Response;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/getAllCategorie")
    public List<Categorie> getAllCategorie() {
        try {
            Connection connect = new Connect().getConnection();
            List<Categorie> allCategories = new Categorie().select(connect,"");
            return allCategories;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @GetMapping("/getAllMarque")
    public List<Marque> getAllMarque() {
        try {
            Connection connect = new Connect().getConnection();
            List<Marque> allMarques = new Marque().select(connect,"");
            return allMarques;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    
    @PostMapping("/verifloginvendeur")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        Response response = new Response();
        try {
            Utilisateur user = new AuthService().verifloginVendeur(email, password);

            if (user != null) {
                Map<String, Object> map = new AuthService().generateToken(user);
                
                Connection connect = new Connect().getConnection();
                Token token = new Token();
                token.setCle((String) map.get("cle"));
                token.setToken((String) map.get("token"));
                token.setDatecreation(new Date(((java.util.Date) map.get("date")).getTime()));
                token.setDateexpiration(new Date(((java.util.Date) map.get("expirer")).getTime()));
                token.insert(connect);

                
                response.setData(token.getToken());
                response.setStatus(HttpStatus.OK);
                response.setStatus_code("200");
                response.setMessage("");
            }else{
                response.setStatus_code("800");
                response.setMessage("Erreur login ou mot de passe !!");
            }
        } catch (Exception e) {
             e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error during login: " + e.getMessage());
        }
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
