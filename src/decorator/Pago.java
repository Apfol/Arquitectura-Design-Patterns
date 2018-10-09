package decorator;

public class Pago implements Component{
	
	private double valor;
	private String documentoConductor;
	private String documentoPasajero;
	

	
	public void establecerParametros(String parametros) {
		String[] parametrosBanco = parametros.split(",");
		setValor(Double.parseDouble(parametrosBanco[0]));
		setDocumentoConductor(parametrosBanco[1]);
		setDocumentoPasajero(parametrosBanco[2]);
	}

	@Override
	public String obtenerParametros() {
		return "Valor: " + getValor() + ". Documento conductor: " + getDocumentoConductor()
		+ ". Documento pasajero: " + getDocumentoPasajero();
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
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
