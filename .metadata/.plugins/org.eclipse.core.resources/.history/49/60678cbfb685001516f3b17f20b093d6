package backend;
import java.util.ArrayList;

public class Sucursal {
	
	int id;
	String direccion;
	String nombre;
	Operador operador;
	
	Cajero cajero;
	ArrayList<Camion> listaCamiones;
	ArrayList<Encomienda> listaEncomiendas;
	ArrayList<Mensaje> listaMensajes;
	
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
		this.cajero = cajero;
		this.listaCamiones = new ArrayList<>();
		this.listaMensajes = new ArrayList<>();
		this.listaEncomiendas = new ArrayList<>();
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
