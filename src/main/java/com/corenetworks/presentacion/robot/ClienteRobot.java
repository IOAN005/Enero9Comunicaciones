package com.corenetworks.presentacion.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteRobot {
    public static void main(String[] args) {
        String [] preguntas ={"¿Horario de la tienda",
                "¿Que dias no abren ",
                "¿Tienes el libro Java desde zero",
                "¿Precio del libro "};
        try(Socket cliente =new Socket("local host",3000)){

            String preguntaSelectionada = monstrarMenu();
            PrintWriter mensajeEnviar =new PrintWriter(cliente.getOutputStream());
            mensajeEnviar.println(preguntaSelectionada);
            System.out.println("esperando respuesta del servidor ...");

            //Esperamos la respuesta del servidor

            BufferedReader mensajeRecibido=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println(mensajeRecibido.readLine());
        } catch (UnknownHostException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static String monstrarMenu() {
        //Monstrar  la pregunta del array
        //recibir la pregunta del usuario
    }
}
