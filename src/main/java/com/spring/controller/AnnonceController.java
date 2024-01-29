package com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.models.Annonce;
import com.spring.services.AnnonceService;
import com.spring.utility.Response;

import java.io.IOException;
import java.util.Base64;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/annonces")
public class AnnonceController {
    @Autowired
    AnnonceService annonce_service;



    @GetMapping("/user/{idproprietaire}")
    public List<Annonce> getAnnoncesByUser(@RequestHeader("Authorization") String authorizationHeader,@PathVariable String idproprietaire) {
        return annonce_service.getAnnonceByUser(idproprietaire);
    }
    @GetMapping("/user/getAll")
    public List<Annonce> getAllAnnonces() {
        return annonce_service.getAllAnnonce();
    }

    @PostMapping("/addAnnonce")
    public ResponseEntity<Response> addAnnonce(@RequestBody Annonce annonce) {
        Response response = new Response();
        try {
         /*    byte[]  fileBytes = file.getBytes();
            String imgbase64 = Base64.getEncoder().encodeToString(fileBytes);
            annonce.setImage(imgbase64);*/
            System.out.println("Marque   "+annonce.getMarque()+"   prix  "+annonce.getPrix());
            annonce_service.saveAnnonce(annonce);

            response.setStatus_code("200");
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,response.getStatus());
        }
    }

    
    @PostMapping("/imgtobase64")
    public ResponseEntity<Response> convertToBase64(@RequestParam("file")  MultipartFile file) throws IOException {
        byte[]  fileBytes = file.getBytes();
        Response response = new Response();
        response.setMessage(Base64.getEncoder().encodeToString(fileBytes));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

