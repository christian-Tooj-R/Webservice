package com.spring.models;

import java.sql.Date;

import annotation.Column;
import annotation.Table;
import crud.Generalisation;

@Table(name = "utilisateur")
public class Utilisateur extends Generalisation {
    @Column(name = "id")
    Integer id;
    @Column(name = "nom")
    String nom;
    @Column(name = "datenaissance")
    Date datenaissance;
    @Column(name = "email")
    String email;
    @Column(name = "mdp")
    String mdp;
    @Column(name = "typeutilisateur")
    Integer typeutilisateur;


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
    public Date getDatenaissance() {
        return datenaissance;
    }
    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public Integer getTypeutilisateur() {
        return typeutilisateur;
    }
    public void setTypeutilisateur(Integer typeutilisateur) {
        this.typeutilisateur = typeutilisateur;
    }

    
}
