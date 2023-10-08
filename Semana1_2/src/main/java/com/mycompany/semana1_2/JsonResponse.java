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
public class JsonResponse implements HttpResponse{

    @Override
    public void send() {
        String titulo = "Mensaje Json";
        String mensaje = "Esta es una respuesta de tipo Json";
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
