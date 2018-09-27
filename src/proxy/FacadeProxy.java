package proxy;

import java.util.ArrayList;

import facade.Facade;

public class FacadeProxy implements IFacade {

	Facade facade;
	static ArrayList<UsuarioLogin> usuarios = new ArrayList<UsuarioLogin>();


	@Override
	public String realizarOperaciones(String correo, String password, String tipoInstancia) {
		
		for(UsuarioLogin usLogin: usuarios) {
			if (correo.equals(usLogin.getCorreo()) && password.equals(usLogin.getPassword())) {
				facade = new Facade();
				return facade.realizarOperaciones(usLogin.getCorreo(), usLogin.getPassword(), usLogin.getTipoInstancia());
			}
		}
		return "Acceso no permitido";
	}


	public static ArrayList<UsuarioLogin> getUsuarios() {
		return usuarios;
	}


	public static void setUsuarios(ArrayList<UsuarioLogin> usuarios) {
		FacadeProxy.usuarios = usuarios;
	}
	
	

}
