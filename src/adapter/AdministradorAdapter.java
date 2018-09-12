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
public class AdministradorAdapter extends Usuario {

    private Administrador administrador = new Administrador();

    public AdministradorAdapter(String nombre, String usuario, String contrasena, int documento) {
        super(nombre, usuario, contrasena, documento);
    }
    
    public AdministradorAdapter() {
        
    }

    @Override
    public void consultar(ArrayList<Usuario> usuarios) {
        String datosUsuarios = "";
        for (Usuario us: usuarios) {
            if(us instanceof AdministradorAdapter) {
                datosUsuarios += us.getNombre() + " " + us.getCorreo() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, datosUsuarios);
    }

    @Override
    public void eliminar(int documento, ArrayList<Usuario> usuarios) {
        for (Usuario us: usuarios) {
            if(us.getDocumento() == documento) {
                usuarios.remove(us);
            }
        }
    }

    
}
