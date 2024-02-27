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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "InicioSesionServlet", urlPatterns = {"/InicioSesionServlet"})
public class InicioSesionServlet extends HttpServlet {

    int id = 0;
    List<Usuario> usuarios = new ArrayList<>();

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
        String cerrarSesion = request.getParameter("cerrarSesion");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String registrarse = request.getParameter("registrarse");
        String inicioSesion = request.getParameter("inicioSesion");
//        String usuario = "admin";
//        String pass = "admin";
        if (registrarse != null) {
            Usuario usuario = new Usuario();
            usuario.setNombre(username);
            usuario.setPassword(password);
            usuarios.add(usuario);
            request.setAttribute("error", "false");
            request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
        }
        
        if (cerrarSesion != null) {
            session.invalidate();
            response.sendRedirect("inicioSesion.jsp");
        }

        if (inicioSesion != null) {
            if (existeUsuario(new Usuario(username, password))) {
//            session.setAttribute("usuario", usuario);
                session.setAttribute("fechaSession", new Date());
                id++;
                session.setAttribute("usuario", "usuario_" + id);
//request.getRequestDispatcher("principal.jsp").forward(request, response);
                response.sendRedirect("principal.jsp");
            } else {
                request.setAttribute("error", "true");
            request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
                response.sendRedirect("inicioSesion.jsp");
            }
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

    public Boolean existeUsuario(Usuario usuario) {
        for (Usuario usuario1 : usuarios) {
            if (usuario1.equals(usuario)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
