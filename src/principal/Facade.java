package principal;
import java.util.ArrayList;

import adapter.*;
import composite.*;

public class Facade {
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	private static ArrayList<Ruta> rutas = new ArrayList<>();
	
	public int verificarUsuario(String correo, String pass)
	{	
		int tipoPasajero = 0;
		for(Usuario us: usuarios) {
			if(us.getCorreo().equals(correo) && us.getContrasena().equals(pass)) {
				//index = usuarios.indexOf(us);
				tipoPasajero = obtenerTipo(us);
			}else {
				tipoPasajero = 0;
			}
		}
		return tipoPasajero;
	}
	
	private int obtenerTipo(Usuario us)
	{
		int tipoUsu = 0;
		if(us instanceof Pasajero) {
			tipoUsu = 1;
		}else if (us instanceof Conductor){
			tipoUsu = 2;
		}
		return tipoUsu;
	}
	
	public void crearRegistroRuta(String nombre)
	{
		
	}
	
	public void listarRutasConductor()
	{
		
	}
	
	public void actualizarRuta() 
	{
		
	}
	
	public void eliminarRuta()
	{
		
	}

	public void crearRegistroReserva()
	{
		
	}
	public void listarReservasPasajero()
	{
		
	}
	public void modificarReservaPasajero()
	{
		
	}
	public void eliminarReserva()
	{
		
	}
	
	
}
