/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.Espacio;
import Beans.MisVehiculos;
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
@WebServlet(name = "Servlet_Reserva", urlPatterns = {"/Servlet_Reserva"})
public class Servlet_Reserva extends HttpServlet {

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
//Declaracion a DB
                    PreparedStatement sta = ConexionDB.getConnection().
                            prepareStatement("SELECT v.placa,v.dni,v.v_nombre,v.v_marca,c.cat_nombre,t.tar_precio FROM vehiculos v\n"
                                    + "INNER JOIN categoria c ON v.id_catategoria=c.id_catategoria\n"
                                    + "INNER JOIN tarifario t ON c.id_catategoria=t.id_catategoria WHERE dni='" + dni + "'");

                    PreparedStatement sta2 = ConexionDB.getConnection().
                            prepareStatement("SELECT * FROM espacio");

//Ejecutar declaracion con Query
                    ResultSet rs = sta.executeQuery();
                    ResultSet rs2 = sta2.executeQuery();

//Crear nueva lista Array
                    ArrayList<MisVehiculos> lista = new ArrayList<>();
                    ArrayList<Espacio> lista2 = new ArrayList<>();

                    while (rs.next()) {
//Llamar a los datos a la clase empleado
                        MisVehiculos mv = new MisVehiculos(rs.getString(1),
                                rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));

//Mandar a la lista "mv"
                        lista.add(mv);
                    }

                    while (rs2.next()) {
//Llamar a los datos a la clase Espacio
                        Espacio es = new Espacio(rs2.getString(1),
                                rs2.getString(2), rs2.getString(3), rs2.getString(4));

//Mandar a la lista "es"
                        lista2.add(es);
                    }

                    request.setAttribute("lista", lista);
                    request.setAttribute("lista2", lista2);

                    request.getRequestDispatcher("Reserva_NuevaR.jsp").forward(request, response);

                } catch (Exception e) {
                    System.out.println("Error AQUI: " + e);
                }
            } else if (op.equals("reservar")) {
                String placa = request.getParameter("r_placa");

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
