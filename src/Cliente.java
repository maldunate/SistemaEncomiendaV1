
public class Cliente extends Persona{

	String numero;
	String direccion;
	/**
	 * @param numero
	 * @param direccion
	 */
	public Cliente(String nombre, String numero, String direccion) {
		super(nombre);
		this.numero = numero;
		this.direccion = direccion;
	}
	
	
}
