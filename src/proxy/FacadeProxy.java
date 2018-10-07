package proxy;

import java.util.ArrayList;

import facade.Facade;

public class FacadeProxy implements IFacade {
	
	private static FacadeProxy mFacadeProxy;
	private Facade facade;
	public static ArrayList<UsuarioLogin> usuarios = new ArrayList<UsuarioLogin>();
	
	private FacadeProxy() {}
	
	public static FacadeProxy getInstance() {
		if(mFacadeProxy == null) {
			mFacadeProxy = new FacadeProxy();
		}
		return mFacadeProxy;
	}


	@Override
	public Long realizarOperaciones(String correo, String password) {
		for(UsuarioLogin usLogin: usuarios) {
			if (correo.equals(usLogin.getCorreo()) && password.equals(usLogin.getPassword())) {
				facade = Facade.getInstance();
				return facade.realizarOperaciones(usLogin.getCorreo(), usLogin.getPassword());
			}
		}
		return (long) 0;
	}


	public static ArrayList<UsuarioLogin> getUsuarios() {
		return usuarios;
	}


	public static void setUsuarios(ArrayList<UsuarioLogin> usuarios) {
		FacadeProxy.usuarios = usuarios;
	}
	
	

}
