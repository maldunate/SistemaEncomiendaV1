import java.util.ArrayList;

public class Pedido {

	ArrayList<Encomienda> encomiendasPedido;
	Cliente cliente;
	
	/**
	 * @param encomiendasPedido
	 * @param cliente
	 */
	public Pedido(ArrayList<Encomienda> encomiendasPedido, Cliente cliente) {
		this.encomiendasPedido = encomiendasPedido;
		this.cliente = cliente;
	}
	
	
}
