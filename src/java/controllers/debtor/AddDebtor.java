/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.debtor;

import controllers.debtor.*;
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
import models.entities.Debtor;
import utils.MessageLabel;
import utils.Validate;

/**
 *
 * @author Alisson
 */
@WebServlet(name = "AddDebtor", urlPatterns = {"/AddDebtor"})
public class AddDebtor extends HttpServlet {

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

        String identifier = request.getParameter("identifier");
        String name = request.getParameter("name");

        Debtor debtorToAdd = new Debtor();

        debtorToAdd.setName(name);
        debtorToAdd.setIdentifier(identifier);

        //Validação
        if (name.isEmpty()) {
            errorMessages.add("Insira um nome para o devedor.");
        }
        if (!(Validate.isCNPJ(identifier) || Validate.isCPF(identifier))) {
            errorMessages.add("Esse identificardor é inválido. Insira um CPF/CNPJ válido.");
        }
        Debtor debtorToVerify = debtorToAdd.getDebtorByIdentifier();
        
        if (debtorToVerify != null) {
            System.out.println(debtorToVerify.getId());
            System.out.println(debtorToVerify.getIdentifier());
            errorMessages.add("Esse identificardor já está cadastrado para outro devedor.");
        }
        
        if (!errorMessages.isEmpty()) {
            session.setAttribute("errorMessages", errorMessages);
            response.sendRedirect("addDebtor.jsp");
        } else {
            //Mensagem pós ação
            MessageLabel message = new MessageLabel();

            if (debtorToAdd.add()) {
                message.setMessageType(true, "", "O devedor foi adicionado com sucesso!");
                session.setAttribute("message", message);
                response.sendRedirect("ListDebtors");
            } else {
                message.setMessageType(false, "", "Ocorreu um erro ao adicionar o devedor, verifique os campos e tente novamente.");
                session.setAttribute("message", message);
                response.sendRedirect("addDebtor.jsp");
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
