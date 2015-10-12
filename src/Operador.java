
public class Operador extends Persona{

	Sucursal sucursal;
	public Operador(String nombre, Sucursal sucursal) {
		super(nombre);
		this.sucursal = sucursal;
		// TODO Auto-generated constructor stub
	}

	public void InsertarEncomienda ( Encomienda encomienda ){ //metodo que inserta las encomiendas en los camiones y manda los camiones a la sucursal cuando alcanzan su capacidad
		for (Camion camion : sucursal.listaCamiones) {
			if (camion.enCamion.size() < camion.capacidad && encomienda.estadoEncomienda == EstadoEncomienda.EnOrigen && camion.sucursalDestino == encomienda.sucursalDestino) {
				camion.enCamion.add(encomienda);
				sucursal.listaEncomiendas.remove(encomienda);
				encomienda.setEstadoEncomienda(EstadoEncomienda.EnTransito);
				return;
			}
		}
	}
	
    public Encomienda ElegirEncomienda (){
		
    	return null;
	}
    
    public void EnviarCamion( Camion camion ){ // envia a los camiones
    	camion.estadoCamion = EstadoCamion.EnDestino;
    	camion.sucursalDestino.listaCamiones.add(camion);
    	sucursal.listaCamiones.remove(camion);
    	/*
    	 * for (Encomienda encomienda : camion.enCamion) {
		 *	encomienda.setEstadoEncomienda(EstadoEncomienda.EnDestino);
		 *}
    	*/
    }
    
    public void RecibirCamion (){ //recibe a los camiones y los manda de vuelta
    	for (Camion camion : sucursal.listaCamiones) {
			if (camion.estadoCamion == EstadoCamion.EnDestino) {
				for (Encomienda encomienda : camion.enCamion) {
					encomienda.setEstadoEncomienda(EstadoEncomienda.EnDestino);
					if (encomienda.getSucursalDestino().equals(sucursal)) {
						encomienda.setEstadoEncomienda(EstadoEncomienda.Entregado);
						sucursal.listaEncomiendas.add(encomienda);
						camion.enCamion.remove(encomienda);	
					}
				}
				// SI EL CAMION SE QUEDA CON UNA ENCOMIENDA, ENTONCES HAY QUE CREAR UN MENSAJE
				if (camion.enCamion.size() > 0){
					Mensaje m1 = new Mensaje("Encomienda enviada a sucursal equivocada", camion.getSucursalOrigen(), camion.getSucursalDestino());
					EnviarMensaje(m1);
				}
				camion.setEstadoCamion(EstadoCamion.EnOrigen);
				camion.getSucursalOrigen().listaCamiones.add(camion);
				camion.getSucursalDestino().listaCamiones.remove(camion);
			}
		}
    }
    
    public void EnviarMensaje( Mensaje mensaje){
    	mensaje.destinatario.listaMensajes.add(mensaje);
    }

    public void BorrarMensaje( Mensaje mensaje){
    	this.sucursal.listaMensajes.remove(mensaje);
    }	
}
