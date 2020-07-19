/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.sql.Connection;

/**
 *
 * @author oriana
 */
public class Conexion {
    
    Connection con;
    public Connection getConnection(){
            String url = "jdbc:postgresql://localhost:5432/otrabase";
            String user ="postgres";
            String pass = "12345";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("CONEXIÓN ESTABLECIDA");
            
        } catch (Exception e) {
            System.out.println("Error de conexión"+e.getMessage());
        }
    return con;
    }
    
}
