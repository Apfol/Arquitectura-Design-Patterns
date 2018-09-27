package proxy;

public class UsuarioLogin {
	
	private String correo;
	private String password;
	private String tipoInstancia;
	
	public UsuarioLogin(String correo, String password, String tipoInstancia) {
		super();
		this.correo = correo;
		this.password = password;
		this.tipoInstancia = tipoInstancia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String documento) {
		this.correo = documento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoInstancia() {
		return tipoInstancia;
	}

	public void setTipoInstancia(String tipoInstancia) {
		this.tipoInstancia = tipoInstancia;
	}
	
	
}
