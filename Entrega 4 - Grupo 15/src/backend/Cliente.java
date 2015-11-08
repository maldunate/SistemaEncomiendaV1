package backend;

import java.util.ArrayList;

public class Cliente extends Persona{

	String numero;
	String direccion;
	public ArrayList<Pedido> listaPedidos;
	
	/**
	 * @param numero
	 * @param direccion
	 */
	public Cliente(String nombre, String numero, String direccion) {
		super(nombre);
		this.numero = numero;
		this.direccion = direccion;
		this.listaPedidos = new ArrayList<>();
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getValorTotal(){
		int aux = 0;
		if(listaPedidos.size()>0){
			for (Pedido pedido : listaPedidos) {
				aux += pedido.costo;
			}
			return aux;
		} else {
			return 0;	
		}
	}
	
	public ArrayList<String> getNombrePedidos(){
		ArrayList<String> aux = new ArrayList<>();
		if(listaPedidos.size() < 1){
			return aux;
		}
		for (Pedido p : listaPedidos) {
			aux.add(Integer.toString(p.id));
		}
		return aux;
	}
}
	
	

