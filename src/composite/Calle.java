/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

/**
 *
 * @author Apfol
 */
public class Calle implements Componente {

	private String coordenadaXOrigen;
	private String coordenadaYOrigen;
	private String coordenadaXDestino;
	private String coordenadaYDestino;
	private String nombre;
	private String distancia;
	private String tiempoNormal = "60 Km/h";

	public Calle() {
		setCoordenadaXOrigen("");
		setCoordenadaYOrigen("");
		setCoordenadaXDestino("");
		setCoordenadaYDestino("");
		setNombre("");
		setDistancia("");
		setTiempoNormal("");
	}

	public Calle(String coordenadaXOrigen, String coordenadaYOrigen, String coordenadaXDestino,
			String coordenadaYDestino, String nombre, String distancia) {
		this.coordenadaXOrigen = coordenadaXOrigen;
		this.coordenadaYOrigen = coordenadaYOrigen;
		this.coordenadaXDestino = coordenadaXDestino;
		this.coordenadaYDestino = coordenadaYDestino;
		this.nombre = nombre;
		this.distancia = distancia;
	}

	public String getCoordenadaXOrigen() {
		return coordenadaXOrigen;
	}

	public void setCoordenadaXOrigen(String coordenadaXOrigen) {
		this.coordenadaXOrigen = coordenadaXOrigen;
	}

	public String getCoordenadaYOrigen() {
		return coordenadaYOrigen;
	}

	public void setCoordenadaYOrigen(String coordenadaYOrigen) {
		this.coordenadaYOrigen = coordenadaYOrigen;
	}

	public String getCoordenadaXDestino() {
		return coordenadaXDestino;
	}

	public void setCoordenadaXDestino(String coordenadaXDestino) {
		this.coordenadaXDestino = coordenadaXDestino;
	}

	public String getCoordenadaYDestino() {
		return coordenadaYDestino;
	}

	public void setCoordenadaYDestino(String coordenadaYDestino) {
		this.coordenadaYDestino = coordenadaYDestino;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public String getTiempoNormal() {
		return tiempoNormal;
	}

	public void setTiempoNormal(String tiempoNormal) {
		this.tiempoNormal = tiempoNormal;
	}

	@Override
	public void mostrarDatos() {
		System.out.println("Nombre: " + nombre + " ." + "Distancia en metros: " + distancia + " ." + "Tiempo normal: "
				+ tiempoNormal + " ." + "Coordenada X Origen: " + coordenadaXOrigen + " ." + "Coordenada Y Origen: "
				+ coordenadaYOrigen + " ." + "Coordenada X Destino: " + coordenadaXDestino + " ."
				+ "Coordenada Y Destino: " + coordenadaYDestino + " .");
	}

	public String obtenerDatos() {
		return this.toString();
	}

}
