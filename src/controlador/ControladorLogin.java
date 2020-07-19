/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Sucursal;
import modelo.Usuario;
import modelo.UsuarioDao;
import vista.Login1;

/**
 *
 * @author oriana
 */
public class ControladorLogin implements ActionListener{
    UsuarioDao dao= new UsuarioDao();
    Usuario mod= new Usuario();
    Login1 vl = new Login1();
    Sucursal sur= new Sucursal();
    Empleado emp = new Empleado();
     
    
     public ControladorLogin(){
  
       vl.addEvents(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== vl.btnIniciar)
        {
           
            iniciar();
            
            
        }
      
        
    }
/*  public void iniciar(){
       String pass =new String(vl.txtPass.getPassword());
       
        if (!vl.txtUsuario.getText().equals("") && !pass.equals("")) 
        {
               mod.setUsuario(vl.txtUsuario.getText());
               mod.setContrasenna(pass);
               if (dao.login(mod,sur)) {
                vl.dispose();
               ControladorVentanaPrin cprin = new ControladorVentanaPrin(mod,sur);
             
            }else
               {
                   JOptionPane.showMessageDialog(null, "Datos incorrectos");
               }
        }else
        {//datos vacios
            JOptionPane.showMessageDialog(null, "Ingresar datos");
        }
  }*/
      public boolean iniciar(){
       String pass =new String(vl.txtPass.getPassword());
       
        if (!vl.txtUsuario.getText().equals("") && !pass.equals("")) 
        {
               mod.setUsuario(vl.txtUsuario.getText());
               mod.setContrasenna(pass);
               if (dao.login(mod,sur,emp)) {
                vl.dispose();
               ControladorVentanaPrin cprin = new ControladorVentanaPrin(mod,sur,emp);
               return true;
             
            }else
               {
                   JOptionPane.showMessageDialog(null, "Datos incorrectos");
                   return false;
               }
        }else
        {//datos vacios
            JOptionPane.showMessageDialog(null, "Ingresar datos");
            return false;
        }
  }
}
