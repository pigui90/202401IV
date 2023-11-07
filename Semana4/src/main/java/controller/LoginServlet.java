/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    File archivo = new File("user.txt");
    int id = 0;

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
        try {

            String inicio = (String) request.getParameter("inicio");
            String register = (String) request.getParameter("register");
            HttpSession session = request.getSession();
            String user = (String) request.getParameter("username");
            String pass = (String) request.getParameter("password");
            if (inicio != null) {

                if (!archivo.exists()) {
                    archivo.createNewFile();
                }

                FileReader fileReader = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Boolean flag = false;
                String linea = bufferedReader.readLine();
                String passEncrip = convertirdorHexMD5(pass);
                while (linea != null) {
                    String[] secciones = linea.split(";");
                    String passtxt = secciones[1];
                    if (secciones[0].equals(user) && passtxt.equals(passEncrip)) {
                        flag = true;
                        break;
                    }
                    linea = bufferedReader.readLine();
                }

                if (flag) {
                    id++;

//                  session.setAttribute("nombreUsuario", "usuario_");
//                  session.setAttribute("nombreUsuario", "usuario_" + Math.random());
                    session.setAttribute("nombreUsuario", "usuario_" + id);
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */

                        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet LoginServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Session LoginServlet es " + nombreUsuario + "</h1>");
                        out.println("<a href=index.jsp>index</a>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                } else {
                    request.setAttribute("userError", user);
                    request.getRequestDispatcher("login-error.jsp").forward(request, response);

//            session.setAttribute("userErrorSession", user);
//            response.sendRedirect("login-error.jsp");
                }
            } else {
                if (register != null) {
                    if (!archivo.exists()) {
                        archivo.createNewFile();
                    } else {
                        try (FileWriter fileWriter = new FileWriter(archivo, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                            String passEncrip = convertirdorHexMD5(pass);
                            bufferedWriter.write(user + ";" + passEncrip);
                            bufferedWriter.newLine();
                        }
                    }
                    response.sendRedirect("login.jsp");
                }
            }
        } catch (ServletException | IOException | NoSuchAlgorithmException e) {
            System.err.print("Error");
        }
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
