/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import vista.Cartelera;

/**
 *
 * @author Yamilex Sayago
 */
public class CarteleraDao {

    public void cargar(Empleado emp) {

        try {

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };

            Cartelera.jtableCartelera.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conx = new Conexion();
            Connection con = conx.getConnection();

            String SQL = "SELECT nombre,clasificacion,genero,descripcion,duracion FROM pelicproyectada WHERE estatus='A' AND idsucursal=" + emp.getCodigoSucursalEmpleado();

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidad = rsMD.getColumnCount();

            model.addColumn("NOMBRE");
            model.addColumn("CLASIFICACION");
            model.addColumn("GENERO");
            model.addColumn("DESCRIPCION");
            model.addColumn("DURACION");
            while (rs.next()) {

                Object[] filas = new Object[cantidad];

                for (int i = 0; i < cantidad; i++) {

                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
             
            }
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }

    }
 public void cargar2() {

        try {

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };

            Cartelera.jtableCartelera.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conx = new Conexion();
            Connection con = conx.getConnection();

            String SQL = "SELECT nombre,clasificacion,genero,descripcion,duracion FROM pelicproyectada WHERE estatus='A'";

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidad = rsMD.getColumnCount();

            model.addColumn("NOMBRE");
            model.addColumn("CLASIFICACION");
            model.addColumn("GENERO");
            model.addColumn("DESCRIPCION");
            model.addColumn("DURACION");
            while (rs.next()) {

                Object[] filas = new Object[cantidad];

                for (int i = 0; i < cantidad; i++) {

                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
             
            }
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }

    }

}
