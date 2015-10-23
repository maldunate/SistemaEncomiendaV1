package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuIngresarClienteController {

	private MainApp mainApp;
	
	@FXML
	private TextField nombre;

	@FXML
	private TextField direccion;

	@FXML
	private TextField numero;
	
	public MenuIngresarClienteController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerInsertarDespachar(){
		mainApp.mostrarInsertarDespachar();
	}
	
	@FXML
    private void initialize() {
    	
    }
	
	@FXML
	private void handlerIngresarCliente(){
		mainApp.mostrarMessage("Haz ingresado al cliente");
		//rellenar
		mainApp.mostrarMenuCajero();
	}
	
	@FXML
	private void handlerMensajes(){
//		mainApp.mostrarMensajes();

	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
