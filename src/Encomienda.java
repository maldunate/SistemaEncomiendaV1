
enum EstadoEncomienda {enOrigen, enDestino, enTransito, Entregado};

public class Encomienda {

	/**
	 * @param sucursalOrigen
	 * @param sucursalDestino
	 * @param volumen
	 * @param peso
	 * @param prioridad
	 * @param estadoEncomienda
	 */
	public Encomienda( Sucursal sucursalOrigen, Sucursal sucursalDestino, String volumen, int peso, int prioridad ) {
		super();
		this.sucursalOrigen = sucursalOrigen;
		this.sucursalDestino = sucursalDestino;
		this.volumen = volumen;
		this.peso = peso;
		this.prioridad = prioridad;
		this.estadoEncomienda = enOrigen;
	}
	Sucursal sucursalOrigen;
	Sucursal sucursalDestino;
	String volumen;
	int peso;
	int prioridad;
	EstadoEncomienda estadoEncomienda;
	
}
