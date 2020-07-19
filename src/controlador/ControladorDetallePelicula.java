

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import vista.DetallePelicula;


/**
 *
 * @author oriana
 */
public class ControladorDetallePelicula implements ActionListener {

    DetallePelicula depeli = new DetallePelicula();
    Empleado emp = new Empleado();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();

    public ControladorDetallePelicula(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        depeli.addEvents(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

     
        if (ae.getSource() == depeli.btnAtras) {
            
           ControladorMenuReporte conmenu = new ControladorMenuReporte(mod, sur, emp);

            depeli.dispose();

        }
    
    }

} 

