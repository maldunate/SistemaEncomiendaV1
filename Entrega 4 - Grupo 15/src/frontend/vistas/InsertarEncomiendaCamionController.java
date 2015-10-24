package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsertarEncomiendaCamionController {

	private MainApp mainApp;
	
	@FXML
	private ComboBox listaEncomiendas;
	

	@FXML
	private Text sucursalDestino;
	
	@FXML
	private Text direccionFinal;
	
	@FXML
	private Text peso;
	
	@FXML
	private Text precio;
	
	@FXML
	private Text volumen;
	
	@FXML
	private Text prioridad;
	
	public InsertarEncomiendaCamionController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerAtras(){
		mainApp.mostrarInsertarDespachar();
	}


	@FXML
	private void handlerInsertar(){
		mainApp.mostrarMessage("Haz insertado la encomienda");
		
		//rellenar
		
		mainApp.mostrarInsertarDespachar();
	}

	@FXML
    private void initialize() {
    	
	
		
    }
	
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;  
    }
}
