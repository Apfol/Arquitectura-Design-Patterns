package decorator;

public abstract class PagosPSE implements Component{
	protected Component pagoEspecial;
	public PagosPSE(Component pagoEspecial) {
		this.pagoEspecial = pagoEspecial;
	}
	
	
	@Override
	public void establecerParametro(String parametros) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String obtenerParametros() {
		// TODO Auto-generated method stub
		return null;
	}
}
