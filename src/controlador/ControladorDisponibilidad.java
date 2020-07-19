
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import modelo.DisponibilidadDao;
import modelo.Empleado;
import modelo.Funcion;
import modelo.Horario;
import modelo.Sucursal;
import modelo.Usuario;
import vista.DetalleDisponibilidad;


/**
 *
 * @author oriana
 */
public class ControladorDisponibilidad implements ActionListener {

    DetalleDisponibilidad dedis = new DetalleDisponibilidad();
    DisponibilidadDao disdao = new  DisponibilidadDao();
    Funcion fun = new Funcion();
    Horario ho =  new Horario();
    Empleado emp = new Empleado();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    DefaultComboBoxModel cbpeli = new DefaultComboBoxModel(fun.mostrarFuncion());
    DefaultComboBoxModel cbhora =  new DefaultComboBoxModel(ho.mostrarHorario());

    public ControladorDisponibilidad(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        dedis.cbxPelicula.setModel(cbpeli);
        dedis.cbxHorario.setModel(cbhora);
        dedis.addEvents(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

     
        if (ae.getSource() == dedis.btnAtras) {
           ControladorMenuReporte conmenu = new ControladorMenuReporte(mod, sur, emp);

            dedis.dispose();

        }
        
        if(ae.getSource()== dedis.btnMostrar){
        
        mostrasdetalle();
        
        }
        if(ae.getSource()== dedis.cbxPelicula){
        
        disdao.combo();
        }
        if(ae.getSource()== dedis.btnCerrarSesion){
            ControladorLogin cl = new ControladorLogin();
          dedis.dispose();
            
        }
            
    
    }
    
    
    public void mostrasdetalle(){
    
    String horario = dedis.cbxHorario.getSelectedItem().toString();
    int id = Integer.valueOf(dedis.lblid.getText().toString());
    
    
    
    disdao.cantidadven(id,horario);
    disdao.dispo(id);
    
    
    
    }
    
    

}