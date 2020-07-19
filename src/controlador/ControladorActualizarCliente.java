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
import vista.ActualizarCliente;

/**
 *
 * @author Yamilex Sayago
 */
public class ControladorActualizarCliente implements ActionListener {

    Cliente cli = new Cliente();
    ClienteDao clidao = new ClienteDao();
    ActualizarCliente vacli = new ActualizarCliente();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    Empleado emp = new Empleado();

    public ControladorActualizarCliente(Usuario mod, Sucursal sur, Empleado emp) {

        //emDao.setVisible(false);
        vacli.addEvents(this);
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        
    }

    public void limpiar() {
        vacli.txtCedula.setText("");
        vacli.txtApellido.setText("");
        vacli.txtNombre.setText("");
        vacli.txtDir.setText("");
        vacli.txtTel.setText("");

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vacli.btnGuardar) {

            actualizar();

        }

        if (ae.getSource() == vacli.btnLimpiar) {
            limpiar();

        }
        if (ae.getSource() == vacli.btnAtras) {
            // ControladorBuscarEmpleado cbusem= new ControladorBuscarEmpleado();
            vacli.dispose();
            clidao.cargar();

        }
     
      

    }

    public void actualizar() {

        String ced = vacli.txtCedula.getText();
        String nom = vacli.txtNombre.getText();
        String apel = vacli.txtApellido.getText();
        String tel = vacli.txtTel.getText();
        String dir = vacli.txtDir.getText();
        String id = vacli.lblid.getText();
        int lblid = Integer.parseInt(id);
        String algo = vacli.txtClasificacion.getText();

        String resp = clidao.editar(ced, nom, apel, tel, dir, lblid,algo);
        if (resp != null)
        {
            
             JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
             
        } else {
            JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO");
        }
    }
}
