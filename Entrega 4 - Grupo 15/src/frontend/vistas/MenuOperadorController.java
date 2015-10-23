package frontend.vistas;

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

	@FXML
	private void handlerInsertarDespachar(){
		mainApp.mostrarInsertarDespachar();
	
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
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
	

}
