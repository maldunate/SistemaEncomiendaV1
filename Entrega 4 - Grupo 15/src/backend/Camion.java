package backend;
import java.util.ArrayList;

enum EstadoCamion {EnOrigen,EnDestino};

public class Camion extends Vehiculo{
	
	EstadoCamion estadoCamion;
    public ArrayList<Encomienda> enCamion;
	int id;
	
	public Camion(int id, String patente, int capacidad, Sucursal sucursalOrigen, Sucursal sucursalDestino) {
		super(patente, capacidad, sucursalOrigen, sucursalDestino);
		// TODO Auto-generated constructor stub
		this.id = id;
		enCamion = new ArrayList<>();
		this.estadoCamion = EstadoCamion.EnOrigen;
	}

	public EstadoCamion getEstadoCamion() {
		return estadoCamion;
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
