package backend;
import java.util.ArrayList;

enum EstadoCamion {EnOrigen,EnDestino};

public class Camion extends Vehiculo{
	
	EstadoCamion estadoCamion;
    ArrayList<Encomienda> enCamion;
	
	public Camion(String patente, int capacidad, Sucursal sucursalOrigen, Sucursal sucursalDestino) {
		super(patente, capacidad, sucursalOrigen, sucursalDestino);
		// TODO Auto-generated constructor stub
		this.estadoCamion = EstadoCamion.EnOrigen;
	}

	public EstadoCamion getEstadoCamion() {
		return estadoCamion;
	}

	public void setEstadoCamion(EstadoCamion estadoCamion) {
		this.estadoCamion = estadoCamion;
	}
}
