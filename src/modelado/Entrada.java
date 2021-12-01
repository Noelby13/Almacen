/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

import java.util.Date;

/**
 *
 * @author Noel
 */
public class Entrada {
    private int id;
    private Date Fecha;
    private Producto producto;
    private int cantidad;
    private Usuario usuario;
    private int estado;

    public Entrada() {
    }

    public Entrada(int id, Date Fecha, Producto producto, int cantidad,Usuario usuario, int estado) {
        this.id = id;
        this.Fecha = Fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.estado = estado;
    }


    public Entrada(Date Fecha, Producto producto, int cantidad, Usuario usuario, int estado) {
        this.Fecha = Fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.estado = estado;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
