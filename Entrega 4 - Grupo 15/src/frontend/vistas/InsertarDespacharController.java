package frontend.vistas;

import backend.Camion;
import backend.Encomienda;
import backend.SistemaEncomienda;
import backend.Sucursal;
import backend.main;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InsertarDespacharController {

	private MainApp mainApp;
	
	Boolean seleccionado2 = false;
	
	Camion cam = null;
	
	Boolean seleccionado = false;
	
	Encomienda aux;
	
	@FXML
	private Label volumenTotal;
	
	@FXML
	private Label tipo;
	
	@FXML
	private Label nombreSucursalActual;
	
	@FXML
	private Label sucursalDestino;
	
	@FXML
	private Label volumenOcupado;
	
	@FXML
	private ComboBox listaCamiones;
	
	@FXML
	private ComboBox listaEncomiendas;
	
	Sucursal suc = null;
	
	public InsertarDespacharController() {
		
	}

	public void start(Stage primaryStage) {
		
	}


	
	@FXML
    private void initialize() {	
		listaCamiones.setEditable(false);
		listaEncomiendas.setEditable(false);
		for (Sucursal s : SistemaEncomienda.getInstance().getListaSucursales()) {
			if(s.getNombre().equals(SistemaEncomienda.getInstance().getSucursalActual())){
				suc = s;
				break;
			}
		}
		
		listaCamiones.getItems().addAll(SistemaEncomienda.getInstance().getCamionesNombre(suc));
		nombreSucursalActual.setText(SistemaEncomienda.getInstance().getSucursalActual());
	
		
    }
	
	@FXML
	private void handlerIngresarEncomienda(){
		//mainApp.mostrarMessage("Haz insertado exitosamente la encomienda");//encomienda x
		
		mainApp.mostrarInsertarEncomiendaCamion(cam);
		
		
	}
	
	@FXML
	private void handlerListaCamiones(){
		Update();
	
	}
	
	@FXML
	private void handlerListaEncomiendas(){
		seleccionado2 = true;
	}
	
	public void Update(){
		
		for (Camion c : suc.getListaCamiones()) {
			if(c.getPatente().equals(listaCamiones.getValue().toString())){
				cam = c;
				break;
			}
		}
		listaEncomiendas.getItems().clear();
		volumenTotal.setText(Integer.toString(cam.getCapacidad()));
		volumenOcupado.setText(Integer.toString(cam.calcularCapacidad()));
		sucursalDestino.setText(cam.getSucursalDestino().getNombre());
		listaEncomiendas.getItems().addAll(cam.getEncomiendaNombres());
		tipo.setText(cam.nombreTipo());
		seleccionado = true;
	}
	
	@FXML
	private void handlerDespachar(){
		//rellenar
		//Aqui se envía el camion desde la sucursal de origen hacia la de destino, por lo que
		//se elimina de la lista en origen y se agrega a la de camiones arrivados de la destino.
		if(seleccionado){
			suc.getListaCamiones().remove(cam);
			cam.getSucursalDestino().getCamionesConEncomiendas().add(cam);
			seleccionado = false;
			
			//Aqui se cambian los estados de las encomiendas y del camion
			cam.setEstadoEnDestino();
			for(Encomienda e : cam.enCamion){
				e.setEstadoEnDestino();
			}
			
			mainApp.mostrarMessage("Haz despachado el camión");
			mainApp.mostrarMenuOperador();
		}else{
			mainApp.mostrarMessage("Elige un camion para despachar");
		}
	}
	
    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuOperador();
    }
    
	@FXML
	private void handlerEncomiendaActual(){
		if(seleccionado2){			
			for (Encomienda e : cam.enCamion) {
				if(e.nombre.equals(listaEncomiendas.getValue().toString())){
					aux = e;
				}
			}
			if(aux != null){
				mainApp.mostrarEncomiendaActual(0, aux);
			} else {
				mainApp.mostrarMessage("algo pasó");
			}

		} else {
			mainApp.mostrarMessage("Elige encomienda");
		}
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        seleccionado = false;
        seleccionado2 = false;
	}
}
