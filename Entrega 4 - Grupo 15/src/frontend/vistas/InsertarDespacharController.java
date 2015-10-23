package frontend.vistas;

import backend.main;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InsertarDespacharController {

	private MainApp mainApp;

	@FXML
	private Label volumenTotal;
	
	@FXML
	private Label nombreSucursalActual;
	
	@FXML
	private Label sucursalDestino;
	
	@FXML
	private Label volumenOcupado;
	
	@FXML
	private ComboBox listaCamiones;
	
	@FXML
	private ComboBox listaEncomiendas;
	
	public InsertarDespacharController() {
		
	}

	public void start(Stage primaryStage) {
		
	}


	
	@FXML
    private void initialize() {
    	
	
		
    }
	
	@FXML
	private void handlerIngresarEncomienda(){
		//mainApp.mostrarMessage("Haz insertado exitosamente la encomienda");//encomienda x
		mainApp.mostrarInsertarEncomiendaCamion();

	
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
