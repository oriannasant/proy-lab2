/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.PeliculaDao;
import modelo.Sucursal;
import modelo.Usuario;
import vista.RegistrarPelicula;

/**
 *
 * @author oriana
 */
public class ControladorRegistroPeli implements ActionListener{

    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    Empleado emp = new Empleado();

    RegistrarPelicula vpeli = new RegistrarPelicula();
    PeliculaDao pelidao =  new PeliculaDao();

    public ControladorRegistroPeli(Usuario mod, Sucursal sur, Empleado emp) {
        this.emp = emp;
        this.mod = mod;
        this.sur = sur;
        vpeli.addEvents(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vpeli.btnGuardar) {
            guardar();

        }

        if (ae.getSource() == vpeli.btnLimpiar) {
            limpiar();

        }
        if (ae.getSource() == vpeli.btnAtras) {

            vpeli.dispose();
            pelidao.cargar();
        }
       if(ae.getSource()== vpeli.btnCerrarSesion){
          
           ControladorLogin cl = new ControladorLogin();
          vpeli.dispose();
       }
        
    }

    public void limpiar() {
        vpeli.txtNombre.setText("");
        vpeli.txtClasificacion.setText("");
        vpeli.txtGenero.setText("");
        vpeli.txtDescripcion.setText("");
        vpeli.txtDuracion.setText("");
    }

    
        public void guardar(){
         
                String nombre = vpeli.txtNombre.getText();
                String clasificacion = vpeli.txtClasificacion.getText();
                String genero = vpeli.txtGenero.getText();
                String descripcion = vpeli.txtDescripcion.getText();
                String duracion = vpeli.txtDuracion.getText();

        String resp = pelidao.insertPelicula(nombre, clasificacion,genero,descripcion,duracion);
        if (resp != null) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
        }

    }
    
}
