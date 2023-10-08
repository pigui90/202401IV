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
public class HtmlResponse implements HttpResponse{

    @Override
    public void send() {
        JOptionPane.showMessageDialog(null, "Esta es una respuesta HTML");
    }
    
}
