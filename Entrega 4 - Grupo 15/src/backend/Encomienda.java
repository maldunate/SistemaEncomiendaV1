package backend;

import java.lang.reflect.Array;
import java.util.Random;

enum EstadoEncomienda {EnOrigen, EnDestino, EnTransito, Entregado};

public class Encomienda {

	/**
	 * @param sucursalOrigen
	 * @param sucursalDestino
	 * @param volumen
	 * @param peso
	 * @param prioridad
	 * @param estadoEncomienda
	 */
	public Encomienda( Sucursal sucursalOrigen, Sucursal sucursalDestino, int volumen, int peso, int prioridad ) {
		super();
		this.sucursalOrigen = sucursalOrigen;
		this.sucursalDestino = sucursalDestino;
		this.volumen = volumen;
		this.peso = peso;
		this.prioridad = prioridad;
		this.estadoEncomienda = EstadoEncomienda.EnOrigen;
		asignarNombre();
	}
	Sucursal sucursalOrigen;
	Sucursal sucursalDestino;
	int volumen;
	int peso;
	String nombre;

	int prioridad;
	EstadoEncomienda estadoEncomienda;

	public void asignarNombre(){
		Random hola = new Random();
		this.nombre = "soyla"+hola.nextInt(100000);
		
	}
	
	public EstadoEncomienda getEstadoEncomienda() {
		return estadoEncomienda;
	}
	public void setEstadoEncomienda(EstadoEncomienda estadoEncomienda) {
		this.estadoEncomienda = estadoEncomienda;
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
