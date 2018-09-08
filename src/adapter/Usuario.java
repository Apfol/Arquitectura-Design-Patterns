/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public abstract class Usuario {

    private String nombre;
    private String correo;
    private String contrasena;
    private int documento;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public Usuario() {
    }
    
    public Usuario(String nombre, String usuario, String contrasena, int documento) {
        this.nombre = nombre;
        this.correo = usuario;
        this.contrasena= contrasena;
        this.documento = documento;
    }

    
    
    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    };
    public void modificar(Usuario usuario, int documento) {
        for (Usuario us: usuarios) {
            if(us.documento == documento) {
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
    abstract public void eliminar(int documento);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Usuario.usuarios = usuarios;
    }
   
  
}


