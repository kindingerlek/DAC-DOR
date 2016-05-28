/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.report;

import java.util.List;
import models.entities.DebtorCompanySituationLog;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Alisson
 */
public class DebtorCompanySituationLogREL {

    private String path; //Caminho base

    private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper

    //Recupera os caminhos para que a classe possa encontrar os relatórios
    public DebtorCompanySituationLogREL() {
        this.path = this.getClass().getClassLoader().getResource("").getPath();
        this.pathToReportPackage = this.path + "utils/report/";
        System.out.println(pathToReportPackage);
    }

    //Imprime/gera uma lista de DebtorCompanySituationLogs
    public JasperPrint getHistoryReport(List<DebtorCompanySituationLog> clients) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "DebtorHistoryReport.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clients));
        return print;
    }
    
    public JasperPrint getSituationReport(List<DebtorCompanySituationLog> clients) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "DebtorSituationReport.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clients));
        return print;
    }

    public String getPathToReportPackage() {
        return this.pathToReportPackage;
    }

    public String getPath() {
        return this.path;
    }

}
