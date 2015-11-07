package backend;

public class printEncomienda {
	public printEncomienda(String origen, String destino, int volumen, int peso, int prioridad, int precio) {
		super();
		this.destino = destino;
		this.volumen = volumen;
		this.peso = peso;
		this.prioridad = prioridad;
		this.precio = precio;
		this.origen = origen;
	}
	public String origen;
	public String destino;
	public int volumen;
	public int peso;
	public int prioridad;
	public int precio;
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
	public int getPrecio() {
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

}
