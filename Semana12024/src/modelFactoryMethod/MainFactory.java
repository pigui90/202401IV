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
public class MainFactory {

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {

            String responseType = JOptionPane.showInputDialog("Digite el tipo de Respuesta que quiere:");

            HttpResponseFactory hrf;
            switch (responseType) {
                case "HTML":
                    hrf = new HtmlResponseFactory();
                    break;
                case "JSON":
                    hrf = new JsonResponseFactory();
                    break;
                case "XML":
                    hrf = new XmlResponseFactory();
                    break;
                case "SALIR":
                    flag = false;
                    return;
                default:
                    flag = false;
                    return;
            }

            HttpResponse hr = hrf.createResponse();
            hr.send();
        }
    }
}
