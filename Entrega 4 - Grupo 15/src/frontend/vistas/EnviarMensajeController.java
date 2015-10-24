package frontend.vistas;

import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnviarMensajeController {

private MainApp mainApp;
	
	@FXML
	private ComboBox combo; //listaSucursales
	
	@FXML
	private TextArea mensaje;
	
	@FXML
	private TextField asunto;
	
	
	public EnviarMensajeController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerEnviar(){
		mainApp.mostrarMessage("Haz enviado un mensaje");
		
		//rellenar

		mainApp.mostrarMenuComo(SistemaEncomienda.getInstance().getSucursalActual());
	}
	
	@FXML
	private void handlerCancelar(){
		mainApp.mostrarMenuOperador();
	}
	
	@FXML
    private void initialize() {
    	
    }
	
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
