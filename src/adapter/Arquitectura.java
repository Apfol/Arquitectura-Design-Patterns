/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitectura;

import javax.swing.JOptionPane;

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
        String contraseña;
        Usuario pasajero = new Pasajero();
        Usuario conductor = new Conductor();
        Usuario administrador = new AdministradorAdapter();
        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "Seleccione la opción: \n"
                    + "1. Crear usuario \n"
                    + "2. Modificar usuario \n"
                    + "3. Eliminar usuario \n"
                    + "4. Consultar usuario \n"
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
                            contraseña = JOptionPane.showInputDialog("Introducir contraseña");
                            pasajero = new Pasajero(nombre, correo, contraseña);
                            pasajero.adicionar(pasajero);
                            break;
                        case 2:
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            correo = JOptionPane.showInputDialog("Introducir correo");
                            contraseña = JOptionPane.showInputDialog("Introducir contraseña");
                            conductor = new Conductor(nombre, correo, contraseña);
                            conductor.adicionar(conductor);
                            break;
                        case 3:
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            correo = JOptionPane.showInputDialog("Introducir correo");
                            contraseña = JOptionPane.showInputDialog("Introducir contraseña");
                            administrador = new AdministradorAdapter(nombre, correo, contraseña);
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
                            contraseña = JOptionPane.showInputDialog("Introducir contraseña");
                            pasajero = new Pasajero(nombre, correo, contraseña);
                            pasajero.modificar(pasajero, correo);
                            break;
                        case 2:
                            correo = JOptionPane.showInputDialog("Introduce el correo del usuario a modificar");
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            contraseña = JOptionPane.showInputDialog("Introducir contraseña");
                            conductor = new Conductor(nombre, correo, contraseña);
                            conductor.modificar(conductor, correo);
                            break;
                        case 3:
                            correo = JOptionPane.showInputDialog("Introduce el correo del usuario a modificar");
                            nombre = JOptionPane.showInputDialog("Introducir nombre");
                            contraseña = JOptionPane.showInputDialog("Introducir contraseña");
                            administrador = new AdministradorAdapter(nombre, correo, contraseña);
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
                    int opcion4 = Integer.parseInt(JOptionPane.showInputDialog(""
                            + "1. Pasajero \n"
                            + "2. Conductor \n"
                            + "3. Administrador \n"
                            + "4. Regresar"));
                    switch (opcion4) {
                        case 1:
                            pasajero.consultar();
                            break;
                        case 2:
                            conductor.consultar();
                            break;
                        case 3:
                            administrador.consultar();
                            break;
                        case 4:
                    }
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);

    }

}
