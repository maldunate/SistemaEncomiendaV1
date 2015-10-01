import java.util.ArrayList;

public class SistemaEncomienda {

	ArrayList<Pedido> listaPedidos;
	ArrayList<Sucursal> listaSucursales;
	ArrayList<Cliente> listaClientes;
	
	
	public void comenzar(){
		System.out.println("comienza el sistema");
	}
	
	public Pedido InsertarPedido (){
		ArrayList<Encomienda> listaEncomienda = null;
		return new Pedido(listaEncomienda, new Cliente());
	}
}
