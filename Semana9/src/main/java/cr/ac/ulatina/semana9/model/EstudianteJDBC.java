/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ulatina.semana9.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class EstudianteJDBC {

    Connection con = null;

    public EstudianteJDBC() {
        try {
            ConexionBD conexionBD = ConexionBD.getConexionBD();
            con = conexionBD.getCon();
//            host = "127.0.0.1";
//            user = "sa";
//            password = "root";
//            bd = "clasesprogra";
//            driver = "com.mysql.cj.jdbc.Driver";
//            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//            String dir = "jdbc:mysql://"+host+":3306/?user="+user+"";
//            Class.forName(driver);
//            String dir = "jdbc:mysql://"+host+":3306/clasesprogra?"+"zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&verifyServerCertificate="+Boolean.FALSE.toString()+"&useSSL="+Boolean.FALSE.toString()+" ["+user+" on Default schema]";
//            String dir = "jdbc:mysql://" + host + ":3306/" + bd + "?" + "autoReconnect=true&useSSL=false";
//            String dir = "jdbc:sqlserver://" + host + ":1433;databaseName=" + bd;
//            String url = "jdbc:sqlserver://" + host + ":1433;databaseNombre=" + bd + ";integratedSecurity=true";
//            con = DriverManager.getConnection(dir, user, password);
//            con = DriverManager.getConnection(url);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
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

        String sql = "INSERT INTO ESTUDIANTE(nombre, edad, fechaIngreso)"
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

    public List<Estudiante> findAll() {
        List<Estudiante> estudiantes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM estudiante e";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                estudiantes.add(establecerEstudiante(rs));
            }
            return estudiantes;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estudiantes;
    }

    private Estudiante establecerEstudiante(ResultSet rs) {
        Estudiante estudiante = new Estudiante();
        try {
            estudiante.setId(rs.getLong(1));
            estudiante.setNombre(rs.getString(2));
            estudiante.setEdad(rs.getInt(3));
            estudiante.setFechaIngreso(rs.getDate(4).toLocalDate());

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return estudiante;

    }
}
