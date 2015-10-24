package backend;

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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
