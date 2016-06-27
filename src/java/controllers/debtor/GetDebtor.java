/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.debtor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.entities.Company;
import models.entities.Debtor;
import models.entities.DebtorCompanySituation;
import models.entities.DebtorCompanySituationLog;

/**
 *
 * @author Alisson
 */
@WebServlet(name = "GetDebtor", urlPatterns = {"/GetDebtor"})
public class GetDebtor extends HttpServlet {

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
        String identifier = request.getParameter("identifier");
        Integer idDebtor = Integer.parseInt(request.getParameter("debtorId"));
        Debtor debtor = new Debtor();
        if (idDebtor != null) {
            debtor.setId(idDebtor);
            debtor = debtor.getDebtor();
        } else if (identifier != null) {
            List<Debtor> debtorList = (List<Debtor>) Debtor.getAll("identifier", identifier);
            if (!debtorList.isEmpty()) {
                debtor = debtorList.get(0);
            }
        }
        loadCompaniesSituation(debtor);
        List <DebtorCompanySituationLog> logHistory = DebtorCompanySituationLog.getAll(debtor);
        System.out.println(debtor.getName());
        debtor = debtor.getDebtor();
        request.setAttribute("debtor", debtor);
        request.setAttribute("debtorCompanySituationLogs", logHistory);
        
        request.getRequestDispatcher("editDebtor.jsp").forward(request, response);

    }

    private void loadCompaniesSituation(Debtor debtor) {
        boolean changed = false;
        List<Company> companiesToAdd = Company.getAll();
        List<Company> debtorCompanies = Company.getAll();
        for (DebtorCompanySituation dcs : debtor.getSituationCompanies()) {
            debtorCompanies.add(dcs.getCompany());
        }

        for (Company companyToAdd : companiesToAdd) {
            DebtorCompanySituation newDebComSit = new DebtorCompanySituation(companyToAdd, debtor);
            newDebComSit.setIndebt(false);
            if(!debtor.getSituationCompanies().contains(newDebComSit)){
                debtor.getSituationCompanies().add(newDebComSit);
                newDebComSit.setSituationDate(new Date());
                changed = true;
            }            
        }
      
        if (changed) {
            debtor.update();
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
