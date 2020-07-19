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
import vista.MenuReporte;


/**
 *
 * @author oriana
 */
public class ControladorMenuReporte implements ActionListener{
    Usuario mod= new Usuario();
    Sucursal sur= new Sucursal();
    Empleado emp = new Empleado();
    MenuReporte vrepor = new MenuReporte();

    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorMenuReporte(Usuario mod, Sucursal sur,Empleado emp) {
    
        vrepor.addEvents(this);
        this.mod = mod;
        this.sur= sur;
        this.emp=emp;
   
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
      if(ae.getSource()== vrepor.jMenuItem2LRE)
        {
            ControladorListadoEdad cled = new ControladorListadoEdad(mod,sur,emp);
            vrepor.dispose();
            
        }
      if(ae.getSource()== vrepor.jMenuItem1LCF)
      {
        ControladorClienteFrecuente cclife = new ControladorClienteFrecuente(mod,sur,emp);
          vrepor.dispose();
      }
      
      if(ae.getSource()==vrepor.btnDetalleEntr){
      
         ControladorDisponibilidad condis = new ControladorDisponibilidad(mod,sur,emp);
     vrepor.dispose();
      }
      
       if(ae.getSource()==vrepor.btnDetallePeli){
       
         ControladorDetallePelicula condepe = new ControladorDetallePelicula(mod,sur,emp);
         vrepor.dispose();
       }
       
       if(ae.getSource()==vrepor.jMenuItem6MGC){
       
          ControladorMontoCliente concli = new ControladorMontoCliente(mod,sur,emp);
          vrepor.dispose();
       }
       
       if(ae.getSource() == vrepor.jMenuItem3LP){
       
          ControladorPeliculasCine conpelc = new ControladorPeliculasCine(mod,sur,emp);
          vrepor.dispose();
       }
       
       if(ae.getSource()== vrepor.jMenuItem5LEG){
       
           ControladorListadoEmpleado lisemp = new  ControladorListadoEmpleado(mod, sur, emp);
           vrepor.dispose();
       }
        if(ae.getSource()== vrepor.btnAtras)
        {
           ControladorVentanaPrin cvp = new ControladorVentanaPrin(mod, sur, emp);
            vrepor.dispose();
        }
      
       if(ae.getSource()== vrepor.btnCerrarSesion){
          ControladorLogin cl = new ControladorLogin();
          
         vrepor.dispose();
       }
     
         }
}
