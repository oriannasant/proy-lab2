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
public class Horario {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    private int id;
    private String horario;

    public String toString() {
        return this.horario;
    }

    public Vector<Horario> mostrarHorario() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conx = new Conexion();
        Connection con = conx.getConnection();
        Vector<Horario> datos = new Vector<Horario>();
        Horario dat = null;
        try {
            String sql = "SELECT id,horario FROM horario WHERE estatus = 'A'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Horario();
            dat.setId(0);
            dat.setHorario("-Selecione Horario-");
            datos.add(dat);

            while (rs.next()) {
                dat = new Horario();
                dat.setId(rs.getInt("id"));
                dat.setHorario(rs.getString("horario"));
                datos.add(dat);

            }
            rs.close();

        } catch (Exception e) {
            //System.out.println("Error " + e.getMessage());

        }
        return datos;
    }

}
