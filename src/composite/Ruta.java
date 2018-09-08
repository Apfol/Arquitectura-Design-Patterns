/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import java.util.ArrayList;

/**
 *
 * @author Apfol
 */
public class Ruta implements Componente{
    
    private String nombre;
    private String correoUs;
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

    public String getCorreoUs() {
		return correoUs;
	}

	public void setCorreoUs(String correoUs) {
		this.correoUs = correoUs;
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
