/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;
import fly_weight.IFlyWeight;

public abstract class Usuario implements IFlyWeight{

    private String nombre;
    private String correo;
    private String password;
    private String documento;
    //private static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public Usuario() {
    }
    
    public Usuario(String nombre, String correo, String contrasena, String documento) {
        this.nombre = nombre;
        this.correo = correo;
        this.password= contrasena;
        this.documento = documento;
    }

    
    
    public void adicionar(String nombre, String correo, String contrasena, String documento) {
    	this.nombre = nombre;
        this.correo = correo;
        this.password= contrasena;
        this.documento = documento;
    };
    
    public void modificar(String nombre, String correo, String contrasena, String documento) {
    	this.nombre = nombre;
        this.correo = correo;
        this.password= contrasena;
        this.documento = documento;
    };
    
    abstract public void consultar();
    abstract public void eliminar();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return password;
    }

    public void setContrasena(String contrasena) {
        this.password = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
   
  
}


