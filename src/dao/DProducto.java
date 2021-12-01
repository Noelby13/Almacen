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
import javax.swing.table.DefaultTableModel;
import modelado.Producto;

/**
 *
 * @author Noel
 */
public class DProducto {

   
    private Connection conn;
    private final Conexion conexion = new Conexion();
    private PreparedStatement insertarProducto;
    private PreparedStatement editarProducto;
    private PreparedStatement eliminarProducto;
    private PreparedStatement mostrarProducto;
    private static  ArrayList<Producto> listaProducto = new ArrayList();

    public DProducto() {
        try{
            conn= conexion.obtenerConexion();
        
            insertarProducto = conn.prepareStatement("insert into tblProducto"
                    + "(codigoBarra,nombre,marca,lote,ubicacion,cantidad) "
                    + "values(?,?,?,?,?,?)");
            editarProducto = conn.prepareStatement("update tblProducto set "
                    + "nombre = ?, "
                    + "marca = ?, lote = ?, "
                    + "ubicacion = ?, cantidad = ? where codigoBarra = ?");
            
            eliminarProducto = conn.prepareStatement("delete from tblProducto where codigoBarra = ?");
            mostrarProducto = conn.prepareStatement("select * from tblProducto");
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            
        }
        listaProducto = listarRegistro();
        
        
    }
    private ArrayList <Producto> listarRegistro(){
        ArrayList <Producto>result = null;
        ResultSet rs = null;
        try{
            rs = mostrarProducto.executeQuery();
            result = new ArrayList();
            while(rs.next()){
                result.add(new Producto(
                        rs.getString("codigoBarra"),
                        rs.getString("nombre"),
                        rs.getString("marca"),
                        rs.getString("lote"),
                        rs.getString("ubicacion"),
                        rs.getInt("cantidad"),
                        1
                ));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            
        }finally{
             try{
                rs.close();
            }catch(SQLException ex){
                conexion.close(conn);
            }
        }
        return result;
    }
    //metodo que manda producto a DEntrada para obtener producto a la hora de recuperarlo ala base de datos
    /**Realiza busqueda de un producto en el arraylist 
     * 
     * @param codigoBarra
     * @return Producto
     */
    public Producto obtenerProducto(String codigoBarra){
        Producto i= null;
        try{
            for(Producto u: listaProducto){
                if(u.getCodigoBarra().equals(codigoBarra)){
                    i=u;
                    return i;
                }
            }
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return i;
    }
    
    /**
     * 
     * @return DefaultTableModel
     * Tabla con la informacion de los productos.
     */     
    public DefaultTableModel tablaInventario(){
        DefaultTableModel tblModelo = new DefaultTableModel();
          try{
            String titulo [] ={
                "Codigo",
                "Nombre",
                "Marca",
                "Cantidad",
                "Lote"    
              
            };
            tblModelo.setColumnIdentifiers(titulo);
            
            Object datos [] = new Object[5];
            
            for(Producto i: listaProducto){
              
                  datos[0]= i.getCodigoBarra();
                  datos[1]= i.getNombre();
                  datos[2]= i.getMarca();
                  datos[3]= i.getCantidad();
                  datos[4]= i.getLote();
                  
                  tblModelo.addRow(datos);
              
                
            }
  
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return tblModelo;
    }
            
            
    /**
     * Agrega un producto
     * @param codigoBarra
     * @param nombre
     * @param marca
     * @param lote
     * @param ubicacion
     * @param cantidad
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
    
    public int agregarProducto (String codigoBarra, String nombre, String marca, String lote, String ubicacion, int cantidad){
        int b = 0;
        try{
            listaProducto.add(new Producto(
                    codigoBarra,
                    nombre,
                    marca,
                    lote,
                    ubicacion,
                    cantidad,
                    4
            ));
            b=1;
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
    }
    /**
     * Edita un producto
     * @param codigoBarra
     * @param nombre
     * @param marca
     * @param lote
     * @param ubicacion
     * @param cantidad
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
    public int editarProducto(String codigoBarra, String nombre, String marca, String lote, String ubicacion, int cantidad){
        int b=0;
        try{
            for (Producto i: listaProducto){
                if(i.getCodigoBarra().equals(codigoBarra)){
                    i.setCantidad(cantidad);
                    i.setNombre(nombre);
                    i.setLote(lote);
                    i.setMarca(marca);
                    i.setUbicacion(ubicacion);
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
     * Edita un producto
     * @param producto
     * @param cantidad
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
    public int editarProducto(Producto producto,int cantidad){
        int b=0;
        int total =0;
        try{
            for (Producto i: listaProducto){
                if(i.getCodigoBarra().equalsIgnoreCase(producto.getCodigoBarra())){
                    total=i.getCantidad()+cantidad;
                    i.setCantidad(total);
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
     * Elimina un producto 
     * @param codigoBarra
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
    public int eliminarProducto(String codigoBarra){
        int b= 0;
        try{
            for (Producto i: listaProducto){
                if(i.getCodigoBarra().equals(codigoBarra)){
                    i.setEstado(3);
                    b=1;

                }
            }
            
            
        }catch(Exception ex){
            System.out.println(ex.toString()); 
        }
        return b;
    }
    /**
     * Agrega un producto a la base de datos
     * @param producto
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
   public int agregarProductoBD(Producto producto){
       int result=0;
       try{
           insertarProducto.setString(1, producto.getCodigoBarra());
           insertarProducto.setString(2, producto.getNombre());
           insertarProducto.setString(3, producto.getMarca());
           insertarProducto.setString(4, producto.getLote());
           insertarProducto.setString(5, producto.getUbicacion());
           insertarProducto.setInt(6, producto.getCantidad());
           
           result = insertarProducto.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.toString());
           conexion.close(conn);
       }
       return result;
   }
   /**
    * Edita un producto en la base de datos
    * @param producto
    * @return int
    * 0 = error al agregar
    *1= Exito al agregar
    */
   
   public int editarProductoBD(Producto producto){
       int result =0;
       try{
           editarProducto.setString(1, producto.getNombre());
           editarProducto.setString(2, producto.getMarca());
           editarProducto.setString(3, producto.getLote());
           editarProducto.setString(4, producto.getUbicacion());
           editarProducto.setInt(5, producto.getCantidad());
           editarProducto.setString(6, producto.getCodigoBarra());
           
           result = editarProducto.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.toString());
           conexion.close(conn);
       }
       return result;
   }
   /**
    * Elimina un producto de la base de datos 
    * @param producto
    * @return int
    * 0 = error al agregar
    * 1= Exito al agregar
    */
   public int eliminarProductoBD(Producto producto){
       int result = 0;
       try{
           eliminarProducto.setString(1, producto.getCodigoBarra());
           
           result = eliminarProducto.executeUpdate();
           
       }catch(SQLException ex){
           System.out.println(ex.toString());
           conexion.close(conn);
       }
       return result;
       
   }
   /**
    * Actualiza base de datos
    * @return String
    * retorna informacion sobre exito o errores durante la actualizacion 
    */
   public String actualizarBD(){
       String msn="----Inventario----\n";
       String msnError = "Errores en :";
       int nuevos = 0, modificados = 0, eliminados = 0;
       int errorNuevos = 0, errorModificados = 0, errorEliminados = 0;
       for (Producto producto:listaProducto){
           switch(producto.getEstado()){
               case 1:
                   //no hace nada
                   break;
               case 2:
                   //estado modificado
                   if(this.editarProductoBD(producto)!=0){
                       modificados++;
                   }else{
                       errorModificados++;
                       msnError+="\n -Error al modificar "+producto.getNombre();
                   }
                   break;
               case 3:
                   if(this.eliminarProductoBD(producto)!=0){
                       eliminados++;
                   }else{
                       errorEliminados++;
                       msnError +="\n -Error al eliminar"+producto.getNombre();
                   }
                   break;
               case 4:
                   if(this.agregarProductoBD(producto)!=0){
                       nuevos++;
                       
                   }else{
                       errorNuevos++;
                       msnError +="\n Error al agregar"+producto.getNombre();
                   }
                   break;
               default:
                   msnError+="\n Revise el registro: "+ producto.getNombre()
                           + " " + producto.getLote();
                   break;
           }
       }
       msn += "Productos guardados: " + nuevos + "\nProductos editados: "+ modificados+
                "\nProductos eliminados: " + eliminados;
       
        if (msnError.equals("Errores en: ")){
            msn+="\n";
        }else{
           msn+="\n"+ msnError;
       }
       listaProducto = listarRegistro();
       return msn;
   }
   
    public static ArrayList<Producto> getListaProducto() {
         return listaProducto;
     }
           
           
    
    
    
    
    
    
    
    
    
    
    
}
