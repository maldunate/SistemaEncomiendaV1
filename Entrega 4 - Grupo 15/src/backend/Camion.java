package backend;
import java.util.ArrayList;

enum EstadoCamion {EnOrigen,EnDestino};
enum TipoCamion {Fragil, Frio, Caliente, Radiactivo, Normal};

public class Camion extends Vehiculo{
	
	TipoCamion tipo;
	EstadoCamion estadoCamion;
    public ArrayList<Encomienda> enCamion;
	int id;
	
	public Camion(int id, String patente, int capacidad, Sucursal sucursalOrigen, Sucursal sucursalDestino) {
		super(patente, capacidad, sucursalOrigen, sucursalDestino);
		// TODO Auto-generated constructor stub
		this.id = id;
		enCamion = new ArrayList<>();
		this.estadoCamion = EstadoCamion.EnOrigen;
		this.tipo = TipoCamion.Normal;
	}
	
	public String nombreTipo() {
		return tipo.name();
	}
	public TipoCamion getTipo() {
		return tipo;
	}

	public void setTipo(TipoCamion tipo) {
		this.tipo = tipo;
	}
	
	public Boolean setearTipo(String s){
		if (s.equals(TipoCamion.Caliente)) {
			this.tipo = TipoCamion.Caliente;
			return true;
		}
		
		else if (s.equals(TipoCamion.Fragil)) {
			this.tipo = TipoCamion.Fragil;
			return true;
		}
		
		else if (s.equals(TipoCamion.Radiactivo)) {
			this.tipo = TipoCamion.Radiactivo;
			return true;
		}
		
		else if (s.equals(TipoCamion.Frio)) {
			this.tipo = TipoCamion.Frio;
			return true;
		}
		
		else if (s.equals(TipoCamion.Normal)) {
			return true;
		}
		return false;
	}

	public EstadoCamion getEstadoCamion() {
		return estadoCamion;
	}
	
	public void setEstadoEnOrigen() {
		estadoCamion = EstadoCamion.EnOrigen;
	}
	
	public void setEstadoEnDestino() {
		estadoCamion = EstadoCamion.EnDestino;
	}

	public void setEstadoCamion(EstadoCamion estadoCamion) {
		this.estadoCamion = estadoCamion;
	}
	
	public int calcularCapacidad(){
		int aux = 0;
		for (Encomienda e : enCamion) {
			aux += e.volumen;
		}
		return aux;
	}
	
	public ArrayList<String> getEncomiendaNombres(){
		ArrayList<String> lista = new ArrayList<>();
		for (Encomienda s : enCamion) {
			lista.add(s.nombre);
		}
		
		return lista;
	}
}
