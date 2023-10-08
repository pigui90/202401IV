/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana1_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class Subject {
    public List<Observer> observers = new ArrayList<>();
    
    private int state;
    
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    
    public void setState(int st){
        this.state = st;
        notifyObservers();
    }
    
    private void notifyObservers(){
        for (Iterator<Observer> iterator = observers.iterator(); iterator.hasNext();) {
            Observer next = iterator.next();
            next.update(state);
        }
    }
    
    
    
    
    
}
