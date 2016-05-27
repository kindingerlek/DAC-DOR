/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.entities.Admin;

/**
 *
 * @author Alisson
 */
@WebServlet(name = "LoginProcess", urlPatterns = {"/LoginProcess"})
public class LoginProcess extends HttpServlet {

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
            out.println((String)request.getParameter("email"));
            out.println((String)request.getParameter("password"));
            
            //Get the request data
            String password = (String)request.getParameter("password");
            String email = (String)request.getParameter("email");
            //Validate request data
            if(!password.isEmpty()&& !email.isEmpty()){
            
            }
            //Try found the user
            Admin admin = new Admin();
            admin.setEmail(email);
            admin.setPassword(password);
            admin = admin.auth();
            
            //Do something
            if(admin != null && admin.getId()>0){
                //Salvar user na sessão;
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                
                //Redirect to debtors
                request.getRequestDispatcher("ListPersons").forward(request, response);
            }else{
                //Redirect to login
                response.sendRedirect("index.jsp");
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
