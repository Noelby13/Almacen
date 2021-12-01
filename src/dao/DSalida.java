/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import modelado.Cliente;
import modelado.Entrada;
import modelado.Producto;
import modelado.Salida;
import modelado.Usuario;

/**
 *
 * @author Noel
 */
public class DSalida {
    private Connection conn;
    private final Conexion conexion = new Conexion();
    private PreparedStatement insertarSalida;
    private PreparedStatement editarSalida;
    private PreparedStatement eliminarSalida;
    private PreparedStatement mostrarSalida;
    private  ArrayList <Salida> listaSalida = new ArrayList();
    private DProducto p;
    private DCliente cliente;
    private DUsuario user;

    public DSalida(DProducto p, DCliente cliente, DUsuario user) {
        this.p=p;
        this.cliente=cliente;
        this.user=user;
        try{
            conn = conexion.obtenerConexion();
            
            insertarSalida = conn.prepareStatement("insert into tblSalida(fecha,idCliente,cbProducto,cantidad, idUsuario) values(?,?,?,?,?)");
            editarSalida = conn.prepareStatement("update tblSalida set cantidad=?, idCliente=? where id =?");
            eliminarSalida = conn.prepareStatement("delete from tblSalida where id=?");
            mostrarSalida = conn.prepareStatement("select* from tblSalida ");
        }catch(SQLException ex){
            System.out.println(ex.toString());
            
        }
        listaSalida = listarRegistro();
    }

    private ArrayList<Salida> listarRegistro() {
        ArrayList <Salida> result = null;
        ResultSet rs = null;
        try{
           result = new ArrayList();
           rs = mostrarSalida.executeQuery();
           while(rs.next()){
               result.add(new Salida(
                       rs.getInt("id"),
                       rs.getDate("fecha"),
                       cliente.obtenerCliente(rs.getInt("idCliente")),
                       p.obtenerProducto(rs.getString("cbProducto")),
                       rs.getInt("cantidad"),
                       user.obtenerUsuario(rs.getInt("idUsuario")),
                       1
                       
                       
               
               ));
           }
           
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return result;
        
    }
         
    /**
     * Retorna DefaultaTableModel con todos los datos de "Salida" de productos
     * @return DefaultTableModel 
     */
    public DefaultTableModel tablaSalida(){
        DefaultTableModel tblModelo = new DefaultTableModel();
          try{
            String titulo [] ={
                "id",
                "Fecha",
                "Cliente",
                "Producto",
                "cantidad",
                "usuario"
              
            };
            tblModelo.setColumnIdentifiers(titulo);
            
            Object datos [] = new Object[6];
            
            for(Salida i: listaSalida){
              
                  
                  datos[0]= i.getId();
                  datos[1]= i.getFecha().toString();
                  datos[2]= i.getCliente().getNombre();
                  datos[3]= i.getProducto().getNombre();
                  datos[4]= i.getCantidad();
                  datos[5]= i.getUsuario().getNombre();
                  
                          
                  
                  tblModelo.addRow(datos);
              
                
            }
  
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return tblModelo;
    }
    
    /**
     * Retorna la cantidad que se movio de un producto
     * segun su ID de salida
     * @param id
     * @return int
     */
    public int obtenerCantidadSalida(int id){
        int cantidad =0;
        try{
            for (Salida i: listaSalida){
                if(i.getId()==id){
                    cantidad=i.getCantidad();
                    return cantidad;
                }
            }
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        return cantidad;
    }
    
    /**
     * Retorna un producto de una "Salida"
     * @param id
     * @return Producto
     */
    public Producto obtenerProducto(int id){
        Producto p= null;
        try{
            for (Salida i: listaSalida){
                if(i.getId()==id){
                    p=i.getProducto();
                    return p;
                }
            }
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        return p;
    }
    
    /**
     * Agregar salida al arraylist.
     * @param fecha
     * @param cliente
     * @param producto
     * @param cantidad
     * @param usuario
     * @return int
     * 1 = Satisfactorio.
     * 0 = Error
     */
    public int agregarSalida (java.sql.Date fecha, Cliente cliente, Producto producto, int cantidad, Usuario usuario){
        int b = 0;
        try{
            listaSalida.add(new Salida(
                    fecha,
                    cliente,
                    producto,
                    cantidad,
                    usuario,
                    4
            ));
            b=1;
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
    }
    
    /**
     * Edita una "Salida"
     * @param cantidad
     * @param idSalida
     * @return int
     * 1 = Satisfactorio.
     * 0 = Error
     */
    
    
    public int editarSalida(int cantidad, int idSalida){
        int b=0;
        try{
            for (Salida i :listaSalida){
                if(i.getId()==idSalida){
                    i.setCantidad(cantidad);
                    i.setEstado(2);
                    b=1;
                }
            }
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
    }
    /**
     * Elimina una salida
     * @param idSalida
     * @return int
     * 1 = Satisfactorio.
     * 0 = Error
     */
    public int eliminarSalida(int idSalida){
        int b= 0;
        try{
            for (Salida i: listaSalida){
                if(i.getId()==idSalida)
                i.setEstado(3);
                b=1;
            }
            
            
        }catch(Exception ex){
            System.out.println(ex.toString()); 
        }
        return b;
    }
    /**
     * Agregar una salida en la base de datos.
     * @param salida
     * @return int
     * 1 = Satisfactorio.
     * 0 = Error
     */
   public int insertarSalidaBD(Salida salida){
       int result=0;
       try{
           insertarSalida.setDate(1, (java.sql.Date) salida.getFecha());
           insertarSalida.setInt(2, salida.getCliente().getId());
           insertarSalida.setString(3, salida.getProducto().getCodigoBarra());
           insertarSalida.setInt(4, salida.getCantidad());
           insertarSalida.setInt(5, salida.getUsuario().getId());
           
           
           
           result = insertarSalida.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.toString());
           conexion.close(conn);
       }
       return result;
   }
   /**
    * Edita una salida en la base de datos 
    * @param salida
    * @return int 
    * 1 = Satisfactorio.
    * 0 = Error
    */
   public int editarSalidaBD(Salida salida){
       int result =0;
       try{
          
           editarSalida.setInt(1, salida.getCantidad());
           editarSalida.setInt(2, salida.getId());
           
           result = editarSalida.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.toString());
           conexion.close(conn);
       }
       return result;
   }
   /**
    * Elimina una salida de la base de datos.
    * @param salida
    * @return int
    * 1 = Satisfactorio.
    * 0 = Error
    */
   
   public int eliminarSalidaBD(Salida salida){
       int result = 0;
       try{
           eliminarSalida.setInt(1, salida.getId());
           
           result = eliminarSalida.executeUpdate();
           
       }catch(SQLException ex){
           System.out.println(ex.toString());
           conexion.close(conn);
       }
       return result;
       
   }
   /**
    * Actualiza BD
    * @return String
    * retorna mensaje sobre exito o errores en el proceso de
    * actualizar BD
    */
   
   public String actualizarBD(){
       String msn="----Salidas----\n";
       String msnError = "Errores en :";
       int nuevos = 0, modificados = 0, eliminados = 0;
       int errorNuevos = 0, errorModificados = 0, errorEliminados = 0;
       for (Salida salida:listaSalida){
           switch(salida.getEstado()){
               case 1:
                   //no hace nada
                   break;
               case 2:
                   //estado modificado
                   if(this.editarSalidaBD(salida)!=0){
                       modificados++;
                   }else{
                       errorModificados++;
                       msnError+="\n -Error al modificar "+salida.getId();
                   }
                   break;
               case 3:
                   if(this.eliminarSalidaBD(salida)!=0){
                       eliminados++;
                   }else{
                       errorEliminados++;
                       msnError +="\n -Error al eliminar"+salida.getId();
                   }
                   break;
               case 4:
                   if(this.insertarSalidaBD(salida)!=0){
                       nuevos++;
                       
                   }else{
                       errorNuevos++;
                       msnError +="\n Error al agregar"+salida.getId();
                   }
                   break;
               default:
                   msnError+="\n Revise el registro: "+ salida.getId()
                           + " " + salida.getProducto().getNombre();
                   break;
           }
       }
       msn += "Registros guardados: " + nuevos + "\nRegistros editados: "+ modificados+
                "\nRegistros eliminados: " + eliminados;
       
        if (msnError.equals("Errores en: ")){
            msn+="\n";
        }else{
           msn+="\n"+ msnError;
       }
       listaSalida = listarRegistro();
       return msn;
   }
    
    
    
    
}