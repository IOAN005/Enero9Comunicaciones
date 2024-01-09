package com.corenetworks.presentacion;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ProbarServidor {
    public static void main(String[] args) throws IOException {
        PrintWriter fSalida;
        BufferedReader buffer;
        try (
            //instanciar
            ServerSocket servidor = new ServerSocket(3000)){

            while (true) {
                System.out.println("espera de peticion ");
                Socket s1 = servidor.accept();


                buffer = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                System.out.println(buffer.readLine());

               fSalida = new PrintWriter(s1.getOutputStream(),true);
                fSalida.println("Se ha recibido su hola mundo !!!");
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}