package backend;
import java.util.ArrayList;

public class SistemaEncomienda implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static SistemaEncomienda INSTANCE = new SistemaEncomienda(); 
	
	ArrayList<Pedido> listaPedidos;
	ArrayList<Sucursal> listaSucursales;
	ArrayList<Cliente> listaClientes;
	String[] direccion = { "dir1", "dir2", "dir3", "dir4" };
	String[] patentes = {"patente1","patente2","patente3","patente4"};
	String[] nombres = {"nombre1","nombre2","nombre3","nombre4","nombre5","nombre6","nombre7","nombre8","nombre9","nombre10","nombre11","nombre12","nombre13","nombre14"};
	String[] numeros = {"1234567"};
	
	
	public SistemaEncomienda() {
		listaPedidos = new ArrayList<>();
		listaSucursales = new ArrayList<>();
		listaClientes = new ArrayList<>();
		crearSucursales();
	}

	public void comenzar(){
		System.out.println("comienza el sistema");
	}
	
	public static SistemaEncomienda getInstance(){
		return INSTANCE;
	}
	public Pedido InsertarPedido (){
		return null; //Pedido
	}
	
	public ArrayList<String> getSucursalesNombre(){
		
		ArrayList<String> lista = new ArrayList<>();
		for (Sucursal s : listaSucursales) {
			lista.add(s.nombre);
		}
		
		return lista;
	}
	public void Simulacion(){
		//Camion camion1 = new Camion();
		//listaSucursales.add(new Sucursal())
		
	}
	
	public void crearSucursales(){
		Sucursal s1 = new Sucursal(0, direccion[0], "Las Condes", new Operador("Manuel"), new Cajero("Lucas",this));
		s1.cajero.setSucursal(s1);
		s1.operador.setSucursal(s1);
		listaSucursales.add(s1);
		
		Sucursal s2 = new Sucursal(1, direccion[1], "La Reina", new Operador("Manuel2"), new Cajero("Lucas2",this));
		s2.cajero.setSucursal(s2);
		s2.operador.setSucursal(s2);
		listaSucursales.add(s2);
		
		Sucursal s3 = new Sucursal(2, direccion[2], "Chicureo", new Operador("Manuel3"), new Cajero("Lucas3",this));
		s3.cajero.setSucursal(s3);
		s3.operador.setSucursal(s3);
		listaSucursales.add(s3);
		
		Sucursal s4 = new Sucursal(3, direccion[3], "San Joaquin", new Operador("Manuel4"), new Cajero("Lucas4",this));
		s4.cajero.setSucursal(s4);
		s4.operador.setSucursal(s4);
		listaSucursales.add(s4);
		
		for (Sucursal s : listaSucursales) {
			s.agregarCamiones(listaSucursales);
		}
	}

	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public ArrayList<Sucursal> getListaSucursales() {
		return listaSucursales;
	}

	public void setListaSucursales(ArrayList<Sucursal> listaSucursales) {
		this.listaSucursales = listaSucursales;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public String getDireccion(int i) {
		return direccion[i];
	}

	public void setDireccion(String[] direccion) {
		this.direccion = direccion;
	}

	public String[] getPatentes() {
		return patentes;
	}

	public void setPatentes(String[] patentes) {
		this.patentes = patentes;
	}

	public String[] getNombres() {
		return nombres;
	}

	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}

	public String[] getNumeros() {
		return numeros;
	}

	public void setNumeros(String[] numeros) {
		this.numeros = numeros;
	}
	
}
