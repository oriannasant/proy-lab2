/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.DetalleDisponibilidad;

/**
 *
 * @author Yamilex Sayago
 */
public class DisponibilidadDao {
    
     Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int r = 0;
    
    
    public int cantidadven(int id,String horario){
        
    
    String sql = "SELECT SUM(edad1+edad2+edad3+edad4+edad5) as c  FROM detalleentrada INNER JOIN funcion ON idfuncion='"+id+"'AND funcion.horario ='"+horario+"'";
    
            
           // "SELECT SUM(edad1+edad2+edad3+edad4+edad5) as CantidadVendida FROM detalleentrada INNER JOIN funcion WHERE idfuncion='"+id+"' AND funcion.horario ='"+horario+"'";
    
        try {
            ps = con.prepareStatement(sql);
             rs= ps.executeQuery();
            
            if(rs.next()){
              int cantidad = (rs.getInt("c"))/2;
              String can = String.valueOf(cantidad);
              DetalleDisponibilidad.txtEntradaV.setText(can);
            
            }
            
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR"+e);
        }
    return r;
    }
    
    public void combo() {

        String nombre = DetalleDisponibilidad.cbxPelicula.getSelectedItem().toString();
        String sql = "SELECT * FROM funcion WHERE nombre =?";

        try {
            

            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String conid = String.valueOf(id);
                DetalleDisponibilidad.lblid.setText(conid);
                
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void dispo(int id){
    String sql = "SELECT * FROM funcion  WHERE  id=?";
    
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
            int dis = rs.getInt("disponibilidad");
            String did = String.valueOf(dis);
            DetalleDisponibilidad.txtAsientosD.setText(did);
            
            }
            
        } catch (Exception e) {
        }
    }
    
}
