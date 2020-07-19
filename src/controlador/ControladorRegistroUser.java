/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Rol;
import modelo.Sucursal;
import modelo.Usuario;
import modelo.UsuarioDao;
import vista.RegistrarUsuario;

/**
 *
 * @author oriana
 */
public class ControladorRegistroUser implements ActionListener{
    UsuarioDao dao= new UsuarioDao();
    Usuario mod= new Usuario();
    Sucursal sur = new Sucursal();
    Rol rol = new Rol();
    Empleado emp=new Empleado();
    RegistrarUsuario vista= new RegistrarUsuario();
   // DefaultComboBoxModel molct = new DefaultComboBoxModel(sur.mostrarSucursal());
    DefaultComboBoxModel roles = new DefaultComboBoxModel(rol.mostrarRol());
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ControladorRegistroUser(Usuario mod, Sucursal sur, Empleado emp){
  
       // this.vista.btnGuardar.addActionListener(this);
       vista.addEvents(this);
       this.mod = mod;
       this.emp = emp;
       this.sur=sur;
               
    //vista.cboIDSucursal.setModel(molct);
    vista.cboTipoRol.setModel(roles);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
           if(ae.getSource()== vista.btnGuardar)
        {   guardar();  
                     // if( vista.txtCodigo.getText().equals(emp.getId())){
           /* int cod = Integer.parseInt(vista.txtCodigo.getText());
            if ( cod ==emp.getId()){
                          guardar();  
                         
                          JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO");
                      }else{
                      
                      JOptionPane.showMessageDialog(null, "ERROR EL CODIGO DEL EMPLEADO NO EXISTE");
                  
                      }*/
               
        }
        if(ae.getSource()== vista.btnCerrar)
        {
            ControladorLogin cl = new ControladorLogin();
            vista.dispose();
 
        } 
       if(ae.getSource()== vista.btnLimpiar)
        {
            limpiar();
            
        }
       if(ae.getSource()== vista.btnAtras)
       {
           ControladorConfiguracion cconfg= new ControladorConfiguracion(mod,sur,emp);
            vista.dispose();
       }
      
   
    } 
     public void guardar(){

        String pass = new String(vista.txtContrasenna.getPassword());
        String passcon = new String(vista.txtConfirme.getPassword());
        
        if(pass.equals(passcon))
        {
            String usuario = vista.txtUsuario.getText();
            int codigo = Integer.parseInt(vista.txtCodigo.getText());
            int item = vista.cboTipoRol.getSelectedIndex();
           /* mod.setUsuario(vista.txtUsuario.getText());
            mod.setContrasenna(pass);
            int codigo = Integer.parseInt(vista.txtCodigo.getText());
            mod.setCodigoEmpleado(codigo);
            //int itemsur = vista.cboIDSucursal.getSelectedIndex();
            int item = vista.cboTipoRol.getSelectedIndex();
            mod.setId_tipoRol(item);
            //mod.setId(itemsur);
            */
            
            String resp = dao.registrar(usuario, pass, codigo, item);
            if (resp != null) {

                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } 
            
        
        }else
        {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }}
     public void limpiar()
{
    vista.txtUsuario.setText("");
    vista.txtContrasenna.setText("");
    vista.txtConfirme.setText("");
    vista.txtCodigo.setText("");
}
        
}
