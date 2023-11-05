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


    public void prueba() {
        try {
            Statement statement = this.conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIS (ID, NOM, COGNOM, TIPUSUSUARI) VALUES (1, 'Mock', 'User', 'EMPRESA')");
            statement.executeUpdate("INSERT INTO USUARIS (ID, NOM, COGNOM, TIPUSUSUARI) VALUES (2, 'Another', 'User', 'EMPRESA')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultaEmpresas(){
        // Check from the h2 database the table "USUARIS" if the user role is "EMPRESA" and 
        try {
            Statement statement = this.conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USUARIS WHERE TIPUSUSUARI = 'EMPRESA'");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("ID") + " Nom: " + resultSet.getString("NOM") + " Cognom: " + resultSet.getString("COGNOM") + " Tipus: " + resultSet.getString("TIPUSUSUARI"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String hola(){
        return "Hola";
    }
}
