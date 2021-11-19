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
import modelado.Entrada;
import modelado.Producto;
import modelado.Usuario;

/**
 *
 * @author Noel
 */
public class DEntrada {
    private Connection conn;
    private final Conexion conexion = new Conexion();
    private PreparedStatement insertarEntrada;
    private PreparedStatement editarEntrada;
    private PreparedStatement eliminarEntrada;
    private PreparedStatement mostrarEntrada;
    private static ArrayList <Entrada> listaEntrada = new ArrayList();
    DProducto p = new DProducto();
    DUsuario user = new DUsuario();

    public DEntrada() {
        try{
            conn = conexion.obtenerConexion();
            
            insertarEntrada = conn.prepareStatement("insert into tblEntrada(fecha,cbProducto,cantidad,idUsuario) values(?,?,?,?)");
            editarEntrada = conn.prepareStatement("update tblEntrada set cantidad=?, where id =?");
            eliminarEntrada = conn.prepareStatement("delete from tblEntrada where id=?");
            mostrarEntrada = conn.prepareStatement("select* from tblEntrada ");
        }catch(SQLException ex){
            System.out.println(ex.toString());
            
        }
        listaEntrada = listarRegistro();
    }

    private ArrayList<Entrada> listarRegistro() {
        ArrayList <Entrada> result = null;
        ResultSet rs = null;
        try{
           result = new ArrayList();
           rs = mostrarEntrada.executeQuery();
           while(rs.next()){
               result.add(new Entrada(
                       rs.getInt("id"),
                       rs.getDate("fecha"),
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
        //tabla que manda al panel reporte cuando se seleciona inventario 
    public DefaultTableModel tablaEntrada(){
        DefaultTableModel tblModelo = new DefaultTableModel();
          try{
            String titulo [] ={
                "id",
                "Fecha",
                "Nombre",
                "cantidad",
                "Usuario"
              
            };
            tblModelo.setColumnIdentifiers(titulo);
            
            Object datos [] = new Object[5];
            
            for(Entrada i: listaEntrada){
              
                  
                  datos[0]= i.getId();
                  datos[1]= i.getFecha();
                  datos[2]= i.getProducto().getNombre();
                  datos[3]= i.getCantidad();
                  datos[4]= i.getUsuario().getNombreUsuario();
                  
                  tblModelo.addRow(datos);
              
                
            }
  
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return tblModelo;
    }
    
    public int agregarEntrada (java.sql.Date fecha, Producto producto, int cantidad, Usuario usuario){
        int b = 0;
        try{
            listaEntrada.add(new Entrada(
                    fecha,
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
    
    public int editarEntrada(int cantidad, int idEntrada){
        int b=0;
        try{
            for (Entrada i: listaEntrada){
                if(i.getId()==idEntrada){
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
    
    public int eliminarEntrada(int idEntrada){
        int b= 0;
        try{
            for (Entrada i: listaEntrada){
                if(i.getId()==idEntrada)
                i.setEstado(3);
                b=1;
            }
            
            
        }catch(Exception ex){
            System.out.println(ex.toString()); 
        }
        return b;
    }
    
   public int insertarEntradaBD(Entrada entrada){
       int result=0;
       try{
           insertarEntrada.setDate(1, entrada.getFecha());
           insertarEntrada.setString(2, entrada.getProducto().getCodigoBarra());
           insertarEntrada.setInt(3, entrada.getCantidad());
           insertarEntrada.setInt(4, entrada.getUsuario().getId());
           
           
           result = insertarEntrada.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.toString());
           conexion.close(conn);
       }
       return result;
   }
   
   public int editarEntradaBD(Entrada entrada){
       int result =0;
       try{
          
           editarEntrada.setInt(1, entrada.getCantidad());
           editarEntrada.setInt(3, entrada.getId());
           
           result = editarEntrada.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.toString());
           conexion.close(conn);
       }
       return result;
   }
   
   public int eliminarEntradaBD(Entrada entrada){
       int result = 0;
       try{
           eliminarEntrada.setInt(1, entrada.getId());
           
           result = eliminarEntrada.executeUpdate();
           
       }catch(SQLException ex){
           System.out.println(ex.toString());
           conexion.close(conn);
       }
       return result;
       
   }
   
   public String actualizarBD(){
       String msn="";
       String msnError = "Errores en :";
       int nuevos = 0, modificados = 0, eliminados = 0;
       int errorNuevos = 0, errorModificados = 0, errorEliminados = 0;
       for (Entrada entrada:listaEntrada){
           switch(entrada.getEstado()){
               case 1:
                   //no hace nada
                   break;
               case 2:
                   //estado modificado
                   if(this.editarEntradaBD(entrada)!=0){
                       modificados++;
                   }else{
                       errorModificados++;
                       msnError+="\n -Error al modificar "+entrada.getId();
                   }
                   break;
               case 3:
                   if(this.eliminarEntradaBD(entrada)!=0){
                       eliminados++;
                   }else{
                       errorEliminados++;
                       msnError +="\n -Error al eliminar"+entrada.getId();
                   }
                   break;
               case 4:
                   if(this.insertarEntradaBD(entrada)!=0){
                       nuevos++;
                       
                   }else{
                       errorNuevos++;
                       msnError +="\n Error al agregar"+entrada.getId();
                   }
               default:
                   msnError+="\n Revise el registro: "+ entrada.getId()
                           + " " + entrada.getProducto().getNombre();
                   break;
           }
       }
       msn = "Registros guardados: " + nuevos + "\nRegistros editados: "+ modificados+
                "\nRegistros eliminados: " + eliminados;
       
       if (!msnError.equals("Errores en: ")){
            msn+="\n"+ msnError;
        } 
       listaEntrada = listarRegistro();
       return msn;
   }
    
    
    
    
}
