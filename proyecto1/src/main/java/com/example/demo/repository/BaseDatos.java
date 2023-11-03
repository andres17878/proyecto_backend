package com.example.demo.repository;

import java.sql.*;

import com.example.demo.bean.Usuari;

public class BaseDatos {

    private Connection conexion;

    public BaseDatos() {
        try{
            Class.forName("org.h2.Driver");
            String conex = "jdbc:h2:mem:borsa_de_treball;DB_CLOSE_DELAY=-1";
            this.conexion = DriverManager.getConnection(conex, "sa", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void consultaEmpresas(){
        // Check from the h2 database the table "EMPRESA" and its content
        
    }



}
