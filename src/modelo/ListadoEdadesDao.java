/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.image.ImageObserver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Funciones;
import vista.ListadoEdad;

/**
 *
 * @author Yamilex Sayago
 */
public class ListadoEdadesDao {
    
    
    Conexion conx = new Conexion();
    Connection con = conx.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void listadoedades(int id,String peli){
        
    
    String sql = "SELECT detalleentrada.edad1,detalleentrada.edad2,detalleentrada.edad3,detalleentrada.edad4,detalleentrada.edad5 FROM funcion INNER JOIN detalleentrada ON  detalleentrada.idfuncion ='"+id+"' AND funcion.nombre = '"+ peli +"'";
    
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };

            ListadoEdad.jtablaedad.setModel(model);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
 
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidad = rsMD.getColumnCount();
            model.addColumn("0 A 1 ");
            model.addColumn("1 A 4");
            model.addColumn("4 A 12");
            model.addColumn("13 A 60");
            model.addColumn(" 60+ ");

            while (rs.next()) {

                Object[] filas = new Object[cantidad];

                for (int i = 0; i < cantidad; i++) {

                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
                ListadoEdad.jtablaedad.setVisible(true);
                
            }

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"ERROR "+e);
        }
    }
        public void combo(){
       
            String nom = ListadoEdad.cboNombre.getSelectedItem().toString();
            
            String sql = "SELECT * FROM funcion WHERE nombre =?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                ListadoEdad.lblifun.setText(id);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
        }
    
    
    }

