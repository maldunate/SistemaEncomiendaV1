
public abstract class Vehiculo {

	String patente;
	int capacidad;
	Sucursal sucursalOrigen;
	Sucursal sucursalDestino;
	/**
	 * @param patente
	 * @param capacidad
	 * @param sucursalOrigen
	 * @param sucursalDestino
	 */
	public Vehiculo(String patente, int capacidad, Sucursal sucursalOrigen, Sucursal sucursalDestino) {
		super();
		this.patente = patente;
		this.capacidad = capacidad;
		this.sucursalOrigen = sucursalOrigen;
		this.sucursalDestino = sucursalDestino;
	}
	
}
