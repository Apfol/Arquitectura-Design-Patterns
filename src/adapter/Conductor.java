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
public class Conductor extends Usuario{
    
    public Conductor(String nombre, String correo, String contrasena, String documento) {
        super(nombre, correo, contrasena, documento);
    }
    
    public Conductor() {
        
    }

    @Override
    public void consultar() {
       
    }

    @Override
    public void eliminar() {
        
    }
   
}
