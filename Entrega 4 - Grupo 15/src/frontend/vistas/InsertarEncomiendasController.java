package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class InsertarEncomiendasController {

private MainApp mainApp;
	
	public InsertarEncomiendasController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerIngresarEncomiendas(){
		mainApp.mostrarMessage("Haz ingresado exitosamente la encomienda, haz click en terminar cuando no quieras agregar m�s encomiendas");
		//rellenar
		mainApp.mostrarInsertarEncomiendas();
	}
	
	@FXML
	private void handlerTerminarPedido(){
		mainApp.mostrarMessage("Haz ingresado exitosamente el pedido");
		//rellenar
		mainApp.mostrarMenuCajero();
	}
	
	@FXML
    private void initialize() {
    	
    }
	
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}