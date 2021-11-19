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
import modelado.Usuario;

/**
 *
 * @author Noel
 */
public class DUsuario {
    private Connection conn;
    private final Conexion conexion = new Conexion();
    private PreparedStatement insertarUsuario;
    private PreparedStatement editarUsuario;
    private PreparedStatement eliminarUsuario;
    private PreparedStatement mostrarUsuario;
    private static ArrayList <Usuario> listaUsuario= new ArrayList();

    public DUsuario() {
        try{
            conn = conexion.obtenerConexion();
            
            insertarUsuario = conn.prepareStatement("insert into tblUsuario"
                    + "(nombre, nombreUsuario, contraseña, privilegio) "
                    + "values (?,?,?,?)");
            editarUsuario = conn.prepareStatement("Update tblUsuario set "
                    + "nombre =?, "
                    + "nombreUsuario =?, "
                    + "contraseña =?, "
                    + "privilegio =? "
                    + "where id = ? ");
            eliminarUsuario = conn.prepareStatement("delete from tblUsuario where id =?");
            
            mostrarUsuario = conn.prepareStatement("select * from tblUsuario");
            
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        listaUsuario = listarRegistro();
        
    }
    public ArrayList<Usuario> listarRegistro(){
        ArrayList <Usuario> result = null;
        ResultSet rs = null;
        try{
            rs = mostrarUsuario.executeQuery();
            result = new ArrayList();
            while(rs.next()){
                result.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("nombreUsuario"),
                        rs.getString("contraseña"),
                        rs.getString("privilegio"),
                        1
                ));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            conexion.close(conn);
        }
        return result;
    }
    public int autenticarUsuario(String username, String contraseña){
        int b=0;
        try{
            
            for(Usuario i: listaUsuario){
              if(i.getNombreUsuario().equals(username) && i.getContraseña().equals(contraseña)){
                  return 1;
              }
              
            }

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
}
    public String informacionUsuario (){
        String msm="----USUARIOS---";
        for(Usuario i:listaUsuario){
            msm+=i.getId()+"\n";
            msm+=i.getNombre()+"\n";
            msm+=i.getNombreUsuario()+"\n";
            msm+=i.getContraseña()+"\n";
        }
        
        return msm;
    }
    
    public Usuario obtenerUsuario(int usuario){
        Usuario i= null;
        try{
            for(Usuario u: listaUsuario){
                if(u.getId()==usuario){
                    i=u;
                    return i;
                }
            }
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return i;
    }
    
    public Usuario obtenerUsuarioUsername(String username){
        Usuario i= null;
        try{
            for(Usuario u: listaUsuario){
                if(u.getNombreUsuario().equals(username)){
                    i=u;
                    return i;
                }
            }
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return i;
    }
    
    
    
    public int agregarUsuario(String nombre, String nombreUsuario, String contraseña, String privilegio){
        int b=0;
        try{
            listaUsuario.add(new Usuario(
                    nombre,
                    nombreUsuario,
                    contraseña,
                    privilegio,
                    4
            ));
            b=1;
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
    }
    
      public int editarUsuario(String nombre, String nombreUsuario, String contraseña, String privilegio){
        int b=0;
        try{
            for (Usuario i: listaUsuario){
                if(i.getNombreUsuario().equals(nombreUsuario)){
                    i.setNombre(nombre);
                    i.setNombreUsuario(nombreUsuario);
                    i.setContraseña(contraseña);
                    i.setPrivilegio(privilegio);
                    i.setEstado(2);
                }
            }
            b=1;        
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
    }
    
      public int eliminarUsuario(int id){
        int b=0;
        try{
            for(Usuario i : listaUsuario){
                if(i.getId()== id){
                    i.setEstado(3);
                }
            }
            b=1;
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return b;
    }
      
    public int agregarUsuarioBD(Usuario usuario){
        int result =0;
        try{
            insertarUsuario.setString(1, usuario.getNombre());
            insertarUsuario.setString(2, usuario.getNombreUsuario());
            insertarUsuario.setString(3, usuario.getContraseña());
            insertarUsuario.setString(4, usuario.getPrivilegio());
            
            result = insertarUsuario.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            conexion.close(conn);
        }
        return result;
    }
    
    public int eliminarUsuarioBD(Usuario usuario){
        int result =0;
        try{
            eliminarUsuario.setInt(1, usuario.getId());
            
            result = eliminarUsuario.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            conexion.close(conn);
        }
        return result;
    }
    
    public int editarUsuarioBD(Usuario usuario){
        int result =0;
        try{
            editarUsuario.setString(1, usuario.getNombre());
            editarUsuario.setString(2, usuario.getNombreUsuario());
            editarUsuario.setString(3, usuario.getContraseña());
            editarUsuario.setString(4, usuario.getPrivilegio());
            editarUsuario.setInt(5, usuario.getId());
            
            result = editarUsuario.executeUpdate();
            
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
       for (Usuario usuario:listaUsuario){
           switch(usuario.getEstado()){
               case 1:
                   //no hace nada
                   break;
               case 2:
                   //estado modificado
                   if(this.editarUsuarioBD(usuario)!=0){
                       modificados++;
                   }else{
                       errorModificados++;
                       msnError+="\n -Error al modificar "+usuario.getNombreUsuario();
                   }
                   break;
               case 3:
                   if(this.eliminarUsuarioBD(usuario)!=0){
                       eliminados++;
                   }else{
                       errorEliminados++;
                       msnError +="\n -Error al eliminar"+usuario.getNombreUsuario();
                   }
                   break;
               case 4:
                   if(this.agregarUsuarioBD(usuario)!=0){
                       nuevos++;
                       
                   }else{
                       errorNuevos++;
                       msnError +="\n Error al agregar"+usuario.getNombreUsuario();
                   }
               default:
                   msnError+="\n Revise el registro: "+ usuario.getNombreUsuario();
                   break;
           }
       }
       msn = "Registros guardados: " + nuevos + "\nRegistros editados: "+ modificados+
                "\nRegistros eliminados: " + eliminados;
       
       if (!msnError.equals("Errores en: ")){
            msn+="\n"+ msnError;
        } 
       listaUsuario = listarRegistro();
       return msn;
       
   }
      
    
    
    
    
    
    
}
