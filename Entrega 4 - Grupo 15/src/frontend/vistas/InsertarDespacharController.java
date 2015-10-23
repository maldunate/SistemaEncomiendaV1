package frontend.vistas;

import backend.main;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class InsertarDespacharController {

	private MainApp mainApp;
	
	
	
	public InsertarDespacharController() {
		
	}

	public void start(Stage primaryStage) {
		
	}


	
	@FXML
    private void initialize() {
    	
	
		
    }
	
	@FXML
	private void handlerIngresarEncomienda(){
		mainApp.mostrarMessage("Haz insertado exitosamente la encomienda");//encomienda x
		mainApp.mostrarMenuOperador();

	
	}
	
	@FXML
	private void handlerDespachar(){
		mainApp.mostrarMessage("Haz despachado el camión");
		//rellenar
		mainApp.mostrarMenuOperador();
	}
	
	@FXML
	private void handlerEncomiendaActual(){
		mainApp.mostrarEncomiendaActual(0);

	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
