/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author oriana
 */
public class Empleado extends Persona{
     private String cargo;
    private int id;
    private int codigoSucursalEmpleado;

    public int getCodigoSucursalEmpleado() {
        return codigoSucursalEmpleado;
    }

    public void setCodigoSucursalEmpleado(int codigoSucursalEmpleado) {
        this.codigoSucursalEmpleado = codigoSucursalEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
   
}
