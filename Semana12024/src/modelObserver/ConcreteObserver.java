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
public class ConcreteObserver implements Observer{
    
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int state) {
        JOptionPane.showMessageDialog(null, name + " ha sido notificado. Nuevo Valor: " + state);
    }
    
    
    
    
}
