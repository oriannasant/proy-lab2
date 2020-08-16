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
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.ListadoMontoCliente;
import vista.ListadoEmpleado;
import java.util.Date;  

/**
 *
 * @author oriana
 */
public class VentaDao {
     Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
   Date d=new Date(); 
    //este metodo no se bien que hace
    public String idVenta(){
        String idv ="";
        String sql= "SELECT max(codigoventa) FROM venta ";
        try {//agarro el id 3 que era la unica venta que existia enla bd
            //entonces coloca el id de detalle venta al numero max
            // esta como raro porque si no inserta la venta como va a pasar ese id
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idv= rs.getString(1);
                
            }
            
        } catch (Exception e) {
        }
        return idv;
    }
    public int guardarVenta(Venta v){
        Venta venta = new Venta();
        
        String sql= "INSERT INTO venta ( idcliente, idvendedor,monto,fechaventa,formapago,estatus) VALUES(?,?,?,?,?,'A') ";
        try {
            //,fechaventa la fecha como se hizo el video genera error
            ps = con.prepareStatement(sql);
            //ps.setInt(1, v.getCodigoventa());
            ps.setInt(1, v.getIdcliente());
            ps.setInt(2, v.getIdvendedor());
            ps.setFloat(3, v.getMonto());
            ps.setString(4, v.getFechaventa());
           ps.setString(5, v.getFormadepago());
            r= ps.executeUpdate();
            //rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ESTAR AQUI"+e);
        }
    
    return r;
    }
 
       
   
public int guardarDetalleVenta(DetalleVenta dven){
        
        String sql= "INSERT INTO detalleventa (idventa, idproducto, precio, cantidad) VALUES(?,?,?,?) ";
        try {
          ps = con.prepareStatement(sql);
           
            ps.setInt(1, dven.getIdventa());
            ps.setInt(2, dven.getIdproducto());
          
            ps.setFloat(3, dven.getPrecio());
            ps.setInt(4, dven.getCantidad());
            ps.executeUpdate();
            // rs.close();
        } catch (Exception e) {
        }
        return r;
    }
 
     public void cargar() {

        try {

            //int text = mod.getId_tipoRol();

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };
            ListadoEmpleado.jTaReporte.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;
            //if (text != 1) {
                //String SQL = "SELECT id,cedula,nombre,apellido,telefono,direccion,cargo FROM empleado WHERE estatus='A'";

                String SQL = "SELECT v.idvendedor,e.nombre,SUM(v.monto) FROM venta AS v INNER JOIN empleado AS e ON v.idvendedor= e.id WHERE e.estatus='A' GROUP by v.idvendedor,e.nombre";
                        
                        
                       // "SELECT v.idvendedor,e.nombre,SUM(v.monto) FROM venta AS v INNER JOIN empleado AS e ON v.idvendedor= e.id WHERE e.estatus='A' GROUP BY e.nombre";

                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();

                ResultSetMetaData rsMD = rs.getMetaData();
                int cantidad = rsMD.getColumnCount();
               
                model.addColumn("Id Empleado");
                model.addColumn("Nombre");
                model.addColumn("Monto");
            
                while (rs.next()) {

                    Object[] filas = new Object[cantidad];

                    for (int i = 0; i < cantidad; i++) {

                        filas[i] = rs.getObject(i + 1);
                    }
                    model.addRow(filas);
                   // vista.tabla.setVisible(true);
                   // vista.setVisible(true);
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
            ListadoMontoCliente.jListadoMontocli.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;
           
                //String SQL = "SELECT id,cedula,nombre,apellido,telefono,direccion,cargo FROM empleado WHERE estatus='A'";

                String SQL = "SELECT v.idcliente,c.cedula,c.nombre,c.apellido,SUM(monto) AS platagastada FROM venta AS v INNER JOIN cliente AS c ON v.idcliente= c.id WHERE c.estatus='A' GROUP by v.idcliente,c.nombre,c.cedula,c.apellido";
                        //"SELECT v.idcliente,c.cedula,c.nombre,c.apellido,SUM(monto) AS platagastada FROM venta AS v INNER JOIN cliente AS c ON v.idcliente= c.id WHERE c.estatus='A' GROUP by c.nombre";

                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();

                ResultSetMetaData rsMD = rs.getMetaData();
                int cantidad = rsMD.getColumnCount();
                model.addColumn("Id Cliente");
                model.addColumn("Cedula");
                model.addColumn("Nombre"); 
                model.addColumn("Apellido");
                model.addColumn("Monto");
                
            
                while (rs.next()) {

                    Object[] filas = new Object[cantidad];

                    for (int i = 0; i < cantidad; i++) {

                        filas[i] = rs.getObject(i + 1);
                    }
                    model.addRow(filas);
                    //vista.tabla.setVisible(true);
                    //vista.setVisible(true);
                
            } 
                
            
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }

    }
   /* public void porfechas(){
        
        //en la documentacion dice que no usemos el date time  por viejo
    String fechainicio = new SimpleDateFormat("yyyy/MM").format(d.getDate());
    String confe= ListadoEmpleado.lblfecha.getFecha();
    }
    */
    }
    

