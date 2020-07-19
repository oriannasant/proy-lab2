/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.CarteleraDao;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import vista.Cartelera;
import vista.VentanaEntrada;

/**
 *
 * @author oriana
 */
public class ControladorCartelera implements ActionListener {

    Cartelera vcar = new Cartelera();
    Empleado emp = new Empleado();
    DefaultTableModel modelo = new DefaultTableModel();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    CarteleraDao cardao = new CarteleraDao();
    public ControladorCartelera(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        vcar.addEvents(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        
        if (ae.getSource() == vcar.btnAtras) {
 
            vcar.dispose();

        }
     

    }

}
