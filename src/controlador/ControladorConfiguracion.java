/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import vista.MenuRegistrar;

/**
 *
 * @author oriana
 */
public class ControladorConfiguracion implements ActionListener{
    
    MenuRegistrar vconfg = new MenuRegistrar();
    Usuario mod= new Usuario();
    Sucursal sur= new Sucursal();
    Empleado emp = new Empleado();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ControladorConfiguracion(Usuario mod,Sucursal sur,Empleado emp){
    vconfg.addEvents(this);
    this.mod =mod;
    this.emp=emp;
    this.sur = sur;
    String id = String.valueOf(emp.getCodigoSucursalEmpleado());
    vconfg.lblidemp.setText(id);
    validar(mod,sur);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== vconfg.btnRegistrarEmpl)
        {
            //llamar controlador de la ventana a abrir
            ControladorBuscarEmpleado cbuscare = new ControladorBuscarEmpleado(mod,sur,emp);
            //ControladorRegistroEmpleado cempleado = new ControladorRegistroEmpleado();
            vconfg.dispose();
        }
      if(ae.getSource()== vconfg.btnRegistrarUsuario){
          
          ControladorRegistroUser cu = new ControladorRegistroUser(mod, sur, emp);
          vconfg.dispose();
      }
        if(ae.getSource()== vconfg.btnRegistrarPeli)
        {
            //llamar controlador de la ventana a abrir
            ControladorBuscarPeli cbpeli = new ControladorBuscarPeli(mod,sur,emp);
            vconfg.dispose();
            
        }
        if(ae.getSource()== vconfg.btnRegistrarSucursal)
        {
            //llamar controlador de la ventana a abrir
            ControladorRegistrarSucursal csur = new ControladorRegistrarSucursal(mod,sur,emp);
            vconfg.dispose();
            
        }
      if(ae.getSource()== vconfg.btnCerrarSesion){
         
          ControladorLogin cl = new ControladorLogin();
            vconfg.dispose();
      }
       if(ae.getSource()== vconfg.btnAtras){
        
          ControladorVentanaPrin cprin = new ControladorVentanaPrin(mod,sur,emp);
            vconfg.dispose();
      }  
       if(ae.getSource()== vconfg.btnRegistrarFuncion){
         ControladorAgregarFuncion af = new ControladorAgregarFuncion(mod, sur, emp);
            vconfg.dispose();
       }
         }
    
      public void validar(Usuario mod, Sucursal sur)
    {  
         if(mod.getId_tipoRol() == 1){
        }
       if(mod.getId_tipoRol() == 2){
                 vconfg.btnRegistrarSucursal.setVisible(false);
                 vconfg.btnRegistrarFuncion.setVisible(false);}
        
            if(mod.getId_tipoRol() == 3){
                 vconfg.btnRegistrarSucursal.setVisible(false);}
            
            if(mod.getId_tipoRol() == 4){
                 vconfg.btnRegistrarSucursal.setVisible(false);
                 vconfg.btnRegistrarFuncion.setVisible(false);
            }
            
            if(mod.getId_tipoRol() == 5){
                 vconfg.btnRegistrarSucursal.setVisible(false);
                 vconfg.btnRegistrarFuncion.setVisible(false);
            }
        
    }
}
