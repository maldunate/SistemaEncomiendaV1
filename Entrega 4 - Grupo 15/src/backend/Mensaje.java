package backend;

public class Mensaje  implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1702558503349859758L;
	public String texto;
	public Sucursal destinatario;
	public Sucursal origen;
	public String asunto;
	
	public Mensaje(String texto, Sucursal destinatario, Sucursal origen, String asunto) {
		super();
		this.texto = texto;
		this.destinatario = destinatario;
		this.origen = origen;
		this.asunto = asunto;
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
