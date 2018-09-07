/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitectura;

/**
 *
 * @author Andrés
 */
public class Administrador {

    public void create() {
        System.out.println("Se ha creado administrador");
    }

    public void brief() {
        System.out.println("Se ha consultado administrador");
    }

    public void update() {
        System.out.println("Se ha actualizado administrador");
    }

    public void delete() {
        System.out.println("Se ha eliminado administrador");
    }

    @Override
    public String toString() {
        return "Administrador"; //To change body of generated methods, choose Tools | Templates.
    }

}
