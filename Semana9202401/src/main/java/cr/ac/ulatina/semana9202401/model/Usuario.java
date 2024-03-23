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
public class Usuario {

    private long idUsuario;
    private String email;
    private String password;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void save(Usuario usuario) {
        try {
            ConexionBD conexionBD = ConexionBD.getConexionBD();
            Connection con = conexionBD.getCon();

            String sql = "INSERT INTO USUARIO (email, password) VALUES (?,?)";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getPassword());

            int rowcount = ps.executeUpdate();
            if (rowcount == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    usuario.setIdUsuario(rs.getLong(1));
                }
            } else {
                throw new SQLException("El 'insert' no ocurrio, valor de: " + rowcount);
            }
            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERROR:" + ex.getMessage());
        }

    }

    public boolean buscarUsuario(String email, String pass) {
        try {
            ConexionBD conexionBD = ConexionBD.getConexionBD();
            Connection con = conexionBD.getCon();

            Usuario usuario = null;
            String sql = "SELECT * FROM USUARIO u WHERE u.email = ? and u.password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario = establecerUsuario(rs);
                break;
            }
           // con.close();

            return usuario != null;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private Usuario establecerUsuario(ResultSet rs) {
        try {
            Usuario usuario = new Usuario();

            usuario.setIdUsuario(rs.getLong(1));
            usuario.setEmail(rs.getString(2));
            usuario.setPassword(rs.getString(3));
            return usuario;

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
