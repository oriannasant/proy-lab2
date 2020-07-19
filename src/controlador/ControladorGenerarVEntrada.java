/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SpinnerNumberModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import modelo.CarteleraDao;
import modelo.Cliente;
import modelo.Conexion;
import modelo.DetalleEntrada;
import modelo.Empleado;
import modelo.FormaPagoM;
import modelo.FuncionDao;
import modelo.Pelicula;
import modelo.Sucursal;
import modelo.Usuario;
import modelo.VentaEntrada;
import modelo.VentaEntradaDao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.VentanaEntrada;

/**
 *
 * @author oriana
 */
public class ControladorGenerarVEntrada implements ActionListener, ChangeListener {

    VentanaEntrada ventr = new VentanaEntrada();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    Empleado emp = new Empleado();
    Cliente cli = new Cliente();
    FuncionDao fundao = new FuncionDao();
    VentaEntrada veen = new VentaEntrada();
    DetalleEntrada deen = new DetalleEntrada();
    DefaultTableModel modelo = new DefaultTableModel();
    Pelicula pelicula = new Pelicula();
    CarteleraDao cardao = new CarteleraDao();
    VentaEntrada men = new VentaEntrada();
    VentaEntradaDao endao = new VentaEntradaDao();
    FormaPagoM modelof = new FormaPagoM();
    DefaultComboBoxModel molpago = new DefaultComboBoxModel(modelof.mostrarFP());

    // Horario hr= new Horario();
    //Funcion cfun = new Funcion();
    //DefaultComboBoxModel peli = new DefaultComboBoxModel(pelicula.mostrarPeli());
    //DefaultComboBoxModel hora = new DefaultComboBoxModel(hr.mostrarHora(pelicula.getId()));
    //DefaultComboBoxModel fun = new DefaultComboBoxModel(cfun.mostrarF());
    //VentaEntrada vet = new VentaEntrada();
    public ControladorGenerarVEntrada(Usuario mod, Sucursal sur, Empleado emp) {
        ventr.addEvents(this);
        ventr.cboFormaPago.setModel(molpago);
        ventr.addChanges(this);
        this.mod = mod;
        this.emp = emp;
        this.sur = sur;
        SpinnerNumberModel nm = new SpinnerNumberModel();
        SpinnerNumberModel nm1 = new SpinnerNumberModel();
        SpinnerNumberModel nm2 = new SpinnerNumberModel();
        SpinnerNumberModel nm3 = new SpinnerNumberModel();
        SpinnerNumberModel nm4 = new SpinnerNumberModel();
        nm.setMinimum(0);
        nm1.setMinimum(0);
        nm2.setMinimum(0);
        nm3.setMinimum(0);
        nm4.setMinimum(0);
        ventr.spibebe.setModel(nm);
        ventr.spiadulto.setModel(nm1);
        ventr.spinino1.setModel(nm2);
        ventr.spinino2.setModel(nm3);
        ventr.spiviejo.setModel(nm4);
        ventr.txtMonto.setText("5$");
        ventr.txtaño1.setText("0.0");
        ventr.txtaño2.setText("0.0");
        ventr.txtaño3.setText("0.0");
        ventr.txtaño4.setText("0.0");
        ventr.txtaño5.setText("0.0");
        ventr.txtTotal.setText("0.0");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == ventr.btnCartelera) {
            ControladorCartelera ccar = new ControladorCartelera(mod, sur, emp);
            if(mod.getId_tipoRol()== 1){
             
                cardao.cargar2();
               
                
             }else{
            cardao.cargar(emp);
            }
        }
        if (ae.getSource() == ventr.btnGenerarventa) {

            String total = ventr.txtTotal.getText();
            String nombre = ventr.txtNombrePeli.getText();
            int cantidisp = Integer.parseInt(ventr.txtDispo.getText());
            
            if (nombre.equals("")) {

                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UNA FUNCION");
            } else if ((!"".equals(nombre)) && total.equals("0.0")) {

                JOptionPane.showMessageDialog(null, "NO HAY ENTRADAS SELECCIONADAS");

            }else if(cantidad() > cantidisp){
            
             JOptionPane.showMessageDialog(null,"NO HAY SUFICIENTES ASIENTOS");
                
            }
            
            else if ((!"".equals(nombre)) && (!"".equals(total))) {
                if (cli.getId() != 0) {

                    guardarVentaEntrada();
                    detalleentrada();
                    actudip();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "VENTA REALIZADA CORRECTAMENTE");

                } else {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR DATOS DEL CLIENTE");
                }
            }

        }
        if (ae.getSource() == ventr.btnCerrarSesion) {

            ControladorLogin cl = new ControladorLogin();
            ventr.dispose();
        }
        if (ae.getSource() == ventr.btnAtras) {
            ControladorVentanaPrin cpr = new ControladorVentanaPrin(mod, sur, emp);
            ventr.dispose();
        }

        if (ae.getSource() == ventr.btnTotal) {

            endao.total();
        }

        if (ae.getSource() == ventr.btnlimpiar) {

            limpiar();
        }
        if (ae.getSource() == ventr.btnFuncion) {
            ControladorFunciones confun = new ControladorFunciones(mod, sur, emp);
            if(mod.getId_tipoRol()== 1){
             
                fundao.cargar();
               
                
             }else{
            fundao.cargar2(emp);
            }
            
        }
        if (ae.getSource() == ventr.btnCliente) {
            ControladorBuscarCliente bcli = new ControladorBuscarCliente(mod, sur, emp, cli);
        }
           if (ae.getSource() == ventr.btnGenerarT) {
            
               try {
            Conexion conx= new Conexion();
            Connection con= conx.getConnection();
            JasperReport reporte= null;
            
            String path="src\\modelo\\ticketEntrada.jasper";
            reporte= (JasperReport) JRLoader.loadObjectFromFile(path);
             JasperPrint jprint= JasperFillManager.fillReport(path, null,con);
            
            JasperViewer view= new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(VentanaEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //ventr.addChanges(this);
        if (e.getSource() == ventr.spibebe) {
            endao.año1();
        }
        if (e.getSource() == ventr.spinino1) {
            endao.año2();
        }
        if (e.getSource() == ventr.spinino2) {
            endao.año3();
        }
        if (e.getSource() == ventr.spiadulto) {
            endao.año4();
        }
        if (e.getSource() == ventr.spiviejo) {
            endao.año5();
        }

    }

    public void guardarVentaEntrada() {
        String montomostrar = ventr.txtTotal.getText();

        int idvendedor = emp.getId();
        int idcliente = cli.getId();
         float monto = Float.parseFloat(montomostrar);
        String fecha = ventr.lblfecha.getFecha();
        int cantidaden = cantidad();
        String fp = ventr.cboFormaPago.getSelectedItem().toString();


        veen.setIdcliente(idcliente);
        veen.setIdvendedor(idvendedor);
        veen.setMontototal(monto);
        veen.setcantidaden(cantidaden);
        veen.setFecha(fecha);
        veen.setFormaP(fp);
        

        endao.guardarVentaEntrada(veen);

    }

    public void detalleentrada() {
        String identrada = endao.idVentaentrada();
        int identra = Integer.parseInt(identrada);
        int idfuncion = Integer.parseInt(ventr.lblid.getText());
        int edad1 = Integer.parseInt(ventr.spibebe.getValue().toString());
        int edad2 = Integer.parseInt(ventr.spinino1.getValue().toString());
        int edad3 = Integer.parseInt(ventr.spinino2.getValue().toString());
        int edad4 = Integer.parseInt(ventr.spiadulto.getValue().toString());
        int edad5 = Integer.parseInt(ventr.spiviejo.getValue().toString());

        deen.setIdventaentrada(identra);
        deen.setIdfuncion(idfuncion);
        deen.setEdad1(edad1);
        deen.setEdad2(edad2);
        deen.setEdad3(edad3);
        deen.setEdad4(edad4);
        deen.setEdad5(edad5);
        endao.guardarDetalleVenta(deen);
    }

    public void limpiar() {
        ventr.txtTotal.setText("0.0");
        ventr.txtaño1.setText("0.0");
        ventr.txtaño2.setText("0.0");
        ventr.txtaño3.setText("0.0");
        ventr.txtaño4.setText("0.0");
        ventr.txtaño5.setText("0.0");
        ventr.txtCla.setText("");
        ventr.txtHorario.setText("");
        ventr.txtNombrePeli.setText("");
        ventr.txtSala.setText("");
        ventr.txtDispo.setText("");

    }

    public int cantidad() {
        int cant = 0;

        int val = Integer.parseInt(ventr.spibebe.getValue().toString());
        int val2 = Integer.parseInt(ventr.spinino1.getValue().toString());
        int val3 = Integer.parseInt(ventr.spinino2.getValue().toString());
        int val4 = Integer.parseInt(ventr.spiadulto.getValue().toString());
        int val5 = Integer.parseInt(ventr.spiviejo.getValue().toString());

        cant = val + val2 + val3 + val4 + val5;

        return cant;
    }

    public void actudip() {

        int id = Integer.parseInt(ventr.lblid.getText());
        int cantidisp = Integer.parseInt(ventr.txtDispo.getText());

        int nuedisp = (cantidisp - cantidad());

        endao.actudisp(nuedisp, id);

    }

}
