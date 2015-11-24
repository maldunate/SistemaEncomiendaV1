package backend;

public class printEncomienda {
	public printEncomienda(String origen, String destino, int volumen, int peso, int prioridad, double precio, String tipo) {
		super();
		this.destino = destino;
		this.volumen = volumen;
		this.peso = peso;
		this.prioridad = prioridad;
		this.precio = precio;
		this.origen = origen;
		this.tipo = tipo;
	}
	public String origen;
	public String destino;
	public String tipo;
	public int volumen;
	public int peso;
	public int prioridad;
	public double precio;
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
