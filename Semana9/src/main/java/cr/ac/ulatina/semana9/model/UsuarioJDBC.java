/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ulatina.semana9.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
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
public class UsuarioJDBC {

    static Connection con = null;
    String host;
    String user;
    String password;
    String bd;
    String driver;

    public UsuarioJDBC() {
        try {
            host = "127.0.0.1";
            user = "root";
            password = "root";
            bd = "clasesprogra";
            driver = "com.mysql.cj.jdbc.Driver";
            //String dir = "jdbc:mysql://"+host+":3306/?user="+user+"";
            Class.forName(driver);
//            String dir = "jdbc:mysql://"+host+":3306/clasesprogra?"+"zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&verifyServerCertificate="+Boolean.FALSE.toString()+"&useSSL="+Boolean.FALSE.toString()+" ["+user+" on Default schema]";
            String dir = "jdbc:mysql://" + host + ":3306/" + bd + "?" + "autoReconnect=true&useSSL=false";
//            String dir = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]";

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

    public Usuario save(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (email, password) VALUES (?,?)";
        try {
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
            con.close();

        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return usuario;
    }

    public Usuario findByEmailAndPass(String email, String pass) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario u WHERE u.email = ? and u.password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usuario = establecerLibro(rs);
        }
        return usuario;
    }

    private Usuario establecerLibro(ResultSet rs) {
        Usuario usuario = new Usuario();
        try {
            usuario.setIdUsuario(rs.getLong(1));
            usuario.setEmail(rs.getString(2));
            usuario.setPassword(rs.getString(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;

    }
}
