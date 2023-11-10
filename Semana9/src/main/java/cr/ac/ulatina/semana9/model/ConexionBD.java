/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ulatina.semana9.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class ConexionBD {

    static ConexionBD conexionBD;
    Connection con = null;
    String host;
    String user;
    String password;
    String bd;
    String driver;

    private ConexionBD() {
        try {
            host = "127.0.0.1";
            user = "root";
            password = "root";
            bd = "clasesprogra";
            driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String dir = "jdbc:mysql://" + host + ":3306/" + bd + "?" + "autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(dir, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConexionBD getConexionBD() {
        if (conexionBD == null) {
            synchronized (ConexionBD.class) {
                if (conexionBD == null) {
                    conexionBD = new ConexionBD();
                }
            }

        }
        return conexionBD;
    }

    public Connection getCon() {
        return con;
    }
    
    public void closeConexion() {
        try {
            con.close();
        } catch (SQLException e) {

        }
    }

}
