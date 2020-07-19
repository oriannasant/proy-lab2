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
public class Pelicula extends Conexion{
    private int id;
    private String nombre;
    private String clasificacion;
    private String descripcion;
    private String genero;
    private String duracion;

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

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
     public String toString(){
    return this.nombre;
    }
     public Vector<Pelicula>mostrarPelicula(){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        Vector<Pelicula>datos = new Vector<Pelicula>();
        Pelicula dat = null;
        try {
            String sql = "SELECT id,nombre FROM pelicproyectada WHERE estatus='A'";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Pelicula();
            dat.setId(0);
            dat.setNombre("-Seleccionar Pelicula-");
            datos.add(dat);
            
            while (rs.next()) {
            dat = new Pelicula();
            dat.setId(rs.getInt("id"));
            dat.setNombre(rs.getString("nombre"));
            datos.add(dat);
                
            }
            rs.close();
            
        } catch (Exception e) {
          //  System.out.println("Error "+e.getMessage());
         
        }
        return datos;
    }
}
