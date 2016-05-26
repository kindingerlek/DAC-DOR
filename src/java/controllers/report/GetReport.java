/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.report;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.entities.PersonCompanySituation;
import models.entities.PersonCompanySituationLog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import static utils.HibernateUtils.getSessionFactory;
import utils.report.PersonCompanySituationLogREL;

/**
 *
 * @author Alisson
 */
@WebServlet(name = "GetReport", urlPatterns = {"/GetReport"})
public class GetReport extends HttpServlet {

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
        List listToMakeReport = (List) request.getAttribute("PersonCompanySituationList");
        if (!listToMakeReport.isEmpty()) {
            if (listToMakeReport.get(0).getClass() == PersonCompanySituationLog.class) {
                try {
                    PersonCompanySituationLogREL relatorio = new PersonCompanySituationLogREL();
                    JasperPrint pdfToPrint = relatorio.getHistoryReport(listToMakeReport);
                    response.setContentType("application/pdf");
                    OutputStream outputStream = null;
                    outputStream = response.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(pdfToPrint, outputStream);
                } catch (Exception e) {
                    request.setAttribute("message", "Erro ao gerar Pdf: " + e.getMessage());
                    request.getRequestDispatcher("error.jsp").forward(request, response);

                }
            } else if (listToMakeReport.get(0).getClass() == PersonCompanySituation.class) {
                try {
                    PersonCompanySituationLogREL relatorio = new PersonCompanySituationLogREL();
                    JasperPrint pdfToPrint = relatorio.getSituationReport(listToMakeReport);
                    response.setContentType("application/pdf");
                    OutputStream outputStream = null;
                    outputStream = response.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(pdfToPrint, outputStream);
                } catch (Exception e) {
                    request.setAttribute("message", "Erro ao gerar Pdf: " + e.getMessage());
                    request.getRequestDispatcher("error.jsp").forward(request, response);

                }
            }
        }
        request.setAttribute("message", "Erro ao gerar relatório, nenhum item para ser processado.");
        request.getRequestDispatcher("error.jsp").forward(request, response);
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
