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
public class Producto extends Conexion{
      int codigo;
    String nombreProducto;
    float precio;
    String disponibilidad;

    public Producto() {
    }
    

    public Producto(int codigo, String nombreProducto, float precio, String disponibilidad) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
            
    public String toString(){
    return this.nombreProducto;
    }
    public Vector<Producto>mostrarProducto(){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        Vector<Producto>datos = new Vector<Producto>();
        Producto dat = null;
        try {
            String sql = "SELECT * FROM producto";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Producto();
            dat.setCodigo(0);
            dat.setNombreProducto("-Seleccionar Producto-");
            datos.add(dat);
            
            while (rs.next()) {
            dat = new Producto();
            dat.setCodigo(rs.getInt("codigo"));
            dat.setNombreProducto(rs.getString("nombreproducto"));
            datos.add(dat);
                
            }
            rs.close();
            
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
         
        }
        return datos;
    }
    
}
