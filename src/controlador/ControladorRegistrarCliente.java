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
import vista.RegistrarCliente;

/**
 *
 * @author oriana
 */
public class ControladorRegistrarCliente implements ActionListener{
    Usuario mod= new Usuario();
    Sucursal sur= new Sucursal();
    Cliente cli = new Cliente();
    Empleado emp = new Empleado();
    ClienteDao clidao = new ClienteDao();
    RegistrarCliente vregiscli = new RegistrarCliente();
public ControladorRegistrarCliente(Usuario mod, Sucursal sur,Empleado emp, Cliente cli)
{
    vregiscli.addEvents(this);
    this.mod = mod;
    this.sur= sur;
    this.emp=emp;
    this.cli=cli;
}
    @Override
    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == vregiscli.btnGuardar) {

            String cedula = vregiscli.txtCedula.getText();
            String nombre = vregiscli.txtNombre.getText();
            String apellido = vregiscli.txtApellido.getText();
            String telefono = vregiscli.txtTel.getText();
            String direccion = vregiscli.txtDir.getText();

            String resp = clidao.insertCliente(cedula, nombre, apellido, telefono, direccion);
            if (resp != null) {

                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                //JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
     
       if(ae.getSource()== vregiscli.btnCerrarSesion){
          
           ControladorLogin cl = new ControladorLogin();
          vregiscli.dispose();
       }
       if(ae.getSource()== vregiscli.btnAtras)
      {
          ControladorBuscarCliente cbus = new ControladorBuscarCliente(mod, sur,emp,cli);
            vregiscli.dispose();
      }
       
        
         if(ae.getSource()== vregiscli.btnLimpiar)
      {
          limpiar();
         
      }
         }
    public void limpiar(){vregiscli.txtCedula.setText("");
            vregiscli.txtNombre.setText("");
            vregiscli.txtApellido.setText("");
            vregiscli.txtTel.setText("");
            vregiscli.txtDir.setText("");}
    
    
}
