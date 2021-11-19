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
public class Cliente {
    private int id;
    private String nombre;
    private String ruc;
    private int estado;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String ruc, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.ruc = ruc;
        this.estado = estado;
    }

    public Cliente(String nombre, String ruc, int estado) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.estado = estado;
    }
    

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    
    
}
