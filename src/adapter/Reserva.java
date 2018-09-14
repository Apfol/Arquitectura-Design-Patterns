package adapter;

public class Reserva {

	private String nombreReserva;
	//private String lugarOrigen;
	//private String lugarDestino;
	private int puestoRutaReservada;
	private String nombreRutaReservada;
	private String documentoPasajero;

	

	public Reserva(String nombreReserva, int puestoRutaReservada, String nombreRutaReservada,
			String documentoPasajero) {
		
		this.nombreReserva = nombreReserva;
		this.puestoRutaReservada = puestoRutaReservada;
		this.nombreRutaReservada = nombreRutaReservada;
		this.documentoPasajero = documentoPasajero;
	}

	public String getDocumentoPasajero() {
		return documentoPasajero;
	}

	public void setDocumentoPasajero(String documentoPasajero) {
		this.documentoPasajero = documentoPasajero;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}

/*	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public String getLugarDestino() {
		return lugarDestino;
	}

	public void setLugarDestino(String lugarDestino) {
		this.lugarDestino = lugarDestino;
	}*/

	public int getPuestoAReservar() {
		return puestoRutaReservada;
	}

	public void setPuestoAReservar(int puestoAReservar) {
		this.puestoRutaReservada = puestoAReservar;
	}

	public String getNombreRutaReservada() {
		return nombreRutaReservada;
	}

	public void setNombreRutaReservada(String nombreRutaReservada) {
		this.nombreRutaReservada = nombreRutaReservada;
	}

	@Override
	public String toString() {
		return "Reserva [nombreReserva=" + nombreReserva + ", puestoRutaReservada=" + puestoRutaReservada
				+ ", nombreRutaReservada=" + nombreRutaReservada + ", documentoPasajero=" + documentoPasajero + "]";
	}
	
	

}
