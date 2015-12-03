package backend;

public class MensajeError implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1702558503349859758L;
	public String mensaje;
	public int i;
	
	public MensajeError(String mensaje, int i) {
		super();
		this.mensaje = mensaje;;
		this.i = i;
	}


	
}
