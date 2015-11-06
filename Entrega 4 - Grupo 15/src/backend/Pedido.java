package backend;
import java.util.ArrayList;

public class Pedido {

	public ArrayList<Encomienda> encomiendasPedido;
	Cliente cliente;
	int costo;



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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
