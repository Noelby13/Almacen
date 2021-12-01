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
import modelado.Cliente;

/**
 *
 * @author Noel
 */
public class DCliente {
    private Connection conn;
    private final Conexion conexion = new Conexion();
    private PreparedStatement insertarCliente;
    private PreparedStatement editarCliente;
    private PreparedStatement eliminarCliente;
    private PreparedStatement mostrarCliente;
    private static ArrayList <Cliente> listaCliente = new ArrayList();

    public DCliente() {
        try{
            conn = conexion.obtenerConexion();
            
            insertarCliente = conn.prepareStatement("insert into tblCliente(nombre, ruc) values(?,?)");
            editarCliente = conn.prepareStatement("Update tblCliente set nombre =?, ruc =? where id =?");
            eliminarCliente = conn.prepareStatement("delete from tblCliente where id = ?");
            mostrarCliente = conn.prepareStatement("select * from tblCliente");
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        listaCliente = listarRegistro();
    }
    
    public ArrayList<Cliente> listarRegistro(){
        ArrayList <Cliente> result = null;
        ResultSet rs = null;
        try{
            result = new ArrayList();
            rs = mostrarCliente.executeQuery();
            while(rs.next()){
                result.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ruc"),
                        1
                ));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            conexion.close(conn);
        }
        return result;
    }
    
    
    /**
     * Realiza busqueda de un cliente en el arraylist
     * @param idUsuario
     * @return cliente
     */

    public Cliente obtenerCliente(int idUsuario){
        Cliente i= null;
        try{
            for(Cliente u: listaCliente){
                if(u.getId()==(idUsuario)){
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
     * Retorna TableModel con la informacion de los clientes.
     * @return DefaultTableModel
     * 
     */
    
    public DefaultTableModel tablaClienteMovimiento(){
        DefaultTableModel tblModelo = new DefaultTableModel();
        
          try{
            String titulo [] ={
                "id",
                "Nombre",
                "RUC"
              
            };
            tblModelo.setColumnIdentifiers(titulo);
            
            Object datos [] = new Object[3];
            
            for(Cliente i: listaCliente){
              
                  
                  datos[0]= i.getId();
                  datos[1]= i.getNombre();
                  datos[2]= i.getRuc();
                  
                  tblModelo.addRow(datos);
              
                
            }
  
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return tblModelo;
    }
    /**
     * agrega cliente
     * @param nombre
     * @param ruc
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
    public int agregarCliente(String nombre, String ruc){
        int b=0;
        try{
            listaCliente.add(new Cliente(
                    nombre,
                    ruc,
                    4
            ));
            b=1;
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
    }
    
    /**
     * edita cliente del arraylist
     * @param nombre
     * @param ruc
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
    
    public int editarCliente(String nombre, String ruc){
        int b=0;
        try{
            for(Cliente i: listaCliente){
                if(i.getRuc().equals(ruc)){
                    i.setNombre(nombre);
                    i.setEstado(2);
                }
            }
            b=1;

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
    }
    
    /**
     * Elimina cliente 
     * @param id
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
    
    public int eliminarCliente(int id){
        int b=0;
        try{
            for(Cliente i: listaCliente){
                if(i.getId()==id){
                    i.setEstado(3);
                }
            }
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
    }
    /**
     * Elimina un cliente de la base de datos.
     * @param cliente
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
    public int eliminarClienteBD(Cliente cliente){
        int result =0;
        try{
            eliminarCliente.setInt(1, cliente.getId());
            
            result = eliminarCliente.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            conexion.close(conn);
        }
        return result;
    }
    
    /**
     * Agrega un cliente a la base de datos
     * @param cliente
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
    
    public int agregarClienteBD(Cliente cliente){
        int result =0;
        try{
            insertarCliente.setString(1, cliente.getNombre());
            insertarCliente.setString(2, cliente.getRuc());
            
            
            result = insertarCliente.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            conexion.close(conn);
        }
        return result;
    }
    /**
     * editar cliente en la base de datos 
     * @param cliente
     * @return int
     * 0 = error al agregar
     * 1= Exito al agregar
     */
      
    public int editarClienteBD(Cliente cliente){
        int result =0;
        try{
            editarCliente.setString(1, cliente.getNombre());
            editarCliente.setString(2, cliente.getRuc());
            editarCliente.setInt(3, cliente.getId());
            
            
            result = editarCliente.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            conexion.close(conn);
        }
        return result;
    }
    /**
    * Actualiza base de datos 
    * @return String
    * Retorna informacion de datos y errores actualizados.
    */
     public String actualizarBD(){
       String msn="----Clientes----\n";
       String msnError = "Errores en :";
       int nuevos = 0, modificados = 0, eliminados = 0;
       int errorNuevos = 0, errorModificados = 0, errorEliminados = 0;
       for (Cliente cliente:listaCliente){
           switch(cliente.getEstado()){
               case 1:
                   //no hace nada
                   break;
               case 2:
                   //estado modificado
                   if(this.editarClienteBD(cliente)!=0){
                       modificados++;
                   }else{
                       errorModificados++;
                       msnError+="\n -Error al modificar "+cliente.getNombre();
                   }
                   break;
               case 3:
                   if(this.eliminarClienteBD(cliente)!=0){
                       eliminados++;
                   }else{
                       errorEliminados++;
                       msnError +="\n -Error al eliminar"+cliente.getNombre();
                   }
                   break;
               case 4:
                   if(this.agregarClienteBD(cliente)!=0){
                       nuevos++;
                       
                   }else{
                       errorNuevos++;
                       msnError +="\n Error al agregar"+cliente.getNombre();
                   }
                   break;
               default:
                   msnError+="\n Revise el registro: "+ cliente.getNombre()
                           + " " + cliente.getRuc();
                   break;
           }
       }
       msn += "Clients guardados: " + nuevos + "\nClientes editados: "+ modificados+
                "\nClientes eliminados: " + eliminados;
       
        if (msnError.equals("Errores en: ")){
            msn+="\n";
        }else{
           msn+="\n"+ msnError;
       }
       listaCliente = listarRegistro();
       return msn;
   }
    
    
    
}
