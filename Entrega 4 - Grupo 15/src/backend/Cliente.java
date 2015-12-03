package backend;

import java.util.ArrayList;

public class Cliente extends Persona{

	String numero;
	String direccion;
	public String clave;
	public ArrayList<Pedido> listaPedidos;
	double coeficiente_frecuente;

	/**
	 * @param numero
	 * @param direccion
	 */
	public Cliente(String nombre, String numero, String direccion, String clave) {
		super(nombre);
		this.numero = numero;
		this.direccion = direccion;
		this.listaPedidos = new ArrayList<>();
		this.coeficiente_frecuente = 0;
		this.clave = clave;
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

	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public double getCoeficiente_frecuente() {
		return coeficiente_frecuente;
	}

	public void setCoeficiente_frecuente() {
		int sum = 0;
		int lenpedidos = 0;
		int cienkilos = 0;
		int cienlitros = 0;
		int mismadireccion = 0;
		int encomiendasenorigen = 0;
		double coef_gasto;
		double coef = 0;
		//calcula descuento segun cuanto ha gastado el cliente.
		for (Pedido p: listaPedidos){
			lenpedidos += p.encomiendasPedido.size();
			for (Encomienda e: p.encomiendasPedido){
				sum += e.precio;
				if (e.getEstadoEncomiendaString() == "EnOrigen"){
					encomiendasenorigen += 1;
				}
				if (e.getPeso()>100){
					cienkilos += 1;
				}
				if (e.getVolumen()>1000000);{
					cienlitros += 1;
				}
			}
		}
		coef_gasto = Math.log10(sum)*(1/100);
		if (lenpedidos > 20){
			coef += 0.1;
		}
		if (listaPedidos.size() > 5){
			coef += 0.1;
		}
		if (coef_gasto> 0.2){
			coef += 0.2;
			}
		if (coef_gasto<0.2){
			coef += coef_gasto;
			}
		if (cienkilos > 0){
			coef += 0.1;
		}
		if (cienlitros > 0){
			coef += 0.1;
		}
		for (Pedido p: listaPedidos){
			for (Encomienda e: p.encomiendasPedido){
				for (Encomienda e1: p.encomiendasPedido){
					if (e.getDireccionFinal() == e1.getDireccionFinal() && e.getNombre() != e1.getNombre()){
						mismadireccion += 1;
					}
				}
			}
		}
		if (mismadireccion > 10){
			coef += 0.1;
		}
		if (coef == 0.7){
			coef += 0.3;
		}
		if (encomiendasenorigen > 10){
			coef += 0.3;
		}
		this.coeficiente_frecuente = coef;


	}
}



