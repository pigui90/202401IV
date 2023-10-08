/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana1_2;

/**
 *
 * @author Sergio
 */
public class DatabaseConecction {

    private DatabaseConecction conexion;

    String ip;
    String usuario;
    String password;
    String esquema;

    private DatabaseConecction() {
        this.ip = "127.0.0.1";
        this.usuario = "admin";
        this.password = "admin";
        this.esquema = "supermercado";
    }

    public DatabaseConecction getConexion() {
        if (conexion == null) {
            synchronized (DatabaseConecction.class) {
                if (conexion == null) {
                    conexion = new DatabaseConecction();
                }
            }

        }
        return conexion;
    }

}
