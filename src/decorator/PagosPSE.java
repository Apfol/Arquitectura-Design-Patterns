package decorator;

public abstract class PagosPSE implements Component{
	
	protected Component pagoEspecial;
	private boolean confirmacionPago;
	
	public PagosPSE(Component pagoEspecial) {
		this.pagoEspecial = pagoEspecial;
	}
	
	@Override
	public void establecerParametros(String parametros) {
		//pagoEspecial.establecerParametros(parametros);
		setConfirmacionPago(Boolean.parseBoolean(parametros));
	}
	
	@Override
	public String obtenerParametros() {
		return pagoEspecial.obtenerParametros() +". "+ this.confirmacionPago ;
	}

	public boolean isConfirmacionPago() {
		return confirmacionPago;
	}

	public void setConfirmacionPago(boolean confirmacionPago) {
		this.confirmacionPago = confirmacionPago;
	}
	
}
