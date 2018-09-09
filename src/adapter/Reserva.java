package adapter;

public class Reserva {

	private String nombreReserva;
	private String lugarOrigen;
	private String lugarDestino;
	private String puestoRutaReservada;
	private String nombreRutaReservada;
	private int documentoPasajero;

	public Reserva(String nombreReserva, String lugarOrigen, String lugarDestino, String puestoAReservar,
			String nombreRutaReservada, int documentoPasajero) {
		super();
		this.nombreReserva = nombreReserva;
		this.lugarOrigen = lugarOrigen;
		this.lugarDestino = lugarDestino;
		this.puestoRutaReservada = puestoAReservar;
		this.nombreRutaReservada = nombreRutaReservada;
		this.documentoPasajero = documentoPasajero;
	}

	public int getDocumentoPasajero() {
		return documentoPasajero;
	}

	public void setDocumentoPasajero(int documentoPasajero) {
		this.documentoPasajero = documentoPasajero;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}

	public String getLugarOrigen() {
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
	}

	public String getPuestoAReservar() {
		return puestoRutaReservada;
	}

	public void setPuestoAReservar(String puestoAReservar) {
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
		return "Reserva [nombreReserva=" + nombreReserva + ", lugarOrigen=" + lugarOrigen + ", lugarDestino="
				+ lugarDestino + ", puestoRutaReservada=" + puestoRutaReservada + ", nombreRutaReservada="
				+ nombreRutaReservada + ", documentoPasajero=" + documentoPasajero + "]";
	}

}
