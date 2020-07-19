/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cliente;
import modelo.ClienteDao;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import vista.ActualizarCliente;
import vista.BuscarCliente;

/**
 *
 * @author oriana
 */
public class ControladorBuscarCliente implements ActionListener{
Cliente cli = new Cliente();
ClienteDao clidao = new ClienteDao();
Sucursal sur= new Sucursal();
Usuario mod= new Usuario();
Empleado emp = new Empleado();
BuscarCliente vbuscarcli = new BuscarCliente();

public ControladorBuscarCliente(Usuario mod, Sucursal sur,Empleado emp,Cliente cli)
{
    vbuscarcli.addEvents(this);
    this.mod = mod;
    this.sur= sur;
    this.emp = emp;
    this.cli = cli;
    clidao.cargar();
}
    @Override
    public void actionPerformed(ActionEvent ae) {
             if(ae.getSource()== vbuscarcli.btnRegistrar)
        {
            ControladorRegistrarCliente crescli = new ControladorRegistrarCliente(mod,sur,emp,cli);
            vbuscarcli.dispose();
        }
     
      
       if(ae.getSource()== vbuscarcli.btnAtras)
      {
      
         //ControladorGenerarVEntrada cven= new ControladorGenerarVEntrada(mod, sur,emp);
     
          
          vbuscarcli.dispose();
         
      }
       
         if(ae.getSource()== vbuscarcli.btnAceptar)
      {
          
         clidao.listaridcli(cli);
         
      }
          
         
         if(ae.getSource()==vbuscarcli.txtBuscar){
           clidao.buscar(vbuscarcli);
         }
         
         if(ae.getSource()==vbuscarcli.btnEditar){
         
             ControladorActualizarCliente cacli= new ControladorActualizarCliente(mod,sur,emp);
             cargar();
         }
         
         if(ae.getSource()==vbuscarcli.btnborrar){
             clidao.borrar(cli);
             clidao.cargar();
         }
         }

      public void cargar(){
     int fila = BuscarCliente.jTablaCliente.getSelectedRow();

        ActualizarCliente.txtCedula.setText(BuscarCliente.jTablaCliente.getValueAt(fila, 1).toString());
        ActualizarCliente.txtNombre.setText(BuscarCliente.jTablaCliente.getValueAt(fila, 2).toString());
        ActualizarCliente.txtApellido.setText(BuscarCliente.jTablaCliente.getValueAt(fila, 3).toString());
        ActualizarCliente.txtTel.setText(BuscarCliente.jTablaCliente.getValueAt(fila, 4).toString());
        ActualizarCliente.txtDir.setText(BuscarCliente.jTablaCliente.getValueAt(fila, 5).toString());
        //ActualizarCliente.lblid.setText(BuscarCliente.jTablaCliente.getValueAt(fila,0).toString());
      // ActualizarCliente.txtClasificacion.setText(BuscarCliente.jTablaCliente.getValueAt(fila, 6).toString());
        ActualizarCliente.lblid.setText(BuscarCliente.jTablaCliente.getValueAt(fila,0).toString());
    }
     /* public void selccli(){
      // aqui le debo decir que me setee algo de la tabla
      // int fila = BuscarCliente.jTablaCliente.getSelectedRow();
      int lblid = Integer.parseInt(id);
      
                
      clidao.listaridcli(id,vbuscarcli);
               
      }*/
      
}
