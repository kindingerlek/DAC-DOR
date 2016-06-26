/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
 * @author Bruno
 */
@WebServlet(name = "AddAdmin", urlPatterns = {"/AddAdmin"})
public class AddAdmin extends HttpServlet {

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
        String urlToSend = "ListAdmins";
        HttpSession session = request.getSession();
        List<String> errorMessages = new ArrayList();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");
        String name = request.getParameter("name");

        if (name.isEmpty()) {
            errorMessages.add("Insira um nome para o administrador.");
        }
        if (email.isEmpty()) {
            errorMessages.add("Insira um email para o administrador.");
        }
        if (password.isEmpty()) {
            errorMessages.add("Insira uma senha.");
        }
        if (!passwordConfirmation.equals(password)) {
            errorMessages.add("As senhas informadas não estão iguais.");
        }

        Admin adminToVerifyInDb = new Admin();
        adminToVerifyInDb.setEmail(email);
        adminToVerifyInDb = adminToVerifyInDb.getAdminByEmail();

        if (adminToVerifyInDb != null) {
            if (adminToVerifyInDb.getId() == -1) {
                errorMessages.add("Houve um problema ao verificar se email já está em uso, por favor volte em alguns instantes.");
            } else {
                errorMessages.add("O email informado já está cadastrado.");
            }
        }
        if (!errorMessages.isEmpty()) {
            session.setAttribute("errorMessages", errorMessages);
            response.sendRedirect("addAdmin.jsp");
        } else {
            Admin adminToAdd = new Admin();
            adminToAdd.setEmail(email);
            adminToAdd.setPassword(password);
            adminToAdd.setName(name);
            adminToAdd.add();
            //Mensagens pos ação
            MessageLabel message = new MessageLabel();
            if (adminToAdd.add()) {
                message.setMessageType(true, "", "O Administrador foi Adicionado com sucesso!");
                session.setAttribute("message", message);
                response.sendRedirect("ListAdmins");
            } else {
                message.setMessageType(false, "", "Ocorreu um erro ao adicionar o administrador, verifique os campos e tente novamente.");
                session.setAttribute("message", message);
                response.sendRedirect("addAdmin.jsp");
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
