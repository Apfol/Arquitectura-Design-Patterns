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
public class Conductor extends Usuario{
    
    public Conductor(String nombre, String correo, String contrasena, String documento) {
        super(nombre, correo, contrasena, documento);
    }
    
    public Conductor() {
        
    }

    @Override
    public void consultar() {
    	String datosUsuarios = "";
        ArrayList<Usuario> usuarios = this.getUsuarios();
        for (Usuario us: usuarios) {
            if(us instanceof Conductor) {
                datosUsuarios += us.getNombre() + " " + us.getCorreo() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, datosUsuarios);
    }

    @Override
    public void eliminar(String correo) {
    	ArrayList<Usuario> usuarios = this.getUsuarios();
        for (Usuario us: usuarios) {
            if(us.getCorreo().equals(correo)) {
                usuarios.remove(us);
            }
        }
    }
   
}
