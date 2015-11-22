package backend;
import java.util.ArrayList;
import java.util.Random;

public class Sucursal  implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -187995296828159540L;
	int id;
	String direccion;
	String nombre;
	Operador operador;
	Random r = new Random();	
	Cajero cajero;
	public ArrayList<Operador> listaOperadores = new ArrayList<>();;
	ArrayList<Camion> listaCamiones = new ArrayList<>();;
	ArrayList<Encomienda> listaEncomiendas = new ArrayList<>();;
	ArrayList<Camion> camionesConEncomiendas = new ArrayList<>();;
	ArrayList<Mensaje> listaMensajes = new ArrayList<>();;
	
	/**
	 * @param id
	 * @param direccion
	 * @param nombre
	 * @param operador
	 * @param cajero
	 * @param listaCamiones
	 * @param listaMensajes 
	 */
	
	public Sucursal(int id, String direccion, String nombre, Operador operador, Cajero cajero) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.nombre = nombre;
		this.operador = operador;
		listaOperadores.add(this.operador);
		this.cajero = cajero;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public ArrayList<Camion> getListaCamiones() {
		return listaCamiones;
	}

	public void setListaCamiones(ArrayList<Camion> listaCamiones) {
		this.listaCamiones = listaCamiones;
	}
	
	public ArrayList<Camion> getCamionesConEncomiendas() {
		return camionesConEncomiendas;
	}

	public void setCamionesConEncomiendas(ArrayList<Camion> camionesConEncomiendas) {
		this.camionesConEncomiendas = camionesConEncomiendas;
	}

	public ArrayList<Encomienda> getListaEncomiendas() {
		return listaEncomiendas;
	}

	public void setListaEncomiendas(ArrayList<Encomienda> listaEncomiendas) {
		this.listaEncomiendas = listaEncomiendas;
	}

	public ArrayList<Mensaje> getListaMensajes() {
		return listaMensajes;
	}

	public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
		this.listaMensajes = listaMensajes;
	}
	
	public void agregarCamion(String patente, int capacidad, Sucursal sucursalDestino){
		this.listaCamiones.add(new Camion(r.nextInt(99999), patente, capacidad, this, sucursalDestino));
	}
	
	public void agregarCamiones(ArrayList<Sucursal> listaSucursales){
		for (Sucursal s : listaSucursales) {
			int i = 1;
			if(!s.equals(this)){
				listaCamiones.add(new Camion(i, this.nombre + " a " + s.nombre, 10, this, s));
			    i++;
			}
		}
	}

}
