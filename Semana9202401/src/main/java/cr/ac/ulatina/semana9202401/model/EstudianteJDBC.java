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
    
    
    public Boolean agregarEstudiante(Estudiante estudiante){
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
    
}
