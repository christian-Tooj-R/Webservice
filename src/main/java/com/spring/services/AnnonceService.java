package com.spring.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Annonce;
import com.spring.repository.AnnonceRepository;



@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository annonce;
    
    public List<Annonce> getAnnonceByUser(String proprietaire) {
        return annonce.findByProprietaire(proprietaire);
    }
    
    public List<Annonce> getAllAnnonce() {
        return annonce.findAll();
    }
    public Annonce saveAnnonce(Annonce ac) {
        return annonce.save(ac);
    }
    
}
