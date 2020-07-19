/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author oriana
 */
public class FormaPagoM extends Conexion{
    private int id;
    private String nombre;
 

    public FormaPagoM() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public FormaPagoM(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

 
    
    public String toString(){
    return this.nombre;
    }
    public Vector<FormaPagoM>mostrarFP(){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        Vector<FormaPagoM>datos = new Vector<FormaPagoM>();
        FormaPagoM dat = null;
        try {
            String sql = "SELECT * FROM formapago";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new FormaPagoM();
            dat.setId(0);
            dat.setNombre("-Selecciona Forma de Pago-");
            datos.add(dat);
            
            while (rs.next()) {
            dat = new FormaPagoM();
            dat.setId(rs.getInt("id"));
            dat.setNombre(rs.getString("nombre"));
            datos.add(dat);
                
            }
            rs.close();
            
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
         
        }
        return datos;
    }
}
