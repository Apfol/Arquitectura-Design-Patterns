package decorator;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
public class PagosPSETarjeta extends PagosPSE
{
	private String numeroTarjeta;
	private String codigoSeguridad;
	private Date fechaVencimiento;
	
	public PagosPSETarjeta(Component pagoEspecial) 
	{
		super(pagoEspecial); // El pago especial que se paso ahora sera q¿el decorado que es el protected
		
	}
	
	public void establecerParametros(String parametros)
	{
		pagoEspecial.establecerParametros(parametros);// Para que el pago establezca sus atributos que son los primeros 3
		String[] params = parametros.split(",");
		setNumeroTarjeta(params[3]);
		setCodigoSeguridad(params[4]);
		try {
			setFechaVencimiento(new SimpleDateFormat("yyyy/dd/MM").parse(params[5]));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.establecerParametros(params[6]);
	}
	
	//
	public String obtenerParametros()
	{
		return super.obtenerParametros() + ". Número de tarjeta: "+this.numeroTarjeta+" . Codigo seguridad: "+ this.codigoSeguridad
				+" . Fecha vencimiento: "+this.fechaVencimiento ;
	}
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
}
