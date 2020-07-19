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
import vista.ActualizarEmpleado;
import vista.BuscarEmpleado;

/**
 *
 * @author oriana
 */
public class EmpleadoDao extends Conexion {

    Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;
    Sucursal sur = new Sucursal();

    public String insertEmpleado(String cedula, String nombre, String apellido, String telefono, String direccion, String cargo, int idSucursal) {
        String resp = null;

        String sql = "INSERT INTO empleado (cedula,nombre,apellido,telefono,direccion,cargo,codigosucursal,estatus)VALUES(?,?,?,?,?,?,?,'A')";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, cargo);
            ps.setInt(7, idSucursal);
            
            //ps.setInt(7, otro);

            int numf = ps.executeUpdate();
            if (numf > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR" + e.getMessage());

        }
        return resp;

    }

    public String editar(String cedula, String nombre, String apellido, String telefono, String direccion, String cargo, int itemsur, int id) {
        String resp = null;
        String text = ActualizarEmpleado.txtCedula.getText();
        if (ActualizarEmpleado.txtCedula.getText().length() == 0 || ActualizarEmpleado.txtNombre.getText().length() == 0
                || ActualizarEmpleado.txtApellido.getText().length() == 0 || ActualizarEmpleado.txtTel.getText().length() == 0
                || ActualizarEmpleado.txtDir.getText().length() == 0 || ActualizarEmpleado.txtCargo.getText().length() == 0) {

            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS DEBEN ESTAR COMPLETOS");

        }

        String sql = "UPDATE empleado SET"
                + " cedula  = ?,"
                + " nombre = ?,"
                + " apellido = ?,"
                + " telefono = ?,"
                + " direccion = ?,"
                + " cargo = ?,"
                + " codigosucursal = ?"
                + " WHERE id = ? ";

        try { 

            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, cargo);
            ps.setInt(7, itemsur);
            ps.setInt(8, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());

        }
        return resp;
    }

    public void borrar() {

        try {
            int fila = BuscarEmpleado.jTablaEmpleado.getSelectedRow();

            String sql = "UPDATE empleado SET estatus='I' WHERE id=" + BuscarEmpleado.jTablaEmpleado.getValueAt(fila, 0).toString();

            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR AL ELMINAR UN REGISTRO");
        }

    }

    public void buscar(BuscarEmpleado vbemp) {

        String text = vbemp.txtBuscar.getText();

        String sql;

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
        ResultSet rs = null;
        if (text.equals("")) {

            sql = "SELECT id,cedula,nombre,apellido,telefono,direccion,cargo FROM empleado WHERE estatus='A'";

        } else {

            sql = "SELECT id,cedula,nombre,apellido,telefono,direccion,cargo FROM empleado WHERE cedula LIKE '%" + text + "%' AND estatus='A' ";

        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidad = rsMD.getColumnCount();

            model.addColumn("");
            model.addColumn("CEDULA");
            model.addColumn("NOMBRE");
            model.addColumn("APELLIDO");
            model.addColumn("TELEFONO");
            model.addColumn("DIRECION");
            model.addColumn("CARGO");
            while (rs.next()) {

                Object[] filas = new Object[cantidad];

                for (int i = 0; i < cantidad; i++) {

                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
                vbemp.jTablaEmpleado.setModel(model);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }

    public void cargar(Empleado emp, Usuario mod) {

        try {

            int text = mod.getId_tipoRol();

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };
            BuscarEmpleado.jTablaEmpleado.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;
            if (text != 1) {
                //String SQL = "SELECT id,cedula,nombre,apellido,telefono,direccion,cargo FROM empleado WHERE estatus='A'";

                String SQL = "SELECT id,cedula,nombre,apellido,telefono,direccion,cargo FROM empleado WHERE estatus='A' AND codigosucursal=" + emp.getCodigoSucursalEmpleado();

                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();

                ResultSetMetaData rsMD = rs.getMetaData();
                int cantidad = rsMD.getColumnCount();
                model.addColumn("");
                model.addColumn("CEDULA");
                model.addColumn("NOMBRE");
                model.addColumn("APELLIDO");
                model.addColumn("TELEFONO");
                model.addColumn("DIRECION");
                model.addColumn("CARGO");
                while (rs.next()) {

                    Object[] filas = new Object[cantidad];

                    for (int i = 0; i < cantidad; i++) {

                        filas[i] = rs.getObject(i + 1);
                    }
                    model.addRow(filas);
                    BuscarEmpleado.jTablaEmpleado.setVisible(true);
                    //vbemp.setVisible(true);
                }
            } else {

                String sql = "SELECT id,cedula,nombre,apellido,telefono,direccion,cargo FROM empleado WHERE estatus='A' ";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                ResultSetMetaData rsMD = rs.getMetaData();
                int cantidad = rsMD.getColumnCount();
                model.addColumn("");
                model.addColumn("CEDULA");
                model.addColumn("NOMBRE");
                model.addColumn("APELLIDO");
                model.addColumn("TELEFONO");
                model.addColumn("DIRECION");
                model.addColumn("CARGO");
                while (rs.next()) {

                    Object[] filas = new Object[cantidad];

                    for (int i = 0; i < cantidad; i++) {

                        filas[i] = rs.getObject(i + 1);
                    }
                    model.addRow(filas);
                    BuscarEmpleado.jTablaEmpleado.setVisible(true);
                    //vbemp.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }

    }

}
