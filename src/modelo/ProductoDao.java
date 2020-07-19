/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.GenerarVenta;

/**
 *
 * @author oriana
 */
public class ProductoDao extends Conexion {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConnection();
    Producto p = new Producto();

   /* public Producto mostrar(int items) {
    MOSTRAR PRODUCTO CON BOTON
        String sql = "SELECT nombreproducto,precio FROM producto WHERE codigo =" + items;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setNombreProducto(rs.getString(1));
                p.setPrecio(rs.getFloat(2));
            }

        } catch (Exception e) {

            System.out.println("Error mardia sea " + e.getMessage());
        }
        return p;
    }*/
// monstar producto con combo box
    public void mostrarproducto() {

        String nombrep = GenerarVenta.cboProduc.getSelectedItem().toString();

        String sql = "SELECT * FROM producto WHERE nombreproducto =?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, nombrep);
            rs = ps.executeQuery();
            if (rs.next()) {
                String nmp = rs.getString("nombreproducto");
                String pre = rs.getString("precio");
                GenerarVenta.txtProducto.setText(nmp);
                GenerarVenta.txtPrecio.setText(pre);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

//Producto p = new Producto();
//GenerarVenta vg = new GenerarVenta();
//DefaultTableModel modelo = new DefaultTableModel();
//int idp;
        /* public List Listar(){
         List<Producto>datos = new ArrayList<Producto>();
         String sql = "SELECT *FROM producto";
         try {
         con= conectar.getConnection();
         ps= con.prepareStatement(sql);
         rs= ps.executeQuery();
            
         while(rs.next()){
         Producto pro=new Producto();
         pro.setCodigo(rs.getInt("codigo"));
         pro.setNombreProducto(rs.getString("nombreproducto"));
         pro.setPrecio(rs.getFloat("precio"));
         pro.setDisponibilidad(rs.getString("disponi"));
         datos.add(pro);
         }
         } catch (Exception e) {
         System.out.println("Error "+e.getMessage());
         }
         return datos;
         }*/
        /*public void agregarproducto() {

         int fila = VentanaGolosina.jTabla.getSelectedRow();
         //int fila = vgol.jTabla.getSelectedRow();
         try {
         int codigo; 
         String nombreproducto;
         float precio;
                   

         if (fila == -1) {

         JOptionPane.showMessageDialog(null, "DEBE SELECIONAR UNA FILA");

         } else {
         DefaultTableModel m = (DefaultTableModel)VentanaGolosina.jTabla.getModel();
                
         //codigo = Integer.parseInt(vgol.jTabla.getValueAt(fila, 1));
         codigo = Integer.parseInt(VentanaGolosina.jTabla.getValueAt(fila, 1).toString());
         //codigo = (Integer)vgol.jTabla.getValueAt(fila, 1);
         nombreproducto = VentanaGolosina.jTabla.getValueAt(fila, 2).toString();
         //nombreproducto = vgol.jTabla.getValueAt(fila, 2).toString();
         precio = Float.parseFloat(VentanaGolosina.jTabla.getValueAt(fila, 3).toString());
         // disponi =VentanaGolosina.jTabla.getValueAt(fila, 4).toString();
               
         String sql = "INSERT INTO ventaproducto (codigo,nombreproducto,precio) VALUES(?,?,?)";
         ps = con.prepareStatement(sql);
         ps.setInt(1, codigo);
         ps.setString(2, nombreproducto);
         ps.setFloat(3, precio);
         //ps.setString(4, disponi);
                
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null,"PELICULA AGREGADA EXITOSAMENTE! :D");
                
         }
         } catch (Exception e) {
            
         System.out.println("Error " + e.getMessage());

         }
         }*/
        /* public void cargar() {

         try {

         DefaultTableModel model = new DefaultTableModel() {
         @Override
         public boolean isCellEditable(int filas, int columnas) {
         return false;
         }
         };

         VentanaGolosina.jTabla.setModel(model);

         PreparedStatement ps = null;
         ResultSet rs = null;
         Conexion conx = new Conexion();
         Connection con = conx.getConnection();

         String SQL = "SELECT * FROM producto";

         ps = con.prepareStatement(SQL);
         rs = ps.executeQuery();

         ResultSetMetaData rsMD = rs.getMetaData();
         int cantidad = rsMD.getColumnCount();

         model.addColumn("Codigo");
         model.addColumn("Producto");
         model.addColumn("Precio");
         model.addColumn("Disponibilidad");
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
         /* public void agregarProducto(JTable jTablaVentaG, int items) {
         //no tengo el controlador aqui con un entitymanager
         //DefaultTableModel pr = null;
         try {
         DefaultTableModel model = new DefaultTableModel();
         jTablaVentaG.setModel(model);
        
        
         PreparedStatement ps = null;
         ResultSet rs = null;
        
         Conexion conx = new Conexion();
         Connection con = conx.getConnection();
        
         // String[] columnas = {"Codigo","Producto","Precio"};
         // pr = new DefaultTableModel(null,columnas);
        
            
         String sql = "SELECT codigo, nombreproducto FROM producto where codigo ="+ items;

         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();

         ResultSetMetaData rsMD = rs.getMetaData();
         int cantidad = rsMD.getColumnCount();

         model.addColumn("Codigo");
         model.addColumn("Producto");
            
          
         while (rs.next()) {

         Object[] filas = new Object[cantidad];

         for (int i = 0; i < cantidad; i++) {

         filas[i] = rs.getObject(i + 1);
         }
         model.addRow(filas);
             
         }*/
// String sql = "SELECT codigo, nombreproducto FROM producto where codigo ="+ codigo;
        /*ResultSetMetaData rsMD = rs.getMetaData();
         int cantidad = rsMD.getColumnCount();
         String[] filas = new String[4];
         while (rs.next()){
         for (int i = 1; i <= cantidad; i++) {
         filas[1] = pro.getCodigo()+ "";
         filas[2] = pro.getNombreProducto()+"";
         //  filas[3] = pro.getPrecio()+"";
         pr.addRow(filas);
         }}
         /* while (rs.next()) {

         //Object[] filas = new Object[cantidad];
         String[] filas = new String[3];
         for (int i = 0; i < cantidad; i++) {

         filas[1] = pro.getCodigo()+ "";
         filas[2] = pro.getNombreProducto()+"";
         filas[3] = pro.getPrecio()+"";
         pr.addRow(filas);
         }
         jTablaVentaG.setModel(pr);}
         //jTablaVentaG.setModel(pr);
         } catch (SQLException ex) {
            
         }

         }*/
        /* public void agregarproducto(){
         float total;
         modelo = (DefaultTableModel)vg.jTablaVentaG.getModel();
         int it =0;
         it +=1;
         idp=p.getCodigo();
         String nomp = vg.txtProducto.getText();
         float pre = Float.parseFloat(vg.txtPrecio.getText());
         int cant = Integer.parseInt(vg.jSCantidad.getValue().toString());
         total = cant * pre;
  
         //mostrar en la tabla
  
         ArrayList lista = new ArrayList();
  
         lista.add(it);
         lista.add(idp);
         lista.add(nomp);
         lista.add(cant);
         lista.add(total);
         Object[]ob= new Object[5];
         ob[0] = lista.get(0);
         ob[1] = lista.get(1);
         ob[2] = lista.get(2);
         ob[3] = lista.get(3);
         ob[4] = lista.get(4);
         modelo.addRow(ob);
         vg.jTablaVentaG.setModel(modelo);
         }*/
    }
}
