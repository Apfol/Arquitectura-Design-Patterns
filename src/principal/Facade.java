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
	
	public String obtenerUsuarios() {
		String info = "";
		for(Usuario us: usuarios) {
			info += us.toString() + "\n";
		}
		return info;
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

	public void eliminarRuta(String nombreRuta, int documentoConductor) {
		System.out.println("antes"+rutas.size());
		for(Ruta rut: rutas) {
			if(rut.getNombre().equals(nombreRuta) && rut.getDocumentoConductor() == documentoConductor) {
				System.out.println(rut);
				rutas.remove(rut);
			}
		}
		System.out.println("Desoues"+rutas.size());
		
	}

	//Robinson el nombre de la ruta es la relacion TOca cambiarla creo
	public void crearRegistroReserva(String nombreReserva, String lugarOrigen, String lugarDestino, String nombreRutaReservada, String puestoRutaReservada, int documentoPasajero) {
		Reserva reserv = new Reserva(nombreReserva, lugarOrigen, lugarDestino, puestoRutaReservada, nombreRutaReservada, documentoPasajero);
		reservas.add(reserv);
		System.out.println("Reserva añadida"+reserv.toString());
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
	
	public String listarReservasPas(int documentoPasajero) {
		String lista = "No se encontraron reservas para el pasajero "+documentoPasajero;
		String infoRes = "";
		for(int i=0; i < reservas.size(); i++) {
			if(reservas.get(i).getDocumentoPasajero() == documentoPasajero) {
				infoRes += (i++)+reservas.get(i).toString() + "\n";
			}
		}
		return (infoRes.isEmpty() ? lista: infoRes);
	}

	//Robinson
	public void modificarReservaPasajero(String nombreReservaModificar, String lugarOrigenModificado, 
											String lugarDestinoModificado, String nombreRutaReservadaModificado,
											String puestoRutaReservadaModificado, int documentoPasajero) {
		//NO SE DEBE MODIFICAR NOMBRE DE RESERVA
		for(Reserva res: reservas) {
			
			if(res.getNombreReserva().equals(nombreReservaModificar) && res.getDocumentoPasajero() == documentoPasajero) {
				System.out.println("Antes de modificar "+res.toString());
				res.setLugarOrigen((lugarOrigenModificado.isEmpty() ? res.getLugarOrigen() : lugarOrigenModificado));
				res.setLugarDestino((lugarDestinoModificado.isEmpty() ? res.getLugarDestino(): lugarDestinoModificado));
				res.setNombreRutaReservada((nombreRutaReservadaModificado.isEmpty() ? res.getNombreRutaReservada() : nombreRutaReservadaModificado));
				res.setPuestoAReservar((puestoRutaReservadaModificado.isEmpty() ? res.getPuestoAReservar() : puestoRutaReservadaModificado));
				//res.setDocumentoPasajero((documentoPasajero));
				System.out.println("nueva"+ res.toString());
			}
		}
		
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
	
	public void usuariosDummy() {
		usuarios.add(new Conductor("Jario lopez", "jairolo@unisabana.edu.co", "jario123", 1073525507));
		usuarios.add(new Conductor("Sara Bustos", "sarabu@unisabana.edu.co", "sara123", 1045676829));
		usuarios.add(new Pasajero("Ana Garcia", "anaga@unisabana.edu.co", "ana123", 1234567889));
		usuarios.add(new Pasajero("Juan Correa", "juanco@unisabana.edu.co", "juan123", 216654382));
		usuarios.add(new AdministradorAdapter("Jaime Contreras", "jaimeco@unisabana.edu.co", "jaime123", 106435678));
	}
	
	public void rutasDummy() {
		Componente c1 = new Calle("12.09.54", "14.23.64", "34.13.74", "345.26.42.5", "Calle 9", "9 mts");
        Componente c2 = new Calle("34.25.1", "64.26.32.6", "32.75.47", "36.32.1345", "Calle 57", "14 mts");
        Componente c3 = new Calle("52.63.7.2", "54.2.67.2", "3245.2.6.3", "32.1.5.3", "Calle 91", "16 mts");
        
        //Rutas de Jairo
        Ruta ruta1 = new Ruta("Ruta 1",1073525507);
        Ruta ruta2 = new Ruta("Ruta 2",1073525507);
        //Rutas de Sara
        Ruta ruta3 = new Ruta("Ruta 3",1045676829);
      
        ruta1.add(c1);
        ruta2.add(c2);
        ruta3.add(c3);
        
        rutas.add(ruta1);
        rutas.add(ruta2);
        rutas.add(ruta3);
	}
	
	public void reservasDummy() {
		//Reserva de Ana
		reservas.add(new Reserva("Reserva 124738", "Calle 7", "Unisabana", "Delantero", "Ruta 1", 1234567889));
		//Reserva de Juan
		reservas.add(new Reserva("Reserva 5243446", "Unisabana", "Avenida Caracas", "Tresero lado izquiero", "Ruta 3", 216654382));
	}
	

}
