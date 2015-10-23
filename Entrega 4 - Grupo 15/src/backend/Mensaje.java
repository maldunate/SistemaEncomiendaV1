package backend;

public class Mensaje {
	
	public String texto;
	public Sucursal destinatario;
	public Sucursal origen;
	
	public Mensaje(String texto, Sucursal destinatario, Sucursal origen) {
		super();
		this.texto = texto;
		this.destinatario = destinatario;
		this.origen = origen;
	}

	public Sucursal getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Sucursal destinatario) {
		this.destinatario = destinatario;
	}

	public Sucursal getOrigen() {
		return origen;
	}

	public void setOrigen(Sucursal origen) {
		this.origen = origen;
	}
	

}
