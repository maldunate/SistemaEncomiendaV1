package backend;

public class printEncomienda {
	public printEncomienda(String origen, String destino, int volumen, int peso, int prioridad, double precio, String tipo, String fecha, String nombre, String estado) {
		super();
		this.destino = destino;
		this.volumen = volumen;
		this.peso = peso;
		this.prioridad = prioridad;
		this.precio = precio;
		this.origen = origen;
		this.tipo = tipo;
		this.fecha = fecha;
		this.nombre = nombre;
		this.estado = estado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String origen;
	public String destino;
	public String tipo;
	public int volumen;
	public int peso;
	public int prioridad;
	public double precio;
	public String fecha;
	public String nombre;
	public String estado;
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
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
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
