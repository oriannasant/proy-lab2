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
import vista.AgregarFuncion;

/**
 *
 * @author Yamilex Sayago
 */

public class Sala {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numerosala;
    }

    public void setNumero(String numerosala) {
        this.numerosala = numerosala;
    }

    public int getCanasientos() {
        return canasientos;
    }

    public void setCanasientos(int canasientos) {
        this.canasientos = canasientos;
    }

    public int getCodigosucursal() {
        return codigosucursal;
    }

    public void setCodigosucursal(int codigosucursal) {
        this.codigosucursal = codigosucursal;
    }
    private int id;
    public String numerosala;
    private int canasientos;
    private int codigosucursal;
   @Override 
     public String toString(){
    return this.numerosala;
    }
   /* public Vector<Sala> mostrarSalas() {
        PreparedStatement ps = null;
        ResultSet rs = null;
         Conexion conx = new Conexion();
         Connection con = conx.getConnection();
        
        Vector<Sala> datos = new Vector<Sala>();
        Sala dat = null;
        try {
            
            
            String sql = "SELECT id,numero FROM sala WHERE estatus='A' AND idsucursal='"+2+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Sala();
            dat.setId(0);
            dat.setNumero("-Selecione Sala-");
            datos.add(dat);

            while (rs.next()) {
                dat = new Sala();
                dat.setId(rs.getInt("id"));
                dat.setNumero(rs.getString("numero"));
                datos.add(dat);

            }
            rs.close();

        } catch (Exception e) {
           // System.out.println("Error " + e.getMessage());

        }
        return datos;
    }*/
}
