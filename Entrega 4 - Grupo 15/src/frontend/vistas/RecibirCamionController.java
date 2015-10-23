package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class RecibirCamionController  {

	private MainApp mainApp;
	
	
	public RecibirCamionController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
    private void initialize() {
    			
    }
		
	@FXML
	private void handlerRecibir(){
		mainApp.mostrarMessage("Haz recibido el camion");
		//rellenar
		mainApp.mostrarMenuOperador();

	}
	
	@FXML
	private void handlerEncomiendaActual(){
		mainApp.mostrarEncomiendaActual(1);

	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
