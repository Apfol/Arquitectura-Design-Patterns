/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import java.util.ArrayList;


public class Ruta implements Componente{
    
    private String nombre;
    private ArrayList <Componente> componentes;
    private String documentoConductor;

    public Ruta(String nombre, String documentoConductor) {
        this.nombre = nombre;
        this.documentoConductor = documentoConductor;
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

    public String getDocumentoConductor() {
		return documentoConductor;
	}

	public void setDocumentoConductor(String documentoConductor) {
		this.documentoConductor = documentoConductor;
	}

	public ArrayList<Componente> getComponentes() {
        return componentes;
    }

	public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Se muestra ruta: " + nombre + ".");
        for(Componente c : componentes) c.mostrarDatos();
    }
    public String obtenerDatos()
    {
    	String infoComponentes = "";
    	for(Componente c: componentes) {
    		infoComponentes +=c.obtenerDatos();
    	}
    	return this.toString() + "\n\t"+infoComponentes;
    }
    
    public void add(Componente c) {
        getComponentes().add(c);
    }
 
}
