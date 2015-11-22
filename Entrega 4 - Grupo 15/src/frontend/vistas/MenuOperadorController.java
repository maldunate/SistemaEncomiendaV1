package frontend.vistas;

import java.util.ArrayList;

import backend.Encomienda;
import backend.SistemaEncomienda;
import backend.Sucursal;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MenuOperadorController {


	private MainApp mainApp;
	
	public MenuOperadorController() {
		
	}

	public void start(Stage primaryStage) {
		
	}
	public String msje = "Las encomiendas de mayor prioridad que no han sido enviadas son:";
	public ArrayList<Encomienda> encom = new ArrayList<>();
	
	private void notificacion(){
        System.out.println(msje);
		Sucursal actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());
		for (Encomienda e: actual.getListaEncomiendas()){
			if (e.getPrioridad() == 1){
				encom.add(e);
				}
			}
		for (Encomienda f: encom){
			msje += " " + f.getNombre() + ", con destino a sucursal " + f.getSucursalDestino().getNombre() + ".";
		}
		System.out.println(msje);
		mainApp.mostrarMessage(msje);
		}
	@FXML
	private void handlerInsertarDespachar(){
		notificacion();
		mainApp.mostrarInsertarDespachar();
	
	}
	
	@FXML
	private void handlerVerErrores(){
		mainApp.mostrarVerErroresOperarios();
	}
	
	@FXML
	private void handlerRegistrarError(){
		mainApp.mostrarRegistrarError();
	}
	
	@FXML
    private void initialize() {
    	
    }
	
	@FXML
	private void handlerRecepcion(){
		mainApp.mostrarRecibirCamion();
	}
	
	@FXML
	private void handlerMensajes(){
		mainApp.mostrarEnviarMensaje();

	}
	
	@FXML
	private void handlerVerMensajes(){
		mainApp.mostrarVerMensaje();

	}
	
    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuComo(SistemaEncomienda.getInstance().getSucursalActual());
    }
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
	

}
