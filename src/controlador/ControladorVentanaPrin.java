/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import vista.VentanaPrin;


/**
 *
 * @author oriana
 */
public class ControladorVentanaPrin implements ActionListener{
    
    VentanaPrin vprin = new VentanaPrin();
    Usuario mod= new Usuario();
    Sucursal sur = new Sucursal();
    Empleado emp = new Empleado();
    Cliente cli = new Cliente();
    
    /*public ControladorVentanaPrin(){
    vprin.addEvents(this);
    }*/
      
    public ControladorVentanaPrin(Usuario mod, Sucursal sur,Empleado emp) {
     //este metodo verifica por tipo de rol que opciones del menu se podra ver
        vprin.addEvents(this);
         this.mod =mod;
         this.sur = sur;
         this.emp = emp;
       
        valid(mod,sur,emp);
        
   
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
      if(ae.getSource()== vprin.btnEntradas)
        {
            //llamar controlador de la ventana a abrir
            ControladorGenerarVEntrada cvenentra = new ControladorGenerarVEntrada(mod,sur,emp);
            vprin.dispose();
            
        }
      if(ae.getSource()== vprin.btnGolosinas)
      {
          //controlador de la venta golosinas
          ControladorGenerarVenta cgve = new ControladorGenerarVenta(mod,sur,emp,cli);
          vprin.dispose();
      }
        if(ae.getSource()== vprin.btnMenuReportes)
        {
            ControladorMenuReporte cmenu = new ControladorMenuReporte(mod,sur,emp);
            vprin.dispose();
            
        }
      if(ae.getSource()== vprin.btnConfiguracion){
          ControladorConfiguracion ccnfg = new ControladorConfiguracion(mod,sur,emp);
         
          vprin.dispose();
          //controlador de menu a registrar
      }
       if(ae.getSource()== vprin.btnCerrarSesion){
          ControladorLogin cl = new ControladorLogin();
          
          vprin.dispose();
       }
            
         }
  
    public void valid(Usuario mod, Sucursal sur, Empleado emp)
    {  
        if(mod.getId_tipoRol() == 1){}
       
        if(mod.getCodigoEmpleado() == emp.getId()){
                if(emp.getCodigoSucursalEmpleado()== sur.getCodigoSucursal()){
                    if(mod.getId_tipoRol() == 2){
                    vprin.btnEntradas.setVisible(false);}
        
                    if(mod.getId_tipoRol() == 3){
                      vprin.btnGolosinas.setVisible(false);}
            
                    if(mod.getId_tipoRol() == 4){
                    vprin.btnGolosinas.setVisible(false);
                    vprin.btnConfiguracion.setVisible(false);
                    vprin.btnMenuReportes.setVisible(false);}
            
                    if(mod.getId_tipoRol() == 5){
                    vprin.btnEntradas.setVisible(false);
                    vprin.btnConfiguracion.setVisible(false);
                    vprin.btnMenuReportes.setVisible(false);}}
                else
                {
                    vprin.btnGolosinas.setVisible(false);
                    vprin.btnEntradas.setVisible(false);
                    vprin.btnConfiguracion.setVisible(false);
                    vprin.btnMenuReportes.setVisible(false);
                    JOptionPane.showMessageDialog(null, "NO EXISTE LA SUCURSAL");}
        }
        else{
                    vprin.btnGolosinas.setVisible(false);
                    vprin.btnEntradas.setVisible(false);
                    vprin.btnConfiguracion.setVisible(false);
                    vprin.btnMenuReportes.setVisible(false);
                    JOptionPane.showMessageDialog(null, "NO EXISTE EL EMPLEADO");
        }
         //if (mod.getCedula().equals(sur.getRif()))
       // if(mod.getCodigoSucursal() == sur.getCodigoSucursal())
        //if(emp.getCodigoSucursalEmpleado() == sur.getCodigoSucursal()){
       
     
    }
    
}
