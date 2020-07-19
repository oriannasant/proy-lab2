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
import modelo.Ciudad;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.SucursalDao;
import modelo.Usuario;
import vista.RegistrarSucursal;

/**
 *
 * @author oriana
 */
public class ControladorRegistrarSucursal implements ActionListener{
    
    Sucursal sur = new Sucursal();
    SucursalDao sdao = new SucursalDao();
    RegistrarSucursal vsu = new RegistrarSucursal();
    Ciudad ciu = new Ciudad();
    Usuario mod = new Usuario();
    Empleado emp = new Empleado();
    DefaultComboBoxModel molc = new DefaultComboBoxModel(ciu.mostrarCiudad());
    
    
    
public ControladorRegistrarSucursal(Usuario mod,Sucursal sur, Empleado emp)
{
    vsu.addEvents(this);
    this.emp=emp;
    this.mod = mod;
    this.sur= sur;
    vsu.cboCiudad.setModel(molc);
    
}
     public void limpiar()
{
    vsu.txtRif.setText("");
    vsu.txtNombre.setText("");
    vsu.jTextAreaDescripcion.setText("");
    
    
  
}
    /* public void guardar(){
        String rif= vsu.txtRif.getText();
        String nom= vsu.txtNombre.getText();
       String tarea = vsu.jTextAreaDescripcion.getText();
       
       //datos del combo box
         int item = vsu.cboCiudad.getSelectedIndex();
        
        sur.setNombre(nom);
        sur.setRif(rif);
        sur.setDescripcion(tarea);
        sur.setIdciudad(item);
        
       if(sdao.registrar(sur))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        
        
    }*/
     public void guardar(){
        String rif= vsu.txtRif.getText();
        String nombre= vsu.txtNombre.getText();
        String descripcion = vsu.jTextAreaDescripcion.getText();
       
       //datos del combo box
        int item = vsu.cboCiudad.getSelectedIndex();
        String resp = sdao.registrar(rif, nombre, descripcion, item);
            if (resp != null) {

                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } 
        
          
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== vsu.btnGuardar)
        {
         guardar();
         
             }
     
       if(ae.getSource()== vsu.btnCerrarSesion){
          
           ControladorLogin cl = new ControladorLogin();
          vsu.dispose();
       }
       if(ae.getSource()== vsu.btnAtras)
      {
          ControladorConfiguracion cconf = new ControladorConfiguracion(mod,sur,emp);
            vsu.dispose();
      }
       
        if(ae.getSource()== vsu.btnLimpiar)
      {
         limpiar();
      }
         }
    
}
