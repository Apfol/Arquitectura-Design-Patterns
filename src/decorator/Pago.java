package decorator;

public class Pago implements Component{
	
	public String valor;
	public String documentoConductor;
	public String documentoPasajero;
	

	@Override
	public void establecerParametros(String parametros) {
		String[] parametrosBanco = parametros.split(",");
		setValor(parametrosBanco[1]);
		setDocumentoConductor(parametrosBanco[2]);
		setDocumentoPasajero(parametrosBanco[3]);
	}

	@Override
	public String obtenerParametros() {
		return "Valor: " + getValor() + ". Documento conductor: " + getDocumentoConductor()
		+ ". Documento pasajero: " + getDocumentoPasajero();
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDocumentoConductor() {
		return documentoConductor;
	}

	public void setDocumentoConductor(String documentoConductor) {
		this.documentoConductor = documentoConductor;
	}

	public String getDocumentoPasajero() {
		return documentoPasajero;
	}

	public void setDocumentoPasajero(String documentoPasajero) {
		this.documentoPasajero = documentoPasajero;
	}
	
}
