/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ulatina.semana9202401.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class EstudianteJDBC {

    ConexionBD conexionBD;
    Connection con;

    public EstudianteJDBC() {
        conexionBD = ConexionBD.getConexionBD();
        con = conexionBD.getCon();
    }

    public Boolean agregarEstudiante(Estudiante estudiante) {
        try {
            String sql = "INSERT INTO ESTUDIANTE (nombre, edad, fechaIngreso) VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, estudiante.getNombre());
            ps.setInt(2, estudiante.getEdad());
            ps.setDate(3, java.sql.Date.valueOf(estudiante.getFechaIngreso()));

            int rowcount = ps.executeUpdate();
            if (rowcount == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    estudiante.setId(rs.getLong(1));
                    return true;
                }

            } else {
                throw new SQLException("El 'insert' no ocurrio, valor de: " + rowcount);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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

    public Estudiante findById(int id) {
        Estudiante estudiante = new Estudiante();
        try {
            String sql = "SELECT * FROM estudiante e where e.id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return establecerEstudiante(rs);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estudiante;
    }

    public Boolean eliminar(int id) {
        try {
            String sql = "DELETE FROM ESTUDIANTE e WHERE e.id = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            int rowcount = ps.executeUpdate();
            return rowcount == 1;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Boolean.FALSE;

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
