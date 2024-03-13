/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ulatina.semana9202401.model;

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
            //user = "sa";
            password = "root";
            bd = "prograiv012024";
//        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String dir = "jdbc:mysql://" + host + ":3306/" + bd + "?" + "autoReconnect=true&useSSL=false";
//            String url = "jdbc:sqlserver://" + host + ":1433;databaseName=" + bd + ";integratedSecurity=true";
//            String dir2 = "jdbc:sqlserver://" + host + ":1433;databaseName=" + bd;

            con = DriverManager.getConnection(dir, user, password); // My SQL
//            con = DriverManager.getConnection(dir2, user, password); // My SQL
            //con = DriverManager.getConnection(url); // SQL

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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
