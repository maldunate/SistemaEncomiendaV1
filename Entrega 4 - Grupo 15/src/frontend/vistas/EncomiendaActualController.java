package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EncomiendaActualController {

	private MainApp mainApp;
	int i;
	
	
	
	public EncomiendaActualController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerAtras(){
		if (i==1){
		mainApp.mostrarRecibirCamion();
		} else if (i==0) {
			mainApp.mostrarInsertarDespachar();
			
		}
	}
	
	@FXML
    private void initialize() {
    	
	
		
    }
	
	
	public void setMainApp(MainApp mainApp, int i) {
        this.mainApp = mainApp;  
        this.i = i;
    }
}
