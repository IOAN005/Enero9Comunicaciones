package com.corenetworks.presentacion.cajero;

import com.corenetworks.modelo.CuentaBancaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteCajero {
    public static void main(String[] args) {

        CuentaBancaria cB1 = solicitarDatos();
        System.out.println(cB1.toString());
        try (Socket cliente = new Socket("localhost", 3000)) {
            PrintWriter mensajeEnviar =new PrintWriter(cliente.getOutputStream(),true);
            mensajeEnviar.println(cB1.getTipoOperacion()+","+cB1.getId()+","+cB1.getCantidad());
            System.out.println("Esperando respuesta del servidor -> ");
            BufferedReader mensajeRecibido=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println(mensajeRecibido.readLine());


        } catch (UnknownHostException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static CuentaBancaria solicitarDatos() {
        CuentaBancaria cB1 = new CuentaBancaria();
        int tipoOperacion = 0;
        Scanner teclado = new Scanner(System.in);



            System.out.printf("%s %n", "-".repeat(50));
            System.out.printf("%-20s  %n", "MENU BANCARIO");
            System.out.printf("%s %n", "-".repeat(50));
            System.out.printf("%s %n", "1) Consultar Saldo");
            System.out.printf("%s %n", "2) Retirar la cantidad");
            System.out.printf("%s %n", "3) Ingresar una cantidad");
            System.out.printf("%s %n", "4) Salir");
            System.out.printf("Escriba la opcion ->");
            tipoOperacion = teclado.nextInt();
//            if (tipoOperacion==4 ){
//                break;
//            }
            teclado.nextLine();
            System.out.printf("Escribir la cuenta ->");
            cB1.setId(teclado.next());
            if (tipoOperacion == 2 || tipoOperacion == 3) {
                System.out.printf("escribir la cantidad ->");
                cB1.setCantidad(teclado.nextDouble());
            }
            cB1.setTipoOperacion(Integer.toString(tipoOperacion));



        return cB1;
    }
}
