
public class Cajero extends Persona {

	Sucursal sucursal;
	SistemaEncomienda sistema;
	//Calculadora calculadora = new Calculadora();
	
	public Cajero(String nombre, Sucursal sucursal, SistemaEncomienda sistema) {
		super(nombre);
		this.sucursal = sucursal;
		this.sistema = sistema;
		
		// TODO Auto-generated constructor stub
	}
	
	public void IngresarPedido(String nombre, String numero, String direccion ){
		Cliente cliente = IngresarCliente(nombre, numero, direccion); //aca debiera ir una ventana que me pregunta los datos del cliente
		Pedido pedido = new Pedido(cliente);
		Boolean seguir = true;
		while(seguir){//se va a preguntar cuantas encomiendas se quieren insertar
			seguir = Testing.PedirDatosEncomienda(pedido, this); //este metodo debiera abrir una ventana que me pregunte los datos de mi encomienda y al final me pregunta si quiero seguir ingresando o finalizar
		}
		sistema.listaPedidos.add(pedido);
		pedido.setCosto(CalcularPrecio(pedido));
	}
	
    public void IngresarEncomienda (Pedido pedido, Sucursal sucursalOrigen, Sucursal sucursalDestino, int volumen, int peso, int prioridad){
		pedido.encomiendasPedido.add(new Encomienda(sucursalOrigen, sucursalDestino, volumen, peso, prioridad));
	}
	
    public Cliente IngresarCliente(String nombre, String numero, String direccion){
    	return new Cliente(nombre, numero,direccion);
    }
	
	public void CambiarSucursalEncomienda (Encomienda encomienda, Sucursal sucursal){
		encomienda.setSucursalDestino(sucursal);
	}
	
	public int CalcularPrecio (Pedido pedido){
		return Calculadora.calcular(pedido);
	}
}
