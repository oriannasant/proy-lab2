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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.ActualizarPelicula;
import vista.BuscarPelicula;

/**
 *
 * @author Yamilex Sayago
 */
public class PeliculaDao extends Conexion {

    Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;

    public String insertPelicula(String nombre, String clasificacion, String genero, String descripcion, String duracion) {

        String resp = null;
        // PreparedStatement ps = null;

        String sql = "INSERT INTO pelicula(nombre,clasificacion,genero,descripcion,duracion,estatus)VALUES(?,?,?,?,?,'A')";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, clasificacion);
            ps.setString(3, genero);
            ps.setString(4, descripcion);
            ps.setString(5, duracion);
            int numf = ps.executeUpdate();
            if (numf > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR" + e.getMessage());

        }
        return resp;

    }

    public void cargar() {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };

            BuscarPelicula.jTablaPelicula.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String SQL = "SELECT id,nombre,clasificacion,genero,descripcion,duracion FROM pelicula WHERE estatus='A'";

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidad = rsMD.getColumnCount();
            model.addColumn("Id");
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
                BuscarPelicula.jTablaPelicula.setVisible(true);
                // BuscarPelicula.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }

    }

    public void buscar(BuscarPelicula bpeli) {
        String text = bpeli.txtBuscar2.getText();

        String sql;

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };

        ResultSet rs = null;
        if (text.equals("")) {

            sql = "SELECT id,nombre,clasificacion,genero,descripcion,duracion FROM pelicula WHERE estatus='A'";

        } else {

            sql = "SELECT id,nombre,clasificacion,genero,descripcion,duracion FROM pelicula WHERE nombre LIKE '%" + text + "%' and estatus='A' ";

        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidad = rsMD.getColumnCount();

            model.addColumn("Id");
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
                bpeli.jTablaPelicula.setModel(model);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }

    public void borrar() {

        try {
            int fila = BuscarPelicula.jTablaPelicula.getSelectedRow();

            String sql = "UPDATE pelicula SET estatus='I' WHERE id=" + BuscarPelicula.jTablaPelicula.getValueAt(fila, 0).toString();

            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR AL ELMINAR UN REGISTRO");
        }

    }

    public String editar(String nombre, String clasificacion, String genero, String descripcion, String duracion, int id) {
        String resp = null;

        String text = ActualizarPelicula.txtNombre.getText();

        if (ActualizarPelicula.txtNombre.getText().length() == 0 || ActualizarPelicula.txtClasificacion.getText().length() == 0
                || ActualizarPelicula.txtGenero.getText().length() == 0 || ActualizarPelicula.txtDescripcion.getText().length() == 0) {

            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS DEBEN ESTAR COMPLETOS");

        }

        String sql = "UPDATE pelicula SET"
                + " nombre = ?,"
                + " clasificacion = ?,"
                + " genero = ?,"
                + " descripcion = ?,"
                + " duracion = ?"
                + "WHERE id = ? ";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, clasificacion);
            ps.setString(3, genero);
            ps.setString(4, descripcion);
            ps.setString(5, duracion);
            ps.setInt(6, id);
            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());

        }
        return resp;

    }
    public void agregarpeliculaselec(int item) {

        int fila = BuscarPelicula.jTablaPelicula.getSelectedRow();

        //String sql = "INSERT INTO pelicproyectada(nombre,clasificacion,genero,descripcion,duracion) Select nombre,clasificacion,genero,descripcion,duracion FROM pelicula ";
        try {
            String nombre, clasificacion, genero, descripcion, duracion;
          

            if (fila == -1) {

                JOptionPane.showMessageDialog(null, "DEBE SELECIONAR UNA FILA");

            } else {
                DefaultTableModel m = (DefaultTableModel) BuscarPelicula.jTablaPelicula.getModel();
                nombre = BuscarPelicula.jTablaPelicula.getValueAt(fila, 1).toString();
                clasificacion = BuscarPelicula.jTablaPelicula.getValueAt(fila, 2).toString();
                genero = BuscarPelicula.jTablaPelicula.getValueAt(fila, 3).toString();
                descripcion = BuscarPelicula.jTablaPelicula.getValueAt(fila, 4).toString();
                duracion = BuscarPelicula.jTablaPelicula.getValueAt(fila, 5).toString();

                String sql = "INSERT INTO pelicproyectada (nombre,clasificacion,genero,descripcion,duracion,idsucursal,estatus) VALUES(?,?,?,?,?,?,'A')";
                ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, clasificacion);
                ps.setString(3, genero);
                ps.setString(4, descripcion);
                ps.setString(5, duracion);
                ps.setInt(6, item);
                ps.executeUpdate();
              
                JOptionPane.showMessageDialog(null,"PELICULA AGREGADA EXITOSAMENTE!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"PElICULA YA AGREGADA EN CARTELERA");
            System.out.println("Error " + e.getMessage());

        }
    }
}
