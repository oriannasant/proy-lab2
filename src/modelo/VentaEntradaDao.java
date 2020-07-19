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
import vista.VentanaEntrada;


/**
 *
 * @author oriana
 */


public class VentaEntradaDao {
    Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;
    ResultSet rs;
    int r=0;

    public void año1() {

        String valor = VentanaEntrada.spibebe.getValue().toString();
        VentanaEntrada.txtaño1.setText("0.0");

    }

    public void año2() {

        int valor = Integer.parseInt(VentanaEntrada.spinino1.getValue().toString());
        float des = 5f - (5f * 0.25f);
        float cuenta = valor * des;
        String c = String.valueOf(cuenta);
        VentanaEntrada.txtaño2.setText(c);

    }

    public void año3() {

        int valor = Integer.parseInt(VentanaEntrada.spinino2.getValue().toString());
        float des = 5f - (5f * 0.15f);
        float cuenta = valor * des;
        String c = String.valueOf(cuenta);
        VentanaEntrada.txtaño3.setText(c);

    }

    public void año4() {

        int valor = Integer.parseInt(VentanaEntrada.spiadulto.getValue().toString());

        float cuenta = valor * 5;
        String c = String.valueOf(cuenta);
        VentanaEntrada.txtaño4.setText(c);

    }

    public void año5() {

        int valor = Integer.parseInt(VentanaEntrada.spiviejo.getValue().toString());

        float cuenta = valor * (5f/2f);
        String c = String.valueOf(cuenta);
        VentanaEntrada.txtaño5.setText(c);

    }

    public void total() {

        String pr1 = VentanaEntrada.txtaño1.getText();
        float val1 = Float.valueOf(pr1);
        String pr2 = VentanaEntrada.txtaño2.getText();
        float val2 = Float.valueOf(pr2);
        String pr3 = VentanaEntrada.txtaño3.getText();
        float val3 = Float.valueOf(pr3);
        String pr4 = VentanaEntrada.txtaño4.getText();
        float val4 = Float.valueOf(pr4);
        String pr5 = VentanaEntrada.txtaño5.getText();
        float val5 = Float.valueOf(pr5);
        
        float total = val1 + val2 + val3 + val4 + val5;
        String totalmostrar = String.valueOf(total);
        VentanaEntrada.txtTotal.setText(totalmostrar);
        
    }
     public int guardarVentaEntrada(VentaEntrada ven){
 
        String sql= "INSERT INTO ventaentrada ( idcliente, idvendedor,montototal,cantidaden,fecha,formapago,estatus) VALUES(?,?,?,?,?,?,'A') ";
        try {
            //,fechaventa la fecha como se hizo el video genera error
            ps = con.prepareStatement(sql);
            //ps.setInt(1, v.getCodigoventa());
            ps.setInt(1, ven.getIdcliente());
            ps.setInt(2, ven.getIdvendedor());
            ps.setFloat(3, ven.getmontototal());
            ps.setInt(4, ven.getcantidaden());
            ps.setString(5, ven.getFecha());
            ps.setString(6, ven.getFormaP());
            r= ps.executeUpdate();
            //rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA VENTA DE ENTRADA"+e);
        }
    
    return r;
    }
    
      public int guardarDetalleVenta(DetalleEntrada deen){
        
        String sql= "INSERT INTO detalleentrada (idventaentrada,idfuncion,edad1,edad2,edad3,edad4,edad5) VALUES(?,?,?,?,?,?,?) ";
        try {
            ps = con.prepareStatement(sql);
           
            ps.setInt(1, deen.getIdventaentrada());
            ps.setInt(2, deen.getIdfuncion());
            ps.setInt(3, deen.getEdad1());
            ps.setInt(4, deen.getEdad2());
            ps.setInt(5, deen.getEdad3());
            ps.setInt(6, deen.getEdad4());
            ps.setInt(7, deen.getEdad5());
            ps.executeUpdate();
            // rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e);
        }
        return r;
    }
       public String idVentaentrada(){
        String idv ="";
        String sql= "SELECT max(id) FROM ventaentrada ";
        try {//agarro el id 3 que era la unica venta que existia enla bd
            //entonces coloca el id de detalle venta al numero max
            // esta como raro porque si no inserta la venta como va a pasar ese id
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idv= rs.getString(1);
                
            }        
        } catch (Exception e) {
        }
        return idv;
    }
       
          
    public int actudisp(int cant,int id){
    
        String sql="UPDATE funcion SET disponibilidad=? WHERE id=?";
    
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, id);
            r=ps.executeUpdate();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR MANO"+e);
        }
    
    return r;
    }
    
}
