package backend;
import java.util.ArrayList;
import java.util.Random;

public class SistemaEncomienda implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 65498L;

	Random r = new Random();
	private static SistemaEncomienda INSTANCE = new SistemaEncomienda(); 
	
	ArrayList<Pedido> listaPedidos = new ArrayList<>();
	ArrayList<Sucursal> listaSucursales = new ArrayList<>();
	ArrayList<Cliente> listaClientes = new ArrayList<>();
	String sucursalActual;
	
	int cantidadDeClientes = 6;
	
	String[] direccion = { "dir1", "dir2", "dir3", "dir4" };
	String[] patentes = {"patente1","patente2","patente3","patente4"};
	String[] nombres = {"nombre1","nombre2","nombre3","nombre4","nombre5","nombre6","nombre7","nombre8","nombre9","nombre10","nombre11","nombre12","nombre13","nombre14"};
	String[] numeros = {"1234567"};
	
	
	public SistemaEncomienda() {
		//crearSucursales();
		//rellenarClientes();
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
	public ArrayList<String> getCamionesNombre(Sucursal sucursal){
		
		ArrayList<String> lista = new ArrayList<>();
		for (Camion s : sucursal.listaCamiones) {
			lista.add(s.patente);
		}
		
		return lista;
	}

	public ArrayList<String> getMensajesAsuntos(Sucursal sucursal){
		
		ArrayList<String> lista = new ArrayList<>();
		
		for (Mensaje mensaje : sucursal.listaMensajes) {
			lista.add(mensaje.asunto);
		}
		
		return lista;
	} 
	
	public ArrayList<Mensaje> getMensajes(Sucursal sucursal){
		
		ArrayList<Mensaje> lista = new ArrayList<>();
		
		for (Mensaje mensaje : sucursal.listaMensajes) {
			lista.add(mensaje);
		}
		
		return lista;
	} 
	
	public Sucursal compararSucursal(String comboText){
		
		for(Sucursal s : listaSucursales){
			if(s.nombre == comboText){
				return s;
			}
		}
		return null;
	}
	
	public Mensaje devolverMensaje(String mens, Sucursal suc1, Sucursal suc2, String asunto){
		Mensaje mensaje = new Mensaje(mens, suc1, suc2, asunto);
		return mensaje;
	}
	
	public void enviarMensaje(Sucursal sucursal, Mensaje mensaje){
		for(Sucursal s : listaSucursales){
			if(s == sucursal){
				s.listaMensajes.add(mensaje);
			}
		}
	}
	
	public void eliminarMensaje(Sucursal sucursal, Mensaje mensaje){
		for(Sucursal s : listaSucursales){
			if(s == sucursal){
				s.listaMensajes.remove(mensaje);
			}
		}
	}
	
	
	public ArrayList<String> getClientesNombre(){
		
		ArrayList<String> lista = new ArrayList<>();
		for (Cliente c : listaClientes) {
			lista.add(c.getNombre());
		}
		
		return lista;
	}
	
	public Cliente getClienteAPartirDeNombre(String nombre){
		for (Cliente c : listaClientes) {
			if(c.nombre == nombre){
				return c;
			}
		}
		return null;
	}
	
	public void rellenarClientes(){
		for (int i = 0; i < cantidadDeClientes; i++) {
			agregarCliente("nombre"+i, "numero"+i, "direccion"+i);
		}
	}
	
	public void agregarCliente(String nombre, String numero, String direccion){
		listaClientes.add(new Cliente(nombre, numero, direccion));
	}
	
	public void agregarUnaSucursal(String nombre, String direccion){
		listaSucursales.add(new Sucursal(r.nextInt(99999), direccion, nombre, null, null));
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

	public String getSucursalActual() {
		return sucursalActual;
	}

	public void setSucursalActual(String sucursalActual) {
		this.sucursalActual = sucursalActual;
	}
	
	public Sucursal getSucursalAPartirDeNombre(String n){
		for(Sucursal s : listaSucursales) {
			if(s.nombre == n){
				return s;
			}
		}
		
		return null;
	}
	
	public Pedido getPedidoAPartirDeNombre(String n){
		String aux;
		for (Pedido p : listaPedidos) {
			aux = Integer.toString(p.id);
			if(aux.equals(n)){
				return p;
			}
		}
		return null;
	}
	
	public Camion getCamionAPartirDeNombre(String n, Sucursal s){
		for(Camion c : s.listaCamiones) {
			if(c.patente == n){
				return c;
			}
		}
		
		return null;
	}
	
	public void serialize(){
		//crearSucursales();
	    //rellenarClientes();
		SerializeDemo.serializeListaSucursales(listaSucursales);
		SerializeDemo.serializeListaClientes(listaClientes);
		SerializeDemo.serializeListaPedidos(listaPedidos);
	}
	
	public void deserialize(){
		listaSucursales = Deserialize.deserializeListaSucursales(listaSucursales);
		listaClientes = Deserialize.deserializeListaClientes(listaClientes);
		listaPedidos = Deserialize.deserializeListaPedidos(listaPedidos);
		//System.out.println(listaSucursales);
	}
}
