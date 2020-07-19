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
 * @author Yamilex Sayago
 */
public class Funcion {

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

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    int id;
    String nombre;
    String clasificacion;
    String sala;
    String horario;
    
    public String toString(){
    return this.nombre;
    }
    public Vector<Funcion> mostrarFuncion() {
        PreparedStatement ps = null;
        ResultSet rs = null;
         Conexion conx = new Conexion();
         Connection con = conx.getConnection();
        Vector<Funcion> datos = new Vector<Funcion>();
        Funcion fun = null;
        try {
            String sql = "SELECT id,nombre FROM funcion WHERE estatus='A'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            fun = new Funcion();
            fun.setId(0);
            fun.setNombre("-Selecione la Pelicula-");
            datos.add(fun);

            while (rs.next()) {
                fun = new Funcion();
                fun.setId(rs.getInt("id"));
                fun.setNombre(rs.getString("nombre"));
                datos.add(fun);

            }
            rs.close();

        } catch (Exception e) {
           // System.out.println("Error " + e.getMessage());

        }
        return datos;
    }
    
}
