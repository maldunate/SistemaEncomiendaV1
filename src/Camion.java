import java.util.ArrayList;

enum EstadoCamion {EnOrigen,EnDestino};

public class Camion extends Vehiculo{
	

	Chofer chofer;
	EstadoCamion estadoCamion;
    ArrayList<Encomienda> enCamion;
	
	public Camion(String patente, int capacidad, Sucursal sucursalOrigen, Sucursal sucursalDestino, Chofer chofer) {
		super(patente, capacidad, sucursalOrigen, sucursalDestino);
		// TODO Auto-generated constructor stub
		this.chofer = chofer;
		this.estadoCamion = EstadoCamion.EnOrigen;
	}

	public EstadoCamion getEstadoCamion() {
		return estadoCamion;
	}

	public void setEstadoCamion(EstadoCamion estadoCamion) {
		this.estadoCamion = estadoCamion;
	}
}
