/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;



/**
 *
 * @author Andrés
 */
public class AdministradorAdapter extends Usuario {

    private Administrador administrador = new Administrador();

    public AdministradorAdapter(String nombre, String usuario, String contrasena, String documento) {
        super(nombre, usuario, contrasena, documento);
    }
    
    public AdministradorAdapter() {
        
    }

    @Override
    public void consultar() {
       
    }

    @Override
    public void eliminar() {
        
    }

}
