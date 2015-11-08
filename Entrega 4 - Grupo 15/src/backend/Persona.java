package backend;

public abstract class Persona  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7595850789860187821L;
	String nombre;
	
	/**
	 * @param nombre
	 */
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
