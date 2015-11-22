package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

import backend.*;

public class RecibirCamionController  {

	@FXML
	private ComboBox listaCamiones;
	
	@FXML
	private ComboBox listaEncomiendas;
	
	@FXML
	private Label sucursalDestino;

	@FXML
	private Label nombreSucursalActual;

	@FXML
	private Label direccionFinalEncomienda;
	
	Sucursal actual = null;
	
	Boolean elegida = false;
	
	Boolean seleccionado = false;
	
	Encomienda encomienda;

	Camion cam = null;
	
	private MainApp mainApp;
	
	
	public RecibirCamionController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
    private void initialize() {
		listaCamiones.setEditable(false);
		listaEncomiendas.setEditable(false);
		//actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());
		for (Sucursal s : SistemaEncomienda.getInstance().getListaSucursales()) {
			if(s.getNombre().equals(SistemaEncomienda.getInstance().getSucursalActual())){
				actual = s;
				break;					}
			}
		ArrayList<String> temp = new ArrayList<>();
		for(Camion c : actual.getCamionesConEncomiendas()){
			temp.add(c.getPatente());
		}
		listaCamiones.getItems().addAll(temp);
    }
		
	@FXML
	private void handlerRecibir(){
		if(seleccionado){
			//Cambios respectivos al recibir el camion
			cam.getSucursalDestino().getCamionesConEncomiendas().remove(cam);
			cam.getSucursalOrigen().getListaCamiones().add(cam);
			cam.enCamion.clear();
			for(Encomienda e: cam.enCamion){
				e.setEstadoEntregado();
			}
			seleccionado = false;
			mainApp.mostrarMessage("Haz recibido el camion");
			mainApp.mostrarMenuOperador();
		}else{
			mainApp.mostrarMessage("Elige un cambi�n que recibir.");
		}
		
		
		//rellenar
		

	}
	
    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuOperador();
    }
    
	@FXML
	private void handlerEncomiendaActual(){
		if(elegida){
			mainApp.mostrarEncomiendaActual(1, encomienda);
			elegida = false;
		}else{
			mainApp.mostrarMessage("Elige una encomienda");
		}
	}
	
	@FXML
	private void handlerListaEncomiendas(){
		for(Encomienda e : cam.enCamion){
			if(e.nombre == listaEncomiendas.getValue().toString()){
				encomienda = e;
				elegida = true;
			}
		}
	}
	
	@FXML
	private void handlerListaCamiones(){
		Update();
	}
	
	private void Update(){
		for (Camion c : actual.getCamionesConEncomiendas()) {
			if(c.getPatente().equals(listaCamiones.getValue().toString())){
				cam = c;
				break;
			}
		}
		listaEncomiendas.getItems().addAll(cam.getEncomiendaNombres());
		seleccionado = true;
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
