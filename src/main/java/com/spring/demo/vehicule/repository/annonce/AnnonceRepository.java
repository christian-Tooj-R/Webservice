package com.spring.demo.vehicule.repository.annonce;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.demo.vehicule.model.annonce.Annonce;

public interface AnnonceRepository extends MongoRepository<Annonce, String> {
    List<Annonce> findByStatusAndEstValide(int status, int estValide);
    List<Annonce> findByEstValide(int estValide);

    List<Annonce> findByProp(int prop);
    Optional<Annonce> findById(String id);
    List<Annonce> findByCategorie(String categorie);
    
    @Query("{'favoris.iduser': ?0}")
    List<Annonce> findByFavoris(int iduser);
    @Query("{'categorie': ?0,'marque': ?1}")
    List<Annonce> getByCategorieAndMarque(String categorie,String marque);
}