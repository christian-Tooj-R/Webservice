package com.spring.demo.vehicule.repository.categorie;

import com.spring.demo.vehicule.model.categorie.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findById(int id);

}
