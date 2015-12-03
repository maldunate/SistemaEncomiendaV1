package backend;
import java.util.ArrayList;
import java.util.Random;

public class Pedido  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1545348832548877884L;
	public ArrayList<Encomienda> encomiendasPedido;
	Cliente cliente;
	
	int costo;
	int id;

	Random r = new Random();


	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	/**
	 * @param encomiendasPedido
	 * @param cliente
	 */

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.encomiendasPedido = new ArrayList<>();
		this.costo = 0;
		this.id = r.nextInt(99999);
		cliente.listaPedidos.add(this);
	}

	public ArrayList<Encomienda> getEncomiendasPedido() {
		return encomiendasPedido;
	}

	public void setEncomiendasPedido(ArrayList<Encomienda> encomiendasPedido) {
		this.encomiendasPedido = encomiendasPedido;
	}

	public void agregarEncomiendas(Encomienda e) {
		this.encomiendasPedido.add(e);
		costo += e.precio;
	}

	public void sacarEncomienda(Encomienda e){
		costo -= e.precio;
		this.encomiendasPedido.remove(e);
	}
	
	public ArrayList<String> getNombresEncomiendas(){
		ArrayList<String> aux = new ArrayList<>();
		for (Encomienda e : encomiendasPedido) {
			aux.add(e.nombre);
		}
		return aux;
	}
	
	public Encomienda getEncomiendaAPartirDeNombre(String n){
		for (Encomienda e : encomiendasPedido) {
			if(e.nombre == n){
				return e;
			}
		}
		return null;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
