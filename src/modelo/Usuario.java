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
public class Usuario extends Persona{
    private int id;
    private String contrasenna;
    private String usuario;
    private int id_tipoRol;
    private String nombrerol;
    private int codigoEmpleado;

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

  

    public Usuario(){}
    public Usuario(int id, String contrasenna, String usuario, int id_tipoRol, String nombrerol, int codigoEmpleado) {
        this.id = id;
        this.contrasenna = contrasenna;
        this.usuario = usuario;
        this.id_tipoRol = id_tipoRol;
        this.nombrerol = nombrerol;
        this.codigoEmpleado=codigoEmpleado;
    }
    

    public int getId() {
        return id;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId_tipoRol() {
        return id_tipoRol;
    }

    public void setId_tipoRol(int id_tipoRol) {
        this.id_tipoRol = id_tipoRol;
    }
    
    
}
