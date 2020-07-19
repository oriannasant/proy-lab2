

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import modelo.VentaDao;
import vista.ListadoMontoCliente;


/**
 *
 * @author oriana
 */
public class ControladorMontoCliente implements ActionListener {

    ListadoMontoCliente lismocli = new ListadoMontoCliente();
    Empleado emp = new Empleado();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    VentaDao vdao = new VentaDao();

    public ControladorMontoCliente(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        lismocli.addEvents(this);
        vdao.cargar2();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

     
        if (ae.getSource() == lismocli.btnAtras) {
            
           ControladorMenuReporte conmenu = new ControladorMenuReporte(mod, sur, emp);

            lismocli.dispose();

        }
         if (ae.getSource() == lismocli.btnCerrar) {
            ControladorLogin cl = new ControladorLogin();
            lismocli.dispose();
        }
    
    }

} 