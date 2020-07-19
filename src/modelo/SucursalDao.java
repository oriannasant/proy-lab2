/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author oriana
 */
public class SucursalDao extends Conexion{
    
    /**
     *
     * @param sur
     * @return
     */
    Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;
    public String registrar(String rif, String nombre, String descripcion, int idciudad) {
        String resp = null;
        
        String sql = "INSERT INTO sucursal (rif, nombre, descripcion, idciudad) VALUES (?,?,?,?)";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, rif);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.setInt(4, idciudad);
            
            int numf = ps.executeUpdate();
            if (numf > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR" + e.getMessage());

        }
        return resp;
    
    }
     /*public boolean registrar(Sucursal sur){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql= "INSERT INTO sucursal (rif, nombre, descripcion, idciudad) VALUES (?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
                  ps.setString(1, sur.getRif());
                  ps.setString(2, sur.getNombre());
                  ps.setString(3, sur.getDescripcion());
                  ps.setInt(4, sur.getIdciudad());
                  ps.execute();
           return true;
            }
         
         catch (Exception e) { 
            System.out.println("Error "+e.getMessage());
            return false;
        }
    }
    
        public String registrar(Sucursal sur) {
        String resp = null;
        
        String sql = "INSERT INTO sucursal (rif, nombre, descripcion, idciudad) VALUES (?,?,?,?)";
        try {

            ps = con.prepareStatement(sql);
                  ps.setString(1, sur.getRif());
                  ps.setString(2, sur.getNombre());
                  ps.setString(3, sur.getDescripcion());
                  ps.setInt(4, sur.getIdciudad());
                  ps.execute();
            
            int numf = ps.executeUpdate();
            if (numf > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR" + e.getMessage());

        }
        return resp;
    
    }*/
 }
    
