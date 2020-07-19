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
public class Sucursal extends Conexion{
    private String nombre;
     private String descripcion;
     private String rif;
     private int idciudad;
     private int codigoSucursal;

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public Sucursal() {
    }

    public Sucursal(String nombre, String descripcion, String rif, int idciudad, int codigoSucursal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rif = rif;
        this.idciudad = idciudad;
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }
    
    public String toString(){
    return this.nombre;
    }
    public Vector<Sucursal>mostrarSucursal(){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        Vector<Sucursal>datos = new Vector<Sucursal>();
        Sucursal dat = null;
        try {
            String sql = "SELECT nombre, rif FROM sucursal;";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Sucursal();
            dat.setRif("0");
            dat.setNombre("-Selecciona la Sucursal-");
            datos.add(dat);
            
            while (rs.next()) {
            dat = new Sucursal();
            dat.setRif(rs.getString("rif"));
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
