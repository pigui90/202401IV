/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelObserver;

import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class MainObserver {
    public static void main(String[] args) {
        Subject subject = new Subject();
        
        ConcreteObserver concreteObserver = new ConcreteObserver("Sergio");
        ConcreteObserver concreteObserver2 = new ConcreteObserver("Gerardo");
        
        subject.addObserver(concreteObserver);
        subject.addObserver(concreteObserver2);
        
        subject.setState(Integer.parseInt(JOptionPane.showInputDialog("Digite un valor para el state: ")));
    }
}
