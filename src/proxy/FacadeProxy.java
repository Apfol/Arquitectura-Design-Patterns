package proxy;

import java.util.ArrayList;
import java.util.HashMap;

import adapter.Usuario;
import facade.Facade;
import j_unit.User;

public class FacadeProxy implements IFacade {
	
	private static FacadeProxy mFacadeProxy;
	private Facade facade;
	public static ArrayList<UsuarioLogin> usuarios = new ArrayList<UsuarioLogin>();
	private HashMap<String, User> users = new HashMap<String, User>();
	
	private FacadeProxy() {}
	
	public static FacadeProxy getFacadeProxyInstance() {
		if(mFacadeProxy == null) {
			mFacadeProxy = new FacadeProxy();
		}
		return mFacadeProxy;
	}


	@Override
	public String realizarOperaciones(String correo, String password, String tipoInstancia) {
		
		for(UsuarioLogin usLogin: usuarios) {
			if (correo.equals(usLogin.getCorreo()) && password.equals(usLogin.getPassword())) {
				facade = Facade.getFacadeInstance();
				return facade.realizarOperaciones(usLogin.getCorreo(), usLogin.getPassword(), usLogin.getTipoInstancia());
			}
		}
		return "Acceso no permitido";
	}

	

	public void adicionar(String st, User us) {
		users.put(st, us);
	}
	
	public User buscar(String key) {
		return users.get(key);
	}
	
	public boolean actualizar(String key, User u) {
		User resultado = null;
		resultado = users.get(key);
		if(resultado == null) {
			return false;
		} else {
			users.put(key, u);
			return true;
		}
	}
	
	public void eliminar(String key) {
		users.remove(key);
	}

	public static ArrayList<UsuarioLogin> getUsuarios() {
		return usuarios;
	}


	public static void setUsuarios(ArrayList<UsuarioLogin> usuarios) {
		FacadeProxy.usuarios = usuarios;
	}
	
	

}
