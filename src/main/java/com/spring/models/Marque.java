package com.spring.models;

import annotation.Column;
import annotation.Table;
import crud.Generalisation;

@Table(name = "marque")
public class Marque extends Generalisation {
    @Column(name = "id")
    Integer id;
    @Column(name = "nom")
    String nom;

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    

}
