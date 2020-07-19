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
public class Ciudad extends Conexion{
    private int id;
    private String nombre;

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
    public String toString(){
    return this.nombre;
    }
    public Vector<Ciudad>mostrarCiudad(){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        Vector<Ciudad>datos = new Vector<Ciudad>();
        Ciudad dat = null;
        try {
            String sql = "SELECT * FROM ciudad";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Ciudad();
            dat.setId(0);
            dat.setNombre("-Selecciona Ciudad-");
            datos.add(dat);
            
            while (rs.next()) {
            dat = new Ciudad();
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
