/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ulatina.semana9.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class EstudianteJDBC {

    Connection con = null;
    String host;
    String user;
    String password;
    String bd;
    String driver;

    public EstudianteJDBC() {
        try {
//            ConexionBD conexionBD = ConexionBD.getConexionBD();
//            con = conexionBD.getCon();
            host = "127.0.0.1";
            user = "root";
            password = "root";
            bd = "clasesprogra";
            driver = "com.mysql.cj.jdbc.Driver";
//            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            //String dir = "jdbc:mysql://"+host+":3306/?user="+user+"";
            Class.forName(driver);
//            String dir = "jdbc:mysql://"+host+":3306/clasesprogra?"+"zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&verifyServerCertificate="+Boolean.FALSE.toString()+"&useSSL="+Boolean.FALSE.toString()+" ["+user+" on Default schema]";
            String dir = "jdbc:mysql://" + host + ":3306/" + bd + "?" + "autoReconnect=true&useSSL=false";
//            String dir = "jdbc:sqlserver://"+host+":1433;databaseName="+bd;
            con = DriverManager.getConnection(dir, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EstudianteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public Estudiante save(Estudiante estudiante) {
        String sql = "INSERT INTO ESTUDIANTE VALUES (nombre, edad, fechaIngreso)"
                + "VALUES (?,?,?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, estudiante.getNombre());
            ps.setInt(2, estudiante.getEdad());
            ps.setDate(3, java.sql.Date.valueOf(estudiante.getFechaIngreso()));
            int rowcount = ps.executeUpdate();
            if (rowcount == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    estudiante.setId(rs.getLong(1));
                }
            } else {
                throw new SQLException("El 'insert' no ocurrio, valor de: " + rowcount);

            }
            

        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return estudiante;
    }
}
