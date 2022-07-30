/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Utils.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "Servlet_Registrarse", urlPatterns = {"/Servlet_Registrarse"})
public class Servlet_Registrarse extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

//OPERACION DE REGISTRO DE NUEVO USUARIO
            String op = request.getParameter("opcion");

            if (op.equals("registrar")) {
//INSTANCIANDO LAS VARIABLES                
                String nom = request.getParameter("nombre");
                String ape = request.getParameter("apellido");
                String email = request.getParameter("email");
                String pass = request.getParameter("password");
                String cargo = request.getParameter("cargo");

                try {
//DECLARACION A LA BD
                    PreparedStatement sta = ConexionDB.getConnection().
                            prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?)");

                    sta.setString(1, nom);
                    sta.setString(2, ape);
                    sta.setString(3, email);
                    sta.setString(4, pass);
                    sta.setString(5, cargo);

                    sta.executeUpdate();

                    request.setAttribute("R_msg", "Usuario Registrado");
                    request.getRequestDispatcher("Registrarse.jsp").forward(request, response);

                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
                    request.setAttribute("R_msg", "Verifique sus Datos");
                }

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

}
