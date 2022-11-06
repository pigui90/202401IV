/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class EstudianteHilo implements Runnable {

    static long tiempoInicio = System.currentTimeMillis();

    int numeroHilo;

    public EstudianteHilo(int numeroHilo) {
        this.numeroHilo = numeroHilo;
    }

    @Override
    public void run() {
        try {
            if (numeroHilo == 1) {
                System.out.println("Este es el hilo " + numeroHilo);
            } else {
                if (numeroHilo == 2) {
                    System.out.println("Este es el hilo " + numeroHilo);
                    Thread.sleep(5000);
                } else {
                    if (numeroHilo == 3) {
                        String nombre = JOptionPane.showInputDialog("¿Como se llama?");
                        JOptionPane.showMessageDialog(null, "Mucho gusto: " + nombre);
                    } else {
                        if (numeroHilo == 4) {
                            Thread.currentThread().interrupt();
                        } else {
                            if (numeroHilo == 5) {
                                File file = new File("apellidos.txt");
                                FileReader fileReader = new FileReader(file);
                                BufferedReader bufferedReader = new BufferedReader(fileReader);
                                String linea = bufferedReader.readLine();
                                while (linea != null) {
                                    System.out.println(linea);
                                    linea = bufferedReader.readLine();
                                }
                            }
                        }
                    }
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("El hilo " + numeroHilo + " fue interrumpido");
            }
            System.out.println("Ya termino el hilo" + numeroHilo);
            long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;
            System.out.println("El hilo " + numeroHilo + " duro " + (tiempoTranscurrido / 1000.0) + " segundos");
        } catch (InterruptedException ex) {
            Logger.getLogger(EstudianteHilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EstudianteHilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstudianteHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
