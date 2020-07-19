/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.PeliculaDao;
import modelo.Sucursal;
import modelo.Usuario;
import vista.ActualizarPelicula;
import vista.BuscarPelicula;

/**
 *
 * @author oriana
 */
public class ControladorBuscarPeli implements ActionListener{
    

    BuscarPelicula vbuscarpel = new BuscarPelicula();
    Empleado emp = new Empleado();
    DefaultTableModel modelo = new DefaultTableModel();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    PeliculaDao pelidao = new PeliculaDao();
    DefaultComboBoxModel molct = new DefaultComboBoxModel(sur.mostrarSucursal());
    

    public ControladorBuscarPeli(Usuario mod, Sucursal sur, Empleado emp) {
        this.emp = emp;
        this.mod = mod;
        this.sur = sur;
        pelidao.cargar();
        vbuscarpel.addEvents(this);
        vbuscarpel.cboSucursal.setModel(molct);
        validation(mod,sur,emp);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vbuscarpel.btnRegistar) {
            ControladorRegistroPeli cpeli = new ControladorRegistroPeli(mod, sur, emp);
        }

        if (ae.getSource() == vbuscarpel.btnCerrarSesion) {
            ControladorLogin cl = new ControladorLogin();

            vbuscarpel.dispose();
        }
        if (ae.getSource() == vbuscarpel.btnAtras) {

            ControladorConfiguracion cconf = new ControladorConfiguracion(mod, sur, emp);
            vbuscarpel.dispose();

        }
       

        if (ae.getSource() == vbuscarpel.txtBuscar2) {
            pelidao.buscar(vbuscarpel);

        }

        if (ae.getSource() == vbuscarpel.btnborrar) {

            pelidao.borrar();
            pelidao.cargar();

        }
        if(ae.getSource()== vbuscarpel.btnAgregar){
             int in = vbuscarpel.cboSucursal.getSelectedIndex();
        
             if(mod.getId_tipoRol()== 1 && (in == 0)){
             

                JOptionPane.showMessageDialog(null, "DEBE SELECIONAR UNA SUCURSAL");
                
             }else if (mod.getId_tipoRol()== 1 && (in != 0)){
               int item = vbuscarpel.cboSucursal.getSelectedIndex();
             pelidao.agregarpeliculaselec(item);
                
          }else if (mod.getId_tipoRol()!= 1){
        int item = emp.getCodigoSucursalEmpleado();
             pelidao.agregarpeliculaselec(item);
             }
        }

        if (ae.getSource() == vbuscarpel.btnEditar) {

            ControladorActualizarPelicula capeli = new ControladorActualizarPelicula(mod,sur,emp);
           // vbuscarpel.jPopupMenu1.setVisible(false);
            paraedit();
             
        }

    }
      public void validation(Usuario mod, Sucursal sur, Empleado emp)
    {  
        if(mod.getId_tipoRol() == 1){
          

        }
        if(mod.getId_tipoRol() == 2){
         
          vbuscarpel.cboSucursal.setVisible(false);}
       
        if(mod.getId_tipoRol() == 3){
         vbuscarpel.cboSucursal.setVisible(false);
        
        if(mod.getId_tipoRol() == 4){
            
           vbuscarpel.cboSucursal.setVisible(false);}
        if(mod.getId_tipoRol() == 5){
           
            vbuscarpel.cboSucursal.setVisible(false);}
          
    }
    }
    
    public void paraedit(){
         
        int fila = BuscarPelicula.jTablaPelicula.getSelectedRow();

        ActualizarPelicula.txtNombre.setText(BuscarPelicula.jTablaPelicula.getValueAt(fila, 1).toString());
        ActualizarPelicula.txtClasificacion.setText(BuscarPelicula.jTablaPelicula.getValueAt(fila, 2).toString());
        ActualizarPelicula.txtGenero.setText(BuscarPelicula.jTablaPelicula.getValueAt(fila, 3).toString());
        ActualizarPelicula.txtDescripcion.setText(BuscarPelicula.jTablaPelicula.getValueAt(fila, 4).toString());
        ActualizarPelicula.txtDuracion.setText(BuscarPelicula.jTablaPelicula.getValueAt(fila, 5).toString());
        ActualizarPelicula.lblid.setText(BuscarPelicula.jTablaPelicula.getValueAt(fila,0).toString());
        
    }

}
