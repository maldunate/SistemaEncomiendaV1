package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class VerMensajeController  {

	@FXML
	private ComboBox listaMensajes; //listaSucursales
	
	@FXML
	private TextArea mensaje;
	
	@FXML
	private Label sucursal;
	
	private MainApp mainApp;
	
	public VerMensajeController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerEliminar(){
		mainApp.mostrarMessage("Haz eliminado el mensaje");
		
		//rellenar

		mainApp.mostrarVerMensaje();
	}
	
	@FXML
	private void handlerSalir(){
		mainApp.mostrarMenuOperador();
	}
	
	@FXML
    private void initialize() {
    	
    }
	
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
