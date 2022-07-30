/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Utils.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "Servlet_Login", urlPatterns = {"/Servlet_Login"})
public class Servlet_Login extends HttpServlet {

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

            String op = request.getParameter("opcion");

            if (op.equals("iniciar_sesion")) {
                String correo = request.getParameter("email"); //CAMBIAR VARIABLES
                String password = request.getParameter("password");

                try {
                    PreparedStatement psta = ConexionDB.getConnection().
                            prepareStatement("SELECT * FROM usuarios WHERE correo=? and contra=?");

                    psta.setString(1, correo);
                    psta.setString(2, password);

                    ResultSet rs = psta.executeQuery();

                    if (rs.next()) {
                        //Variable de sesion
                        HttpSession sesionOk = request.getSession();
                        sesionOk.setAttribute("dni", rs.getString(1).toString());
                        sesionOk.setAttribute("usuario", rs.getString(2).toString());
                        sesionOk.setAttribute("correo", rs.getString(3).toString());
                        sesionOk.setAttribute("cargo", rs.getString(5).toString());

//Cambia a la ventana principal
                        request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                    } else {
//Si no es correcto
                        request.setAttribute("I_msg", "Correo o contraseña incorrectos");
                        request.getRequestDispatcher("Login.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }

            } else if (op.equals("cerrar_sesion")) {
                HttpSession sesionOk = request.getSession();
                sesionOk.invalidate();
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else if (op.equals("registrar")) {
                //INSTANCIANDO LAS VARIABLES                
                String dni = request.getParameter("dni");
                String user = request.getParameter("usuario");
                String email = request.getParameter("email");
                String pass = request.getParameter("password");
                String cargo = request.getParameter("cargo");

                try {
//DECLARACION A LA BD
                    PreparedStatement sta = ConexionDB.getConnection().
                            prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?)");

                    sta.setString(1, dni);
                    sta.setString(2, user);
                    sta.setString(3, email);
                    sta.setString(4, pass);
                    sta.setString(5, cargo);

                    sta.executeUpdate();

                    request.setAttribute("R_msg_S", "Usuario Registrado");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
                    request.setAttribute("R_msg_E", "Verifique sus datos ingresados");
                    request.getRequestDispatcher("Registrarse.jsp").forward(request, response);

                }
            } else if (op.equals("recuperar")) {                
                String email = request.getParameter("email");
                String pass = request.getParameter("password");

                try {
//Declaracion a DB
                    PreparedStatement sta = ConexionDB.getConnection().
                            prepareStatement("UPDATE usuarios SET contra=? WHERE correo=?");

                    sta.setString(1, pass);                    
                    sta.setString(2, email);

                    sta.executeUpdate();

                    request.setAttribute("Rp_msg_S", "Contraseña Actualizada");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
                    request.setAttribute("Rp_msg_E", "Verifique que su correo sea el correcto");
                    request.getRequestDispatcher("Recuperar_Password.jsp").forward(request, response);

                }
            } else if (op.equals("editar")) {

                String u_dni = request.getParameter("dni");
                String usuario = request.getParameter("usuario");
                String email = request.getParameter("email");

                try {
                    //Declaracion a DB
                    PreparedStatement sta = ConexionDB.getConnection().
                            prepareStatement("UPDATE usuarios SET usuario=?, correo=? WHERE dni=?");

                    sta.setString(1, usuario);
                    sta.setString(2, email);
                    sta.setString(3, u_dni);

                    sta.executeUpdate();

                    request.setAttribute("Pf_msg_S", "Datos Actualizados");
                    request.getRequestDispatcher("Perfil.jsp").forward(request, response);

                } catch (Exception e) {

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
