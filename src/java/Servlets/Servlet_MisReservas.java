/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.MisReservas;
import Utils.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "Servlet_MisReservas", urlPatterns = {"/Servlet_MisReservas"})
public class Servlet_MisReservas extends HttpServlet {

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
            String op = request.getParameter("op");
            String dni = request.getParameter("dni");

            if (op.equals("listar")) {                
                try {
                    PreparedStatement sta = ConexionDB.getConnection().
                            prepareStatement("SELECT dni, placa, id_espacio, h_entrada, h_salida FROM reservas");                    
                    
                    ResultSet rs = sta.executeQuery();
                    
                    ArrayList<MisReservas> lista = new ArrayList<>();
                    
                    while (rs.next()) {
//Llamar a los datos a la clase empleado
                        MisReservas mr = new MisReservas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//Mandar a la lista "mr"
                        lista.add(mr);
                    }                    
                    request.setAttribute("lista", lista);

                    request.getRequestDispatcher("MisReservas.jsp").forward(request, response);
                    
                } catch (Exception e) {
                    System.out.println("Error: " + e);
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
