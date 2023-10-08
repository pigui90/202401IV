/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana1_2;

import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class ConcreteObserver implements Observer{
    
    String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int state) {
        String mensaje = "Hola " + name + " ha sido notificado, nuevo state " + state;
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    
    
}
