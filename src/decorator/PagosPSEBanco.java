package decorator;


public class PagosPSEBanco extends PagosPSE{
	
	private String numeroCuenta;
	private String passCuenta;

	public PagosPSEBanco(Component pagoEspecial) {
		super(pagoEspecial);
	}

	
	
	public void establecerParametros(String parametros) {
		pagoEspecial.establecerParametros(parametros);
		String[] parametrosBanco = parametros.split(",");
		setNumeroCuenta(parametrosBanco[3]);
		setPassCuenta(parametrosBanco[4]);
		super.setConfirmacionPago(Boolean.parseBoolean(parametrosBanco[5]));
	}
	
	@Override
	public String obtenerParametros() {
		return pagoEspecial.obtenerParametros() + " + Número de cuenta: " + getNumeroCuenta() + ". Contraseña de cuenta:" +getPassCuenta()
		+ ". Confirmación de pago: " + super.isConfirmacionPago();
	}


	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	public void setPassCuenta(String passCuenta) {
		this.passCuenta = passCuenta;
	}


	public String getNumeroCuenta() {
		return numeroCuenta;
	}


	public String getPassCuenta() {
		return passCuenta;
	}
	
	
	
}
