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
import vista.RegistrarEmpleado;

/**
 *
 * @author oriana
 */
public class ControladorRegistroEmpleado implements ActionListener{
    EmpleadoDao emDao = new EmpleadoDao();
    Usuario mod= new Usuario();
    Sucursal sur= new Sucursal();
    Empleado emp = new Empleado();
    RegistrarEmpleado vempleado = new RegistrarEmpleado();
    DefaultComboBoxModel molct = new DefaultComboBoxModel(sur.mostrarSucursal());
    
    public ControladorRegistroEmpleado(Usuario mod, Sucursal sur,Empleado emp)
    {
        this.emp=emp;
        this.mod = mod;
        this.sur= sur;
        vempleado.addEvents(this);
        vempleado.cboIdSucursal.setModel(molct);
        validation(mod,sur,emp);
    }
     public void limpiar()
{
    vempleado.txtCedula.setText("");
    vempleado.txtApellido.setText("");
    vempleado.txtNombre.setText("");
    vempleado.txtDir.setText("");
    vempleado.txtTel.setText("");
    vempleado.txtCargo.setText("");
  
}
    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()== vempleado.btnGuardar)
        {
           // guardar();
            if(mod.getId_tipoRol()== 1){
               
            String cedula = vempleado.txtCedula.getText();
            String nombre = vempleado.txtNombre.getText();
            String apellido = vempleado.txtApellido.getText();
            String telefono = vempleado.txtTel.getText();
            String direccion = vempleado.txtDir.getText();
            String cargo = vempleado.txtCargo.getText();
          
            int itemsur = vempleado.cboIdSucursal.getSelectedIndex();

            //mod.setId(itemsur);
            String resp = emDao.insertEmpleado(cedula, nombre, apellido, telefono, direccion, cargo, itemsur);
            if (resp != null) {

                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
            }else{
            String cedula = vempleado.txtCedula.getText();
            String nombre = vempleado.txtNombre.getText();
            String apellido = vempleado.txtApellido.getText();
            String telefono = vempleado.txtTel.getText();
            String direccion = vempleado.txtDir.getText();
            String cargo = vempleado.txtCargo.getText();
            int itemsur = emp.getCodigoSucursalEmpleado();
            //int itemsur = vempleado.cboIdSucursal.getSelectedIndex();

            //mod.setId(itemsur);
            String resp = emDao.insertEmpleado(cedula, nombre, apellido, telefono, direccion, cargo, itemsur);
            if (resp != null) {

                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
            
        }
    }
      
       if(ae.getSource()== vempleado.btnLimpiar)
        {
            limpiar();
            
        }
       if(ae.getSource()== vempleado.btnAtras)
       {
          // ControladorBuscarEmpleado cbusem= new ControladorBuscarEmpleado();
            vempleado.dispose();
            emDao.cargar( emp, mod);
       }
      
         }
     public void validation(Usuario mod, Sucursal sur, Empleado emp)
    {  
        if(mod.getId_tipoRol() == 1){
           // int itemsur = vempleado.cboIdSucursal.getSelectedIndex();

        }
        if(mod.getId_tipoRol() == 2){
          vempleado.lblsucursal.setVisible(false);
          vempleado.cboIdSucursal.setVisible(false);}
       
        if(mod.getId_tipoRol() == 3){
         vempleado.cboIdSucursal.setVisible(false);
        vempleado.lblsucursal.setVisible(false);}
        if(mod.getId_tipoRol() == 4){
            vempleado.lblsucursal.setVisible(false);
           vempleado.cboIdSucursal.setVisible(false);}
        if(mod.getId_tipoRol() == 5){
            vempleado.lblsucursal.setVisible(false);
            vempleado.cboIdSucursal.setVisible(false);}
          
    }
   /* public void guardar(){
        String ced= vempleado.txtCedula.getText();
        String nom= vempleado.txtNombre.getText();
        String apel= vempleado.txtApellido.getText();
        String tel= vempleado.txtTel.getText();
        String dir= vempleado.txtDir.getText();
        String car= vempleado.txtCargo.getText();
       if(emDao.registrar(emp))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        */
        
    }
    

