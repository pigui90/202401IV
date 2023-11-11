/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cr.ac.ulatina.semana9.controller;

import cr.ac.ulatina.semana9.model.Usuario;
import cr.ac.ulatina.semana9.model.UsuarioJDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            String inicio = (String) request.getParameter("inicio");
            String register = (String) request.getParameter("register");
            String action = (String) request.getParameter("action");
            String email = (String) request.getParameter("email");
            String pass = (String) request.getParameter("password");
            if (action != null && action.equals("salir")) {
                session.invalidate();
                response.sendRedirect("login.jsp");
            }
            if (register != null) {
                if (registrarUsuario(email, pass)) {
                    session.setAttribute("registro", true);
                }
                response.sendRedirect("login.jsp");

            } else {
                if (inicio != null) {
                    
                    if (buscarUsuario(email, pass)) {
                        request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
                    } else {
                        request.setAttribute("inicioSesion", false);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                }
            }
        } catch (NoSuchAlgorithmException | SQLException e) {
            System.err.print(e.getMessage() + "\n");
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean registrarUsuario(String email, String pass) throws NoSuchAlgorithmException {

        String passEncrip = convertirdorHexMD5(pass);

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(passEncrip);

        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        usuario = usuarioJDBC.save(usuario);

        return usuario.getIdUsuario() != null;

    }

    private boolean buscarUsuario(String email, String pass) throws NoSuchAlgorithmException, SQLException {
        String passEncrip = convertirdorHexMD5(pass);
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        Usuario usuario = usuarioJDBC.findByEmailAndPass(email, passEncrip);
        return usuario != null;
    }

    public String convertirdorHexMD5(String str) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(str.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02x", b));

        }
        return hexString.toString();
    }
}
