package decorator;


public class PagosPSEBanco extends PagosPSE{
	
	private String numeroCuenta;
	private String passCuenta;

	public PagosPSEBanco(Component pagoEspecial) {
		super(pagoEspecial);
	}

	
	@Override
	public void establecerParametros(String parametros) {
		String[] parametrosBanco = parametros.split(",");
		setNumeroCuenta(parametrosBanco[0]);
		setPassCuenta(parametrosBanco[1]);
		super.setConfirmacionPago(Boolean.parseBoolean(parametrosBanco[2]));
	}
	
	@Override
	public String obtenerParametros() {
		return pagoEspecial.obtenerParametros() + " + Número de cuenta: " + getNumeroCuenta() + ". " + getPassCuenta();
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
