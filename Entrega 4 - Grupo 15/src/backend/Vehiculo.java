package backend;

public abstract class Vehiculo  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1761148224517024159L;
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
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}
	public void setSucursalOrigen(Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}
	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}
	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}
	
}
