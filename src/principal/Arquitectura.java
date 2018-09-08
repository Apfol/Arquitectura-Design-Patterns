/*
3e * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;

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
		Usuario pasajero = new Pasajero();
		Usuario conductor = new Conductor();
		Usuario administrador = new AdministradorAdapter();
		int opcion = 0;

		Facade facade = new Facade();

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"" + "Seleccione la opción: \n" + "1. Registrar usuario \n" + "2. Modificar usuario \n"
							+ "3. Eliminar usuario \n" + "4. Acceder al sistema \n" + "0. Salir"));
			switch (opcion) {
			case 1:
				int opcion1 = Integer.parseInt(JOptionPane.showInputDialog(
						"" + "1. Pasajero \n" + "2. Conductor \n" + "3. Administrador \n" + "4. Regresar"));
				switch (opcion1) {
				case 1:
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					documento = Integer.parseInt(JOptionPane.showInputDialog("Introducir documento"));
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contraseña");
					pasajero = new Pasajero(nombre, correo, contrasena, documento);
					//pasajero.adicionar(pasajero);
					break;
				case 2:
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					documento = Integer.parseInt(JOptionPane.showInputDialog("Introducir documento"));
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contraseÃ±a");
					conductor = new Conductor(nombre, correo, contrasena, documento);
					//conductor.adicionar(conductor);
					break;
				case 3:
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					documento = Integer.parseInt(JOptionPane.showInputDialog("Introducir documento"));
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contraseÃ±a");
					administrador = new AdministradorAdapter(nombre, correo, contrasena, documento);
					//administrador.adicionar(administrador);
					break;
				case 4:
				}
				break;
			case 2:
				int opcion2 = Integer.parseInt(JOptionPane.showInputDialog(
						"" + "1. Pasajero \n" + "2. Conductor \n" + "3. Administrador \n" + "4. Regresar"));
				switch (opcion2) {
				case 1:
					documento = Integer
							.parseInt(JOptionPane.showInputDialog("Introduce el documento del usuario a eliminar"));
					correo = JOptionPane.showInputDialog("Introducir correo");
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					contrasena = JOptionPane.showInputDialog("Introducir contraseña");
					pasajero = new Pasajero(nombre, correo, contrasena, documento);
					//pasajero.modificar(pasajero, documento);
					break;
				case 2:
					documento = Integer
							.parseInt(JOptionPane.showInputDialog("Introduce el documento del usuario a eliminar"));
					correo = JOptionPane.showInputDialog("Introducir correo");
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					contrasena = JOptionPane.showInputDialog("Introducir contraseÃ±a");
					conductor = new Conductor(nombre, correo, contrasena, documento);
					//conductor.modificar(conductor, documento);
					break;
				case 3:
					documento = Integer
							.parseInt(JOptionPane.showInputDialog("Introduce el documento del usuario a eliminar"));
					correo = JOptionPane.showInputDialog("Introducir correo");
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					contrasena = JOptionPane.showInputDialog("Introducir contraseña");
					administrador = new AdministradorAdapter(nombre, correo, contrasena, documento);
					//administrador.modificar(administrador, documento);
					break;
				case 4:
				}
				break;
			case 3:
				int opcion3 = Integer.parseInt(JOptionPane.showInputDialog(
						"" + "1. Pasajero \n" + "2. Conductor \n" + "3. Administrador \n" + "4. Regresar"));
				documento = Integer
						.parseInt(JOptionPane.showInputDialog("Introduce el documento del usuario a eliminar"));
				switch (opcion3) {
				case 1:
					//pasajero.eliminar(documento);
					break;
				case 2:
					//conductor.eliminar(documento);
					break;
				case 3:
					//administrador.eliminar(documento);
					break;
				case 4:
				}
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
						facade.crearRegistroReserva();
						break;
					case 2:
						facade.listarReservasPasajero();
						break;
					case 3:
						facade.modificarReservaPasajero();
						break;
					case 4:
						facade.eliminarReserva();
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
						JOptionPane.showMessageDialog(null, facade.listarRutasConductor(usuario.getDocumento()));
						break;
					case 3:
						String nombreRutaModificar = JOptionPane.showInputDialog("Introducir nombre de ruta a modificar");
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
						facade.actualizarRuta(nombreRutaModificar, nombreRutaNuevo, callesModificadas, usuario.getDocumento());
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
