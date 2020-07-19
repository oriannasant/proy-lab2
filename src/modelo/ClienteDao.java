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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.ActualizarClasificacion;
import vista.ActualizarCliente;
import vista.BuscarCliente;
import vista.ListadoFrecuente;

/**
 *
 * @author oriana
 */
public class ClienteDao extends Conexion{

    Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;

    public void clienteDao() {

    }

    public String insertCliente(String cedula, String nombre, String apellido, String telefono, String direccion) {
        String resp = null;
        // PreparedStatement ps = null;

        String sql = "INSERT INTO cliente (cedula,nombre,apellido,telefono,direccion,estatus)VALUES(?,?,?,?,?,'A')";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            //hay que convertir la fecha
            //ps.setDate(7, emp.getFechanac());
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
            DefaultTableModel model = new DefaultTableModel(){
                @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
           
            BuscarCliente.jTablaCliente.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String SQL = "SELECT id,cedula,nombre,apellido,telefono,direccion,clasificacion FROM cliente WHERE estatus='A'";

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
            model.addColumn("CLASIFICACION");
            while (rs.next()) {

                Object[] filas = new Object[cantidad];

                for (int i = 0; i < cantidad; i++) {

                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
                BuscarCliente.jTablaCliente.setVisible(true);
                //vbcli.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
    }

    public void buscar(BuscarCliente vbcli) {

        String text = vbcli.txtBuscar.getText();

        String sql;

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
        ResultSet rs = null;
        if (text.equals("")) {

            sql = "SELECT id,cedula,nombre,apellido,telefono,direccion FROM cliente WHERE estatus='A'";

        } else {

            sql = "SELECT id,cedula,nombre,apellido,telefono,direccion FROM cliente WHERE cedula LIKE '%" + text + "%' AND estatus ='A' ";

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
            while (rs.next()) {

                Object[] filas = new Object[cantidad];

                for (int i = 0; i < cantidad; i++) {

                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
                vbcli.jTablaCliente.setModel(model);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }

    public void borrar(Cliente cli) {

        try {
            int fila = BuscarCliente.jTablaCliente.getSelectedRow();

            String sql = "UPDATE cliente SET estatus='I' WHERE id=" + BuscarCliente.jTablaCliente.getValueAt(fila, 0).toString();

            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR UN REGISTRO");
        }

    }

    public String editar(String cedula, String nombre, String apellido, String telefono, String direccion, int id,String algo) {

        String resp = null;
        String text = ActualizarCliente.txtCedula.getText();
        if (ActualizarCliente.txtCedula.getText().length() == 0 || ActualizarCliente.txtNombre.getText().length() == 0
                || ActualizarCliente.txtApellido.getText().length() == 0 || ActualizarCliente.txtTel.getText().length() == 0
                || ActualizarCliente.txtDir.getText().length() == 0) {

            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS DEBEN ESTAR COMPLETOS");

        }

        String sql = "UPDATE cliente SET"
                + " cedula  = ?,"
                + " nombre = ?,"
                + " apellido = ?,"
                + " telefono = ?,"
                + " direccion = ?,"
                + "clasificacion=?"
                + "WHERE id = ? ";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, algo);
            ps.setInt(7, id);
            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());

        }
        return resp;
    }
    public void listaridcli(Cliente cli) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
            int fila = BuscarCliente.jTablaCliente.getSelectedRow();
          
        try {
            int idfil;
           if (fila == -1){  JOptionPane.showMessageDialog(null, "DEBE SELECIONAR UNA FILA");

            }
           else{
               DefaultTableModel m = (DefaultTableModel) BuscarCliente.jTablaCliente.getModel();
               
               idfil = (Integer)BuscarCliente.jTablaCliente.getValueAt(fila, 0);
           // String sql = "SELECT id FROM cliente WHERE id=" + BuscarCliente.jTablaCliente.getValueAt(fila, 0).toString();
               String sql = "SELECT id FROM cliente WHERE id=" + idfil;
                
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()){
           cli.setId(rs.getInt(1));
           }
         
            JOptionPane.showMessageDialog(null, "INFORMACION AÑADIDA CORRECTAMENTE");}

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR AL AÑADIR");
        }

    }
    
   
     public void clienteFrecuente() {

        try {
            DefaultTableModel model = new DefaultTableModel(){
                @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
            ListadoFrecuente.tabla.setModel(model);
          
            
        
           

            PreparedStatement ps = null;
            ResultSet rs = null;
            String SQL = "SELECT cliente.id,cliente.nombre,cliente.apellido,cliente.clasificacion, SUM(ventaentrada.cantidaden) FROM cliente INNER JOIN ventaentrada ON cliente.id = ventaentrada.idcliente GROUP by cliente.id";
                    
                    
                    //"SELECT cliente.id,cliente.nombre,cliente.apellido,SUM(ventaentrada.cantidaden) FROM cliente INNER JOIN ventaentrada ON cliente.id = ventaentrada.idcliente AND ventaentrada.fecha BETWEEN '"+fechaes+"' AND '"+fechaulti+"' GROUP by cliente.id";

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidad = rsMD.getColumnCount();

            model.addColumn("ID");
            model.addColumn("NOMBRE");
            model.addColumn("APELLIDO");
            model.addColumn("CLASIFICACION");
            model.addColumn("CANTIDAD");

            while (rs.next()) {

                Object[] filas = new Object[cantidad];

                for (int i = 0; i < cantidad; i++) {

                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
                //vbcli.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
    
}
     
     
     
    public String editarclasificacion(  int id,String algo) {
  String resp = null;
      //  String text = ActualizarCliente.txtCedula.getText();
      

        String sql = "UPDATE cliente SET clasificacion = ? WHERE id = ? ";

        try {

            ps = con.prepareStatement(sql);
            
            ps.setString(1, algo);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());

        }
        return resp;
    }
}
