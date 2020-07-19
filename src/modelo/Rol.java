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
public class Rol extends Conexion{
    private int id_tipoRol;
    private String nombrerol;

    public int getId_tipoRol() {
        return id_tipoRol;
    }

    public void setId_tipoRol(int id_tipoRol) {
        this.id_tipoRol = id_tipoRol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }
    public String toString(){
    return this.nombrerol;
    }
    public Vector<Rol>mostrarRol(){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        Vector<Rol>datos = new Vector<Rol>();
        Rol dat = null;
        try {
            String sql = "SELECT * FROM rol";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Rol();
            dat.setId_tipoRol(0);
            dat.setNombrerol("-Seleccionar-");
            datos.add(dat);
            
            while (rs.next()) {
            dat = new Rol();
            dat.setId_tipoRol(rs.getInt("id"));
            dat.setNombrerol(rs.getString("nombre"));
            datos.add(dat);
                
            }
            rs.close();
            
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
         
        }
        return datos;
    }
}
