/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author oriana
 */
public class UsuarioDao extends Conexion{
    
    /**
     *
     * @param usr
     * @return
     */
      Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;

   public void buscar(int cdg, Empleado emp) {
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
       

         String sql = "SELECT id FROM empleado WHERE id = "+cdg+" AND estatus='A'";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
          
           while (rs.next()) {
               emp.setId(rs.getInt(1));
              
              }
           ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
          
}
     public String registrar(String usuario,String contrasenna, int cod, int rol) {
        String resp = null;
        
          String sql= "INSERT INTO usuario (usuario, contrasenna,codigoempleado,tiporol) VALUES (?,?,?,?)";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasenna);
            ps.setInt(3, cod);
            ps.setInt(4, rol);
          
            int numf = ps.executeUpdate();
            if (numf > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR" + e.getMessage());

        }
        return resp;
    
    }
    public boolean login(Usuario usr, Sucursal sur,Empleado emp){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql ="SELECT u.usuario, u.contrasenna, u.tiporol,u.codigoempleado,e.codigosucursal,s.codigo,e.id FROM usuario AS u INNER JOIN rol AS r ON u.tiporol= r.id LEFT JOIN empleado AS e ON u.codigoempleado = e.id LEFT JOIN sucursal AS s ON e.codigosucursal = s.codigo WHERE usuario = ?";
       //String sql= "SELECT u.usuario, u.contrasenna, u.codigosucursal,u.tiporol,r.nombre,s.nombre,s.codigo FROM usuario AS u INNER JOIN rol AS r ON u.tiporol= r.id LEFT JOIN sucursal AS s ON u.codigosucursal = s.codigo WHERE usuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
         
            while (rs.next()) {
                if (usr.getContrasenna().equals(rs.getString(2))) 
                {
                    
                    usr.setId_tipoRol(rs.getInt(3));
                    usr.setCodigoEmpleado(rs.getInt(4));
                    emp.setCodigoSucursalEmpleado(rs.getInt(5));
                    sur.setCodigoSucursal(rs.getInt(6));
                    emp.setId(rs.getInt(7));
                    return true;
                   
                }else 
                {
                return false;
                } 
            }
         return false;
            
        } catch (Exception e) { 
            System.out.println("Error "+e.getMessage());
            return false;
     }}
    public void buscarinfousurio(String usr,String pass){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String contra ="";
        String sql ="SELECT u.usuario, u.contrasenna, u.tiporol,u.codigoempleado,e.codigosucursal,s.codigo,e.id FROM usuario AS u INNER JOIN rol AS r ON u.tiporol= r.id LEFT JOIN empleado AS e ON u.codigoempleado = e.id LEFT JOIN sucursal AS s ON e.codigosucursal = s.codigo WHERE usuario = "+usr;
            
        try {
           
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
         
            if (rs.next()) {
                 String nom = rs.getString("usuario");
                     contra = rs.getString("contrasenna");
                 int tip = rs.getInt("tiporol");
                 int codemp = rs.getInt("codigoempleado");
                 int surc = rs.getInt("codigosucursal");
                 int codsur = rs.getInt("codigo");
                 int idemp = rs.getInt("id");
               
            }
        if ( pass.equals(contra)) 
        {
              /*llama a la vista para guardar el nivel de acceso
                pero esta variable eta declarada en la vista yo la tendria
                que hacer en el controlador en forma global si solo quiero
                que quede todo en las variables y no en los set y get
            
            solo necesito el tipo del rol para ver o no otras ventanas
            no necesito el usuario y pass guardado en algun lado, ya se verifica 
            que coinciden los datos enonces no quiero mas nada (CLARO LA SUCURSAL)
            por la otra condicion de mostrarse por separado
            
            la cuestion es la siguiente si modifico esto afectaria todo 
            lo demas que se hizo en las otras ventanas :(*/
             
            }else
               {
                   JOptionPane.showMessageDialog(null, "Contraseña no coinciden");
                 
               }
            
        } catch (Exception e) { 
            System.out.println("Error "+e.getMessage());
          
     }    
}
    
    }
    
