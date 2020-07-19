/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ClienteDao;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import vista.ActualizarClasificacion;
import vista.ActualizarCliente;

/**
 *
 * @author Yamilex Sayago
 */
public class ControladorActualizarClasificacion implements ActionListener {

    Cliente cli = new Cliente();
    ClienteDao clidao = new ClienteDao();
    ActualizarClasificacion vaclia = new ActualizarClasificacion();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    Empleado emp = new Empleado();

    public ControladorActualizarClasificacion(Usuario mod, Sucursal sur, Empleado emp) {

        //emDao.setVisible(false);
        vaclia.addEvents(this);
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        
    }

    public void limpiar() {
      
        vaclia.txtClasificacion.setText("");

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vaclia.btnGuardar) {

            actualizar();

        }

        if (ae.getSource() == vaclia.btnLimpiar) {
            limpiar();

        }
        if (ae.getSource() == vaclia.btnAtras) {
            // ControladorBuscarEmpleado cbusem= new ControladorBuscarEmpleado();
            vaclia.dispose();
            clidao.clienteFrecuente();

        }
        
      

    }

    public void actualizar() {

        String id = vaclia.lblid.getText();
        int lblid = Integer.parseInt(id);
        String algo = vaclia.txtClasificacion.getText();

        String resp = clidao.editarclasificacion(lblid,algo);
        if (resp != null)
        {
            
             JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
             
        } else {
            JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO");
        }
    }
}
