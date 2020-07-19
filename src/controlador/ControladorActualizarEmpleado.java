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
import modelo.Empleado;
import modelo.EmpleadoDao;
import modelo.Sucursal;
import modelo.Usuario;
import vista.ActualizarEmpleado;
import vista.BuscarEmpleado;

/**
 *
 * @author Yamilex Sayago
 */
public class ControladorActualizarEmpleado implements ActionListener{
    EmpleadoDao emDao = new EmpleadoDao();    
    Empleado emp = new Empleado();
    Usuario mod = new Usuario();
    Sucursal sur= new Sucursal();
    ActualizarEmpleado vacemp = new ActualizarEmpleado();
    DefaultComboBoxModel molct = new DefaultComboBoxModel(sur.mostrarSucursal());
   
    public ControladorActualizarEmpleado(Usuario mod, Sucursal sur,Empleado emp)
    {
        //emDao.setVisible(false);
        vacemp.addEvents(this);
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
                
        vacemp.cboSucursalAc.setModel(molct);
        validation(mod,sur,emp);
    }
    public void validation(Usuario mod, Sucursal sur, Empleado emp)
    {  
        if(mod.getId_tipoRol() == 1){
        }
        if(mod.getId_tipoRol() == 2){
          vacemp.lblSucursal.setVisible(false);
          vacemp.cboSucursalAc.setVisible(false);}
       
        if(mod.getId_tipoRol() == 3){
        vacemp.cboSucursalAc.setVisible(false);
        vacemp.lblSucursal.setVisible(false);}
        if(mod.getId_tipoRol() == 4){
            vacemp.lblSucursal.setVisible(false);
            vacemp.cboSucursalAc.setVisible(false);}
        if(mod.getId_tipoRol() == 5){
            vacemp.lblSucursal.setVisible(false);
            vacemp.cboSucursalAc.setVisible(false);}
          
    }
     public void limpiar()
{
    vacemp.txtCedula.setText("");
    vacemp.txtApellido.setText("");
    vacemp.txtNombre.setText("");
    vacemp.txtDir.setText("");
    vacemp.txtTel.setText("");
    vacemp.txtCargo.setText("");
  
}
    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()== vacemp.btnGuardar)
        {  
           actualizar();
            
        }
      
       if(ae.getSource()== vacemp.btnLimpiar)
        {
            limpiar();
            
        }
       if(ae.getSource()== vacemp.btnAtras)
       {
          // ControladorBuscarEmpleado cbusem= new ControladorBuscarEmpleado();
            vacemp.dispose();
            emDao.cargar( emp, mod);
       }
       
       
         }

   
    public void actualizar(){
        String ced= vacemp.txtCedula.getText();
        String nom= vacemp.txtNombre.getText();
        String apel= vacemp.txtApellido.getText();
        String tel= vacemp.txtTel.getText();
        String dir= vacemp.txtDir.getText();
        String car= vacemp.txtCargo.getText();
        String id1= vacemp.lblid.getText();
        int num1 = Integer.parseInt(id1);
        int itemsur = vacemp.cboSucursalAc.getSelectedIndex();
        
        String resp = emDao.editar(ced, nom, apel, tel, dir, car,itemsur,num1);
        
       if(resp != null)
            {
               JOptionPane.showMessageDialog(null, "");
            }else{
               JOptionPane.showMessageDialog(null, "Registro Actualizado");
            }              
    }
    
}