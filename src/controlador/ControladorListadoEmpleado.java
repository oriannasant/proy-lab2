package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import modelo.VentaDao;
import vista.ListadoEmpleado;

/**
 *
 * @author oriana
 */
public class ControladorListadoEmpleado implements ActionListener {

    ListadoEmpleado lisemp = new ListadoEmpleado();
    Empleado emp = new Empleado();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    VentaDao vdao = new VentaDao();

    public ControladorListadoEmpleado(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
       lisemp.addEvents(this);
       vdao.cargar();
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

     
        if (ae.getSource() == lisemp.btnAtras) {
          
            ControladorMenuReporte comre = new ControladorMenuReporte(mod,sur,emp);
            lisemp.dispose();

        }
         if (ae.getSource() == lisemp.btnCerrarSesion) {
            ControladorLogin cl = new ControladorLogin();
            lisemp.dispose();
        }
    
    }

}