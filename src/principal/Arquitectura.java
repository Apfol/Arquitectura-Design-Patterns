/*
3e * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javax.swing.JOptionPane;

import adapter.AdministradorAdapter;
import adapter.Conductor;
import adapter.Pasajero;
import adapter.Usuario;

/**
 *
 * @author Andrés
 */
public class Arquitectura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String nombre;
        String correo;
        String contrasena;
        Usuario pasajero = new Pasajero();
        Usuario conductor = new Conductor();
        Usuario administrador = new AdministradorAdapter();
        int opcion = 0;
        
        Facade facade = new Facade();

        do {
            
            opcion = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "Seleccione la opci�n: \n"
                    + "1. Registrar usuario \n"
                    + "2. Modificar usuario \n"
                    + "3. Eliminar usuario \n"
                    + "4. Acceder al sistema \n"
                    + "0. Salir"));
            switch (opcion) {
                case 1:
                    int opcion1 = Integer.parseInt(JOptionPane.showInputDialog(""
                            + "1. Pasajero \n"
                            + "2. Conductor \n"
                            + "3. Administrador \n"
                            + "4. Regresar"));
                    switch (opcion1) {
                        case 1:
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            correo = JOptionPane.showInputDialog("Introducir correo");
                            contrasena = JOptionPane.showInputDialog("Introducir contraseña");
                            pasajero = new Pasajero(nombre, correo, contrasena);
                            pasajero.adicionar(pasajero);
                            break;
                        case 2:
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            correo = JOptionPane.showInputDialog("Introducir correo");
                            contrasena = JOptionPane.showInputDialog("Introducir contraseña");
                            conductor = new Conductor(nombre, correo, contrasena);
                            conductor.adicionar(conductor);
                            break;
                        case 3:
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            correo = JOptionPane.showInputDialog("Introducir correo");
                            contrasena = JOptionPane.showInputDialog("Introducir contraseña");
                            administrador = new AdministradorAdapter(nombre, correo, contrasena);
                            administrador.adicionar(administrador);
                            break;
                        case 4:
                    }
                    break;
                case 2:
                    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog(""
                            + "1. Pasajero \n"
                            + "2. Conductor \n"
                            + "3. Administrador \n"
                            + "4. Regresar"));
                    switch (opcion2) {
                        case 1:
                            correo = JOptionPane.showInputDialog("Introduce el correo del usuario a modificar");
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            contrasena = JOptionPane.showInputDialog("Introducir contraseña");
                            pasajero = new Pasajero(nombre, correo, contrasena);
                            pasajero.modificar(pasajero, correo);
                            break;
                        case 2:
                            correo = JOptionPane.showInputDialog("Introduce el correo del usuario a modificar");
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            contrasena = JOptionPane.showInputDialog("Introducir contraseña");
                            conductor = new Conductor(nombre, correo, contrasena);
                            conductor.modificar(conductor, correo);
                            break;
                        case 3:
                            correo = JOptionPane.showInputDialog("Introduce el correo del usuario a modificar");
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            contrasena = JOptionPane.showInputDialog("Introducir contraseña");
                            administrador = new AdministradorAdapter(nombre, correo, contrasena);
                            administrador.modificar(administrador, correo);
                            break;
                        case 4:
                    }
                    break;
                case 3:
                    int opcion3 = Integer.parseInt(JOptionPane.showInputDialog(""
                            + "1. Pasajero \n"
                            + "2. Conductor \n"
                            + "3. Administrador \n"
                            + "4. Regresar"));
                    correo = JOptionPane.showInputDialog("Introduce el correo del usuario a eliminar");
                    switch (opcion3) {
                        case 1:
                            pasajero.eliminar(correo);
                            break;
                        case 2:
                            conductor.eliminar(correo);
                            break;
                        case 3:
                            administrador.eliminar(correo);
                            break;
                        case 4:
                    }
                    break;
                case 4:
                	correo = JOptionPane.showInputDialog("Introduce el correo del usuario a modificar");
                    contrasena = JOptionPane.showInputDialog("Introducir contrasena");
                    int tipoUsuario = facade.buscarTipoUsuario();
                    switch(tipoUsuario) {
                    case 1:
                    	//Pasajero
                    	opcion = Integer.parseInt(JOptionPane.showInputDialog(""
                                + "1. Crear registro de reserva \n"
                                + "2. Listar reservas \n"
                                + "3. Modificar reserva \n"
                                + "4. Eliminar reserva \n"
                                + "0. salir \n"));
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
                    	//Conductor
                    	opcion = Integer.parseInt(JOptionPane.showInputDialog(""
                                + "1. Crear ruta \n"
                                + "2. Listar rutas \n"
                                + "3. Modificar ruta \n"
                                + "4. Eliminar ruta \n"
                                + "0. Salir \n"));
                    	switch (opcion) {
                    	case 1:
                    		facade.crearRegistroRuta("");
                    		break;
                    	case 2:
                    		facade.listarRutasConductor();
                    		break;
                    	case 3:
                    		facade.actualizarRuta();
                    		break;
                    	case 4:
                    		facade.eliminarRuta();
                    		break;
                    	case 0:
                    		break;
                    	}
                    	break;
                    }
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);

    }

}
