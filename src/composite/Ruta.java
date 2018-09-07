/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.composite.ruta;

import java.util.ArrayList;

/**
 *
 * @author Apfol
 */
public class Ruta implements Componente{
    
    private String nombre;
    private ArrayList <Componente> componentes;

    public Ruta(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }
    
    public Ruta() {
        this.nombre = "";
        this.componentes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Se mostró ruta: " + nombre + ".");
        for(Componente c : componentes) c.mostrarDatos();
    }
    
    public void add(Componente c) {
        getComponentes().add(c);
    }
    
}
