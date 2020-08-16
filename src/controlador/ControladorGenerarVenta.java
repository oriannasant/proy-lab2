/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Empleado;
import modelo.FormaPagoM;
import modelo.Producto;
import modelo.ProductoDao;
import modelo.Sucursal;
import modelo.Usuario;
import modelo.Venta;
import modelo.VentaDao;


import vista.GenerarVenta;

/**
 *
 * @author oriana
 */
public class ControladorGenerarVenta implements ActionListener {

    GenerarVenta vgn = new GenerarVenta();
    Cliente cliente = new Cliente();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    Empleado emp = new Empleado();
    Producto p = new Producto();
    ProductoDao dao = new ProductoDao();
    Venta v = new Venta();
    VentaDao vdao = new VentaDao();
    DetalleVenta dven = new DetalleVenta();
    FormaPagoM modelof = new FormaPagoM();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultComboBoxModel molc = new DefaultComboBoxModel(p.mostrarProducto());
    DefaultComboBoxModel molpago = new DefaultComboBoxModel(modelof.mostrarFP());

    public ControladorGenerarVenta(Usuario mod, Sucursal sur, Empleado emp, Cliente cliente) {
        vgn.addEvents(this);
        vgn.cboProduc.setModel(molc);
        this.mod = mod;
        vgn.cbofp.setModel(molpago);
        SpinnerNumberModel sp = new SpinnerNumberModel();
        sp.setMinimum(0);
        vgn.jSCantidad.setModel(sp);
        this.cliente = cliente;
        this.sur = sur;
        this.emp = emp;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vgn.btnBuscarCliente) {

            ControladorBuscarCliente cbcli = new ControladorBuscarCliente(mod, sur, emp, cliente);

        }
        if (ae.getSource() == vgn.btnGenerarVenta) {
            int in = vgn.cbofp.getSelectedIndex();
            if (vgn.txttotal.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "DEBE INGRESAR DATOS");
                
            } else if (in == 0) {

                JOptionPane.showMessageDialog(null, "DEBE SELECIONAR UNA FORMA DE PAGO");

            } else if (!vgn.txttotal.getText().equals("") && (in != 0)) {
                if (cliente.getId() != 0) {
                    guardarVenta();
                    guardarDetalle();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "VENTA REALIZADA CON EXITO");
                } else {

                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR DATOS DEL CLIENTE");

                }
            } 
        }
       
        if (ae.getSource() == vgn.btnAgregar) {

            if (!vgn.txtPrecio.getText().equals("")) {

                agregarproducto();

            } else {

                JOptionPane.showMessageDialog(null, "DEBE INGRESAR DATOS");

            }

        }
        if (ae.getSource() == vgn.btnAtras) {
            ControladorVentanaPrin cvenprin = new ControladorVentanaPrin(mod, sur, emp);
            vgn.dispose();
        }
        if (ae.getSource() == vgn.btnLimpiar) {
            limpiar();
        }
        if (ae.getSource() == vgn.btnCerrarSesion) {
            ControladorLogin lg = new ControladorLogin();
            vgn.dispose();
        }
        /* if (ae.getSource() == vgn.cboProduc) {
         fd.combo(af);
         muestraprod();
         }*/
        if (ae.getSource() == vgn.btnQuitar) {
             
            
           borrar();
          
                
                
    
    }
         /*if (ae.getSource() == vgn.btnGenerarT) {
            
            try {
            Conexion conx = new Conexion();
            Connection con = conx.getConnection();
            JasperReport reporte= null;
            String path="src\\modelo\\ticketGolosina.jasper";
            
            reporte= (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint= JasperFillManager.fillReport(path, null,con);
            
            JasperViewer view= new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(GenerarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           }*/
           
        
        if (ae.getSource() == vgn.cboProduc) {
            dao.mostrarproducto();
        }

    }

// public void guardar(){ int item = vgn.cboProduc.getSelectedIndex();}
    public void guardarVenta() {
        int idvendedor = emp.getId();
        int idcliente = cliente.getId();
        String fp = vgn.cbofp.getSelectedItem().toString();

   // int idcliente = 2;
       String fecha = vgn.lblFecha.getFecha();
               
        float monto = calcularTotal();

        v.setIdcliente(idcliente);
        v.setIdvendedor(idvendedor);
        v.setMonto(monto);
        v.setFechaventa(fecha);
        v.setFormadepago(fp);
        vdao.guardarVenta(v);

    }

    public void guardarDetalle() {
        String idventa = vdao.idVenta();
        int idven = Integer.parseInt(idventa);
        for (int i = 0; i < vgn.jTablaVentaG.getRowCount(); i++) {

            // id = Integer.parseInt(vgn.jTablaVentaG.getValueAt(i, 0).toString());
            int idp = Integer.parseInt(vgn.jTablaVentaG.getValueAt(i, 1).toString());
            float pre = Float.parseFloat(vgn.jTablaVentaG.getValueAt(i, 3).toString());
            int cantidad = Integer.parseInt(vgn.jTablaVentaG.getValueAt(i, 4).toString());

            dven.setIdventa(idven);
            //  dven.setIdventa(id);
            dven.setIdproducto(idp);
            dven.setPrecio(pre);
            dven.setCantidad(cantidad);
            vdao.guardarDetalleVenta(dven);
            // limpiar();
        }
    }

    public float calcularTotal() {
        float totalt = 0;
        for (int i = 0; i < vgn.jTablaVentaG.getRowCount(); i++) {

            float precio = Float.parseFloat(vgn.jTablaVentaG.getValueAt(i, 3).toString());
            int cant = Integer.parseInt(vgn.jTablaVentaG.getValueAt(i, 4).toString());
            totalt = totalt + (cant * precio);

        }
        vgn.txttotal.setText("" + totalt + "0");
        return totalt;
    }

    public void limpiar() {
        vgn.txttotal.setText("");
        vgn.txtPrecio.setText("");
        vgn.txtProducto.setText("");
        //  vgn.jSCantidad.
        limpiartabla();

    }

    public void limpiartabla() {

        for (int i = 0; i < modelo.getRowCount(); i++) {

            modelo.removeRow(i);
            i -= 1;
        }
    }
    /* public void litpro() {
     if(vgn.cboProduc.getSelectedIndex() > 0){
     int items = vgn.cboProduc.getSelectedIndex();
     dao.listarProducto(vgn.jTablaVentaG,items);
         
     }
     
     */
    /*public void muestraprod() {
     ESTE ES EL MOSTRAR PRODUCTO CON BOTON
     int items = vgn.cboProduc.getSelectedIndex();
     if(vgn.cboProduc.getSelectedIndex() > 0){
           
     Producto p = dao.mostrar(items);
           
     vgn.txtProducto.setText(p.getNombreProducto());
     vgn.txtPrecio.setText(""+p.getPrecio());
         
     }else{
     JOptionPane.showMessageDialog(null, "ERROR DEBE SELECCIONAR UN PRODUCTO");
         
     }
    
     }*/

    public void agregarproducto() {
        float total = 0;
        modelo = (DefaultTableModel) vgn.jTablaVentaG.getModel();
        int it = 0;
        it = it + 1;
        // int idp=p.getCodigo();
        int idp = vgn.cboProduc.getSelectedIndex();
        String nomp = vgn.txtProducto.getText();
        float pre = Float.parseFloat(vgn.txtPrecio.getText());
        int cant = Integer.parseInt(vgn.jSCantidad.getValue().toString());
        if (cant != 0) {
            total = cant * pre;

            //mostrar en la tabla
            ArrayList lista = new ArrayList();

            lista.add(it);
            lista.add(idp);
            lista.add(nomp);
            lista.add(pre);
            lista.add(cant);
            lista.add(total);

            Object[] ob = new Object[6];
            ob[0] = lista.get(0);
            ob[1] = lista.get(1);
            ob[2] = lista.get(2);
            ob[3] = lista.get(3);
            ob[4] = lista.get(4);
            ob[5] = lista.get(5);
            modelo.addRow(ob);
            vgn.jTablaVentaG.setModel(modelo);
            calcularTotal();
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY UNA CANTIDAD SELECCIONADA");
        }
    }
 public void borrar() {
     float otro = calcularTotal();
     float totalt=0;
     try {
         int fila = vgn.jTablaVentaG.getSelectedRow();
         int fil;
  //modelo = (DefaultTableModel) vgn.jTablaVentaG.getModel();
  if(fila==-1){
  
  JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
  
  }else{
            //modelo.removeRow(vgn.jTablaVentaG.getSelectedRow());
            //fila--;
            float preciotro = Float.parseFloat(vgn.txttotal.getText()) - otro;
            
            totalt = preciotro;
            vgn.txttotal.setText(""+totalt);
            modelo = (DefaultTableModel)vgn.jTablaVentaG.getModel();
            fil = (int)modelo.getValueAt(fila, 0);
            modelo.removeRow(fil);
  }
         
     } catch (Exception e) {
     }
  
}
}