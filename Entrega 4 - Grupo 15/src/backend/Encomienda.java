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
		this.precio = peso*1000 + volumen*20;
		this.prioridad = prioridad;
		this.estadoEncomienda = EstadoEncomienda.EnOrigen;
		asignarNombre();
	}
	Sucursal sucursalOrigen;
	Sucursal sucursalDestino;
	int volumen;
	int peso;
	public String nombre;
	public int precio;
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

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
