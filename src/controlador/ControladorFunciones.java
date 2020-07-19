/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.FuncionDao;
import modelo.Sucursal;
import modelo.Usuario;
import vista.Funciones;

/**
 *
 * @author Yamilex Sayago
 */
public class ControladorFunciones implements  ActionListener{
    Empleado emp = new Empleado();
    DefaultTableModel modelo = new DefaultTableModel();
    Usuario mod = new Usuario();
    Sucursal sur = new Sucursal();
    FuncionDao fundao = new FuncionDao();
    Funciones fun = new Funciones();
    public ControladorFunciones(Usuario mod, Sucursal sur, Empleado emp) {
        this.mod = mod;
        this.sur = sur;
        this.emp = emp;
        //fundao.cargar();
        fun.addEvents(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == fun.btnSeleccionar) {

           fundao.selecionar();
           fun.dispose();
            
        }
        if (ae.getSource() == fun.btnAtras) {
 
            fun.dispose();

        }
       

    }
}
