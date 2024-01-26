package com.spring.services;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.sql.Connection;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.connexion.Connect;
import com.spring.models.Utilisateur;


public class AuthService {

    public Utilisateur verifloginVendeur(String email,String mdp)throws Exception{
        
        Connection connect = new Connect().getConnection();
        Utilisateur user = new Utilisateur();
        user.setTypeutilisateur(2);
        List<Utilisateur> alluser = user.select(connect,"");
        for (Utilisateur utilisateur : alluser) {
            if(utilisateur.getEmail().equals(email) && utilisateur.getMdp().equals(mdp)){
                connect = new Connect().getConnection();
                Utilisateur users = new Utilisateur();
                users.setEmail(email);
                users.setMdp(mdp);
                List<Utilisateur> allUtilisateurs = users.select(connect,"");
                return allUtilisateurs.get(0);
            }
        }
        return null;
    }
    
    
    public Map<String, Object> generateToken(Utilisateur utilisateur) {
        Date now = new Date();
        long jwtExpirationInMs = TimeUnit.MINUTES.toMillis(120);
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        String cle = generateSecretKey();
        Claims claims = Jwts.claims().setSubject(Long.toString(utilisateur.getId()));
        claims.put("type", utilisateur.getTypeutilisateur());
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, cle)
                .compact();
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("cle", cle);
        response.put("date", now);
        response.put("expirer", expiryDate);
        return response;
    }

    
    public static Claims extractClaims(String jwtToken, String secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
    }

    
    private static String generateSecretKey() {
        byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
        return Base64.getEncoder().encodeToString(keyBytes);
    }

}

