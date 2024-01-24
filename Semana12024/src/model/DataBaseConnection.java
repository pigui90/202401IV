/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sergio
 */
public class DataBaseConnection {
    private static DataBaseConnection conexion;
    private String host;
    private String puerto;
    
    private DataBaseConnection(){
        host = "127.0.0.1";
        puerto = "3306";
    }

    public static DataBaseConnection getConexion() {
        if(conexion == null){
            synchronized (DataBaseConnection.class) {
                if(conexion == null){
                    conexion = new DataBaseConnection();
                }
            }
        }
        return conexion;
    }
    
    
}
