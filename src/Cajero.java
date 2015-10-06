
public class Cajero extends Persona {

	Sucursal sucursal;
	Calculadora calculadora = new Calculadora();
	
	public Cajero(String nombre, Sucursal sucursal) {
		super(nombre);
		this.sucursal = sucursal;
		
		// TODO Auto-generated constructor stub
	}

	public void IngresarPedido (Pedido pedido){
		
	}
	
	public void CambiarDireccionEncomienda (Encomienda encomienda, String direccion){
		
	}
	
	public void CambiarSucursalEncomienda (Encomienda encomienda, Sucursal sucursal){
		
	}
}
