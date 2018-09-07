/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitectura;

import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public abstract class Usuario {

    private String nombre;
    private String correo;
    private String contraseña;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public Usuario() {
    }
    
    public Usuario(String nombre, String usuario, String contraseña) {
        this.nombre = nombre;
        this.correo = usuario;
        this.contraseña = contraseña;
    }

    
    
    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    };
    public void modificar(Usuario usuario, String correo) {
        for (Usuario us: usuarios) {
            if(us.correo.equals(correo)) {
                usuarios.remove(us);
            }
            usuarios.add(usuario);
        }
    };
    public void mostrarUsuarios() {
        usuarios.forEach((us) -> {
            System.out.println(us);
        });
    };
    abstract public void consultar();
    abstract public void eliminar(String correo);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Usuario.usuarios = usuarios;
    }
   
    
    
}


