package backend;

public abstract class Persona {

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
