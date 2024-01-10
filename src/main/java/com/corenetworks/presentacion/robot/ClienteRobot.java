package com.corenetworks.presentacion.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteRobot {
    public static void main(String[] args) {


        String preguntaSelectionada = monstrarMenu();
        try(Socket cliente =new Socket("localhost",3000)){


            PrintWriter mensajeEnviar =new PrintWriter(cliente.getOutputStream(),true);
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
        String[] preguntas = {"¿Horario de la tienda",
                "¿Que dias no abren ",
                "¿Tienes el libro Java desde zero",
                "¿Precio del libro "};
        int numPregunta = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.printf("%s %n", "-".repeat(50));
        System.out.printf("%-20s %n", "MENU DE OPCIONES");
        System.out.printf("%s %n", "-".repeat(50));
        //Mostrar las preguntas del array
        for (int i = 0; i < preguntas.length; i++) {
            System.out.printf("%d %s %n", i + 1, preguntas[i]);
        }
        //Recibir la respuesta del usuario
            while (true) {
                System.out.println("Opcion seleccionada ->");
                numPregunta = teclado.nextInt();
                if (numPregunta >= 1 && numPregunta <= preguntas.length) {
                    break;
                }
            }


        return Integer.toString(numPregunta);
    }
}
