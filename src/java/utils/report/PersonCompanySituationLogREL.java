/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.report;

import java.util.List;
import models.entities.PersonCompanySituationLog;
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
public class PersonCompanySituationLogREL {

    private String path; //Caminho base

    private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper

    //Recupera os caminhos para que a classe possa encontrar os relatórios
    public PersonCompanySituationLogREL() {
        this.path = this.getClass().getClassLoader().getResource("").getPath();
        this.pathToReportPackage = this.path + "utils/report/";
        System.out.println(pathToReportPackage);
    }

    //Imprime/gera uma lista de PersonCompanySituationLogs
    public JasperPrint getHistoryReport(List<PersonCompanySituationLog> clients) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "PersonHistoryReport.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clients));
        return print;
    }
    
    public JasperPrint getSituationReport(List<PersonCompanySituationLog> clients) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "PersonSituationReport.jrxml");
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
