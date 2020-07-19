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
public class VentaEntrada {
   private int codigo;
   private int idcliente;
   private int idvendedor;
   private float montototal;
   private int cantidaden;
   private String fecha;
   private String formaP;

    public int getCantidaden() {
        return cantidaden;
    }

    public void setCantidaden(int cantidaden) {
        this.cantidaden = cantidaden;
    }

    public String getFormaP() {
        return formaP;
    }

    public void setFormaP(String formaP) {
        this.formaP = formaP;
    }
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public float getmontototal() {
        return montototal;
    }

    public void setMontototal(float montototal) {
        this.montototal = montototal;
    }

           

   public int getcantidaden(){
   return cantidaden;
   }
   public void setcantidaden(int cantidaden){
   this.cantidaden= cantidaden;
   }

    public VentaEntrada(int codigo,int montototal,int idcliente,int idvendedor,int cantidaden, String fecha) {
        //this.numero = numero;
        this.fecha = fecha;
        this.montototal= montototal;
        this.codigo  = codigo;
        this.idcliente  = idcliente;
        this.idvendedor  = idvendedor;
        this.cantidaden = cantidaden;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public VentaEntrada() {
    }
  
}
