/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.connexion;

import connect.ConnectToDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
 
/**
 *
 * @author Christian
 */
public class Connect {
    
    public Connection getConnection()throws Exception{
        Class.forName("org.postgresql.Driver");
        String connect = "jdbc:postgresql://dpg-cmfemneg1b2c73cl3nm0-a.oregon-postgres.render.com:5432/clouds5?user=clouds5_user&password=kaYVbGZ75Pd5bC73FuMr4WXcqz8KLm1W";
        Connection con = DriverManager.getConnection(connect);
        return con;
    }
}
