/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana1_2;

/**
 *
 * @author Sergio
 */
public class App {
    
    public static void main(String[] args) {
        Subject subject = new Subject();
        
        ConcreteObserver observer = new ConcreteObserver("Sergio");
        ConcreteObserver observer2 = new ConcreteObserver("Allam");
        
        subject.addObserver(observer);
        subject.addObserver(observer2);
        
        subject.setState(40);
        
        subject.removeObserver(observer);
        
        subject.setState(5);
    }
}
