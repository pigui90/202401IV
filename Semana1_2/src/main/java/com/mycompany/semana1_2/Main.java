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
public class Main {

    public static void main(String[] args) {
        String responseType = "XML";

        HttpResponseFactory factory = null;

        switch (responseType) {
            case "JSON":
                factory = new JsonResponseFactory();
                break;
            case "HTML":
                factory = new HtmlResponseFactory();
                break;
            case "XML":
                factory = new XmlResponseFactory();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de respuesta no contemplada", "error", JOptionPane.ERROR_MESSAGE);
        }

        HttpResponse response = factory.createResponse();
        response.send();
    }
}
