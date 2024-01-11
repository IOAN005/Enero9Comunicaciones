package com.corenetworks.presentacion.cajero;

import com.corenetworks.persistencia.AccesoCuentaBancaria;

import java.sql.SQLException;

public class ProbarSaldo {
    public static void main(String[] args) {
        AccesoCuentaBancaria aCB1= new AccesoCuentaBancaria();
//        try {
//            System.out.println("saldo -> " +aCB1.solicitarSaldo("12345"));
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.toString());
//        }
//        try {
//            System.out.println("pin -> " +aCB1.obtenerPin("34567"));
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.toString());
//        }
        try {
             aCB1.actualizarSaldo("34567",200);
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
