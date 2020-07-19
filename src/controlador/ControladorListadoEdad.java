package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Funcion;
import modelo.ListadoEdadesDao;
import modelo.Sucursal;
import modelo.Usuario;
import vista.ListadoEdad;

/**
 *
 * @author oriana
 */
public class ControladorListadoEdad implements ActionListener {

    ListadoEdad lised = new ListadoEdad();
    ListadoEdadesDao lisdao = new ListadoEdadesDao();
    Funcion fun = new Funcion();
    Empleado emp = new Empleado();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    DefaultComboBoxModel cbonombre  = new DefaultComboBoxModel(fun.mostrarFuncion());

    public ControladorListadoEdad(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        lised.cboNombre.setModel(cbonombre);
        lised.addEvents(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

     
        if (ae.getSource() == lised.btnAtras) {
          
            ControladorMenuReporte comre = new ControladorMenuReporte(mod,sur,emp);
            lised.dispose();

        }
        
        if(ae.getSource()== lised.btnListar){
        
            listaredad();
        
        }
        if(ae.getSource()== lised.cboNombre){
          
            lisdao.combo();
        
        }
 
    }
    
    public void listaredad (){
    
    String nombrepe = lised.cboNombre.getSelectedItem().toString();
    int id = Integer.parseInt(lised.lblifun.getText().toString());
    
    
    lisdao.listadoedades(id,nombrepe);
  
    }

}