package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class CajeroOperadorController {

	private MainApp mainApp;
	
	
	
	public CajeroOperadorController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerCajero(){
		mainApp.mostrarCambiarCajero();
		//mainApp.mostrarMenuCajero();
	
	}
	
	@FXML
	private void handlerCliente(){
		mainApp.mostrarMenuIngresarPedidoCliente();
	
	}
	
	@FXML
	private void handlerAtras(){
		mainApp.showBienvenida();
	
	}
	
	@FXML
    private void initialize() {
    	
	
		
    }
	
	@FXML
	private void handlerOperador(){
		mainApp.mostrarCambiarOperador();
		//mainApp.mostrarMenuOperador();

	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
	

}
