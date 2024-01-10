package com.corenetworks.presentacion.cajero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServidorCajero {
    private static int saldo=3000;
    public static void main(String[] args) {
        BufferedReader mensajeRecibido=null;
        PrintWriter mensajeEnviar=null;
        String [] datos =null;
        try (ServerSocket servidor = new ServerSocket(3000)) {

            while (true) {
                System.out.println("Esperando peticion ...");
                Socket s1 =servidor.accept();
                mensajeRecibido=new BufferedReader(new InputStreamReader(s1.getInputStream()));

                //Obtener los datos
                datos=mensajeRecibido.readLine().split(",");
                double cantidad=Double.parseDouble(datos[2]);
                System.out.println(Arrays.toString(datos));

                mensajeEnviar =new PrintWriter(s1.getOutputStream(),true);
                switch (datos[0]){
                    case "1": mensajeEnviar.println("su saldo es  -> " +saldo);
                    break;
                    case "2":if (saldo>= cantidad){
                        mensajeEnviar.println("su saldo es->" +(saldo-cantidad));
                    }else{
                        mensajeEnviar.println("saldo insuficiente" +(saldo));
                    }
                    break;
                    case "3":
                        mensajeEnviar.println("su saldo es->" +(saldo+cantidad));
                }



            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}