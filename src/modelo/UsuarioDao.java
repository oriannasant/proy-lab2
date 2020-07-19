/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author oriana
 */
public class UsuarioDao extends Conexion{
    
    /**
     *
     * @param usr
     * @return
     */
      Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;
    
    /* public boolean registrar(Usuario usr){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql= "INSERT INTO usuario (usuario, contrasenna,codigoempleado,tiporol) VALUES (?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);

                  ps.setString(1, usr.getUsuario());
                  ps.setString(2, usr.getContrasenna());
                  ps.setInt(3, usr.getCodigoEmpleado());
                  ps.setInt(4, usr.getId_tipoRol());
                  ps.execute();
           return true;
            }
         
         catch (Exception e) { 
            System.out.println("Error "+e.getMessage());
            return false;
        }
    }*/
     public String registrar(String usuario,String contrasenna, int cod, int rol) {
        String resp = null;
        
          String sql= "INSERT INTO usuario (usuario, contrasenna,codigoempleado,tiporol) VALUES (?,?,?,?)";
        try {

                  ps = con.prepareStatement(sql);
                  
                  /*ps.setString(1, usr.getUsuario());
                  ps.setString(2, usr.getContrasenna());
                  ps.setInt(3, usr.getCodigoEmpleado());
                  ps.setInt(4, usr.getId_tipoRol());*/
                  
            ps.setString(1, usuario);
            ps.setString(2, contrasenna);
            ps.setInt(3, cod);
            ps.setInt(4, rol);
          
            int numf = ps.executeUpdate();
            if (numf > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR" + e.getMessage());

        }
        return resp;
    
    }
    public boolean login(Usuario usr, Sucursal sur,Empleado emp){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql ="SELECT u.usuario, u.contrasenna, u.tiporol,u.codigoempleado,e.codigosucursal,s.codigo,e.id FROM usuario AS u INNER JOIN rol AS r ON u.tiporol= r.id LEFT JOIN empleado AS e ON u.codigoempleado = e.id LEFT JOIN sucursal AS s ON e.codigosucursal = s.codigo WHERE usuario = ?";
       //String sql= "SELECT u.usuario, u.contrasenna, u.codigosucursal,u.tiporol,r.nombre,s.nombre,s.codigo FROM usuario AS u INNER JOIN rol AS r ON u.tiporol= r.id LEFT JOIN sucursal AS s ON u.codigosucursal = s.codigo WHERE usuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
         
            while (rs.next()) {
                if (usr.getContrasenna().equals(rs.getString(2))) 
                {
                    
                    usr.setId_tipoRol(rs.getInt(3));
                    usr.setCodigoEmpleado(rs.getInt(4));
                    emp.setCodigoSucursalEmpleado(rs.getInt(5));
                    sur.setCodigoSucursal(rs.getInt(6));
                    emp.setId(rs.getInt(7));
                    return true;
                    /*usr.setCodigoSucursal(rs.getInt(3));
                    usr.setId_tipoRol(rs.getInt(4));
                    usr.setNombrerol(rs.getString(5));
                    sur.setNombre(rs.getString(6));
                    sur.setCodigoSucursal(rs.getInt(7));
                    return true;*/
                }else 
                {
                return false;
                } 
            }
         return false;
            
        } catch (Exception e) { 
            System.out.println("Error "+e.getMessage());
            return false;
     }}
    
    }
    
