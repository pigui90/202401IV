/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cr.ac.ulatina.semana9.controller;

import cr.ac.ulatina.semana9.model.Estudiante;
import cr.ac.ulatina.semana9.model.EstudianteJDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "EstudianteServlet", urlPatterns = {"/EstudianteServlet"})
public class EstudianteServlet extends HttpServlet {

    EstudianteJDBC estudianteJDBC = new EstudianteJDBC();

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
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("agregar")) {
                request.getRequestDispatcher("estudianteFormulario.jsp").forward(request, response);
            } else {
                if (action.equals("ingresar")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String nombre = request.getParameter("nombre");
                    int edad = Integer.parseInt(request.getParameter("edad"));
                    LocalDate fechaIngreso = LocalDate.parse(request.getParameter("fechaIngreso"), formatter);
                    Estudiante estudiante = new Estudiante();
                    estudiante.setNombre(nombre);
                    estudiante.setEdad(edad);
                    estudiante.setFechaIngreso(fechaIngreso);
                    estudianteJDBC.save(estudiante);
                    session.setAttribute("listaEstudiantes", findAllEstudiantes());

                    request.getRequestDispatcher("estudiantePrincipal.jsp").forward(request, response);
                } else {
                    if (action.equals("eliminar")) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        boolean flag = estudianteJDBC.delete(id);
                        if (flag) {
                            request.setAttribute("borrado", true);
                        }
                        session.setAttribute("listaEstudiantes", findAllEstudiantes());

                        request.getRequestDispatcher("estudiantePrincipal.jsp").forward(request, response);

                    } else {
                        if (action.equals("editar")) {

                        } else {
                            if (action.equals("view")) {

                            }
                        }
                    }
                }
            }
        } else {
            session.setAttribute("listaEstudiantes", findAllEstudiantes());

            request.getRequestDispatcher("estudiantePrincipal.jsp").forward(request, response);
        }
    }

    public List<Estudiante> findAllEstudiantes() {
        List<Estudiante> estudiantes = estudianteJDBC.findAll();
        return estudiantes;
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
