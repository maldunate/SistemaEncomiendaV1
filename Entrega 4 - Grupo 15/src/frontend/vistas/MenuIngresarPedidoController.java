package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class MenuIngresarPedidoController  {

	@FXML
	private ComboBox listaClientes;
	
	private MainApp mainApp;
	
	public MenuIngresarPedidoController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerIngresarEncomiendas(){
		System.out.println("LLEUGU");
		mainApp.mostrarInsertarEncomiendas();
	}
	
	@FXML
    private void initialize() {
    	
    }
	
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
