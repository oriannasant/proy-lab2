
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import vista.ListadoPelicula;


/**
 *
 * @author oriana
 */
public class ControladorPeliculasCine implements ActionListener {

    ListadoPelicula lispeli = new ListadoPelicula();
    Empleado emp = new Empleado();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();

    public ControladorPeliculasCine(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        lispeli.addEvents(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

     
        if (ae.getSource() == lispeli.btnAtras) {
            
           ControladorMenuReporte conmenu = new ControladorMenuReporte(mod, sur, emp);

            lispeli.dispose();

        }
    
    }

} 