/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cr.ac.ulatina.controller;

import cr.ac.ulatina.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "InicioSesionServlet", urlPatterns = {"/InicioSesionServlet"})
public class InicioSesionServlet extends HttpServlet {

    List<Usuario> usuarios = new ArrayList<>();
    Usuario usuario;

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
        usuarios = (List) session.getAttribute("list");
        if (usuarios == null) {
            session.setAttribute("list", new ArrayList<>());
            usuarios = (List) session.getAttribute("list");
        }
        String registrarse = request.getParameter("registrarse");
        String inicioSesion = request.getParameter("inicioSesion");
        String password = request.getParameter("password");
        String nombre = request.getParameter("username");
        String passEncrypt = "";
        if (registrarse != null) {
            usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setPassword(convertirHexMD5(password));
            usuarios.add(usuario);
            session.setAttribute("list", usuarios);
            session.setAttribute("exito", true);
            session.setAttribute("error", false);

            response.sendRedirect("inicioSesion.jsp");

        } else {
            if (inicioSesion != null) {
                for (Usuario user : usuarios) {
                    if (user.getNombre().equals(nombre)) {
                        passEncrypt = convertirHexMD5(password);
                        if (user.getPassword().equals(passEncrypt)) {
                            session.setAttribute("usuario", user.getNombre());
                            request.getRequestDispatcher("principal.jsp").forward(request, response);
                        }
                    }
                }
                session.setAttribute("exito", false);

                session.setAttribute("error", true);
                response.sendRedirect("inicioSesion.jsp");

            }
        }
    }

    public String convertirHexMD5(String str) {
        StringBuilder hexString = new StringBuilder();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] md = messageDigest.digest(str.getBytes());
            for (byte b : md) {
                hexString.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(InicioSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hexString.toString();

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

}
