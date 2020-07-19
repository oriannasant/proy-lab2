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
public class Venta {
    private int codigoventa;
    private int idcliente;
    private int idvendedor;
    private float monto;
    private String fechaventa;
    private String formadepago;

    public String getFormadepago() {
        return formadepago;
    }

    public void setFormadepago(String formadepago) {
        this.formadepago = formadepago;
    }

    public Venta() {
    }

    public int getCodigoventa() {
        return codigoventa;
    }

    public Venta(int codigoventa, int idcliente, int idvendedor, float monto,String fechaventa) {
        this.codigoventa = codigoventa;
        this.idcliente = idcliente;
        this.idvendedor = idvendedor;
        this.monto = monto;
        this.fechaventa =fechaventa;
    }

    public String getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }

    public void setCodigoventa(int codigoventa) {
        this.codigoventa = codigoventa;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
}
