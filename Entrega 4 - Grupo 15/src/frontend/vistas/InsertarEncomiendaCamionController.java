package frontend.vistas;

import java.util.ArrayList;

import backend.Camion;
import backend.Encomienda;
import backend.SistemaEncomienda;
import backend.Sucursal;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsertarEncomiendaCamionController {

	private MainApp mainApp;
	
	Camion cam = null;
	
	
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
	/*	ArrayList<String> encomiendasPosibles = new ArrayList<>();
    	for (Encomienda s : cam.getSucursalOrigen().getListaEncomiendas()) {
    		System.out.println(s);
			if(s.getSucursalDestino().equals(cam.getSucursalDestino())){
				encomiendasPosibles.add(s.nombre);
				System.out.println(s);
			}
		}
		
		listaEncomiendas.getItems().addAll(encomiendasPosibles);
	*/	
    }
	
	
	public void setMainApp(MainApp mainApp, Camion camion) {
        this.mainApp = mainApp;  
        this.cam = camion;
    }
}
