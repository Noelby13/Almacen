/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

/**
 *
 * @author Noel
 */
public class Producto {
    private String codigoBarra;
    private String nombre;
    private String marca;
    private String lote;
    private String ubicacion;
    private int cantidad;
    private int estado;

    public Producto() {
    }

    public Producto(String codigoBarra, String nombre, String marca, String lote, String ubicacion, int cantidad, int estado) {
        this.codigoBarra = codigoBarra;
        this.nombre = nombre;
        this.marca = marca;
        this.lote = lote;
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
        this.estado = estado;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
}
