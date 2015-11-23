package backend;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

enum EstadoEncomienda {EnOrigen, EnDestino, EnTransito, Entregado};

public class Encomienda  implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3953647643106678875L;

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
		this.precio = (double)peso*1000 + (double)volumen*20;
		this.prioridad = prioridad;
		this.estadoEncomienda = EstadoEncomienda.EnOrigen;
		this.date = LocalDateTime.now();
		this.pago = LocalDateTime.now();
		this.strdate = date.format(formater);
		asignarNombre();
	}
	Sucursal sucursalOrigen;
	Sucursal sucursalDestino;
	int volumen;
	int peso;
	public String nombre;
	public double precio;
	int prioridad;
	String direccionFinal;
	public EstadoEncomienda estadoEncomienda;
	LocalDateTime date;
	LocalDateTime pago;
	DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	String strdate;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate() {
		this.date = LocalDateTime.now();
		this.strdate = date.format(formater);
	}

	public LocalDateTime getPago() {
		return pago;
	}

	public void setPago(LocalDateTime pago) {
		this.pago = pago;
	}

	public String getStrdate() {
		return strdate;
	}

	public void setStrdate(String strdate) {
		this.strdate = strdate;
	}

	public String getDireccionFinal() {
		return direccionFinal;
	}

	public void setDireccionFinal(String direccionFinal) {
		this.direccionFinal = direccionFinal;
	}

	public void asignarNombre(){
		Random hola = new Random();
		this.nombre = "soyla"+hola.nextInt(100000);

	}

	public EstadoEncomienda getEstadoEncomienda() {
		return estadoEncomienda;
	}

	public String getEstadoEncomiendaString() {
		return this.estadoEncomienda.toString();
	}
	
	public void setEstadoEntregado(){
		estadoEncomienda = EstadoEncomienda.Entregado;
	}
	
	public void setEstadoEnTransito(){
		estadoEncomienda = EstadoEncomienda.EnTransito;
	}
	
	public void setEstadoEnDestino(){
		estadoEncomienda = EstadoEncomienda.EnDestino;
	}
	
	public void setEstadoEnOrigen(){
		estadoEncomienda = EstadoEncomienda.EnOrigen;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio, double coef) {
		this.precio = precio*(1-0.3*coef);
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
