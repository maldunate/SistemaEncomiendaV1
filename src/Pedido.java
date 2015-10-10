import java.util.ArrayList;

public class Pedido {

	ArrayList<Encomienda> encomiendasPedido;
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
	}
	
	public ArrayList<Encomienda> getEncomiendasPedido() {
		return encomiendasPedido;
	}

	public void setEncomiendasPedido(ArrayList<Encomienda> encomiendasPedido) {
		this.encomiendasPedido = encomiendasPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
}
