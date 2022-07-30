/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.Tarifario;
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
@WebServlet(name = "Servlet_Tarifario", urlPatterns = {"/Servlet_Tarifario"})
public class Servlet_Tarifario extends HttpServlet {

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

            String op = request.getParameter("op");

            if (op.equals("listar")) {
                try {
                    //Declaracion a DB
                    PreparedStatement sta = ConexionDB.getConnection().
                            prepareStatement("SELECT t.id_tarifa, c.cat_nombre, t.tar_precio \n"
                                    + "FROM tarifario t INNER JOIN categoria c \n"
                                    + "ON t.id_catategoria = c.id_catategoria");
//Ejecutar declaracion con Query
                    ResultSet rs = sta.executeQuery();

//Crear nueva lista Array
                    ArrayList<Tarifario> lista = new ArrayList<>();
                    while (rs.next()) {
//Llamar a los datos a la clase empleado
                        Tarifario tf = new Tarifario(rs.getInt(1), rs.getString(2), rs.getDouble(3));

//Mandar a la lista "em"
                        lista.add(tf);
                    }
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("Tarifario.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Error" + e);
                }
            } else if (op.equals("insertar")) {
                int id = Integer.parseInt(request.getParameter("new_id"));
                int cat = Integer.parseInt(request.getParameter("new_cat"));
                double precio = Double.parseDouble(request.getParameter("new_price"));
                try {
                    //Declaracion a DB
                    PreparedStatement sta = ConexionDB.getConnection().
                            prepareStatement("INSERT INTO tarifario VALUES (?,?,?)");

                    sta.setInt(1, id);
                    sta.setInt(2, cat);
                    sta.setDouble(3, precio);

                    sta.executeUpdate();

                    request.setAttribute("t_new_in", "Tarifa Registrada");
                    request.getRequestDispatcher("Servlet_Tarifario?op=listar").forward(request, response);
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
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
