package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EnviarMensajeController {

private MainApp mainApp;
	
	public EnviarMensajeController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerEnviar(){
		mainApp.mostrarMessage("Haz enviado un mensaje");
		
		//rellenar

		mainApp.mostrarMenuComo(mainApp.sucursalActual);
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
