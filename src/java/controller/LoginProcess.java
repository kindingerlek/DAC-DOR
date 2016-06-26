/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.entities.Admin;
import utils.MessageLabel;

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
        List<String> errorMessages = new ArrayList();
        HttpSession session = request.getSession();
        //Get the request data
        String password = (String) request.getParameter("password");
        String email = (String) request.getParameter("email");
        //Validate request data
        if (password.isEmpty() || email.isEmpty()) {
            errorMessages.add("Preencha todos os campos.");
            session.setAttribute("errorMessages", errorMessages);
            response.sendRedirect("index.jsp");
        } else {
            //Try found the user
            Admin admin = new Admin();
            admin.setEmail(email);
            admin.setPassword(password);
            Admin adminToFound = admin.auth();

            //Do something
            if (adminToFound != null) {
                if (adminToFound.getId() > 0) {
                    //Salvar user na sessão;  
                    session.setAttribute("admin", adminToFound);
                    MessageLabel message = new MessageLabel();
                    message.setMessageType(true, "", "Login realizado com sucesso");
                    session.setAttribute("message", message);
                    //Redirect to debtors
                    response.sendRedirect("ListDebtors");
                } else if (adminToFound.getId() == -1) {
                    errorMessages.add("Houve um problema ao acessar o banco de dados,por favor tente novamente em alguns instantes.");
                    session.setAttribute("errorMessages", errorMessages);
                    response.sendRedirect("index.jsp");
                }
            } else {
                errorMessages.add("Login ou Senha não encontrados.");

                session.setAttribute("errorMessages", errorMessages);
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
