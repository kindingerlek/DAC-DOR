/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bruno
 */
public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5434/dor", "postgres", "admin");
            System.out.println("Conectado com sucesso.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema com conexão erro:" + ex.getMessage());
        }
       
        return c;
    }
}
