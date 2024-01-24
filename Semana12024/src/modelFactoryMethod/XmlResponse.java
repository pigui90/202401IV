/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelFactoryMethod;

import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class XmlResponse implements HttpResponse{

    @Override
    public void send() {
        JOptionPane.showMessageDialog(null,"Enviando una respuesta XML");
    }
    
}
