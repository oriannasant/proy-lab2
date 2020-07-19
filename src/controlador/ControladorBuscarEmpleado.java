/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Empleado;
import modelo.EmpleadoDao;
import modelo.Sucursal;
import modelo.Usuario;
import vista.ActualizarEmpleado;
import vista.BuscarEmpleado;

/**
 *
 * @author oriana
 */
public class ControladorBuscarEmpleado implements ActionListener {

    EmpleadoDao emDao = new EmpleadoDao();
    Empleado emp = new Empleado();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();

    BuscarEmpleado vbuscarem = new BuscarEmpleado();

    public ControladorBuscarEmpleado(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.emp = emp;
        this.sur = sur;
        emDao.cargar(emp,mod);
        vbuscarem.addEvents(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vbuscarem.btnRegistar) {
            
            ControladorRegistroEmpleado cres = new ControladorRegistroEmpleado(mod, sur, emp);

        }

        if (ae.getSource() == vbuscarem.btnCerrarSesion) {
            ControladorLogin cl = new ControladorLogin();

            vbuscarem.dispose();
        }
        if (ae.getSource() == vbuscarem.btnAtras) {
            vbuscarem.dispose();
            ControladorConfiguracion cconf = new ControladorConfiguracion(mod, sur, emp);
            

        }
        
        if (ae.getSource() == vbuscarem.txtBuscar) {
            emDao.buscar(vbuscarem);

        }

        
        if (ae.getSource() == vbuscarem.btnEditar) {

            ControladorActualizarEmpleado aemp = new ControladorActualizarEmpleado(mod,sur,emp);
            cargar();
        }
        if (ae.getSource() == vbuscarem.btnborrar) {

            emDao.borrar();
            emDao.cargar(emp, mod);

        }

    }

    public void cargar() {
        int fila = BuscarEmpleado.jTablaEmpleado.getSelectedRow();

        ActualizarEmpleado.txtCedula.setText(BuscarEmpleado.jTablaEmpleado.getValueAt(fila, 1).toString());
        ActualizarEmpleado.txtNombre.setText(BuscarEmpleado.jTablaEmpleado.getValueAt(fila, 2).toString());
        ActualizarEmpleado.txtApellido.setText(BuscarEmpleado.jTablaEmpleado.getValueAt(fila, 3).toString());
        ActualizarEmpleado.txtTel.setText(BuscarEmpleado.jTablaEmpleado.getValueAt(fila, 4).toString());
        ActualizarEmpleado.txtDir.setText(BuscarEmpleado.jTablaEmpleado.getValueAt(fila, 5).toString());
        ActualizarEmpleado.txtCargo.setText(BuscarEmpleado.jTablaEmpleado.getValueAt(fila, 6).toString());
        ActualizarEmpleado.lblid.setText(BuscarEmpleado.jTablaEmpleado.getValueAt(fila, 0).toString());
    }

}
