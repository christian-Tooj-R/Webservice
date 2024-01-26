package com.spring.models;



import java.util.Date;

import annotation.Column;
import annotation.Table;
import crud.Generalisation;

@Table(name = "token")
public class Token extends Generalisation{
    @Column(name = "id")
    private Integer id;
    @Column(name = "token")
    private String token;
    @Column(name = "cle")
    private String cle;
    @Column(name = "datecreation")
    private Date datecreation;
    @Column(name = "dateexpiration")
    private Date dateexpiration;

   
    

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(Date dateexpiration) {
        this.dateexpiration = dateexpiration;
    }


}
