package principal;

import java.util.ArrayList;

import adapter.*;
import composite.*;

public class Facade {
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static ArrayList<Ruta> rutas = new ArrayList<Ruta>();
	private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	/*
	 * Metodo que retorna el tipo de usuario.
	 *  Retorna 0 si no existe, 1 si es pasajero y dos si es conductor
	*/
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
		Ruta ruta = new Ruta(nombreRuta, documentoConductor);
		ruta.setComponentes(calles);
		rutas.add(ruta);
	}

	//Robinson
	public String listarRutasConductor(int documento) {
		String infoRutas = "No se encontraron las rutas para el documento "+ documento;
		String info = "";
		for(int i=0; i < rutas.size(); i++) {
			if(rutas.get(i).getDocumentoConductor() == documento) {
				info += (i++) + rutas.get(i).obtenerDatos()+"\n\n";
			}
		}
		return (info.isEmpty() ? infoRutas: info);
	}

	public void actualizarRuta(String nombreRutaModificar, String nombreRutaNuevo, ArrayList<Componente> callesModificadas, int documentoConductor) {
		int position = 0;
		for(Ruta ru: rutas) {
			if(ru.getNombre().equals(nombreRutaModificar)) {
				Ruta rutaNueva = new Ruta(nombreRutaNuevo, documentoConductor);
				rutaNueva.setComponentes(callesModificadas);
				rutas.set(position, rutaNueva);
			}
			position++;
		}
	}

	public void eliminarRuta(int indice, int documentoConductor) {
		// Antes mostrarle lista y decirle cual quiere eliminar desde 1 y pasar el indice
		if(rutas.get(indice).getDocumentoConductor() == documentoConductor) {
			rutas.remove(indice);
		}

	}

	//Robinson
	public void crearRegistroReserva(String nombreReserva, String lugarOrigen, String lugarDestino, String nombreRutaReservada, String puestoRutaReservada, int documentoPasajero) {

	}

	public String listarReservasPasajero(int documentoPasajero) {
		String lista = "";
		for(Reserva re: reservas) {
			if(re.getDocumentoPasajero() == documentoPasajero) {
				lista += "Nombre reserva: " + re.getNombreReserva() 
					+  "Nombre ruta reservada: " +re.getNombreRutaReservada()
					+ ". Puesto reservado: " + re.getPuestoAReservar()
					+ ". Lugar origen: " + re.getLugarOrigen()
					+ ". Luger destino: " + re.getLugarDestino() + "\n";
			}
		}
		return lista;
	}

	//Robinson
	public void modificarReservaPasajero(String nombreReservaModificar, String lugarOrigenModificado, String lugarDestinoModificado, String nombreRutaReservadaModificado, String puestoRutaReservadaModificado, int documentoPasajero) {
		//NO SE DEBE MODIFICAR NOMBRE DE RESERVA
	}

	public void eliminarReserva(String nombreReservaEliminar, int documentoPasajero) {
		for(Reserva re: reservas) {
			if(re.getDocumentoPasajero() == documentoPasajero && re.getNombreReserva() == nombreReservaEliminar) {
				reservas.remove(re);
			}
		}
	}

	public void registrarPasajero(String nombre, int documento, String correo, String contrasena) {
		usuarios.add(new Pasajero(nombre, correo, contrasena, documento));
	}

	public void modificarPasajero(String nombre, int documento, String correo, String contrasena) {
		int position = 0;
		for(Usuario us: usuarios) {
			if(us.getDocumento() == documento) {
				usuarios.set(position, new Pasajero(nombre, correo, contrasena, documento));
			}
			position++;
		}
	}

	public void eliminarUsuario(int documento) {
		for(Usuario us: usuarios) {
			if(us.getDocumento() == documento) {
				usuarios.remove(us);
			}
		}
	}
	
	public void registrarConductor(String nombre, int documento, String correo, String contrasena) {
		usuarios.add(new Conductor(nombre, correo, contrasena, documento));
	}

	public void modificarConductor(String nombre, int documento, String correo, String contrasena) {
		int position = 0;
		for(Usuario us: usuarios) {
			if(us.getDocumento() == documento) {
				usuarios.set(position, new Conductor(nombre, correo, contrasena, documento));
			}
			position++;
		}
	}
	
	public void registrarAdministrador(String nombre, int documento, String correo, String contrasena) {
		usuarios.add(new AdministradorAdapter(nombre, correo, contrasena, documento));
	}

	public void modificarAdministrador(String nombre, int documento, String correo, String contrasena) {
		int position = 0;
		for(Usuario us: usuarios) {
			if(us.getDocumento() == documento) {
				usuarios.set(position, new AdministradorAdapter(nombre, correo, contrasena, documento));
			}
			position++;
		}
	}

}
