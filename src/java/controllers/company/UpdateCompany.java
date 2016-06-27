/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.company;

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
import models.entities.Company;
import utils.MessageLabel;

/**
 *
 * @author Alisson
 */
@WebServlet(name = "UpdateCompany", urlPatterns = {"/UpdateCompany"})
public class UpdateCompany extends HttpServlet {

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
        Company companyToUpdate = new Company();
        List<String> errorMessages = new ArrayList();
        HttpSession session = request.getSession();

        int companyId = Integer.parseInt((String) request.getParameter("companyId"));
        String token = request.getParameter("token");
        String name = request.getParameter("name");
        String urlToSend = "GetCompany?companyId=" + companyId;

        companyToUpdate.setId(companyId);
        companyToUpdate.setToken(token);
        companyToUpdate.setName(name);

        //Validação
        Company oldCompany = companyToUpdate.getCompany();
        if (token.isEmpty()) {
            errorMessages.add("Insira um token para a instituição.");
        }
        if (name.isEmpty()) {
            errorMessages.add("Insira um nome para a instituição");
        }
        if (!oldCompany.getToken().equals(token)) {
            if (companyToUpdate.getCompanyByToken() != null) {
                errorMessages.add("Esse token já está cadastrado para outra instituição.");
            }
        }

        if (!errorMessages.isEmpty()) {

            session.setAttribute("errorMessages", errorMessages);
            response.sendRedirect(urlToSend);
        } else {
            
            //Mensagem pós ação
            MessageLabel message = new MessageLabel();
            if (companyToUpdate.update()) {
                message.setMessageType(true, "", "A instituição foi atualizada com sucesso!");
            } else {
                message.setMessageType(false, "", "Ocorreu um erro ao atualizar a instituição, verifique os campos e tente novamente.");
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
