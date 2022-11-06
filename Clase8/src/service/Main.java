/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package service;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EstudianteHilo;

/**
 *
 * @author Sergio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite la cantidad de hilos a recorrer");
            int n = scan.nextInt();
            EstudianteHilo eh;
            Thread t;
            for (int i = 0; i < n; i++) {
                System.out.println("Digite el  hilo a recorrer");
                int h = scan.nextInt();
                eh = new EstudianteHilo(h);
                t = new Thread(eh);
                t.setName("Hilo Luffy");
                t.start();
            }

            System.out.println("Fin del ciclo...");
            System.out.println("Hola mundo....");
            System.out.println("Vamos a esperar 10 seg");
            EstudianteHilo estudianteHilo = new EstudianteHilo(1);
            EstudianteHilo estudianteHilo2 = new EstudianteHilo(2);
            EstudianteHilo estudianteHilo3 = new EstudianteHilo(3);
            EstudianteHilo estudianteHilo4 = new EstudianteHilo(4);

            Thread hilo1 = new Thread(estudianteHilo);
            hilo1.start();
            Thread hilo2 = new Thread(estudianteHilo2);
            hilo2.start();
            Thread hilo3 = new Thread(estudianteHilo3);
            hilo3.start();
            Thread hilo4 = new Thread(estudianteHilo4);
            hilo4.start();
            Thread.sleep(10000);

//            Thread.currentThread().interrupt();
            if (Thread.interrupted()) {
                System.out.println("El hilo esta interrumpido");
            }
            System.out.println("Ya volvi");

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
