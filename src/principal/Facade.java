package principal;
import java.util.ArrayList;

import adapter.*;

public class Facade {
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	public boolean verificarUsuario(String correo, String pass)
	{
		boolean existe = false;
		for(Usuario us: usuarios) {
			if(us.getCorreo().equals(correo) && us.getContrasena().equals(pass)) {
				existe = true;
			}
		}
		
		return existe;
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
