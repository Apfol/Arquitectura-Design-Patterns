/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class Pasajero extends Usuario {

    public Pasajero(String nombre, String correo, String contrasena, int documento) {
        super(nombre, correo, contrasena, documento);
    }

    public Pasajero() {
    }

    @Override
    public void consultar() {
       
    }

    @Override
    public void eliminar() {
        
    }

}
