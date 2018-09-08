/*
3e * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import adapter.AdministradorAdapter;
import adapter.Conductor;
import adapter.Pasajero;
import adapter.Usuario;
import composite.Calle;
import composite.Componente;
import composite.Ruta;

/**
 *
 * @author AndrÃ©s
 */
public class Arquitectura {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		String nombre;
		String correo;
		String contrasena;
		int documento;
		int opcion = 0;

		Facade facade = new Facade();

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"" + "Seleccione la opción: \n" + "1. Registrar usuario \n" + "2. Modificar usuario \n"
							+ "3. Eliminar usuario \n" + "4. Acceder al sistema \n" + "0. Salir"));
			switch (opcion) {
			case 1:
				nombre = JOptionPane.showInputDialog("Introducir nombre");
				documento = Integer.parseInt(JOptionPane.showInputDialog("Introducir documento"));
				correo = JOptionPane.showInputDialog("Introducir correo");
				contrasena = JOptionPane.showInputDialog("Introducir contraseÃ±a");
				facade.registrarUsuario(nombre, documento, correo, contrasena);
				break;
			case 2:
				documento = Integer
						.parseInt(JOptionPane.showInputDialog("Introduce el documento del usuario a modificar"));
				correo = JOptionPane.showInputDialog("Introducir correo");
				nombre = JOptionPane.showInputDialog("Introducir nombre");
				contrasena = JOptionPane.showInputDialog("Introducir contraseña");
				facade.modificarUsuario(nombre, documento, correo, contrasena);
				break;
			case 3:
				documento = Integer
						.parseInt(JOptionPane.showInputDialog("Introduce el documento del usuario a eliminar"));
				facade.eliminarUsuario(documento);
				break;
			case 4:
				correo = JOptionPane.showInputDialog("Introducir correo");
				contrasena = JOptionPane.showInputDialog("Introducir contrasena");
				Usuario usuario = facade.obtenerUsuario(correo, contrasena);
				int tipoUsuario = facade.verificarUsuario(correo, contrasena);
				switch (tipoUsuario) {
				case 1:
					// Pasajero
					opcion = Integer.parseInt(
							JOptionPane.showInputDialog("" + "1. Crear registro de reserva \n" + "2. Listar reservas \n"
									+ "3. Modificar reserva \n" + "4. Eliminar reserva \n" + "0. salir \n"));
					switch (opcion) {
					case 1:
						// Crear registro reserva
						String nombreReserva = "Reserva " + usuario.hashCode();
						String lugarOrigen = JOptionPane.showInputDialog("Introducir lugar origen");
						String lugarDestino = JOptionPane.showInputDialog("Introducir lugar destino");
						String nombreRutaReservada = JOptionPane
								.showInputDialog("Introducir nombre de ruta a reservar");
						String puestoRutaReservada = JOptionPane.showInputDialog("Introducir puesto a reservar");
						facade.crearRegistroReserva(nombreReserva, lugarOrigen, lugarDestino, nombreRutaReservada,
								puestoRutaReservada, usuario.getDocumento());
						break;
					case 2:
						// Listar reservas
						JOptionPane.showMessageDialog(null, facade.listarReservasPasajero(usuario.getDocumento()));
						break;
					case 3:
						// Modificar reserva
						String nombreReservaModificar = JOptionPane
								.showInputDialog("Introducir nombre de reserva a modificar");
						String lugarOrigenModificado = JOptionPane.showInputDialog("Introducir lugar origen");
						String lugarDestinoModificado = JOptionPane.showInputDialog("Introducir lugar destino");
						String nombreRutaReservadaModificado = JOptionPane
								.showInputDialog("Introducir nombre de ruta a reservar");
						String puestoRutaReservadaModificado = JOptionPane
								.showInputDialog("Introducir puesto a reservar");
						facade.modificarReservaPasajero(nombreReservaModificar, lugarOrigenModificado,
								lugarDestinoModificado, nombreRutaReservadaModificado, puestoRutaReservadaModificado,
								usuario.getDocumento());
						break;
					case 4:
						// Eliminar reserva
						String nombreReservaEliminar = JOptionPane
								.showInputDialog("Introducir nombre de reserva a eliminar");
						facade.eliminarReserva(nombreReservaEliminar, usuario.getDocumento());
						break;
					case 0:
						break;
					}
					break;
				case 2:
					// Conductor
					opcion = Integer.parseInt(JOptionPane.showInputDialog("" + "1. Crear ruta \n" + "2. Listar rutas \n"
							+ "3. Modificar ruta \n" + "4. Eliminar ruta \n" + "0. Salir \n"));
					boolean agregarCalle;
					switch (opcion) {
					case 1:
						// Crear registro ruta
						String nombreRuta = JOptionPane.showInputDialog("Introducir nombre de ruta");
						ArrayList<Componente> calles = new ArrayList<Componente>();
						agregarCalle = true;
						while (agregarCalle) {
							String nombreCalle = JOptionPane.showInputDialog("Introducir nombre de calle");
							String distanciaCalle = JOptionPane.showInputDialog("Introducir distancia de calle");
							String coordenadaXOrigenCalle = JOptionPane
									.showInputDialog("Introducir coordenada X de Origen");
							String coordenadaYOrigenCalle = JOptionPane
									.showInputDialog("Introducir coordenada Y de Origen");
							String coordenadaXDestinoCalle = JOptionPane
									.showInputDialog("Introducir coordenada X de Destino");
							String coordenadaYDestinoCalle = JOptionPane
									.showInputDialog("Introducir coordenada Y de Destino");
							Componente calle = new Calle(coordenadaXOrigenCalle, coordenadaYOrigenCalle,
									coordenadaXDestinoCalle, coordenadaYDestinoCalle, nombreCalle, distanciaCalle);
							calles.add(calle);
							int option = JOptionPane.showConfirmDialog(null, "¿Deseas agregar otra calle?");
							if (option == JOptionPane.NO_OPTION) {
								// Si se seleccionó en no agregar otra calle
								agregarCalle = false;
							}
						}
						facade.crearRegistroRuta(nombreRuta, calles, usuario.getDocumento());
						break;
					case 2:
						// Listar rutas
						JOptionPane.showMessageDialog(null, facade.listarRutasConductor(usuario.getDocumento()));
						break;
					case 3:
						// Modificar ruta
						String nombreRutaModificar = JOptionPane
								.showInputDialog("Introducir nombre de ruta a modificar");
						String nombreRutaNuevo = JOptionPane.showInputDialog("Introducir nuevo nombre de ruta");
						ArrayList<Componente> callesModificadas = new ArrayList<Componente>();
						agregarCalle = true;
						while (agregarCalle) {
							String nombreCalle = JOptionPane.showInputDialog("Introducir nombre de calle");
							String distanciaCalle = JOptionPane.showInputDialog("Introducir distancia de calle");
							String coordenadaXOrigenCalle = JOptionPane
									.showInputDialog("Introducir coordenada X de Origen");
							String coordenadaYOrigenCalle = JOptionPane
									.showInputDialog("Introducir coordenada Y de Origen");
							String coordenadaXDestinoCalle = JOptionPane
									.showInputDialog("Introducir coordenada X de Destino");
							String coordenadaYDestinoCalle = JOptionPane
									.showInputDialog("Introducir coordenada Y de Destino");
							Componente calle = new Calle(coordenadaXOrigenCalle, coordenadaYOrigenCalle,
									coordenadaXDestinoCalle, coordenadaYDestinoCalle, nombreCalle, distanciaCalle);
							callesModificadas.add(calle);
							int option = JOptionPane.showConfirmDialog(null, "¿Deseas agregar otra calle?");
							if (option == JOptionPane.NO_OPTION) {
								// Si se seleccionó en no agregar otra calle
								agregarCalle = false;
							}
						}
						facade.actualizarRuta(nombreRutaModificar, nombreRutaNuevo, callesModificadas,
								usuario.getDocumento());
						break;
					case 4:
						String nombreRutaEliminar = JOptionPane.showInputDialog("Introducir nombre de ruta a eliminar");
						facade.eliminarRuta(nombreRutaEliminar, usuario.getDocumento());
						break;
					case 0:
						break;
					}
					break;
				}
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
				break;
			}
		} while (opcion != 0);

	}

}
