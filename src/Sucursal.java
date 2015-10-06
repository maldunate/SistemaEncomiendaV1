import java.util.ArrayList;

public class Sucursal {
	
	int id;
	String direccion;
	String nombre;
	Operador operador;
	Cajero cajero;
	ArrayList<Camion> listaCamiones;
	ArrayList<Encomienda> listaEncomiendas;
	
	
	/**
	 * @param id
	 * @param direccion
	 * @param nombre
	 * @param operador
	 * @param cajero
	 * @param listaCamiones
	 */
	
	public Sucursal(int id, String direccion, String nombre, Operador operador, Cajero cajero,
			ArrayList<Camion> listaCamiones) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.nombre = nombre;
		this.operador = operador;
		this.cajero = cajero;
		this.listaCamiones = listaCamiones;
	}


	public void enviarMensaje(){
		
	}

}
