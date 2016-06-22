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
import java.util.Collection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.entities.Company;
import models.entities.Debtor;
import models.entities.DebtorCompanySituation;
import utils.MessageLabel;
import utils.Validate;

/**
 *
 * @author Alisson
 */
@WebServlet(name = "UpdateDebtor", urlPatterns = {"/UpdateDebtor"})
public class UpdateDebtor extends HttpServlet {

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
        Debtor debtorToUpdate = new Debtor();
        List<String> errorMessages = new ArrayList();
        HttpSession session = request.getSession();

        String name = (String) request.getParameter("debtor.name");
        Integer id = Integer.parseInt((String) request.getParameter("debtorId"));
        String identifier = (String) request.getParameter("debtor.identifier");

        String urlToSend = "GetDebtor?debtorId=" + id;
        debtorToUpdate.setId(id);
        debtorToUpdate.setName(name);
        debtorToUpdate.setIdentifier(identifier);
        Debtor oldDebtor = debtorToUpdate.getDebtor();

        //Validação
        if (name.isEmpty()) {
            errorMessages.add("Insira um nome para o devedor.");
        }
        if (!(Validate.isCNPJ(identifier) || Validate.isCPF(identifier))) {
            errorMessages.add("Esse identificardor é inválido. Insira um CPF/CNPJ válido.");
        }
        if (!oldDebtor.getIdentifier().equals(identifier)) {
            if (debtorToUpdate.getDebtorByIdentifier() != null) {
                errorMessages.add("Esse identificardor já está cadastrado para outro devedor.");
            }
        }

        if (!errorMessages.isEmpty()) {
            session.setAttribute("errorMessages", errorMessages);
            response.sendRedirect(urlToSend);
        } else {

            //Verify companies situations
            Integer index = 0;
            List<DebtorCompanySituation> updatedDebtorCompanySituation = new ArrayList();
            for (DebtorCompanySituation debComSit : oldDebtor.getSituationCompanies()) {
                index++;
                String indebted = (String) request.getParameter("debtor.situationCompanies[" + index + "].indebt");
                if ("true".equals(indebted)) {
                    debComSit.setIndebt(true);
                } else {
                    debComSit.setIndebt(false);
                }
                updatedDebtorCompanySituation.add(debComSit);
            }

            debtorToUpdate.setSituationCompanies(updatedDebtorCompanySituation);

            //Mensagem pós ação
            MessageLabel message = new MessageLabel();

            if (debtorToUpdate.update()) {
                message.setMessageType(true, "", "O devedor foi atualizado com sucesso!");
            } else {
                message.setMessageType(false, "", "Ocorreu um erro ao atualizar o devedor, verifique os campos e tente novamente.");
            }
            session.setAttribute("message", message);
            response.sendRedirect(urlToSend);
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
