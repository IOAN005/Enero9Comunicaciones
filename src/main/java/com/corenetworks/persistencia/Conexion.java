package com.corenetworks.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //1.Atributos
    protected Connection miConexion;
    //2.Metodos
    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        miConexion = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/corebank",
                "postgres", "agniti86");
        System.out.println("Exito al abrir la conexion");
    }
    //.3Constructores

    public Conexion() {
    }

    //4.Setters y getters
}
