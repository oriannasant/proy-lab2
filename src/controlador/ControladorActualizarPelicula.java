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
import vista.ActualizarPelicula;
import vista.BuscarPelicula;


/**
 *
 * @author Yamilex Sayago
 */
public class ControladorActualizarPelicula implements ActionListener {
    
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    Empleado emp = new Empleado();
    PeliculaDao pelidao =  new PeliculaDao();

    ActualizarPelicula vacpeli = new ActualizarPelicula();
    
    
    public ControladorActualizarPelicula(Usuario mod, Sucursal sur, Empleado emp){
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;

        vacpeli.addEvents(this);
    }

       @Override
       public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vacpeli.btnGuardar) {
           
            actualizar();
            pelidao.cargar();
            BuscarPelicula.jPopupMenu1.setVisible(false);

        }

        if (ae.getSource() == vacpeli.btnLimpiar) {
           limpiar();

        }
        if (ae.getSource() == vacpeli.btnAtras) {
            
            vacpeli.dispose();
            pelidao.cargar();
           // BuscarPelicula.jPopupMenu1.setVisible(false);
        }
       
        
    }

    public void limpiar() {
        vacpeli.txtNombre.setText("");
        vacpeli.txtClasificacion.setText("");
        vacpeli.txtGenero.setText("");
        vacpeli.txtDescripcion.setText("");
    }

    
     public void actualizar(){

        String nom= vacpeli.txtNombre.getText();
        String cla= vacpeli.txtClasificacion.getText();
        String gen= vacpeli.txtGenero.getText();
        String des= vacpeli.txtDescripcion.getText();
        String dur= vacpeli.txtDuracion.getText();
        String id = vacpeli.lblid.getText();
        int lblid = Integer.parseInt(id);
        
        String resp = pelidao.editar(nom,cla,gen,des,dur,lblid);
       if(resp != null)
            {
               JOptionPane.showMessageDialog(null, "Error al actualizar");
                      
               
            }else{
                JOptionPane.showMessageDialog(null, "PELICULA ACTUALIZADA");
            }              
    }
    
}
