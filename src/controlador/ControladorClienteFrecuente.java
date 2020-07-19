package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import vista.ListadoFrecuente;

import modelo.Cliente;

//importe el ClienteDao
import modelo.ClienteDao;
import vista.ActualizarClasificacion;


/**
 *
 * @author oriana
 */
public class ControladorClienteFrecuente implements ActionListener {

    //cambie lisfre por cf = cliente frecuente
    ListadoFrecuente cf = new ListadoFrecuente();
    
    //inicialice al ClienteDao
    ClienteDao cd = new ClienteDao ();
    Cliente cli = new Cliente();
    Empleado emp = new Empleado();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();

    public ControladorClienteFrecuente(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        this.cli=cli;
        cf.addEvents(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

     
        if (ae.getSource() == cf.btnAtras) {
          ControladorMenuReporte conmenu = new ControladorMenuReporte(mod, sur, emp);
            cf.dispose();

        }
        
        //si el boton q se preciona es cerrar
        if (ae.getSource() == cf.btnCerrar) {
            ControladorLogin cl = new ControladorLogin();
            cf.dispose();
        }
        
        //btn clienteFrecuente
        if (ae.getSource() == cf.btnListar) {
            cd.clienteFrecuente();
        }
       
          if (ae.getSource() == cf.btnDatos) {
              
          int fila = ListadoFrecuente.tabla.getSelectedRow();
            
           if (fila == -1){  
               JOptionPane.showMessageDialog(null, "DEBE SELECIONAR UNA FILA");
           }
           else{
             
              ControladorActualizarClasificacion ccla = new ControladorActualizarClasificacion(mod, sur, emp);
            cargar();
          
          }}
    
    
 }
   public void cargar(){
    
     int fila = ListadoFrecuente.tabla.getSelectedRow();

        
       // ActualizarClasificacion.txtClasificacion.setText(ListadoFrecuente.tabla.getValueAt(fila, 6).toString());
        ActualizarClasificacion.lblid.setText(ListadoFrecuente.tabla.getValueAt(fila,0).toString());
    }
  
    
}