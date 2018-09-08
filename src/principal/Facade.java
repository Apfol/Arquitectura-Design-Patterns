package principal;

import java.util.ArrayList;

import adapter.*;
import composite.*;

public class Facade {
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	private static ArrayList<Ruta> rutas = new ArrayList<>();

	public int verificarUsuario(String correo, String pass) {
		int tipoPasajero = 0;
		for (Usuario us : usuarios) {
			if (us.getCorreo().equals(correo) && us.getContrasena().equals(pass)) {
				// index = usuarios.indexOf(us);
				tipoPasajero = obtenerTipo(us);
			} else {
				tipoPasajero = 0;
			}
		}
		return tipoPasajero;
	}

	private int obtenerTipo(Usuario us) {
		int tipoUsu = 0;
		if (us instanceof Pasajero) {
			tipoUsu = 1;
		} else if (us instanceof Conductor) {
			tipoUsu = 2;
		}
		return tipoUsu;
	}
	
	public Usuario obtenerUsuario(String correo, String pass) {
		for (Usuario us : usuarios) {
			if (us.getCorreo().equals(correo) && us.getContrasena().equals(pass)) {
				return us;
			}
		}
		return null;
	}

	public void crearRegistroRuta(String nombreRuta, ArrayList<Componente> calles, int documentoConductor) {
		// TODO Auto-generated method stub
	}

	public String listarRutasConductor(int documento) {
		return "";
	}

	public void actualizarRuta(String nombreRutaModificar, String nombreRutaNuevo, ArrayList<Componente> callesModificadas, int documentoConductor) {

	}

	public void eliminarRuta(String nombreRutaEliminar, int documentoConductor) {

	}

	public void crearRegistroReserva() {

	}

	public void listarReservasPasajero() {

	}

	public void modificarReservaPasajero() {

	}

	public void eliminarReserva() {

	}

}
