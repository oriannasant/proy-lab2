/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.FuncionDao;
import modelo.Horario;
import modelo.Pelicula;
import modelo.Sala;
import modelo.Sucursal;
import modelo.Usuario;
import vista.AgregarFuncion;
import java.time.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;

/**
 *
 * @author Yamilex Sayago
 */
public class ControladorAgregarFuncion implements ActionListener {

    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    Empleado emp = new Empleado();
    Pelicula peli = new Pelicula();
    Sala sal = new Sala();
    Horario hor = new Horario();
    FuncionDao fd = new FuncionDao();
    AgregarFuncion af = new AgregarFuncion();
    DefaultComboBoxModel cbonombre = new DefaultComboBoxModel(peli.mostrarPelicula());
    DefaultComboBoxModel cbosala = new DefaultComboBoxModel(fd.mostrarSalas());
    DefaultComboBoxModel cbohorario = new DefaultComboBoxModel(hor.mostrarHorario());

    public ControladorAgregarFuncion(Usuario mod, Sucursal sur, Empleado emp) {
        this.emp = emp;
        this.mod = mod;
        this.sur = sur;
        af.addEvents(this);
        af.cboNombre.setModel(cbonombre);
        af.cboSala.setModel(cbosala);
        af.cboHorario.setModel(cbohorario);
        String is = String.valueOf(emp.getCodigoSucursalEmpleado());
        af.lblid.setText(is);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == af.btnAtras) {

            ControladorConfiguracion config = new ControladorConfiguracion(mod, sur, emp);
            af.dispose();
        }

        if (ae.getSource() == af.btnGuardar) {
         
            guardar();
         
        }
        if (ae.getSource() == af.cboNombre) {
           
            fd.combo(af);

        }
        if(ae.getSource()== af.cboSala){
        
            fd.combo2(af);
            
        }

      /*  if (ae.getSource() == af.btnLimpiar) {

            af.txtClasificacion.setText("");
            af.cboHorario.setSelectedIndex(0);
            af.cboSala.setSelectedIndex(0);
            af.cboNombre.setSelectedIndex(0);

        }*/
        if (ae.getSource() == af.btnCerrarsesion) {
            ControladorLogin cl = new ControladorLogin();
            af.dispose();
        }
        if (ae.getSource() == af.btnFecha) {
            hacerfecha();
        }
        if(ae.getSource()==af.btnFecha2){
            
            fechafinal();
            
        }


    }

    public void guardar() {

        String nombre = af.cboNombre.getSelectedItem().toString();
        String clasificacion = af.txtClasificacion.getText();
        String sala = af.cboSala.getSelectedItem().toString();
        String horario = af.cboHorario.getSelectedItem().toString();
        String fechaes = af.txtFechaes.getText();
        String fechaulti = af.txtFechaulti.getText();
        int idsuc= emp.getCodigoSucursalEmpleado();
        int dispo = Integer.parseInt(af.txtDisponibilidad.getText());
        String comp = "07:00:00";
        SimpleDateFormat sdate = new SimpleDateFormat("HH:mm:ss");
        try {
            Date hora = sdate.parse(comp);
            Date horab = sdate.parse(horario);
           
            if (clasificacion.equals("A")) {
                String resp = fd.guardar(nombre, clasificacion, sala, horario,fechaes,fechaulti,dispo,idsuc);
                if (resp != null) {
                    JOptionPane.showMessageDialog(null, "FUNCION GUARDADA!");
                }
            } else if ((clasificacion.equals("B") || clasificacion.equals("C")) && horab.compareTo(hora) > 0) {

                String resp = fd.guardar(nombre, clasificacion, sala, horario,fechaes,fechaulti,dispo,idsuc);
                if (resp != null) {

                    JOptionPane.showMessageDialog(null, "FUNCION GUARDADA!");
                }          
  
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PERMITE ESTA PELICULA EN ESTE HORARIO");
            }
           

        } catch (ParseException ex) {
            Logger.getLogger(ControladorAgregarFuncion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void hacerfecha(){
           String dia = Integer.toString(af.datefecha.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(af.datefecha.getCalendar().get(Calendar.MONTH) + 1);
            String anno = Integer.toString(af.datefecha.getCalendar().get(Calendar.YEAR));
            String fech = (anno + "/" + mes + "/" + dia);
            af.txtFechaes.setText(fech);
    
    }
    public void fechafinal(){
            String dia = Integer.toString(af.datefecha2.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(af.datefecha2.getCalendar().get(Calendar.MONTH) + 1);
            String anno = Integer.toString(af.datefecha2.getCalendar().get(Calendar.YEAR));
            String fech = (anno + "/" + mes + "/" + dia);
            af.txtFechaulti.setText(fech);
    
    
    }
    

}
