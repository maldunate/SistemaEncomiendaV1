package frontend.vistas;

import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MenuCajeroController  {


	private MainApp mainApp;
	
	
	
	public MenuCajeroController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerIngresarCliente(){
		mainApp.mostrarMenuIngresarCliente();

	}
	
	@FXML
	private void handlerAtras(){
		mainApp.mostrarMenuComo(SistemaEncomienda.getInstance().getSucursalActual());
	}
	
	@FXML
    private void initialize() {
    	
	
		
    }
	
	@FXML
	private void handlerIngresarPedido(){
		mainApp.mostrarMenuIngresarPedido();

	}
	
    
    @FXML
    void handlerClientePedido() {
    	mainApp.mostrarVerClientePedido();
    }
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
	
}
