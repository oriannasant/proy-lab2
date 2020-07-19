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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellEditor;
import vista.AgregarFuncion;
import vista.Funciones;
import vista.VentanaEntrada;
import vista.MenuRegistrar;

/**
 *
 * @author Yamilex Sayago
 */
public class FuncionDao {
    Empleado emp = new Empleado();
    Sala sl = new Sala();
           
    Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int r;

    public String guardar(String nombre, String clasificacion, String sala, String horario,String fechaes,String fechaulti,int dispo,int idsucursal) {
        
        String resp = null;
        try {
            String sql = "INSERT INTO funcion (nombre,clasificacion,sala,horario,fechaes,fechaulti,disponibilidad,idsucursal,estatus)VALUES(?,?,?,?,?,?,?,?,'A')";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, clasificacion);
            ps.setString(3, sala);
            ps.setString(4, horario);
            ps.setString(5, fechaes);
            ps.setString(6, fechaulti);
            ps.setInt(7, dispo);
            ps.setInt(8,idsucursal);
            int numf = ps.executeUpdate();

            if (numf > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DEBE SELECIONAR TODOS LOS DATOS"+e);

        }
        return resp;
    }

    public void combo(AgregarFuncion af) {

        String nombre = af.cboNombre.getSelectedItem().toString();
        String sql = "SELECT  nombre, clasificacion FROM pelicproyectada WHERE nombre =?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                String cla = rs.getString("clasificacion");
                af.txtClasificacion.setText(cla);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void combo2(AgregarFuncion af) {

        String num = af.cboSala.getSelectedItem().toString();
        String sql = "SELECT * FROM sala WHERE numero =?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, num);
            rs = ps.executeQuery();
            if (rs.next()) {
                String disp = rs.getString("canasientos");
                af.txtDisponibilidad.setText(disp);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cargar() {
       // String g = "2020/07/09";
        String confe= VentanaEntrada.lblfecha.getFecha();
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };

            Funciones.jtableFunciones.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;
                            
            String SQL = "SELECT id,nombre,clasificacion,sala,horario,disponibilidad FROM funcion WHERE (fechaes >  '"+confe+"' AND '"+confe+"' < fechaulti)AND disponibilidad > 0 AND estatus='A'";

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidad = rsMD.getColumnCount();
            model.addColumn("ID");
            model.addColumn("NOMBRE");
            model.addColumn("CLASIFICACION");
            model.addColumn("SALA");
            model.addColumn("HORARIO");
            model.addColumn("DISPONIBILIDAD");
            while (rs.next()) {

                Object[] filas = new Object[cantidad];

                for (int i = 0; i < cantidad; i++) {

                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
                Funciones.jtableFunciones.setVisible(true);
                // BuscarPelicula.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
    }
 public void cargar2(Empleado emp) {
       // String g = "2020/07/09";
        String confe= VentanaEntrada.lblfecha.getFecha();
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };

            Funciones.jtableFunciones.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;
                            
            String SQL = "SELECT id,nombre,clasificacion,sala,horario,disponibilidad FROM funcion WHERE (fechaes >  '"+confe+"' AND '"+confe+"' < fechaulti)AND disponibilidad > 0 AND estatus='A' AND idsucursal=" + emp.getCodigoSucursalEmpleado();

            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidad = rsMD.getColumnCount();
            model.addColumn("ID");
            model.addColumn("NOMBRE");
            model.addColumn("CLASIFICACION");
            model.addColumn("SALA");
            model.addColumn("HORARIO");
            model.addColumn("DISPONIBILIDAD");
            while (rs.next()) {

                Object[] filas = new Object[cantidad];

                for (int i = 0; i < cantidad; i++) {

                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
                Funciones.jtableFunciones.setVisible(true);
                // BuscarPelicula.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
    }
    public void selecionar() {

        try {
            int fila = Funciones.jtableFunciones.getSelectedRow();
            String id = Funciones.jtableFunciones.getValueAt(fila, 0).toString();
            String sql = "SELECT id,nombre,clasificacion,sala,horario,disponibilidad FROM funcion WHERE id ='"+ id +"'AND estatus='A'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                VentanaEntrada.txtNombrePeli.setText(nombre);
                String clasi = rs.getString("clasificacion");
                VentanaEntrada.txtCla.setText(clasi);
                String sala = rs.getString("sala");
                VentanaEntrada.txtSala.setText(sala);
                String horario = rs.getString("horario");
                VentanaEntrada.txtHorario.setText(horario);
                String id1 = rs.getString("id");
                VentanaEntrada.lblid.setText(id1);
                
                int disp = rs.getInt("Disponibilidad");
                String dp = String.valueOf(disp);
                VentanaEntrada.txtDispo.setText(dp);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR" + e);
        }

    }
    
    
    @Override 
     public String toString(){
    return sl.getNumero();
    }
    public Vector<Sala> mostrarSalas() {
        
      int id = Integer.valueOf(MenuRegistrar.lblidemp.getText());
        
        Vector<Sala> datos = new Vector<Sala>();
        Sala dat = null;
        try {
            
            
            String sql = "SELECT id,numero FROM sala WHERE estatus='A' AND idsucursal='"+id+"'";
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
    }
 
    
    

}
