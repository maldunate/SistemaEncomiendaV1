import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

public class SistemaEncomienda {

	ArrayList<Pedido> listaPedidos;
	ArrayList<Sucursal> listaSucursales;
	ArrayList<Cliente> listaClientes;
	String[] direcciones = { "dir1", "dir2", "dir3", "dir4" };
	String[] patentes = {"patente1","patente2","patente3","patente4"};
	String[] nombres = {"nombre1","nombre2","nombre3","nombre4","nombre5","nombre6","nombre7","nombre8","nombre9","nombre10","nombre11","nombre12","nombre13","nombre14"};
	String[] numeros = {"1234567"};
	
	
	public void comenzar(){
		System.out.println("comienza el sistema");
	}
	
	public Pedido InsertarPedido (){
		ArrayList<Encomienda> listaEncomienda = null;
		return new Pedido(listaEncomienda, new Cliente());
	}
	
	public void Simulacion(){
		Camion camion1 = new Camion();
		listaSucursales.add(new Sucursal())
		
	}
}
