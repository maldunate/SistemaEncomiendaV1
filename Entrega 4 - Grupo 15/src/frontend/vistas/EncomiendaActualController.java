package frontend.vistas;

import frontend.MainApp;
import backend.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EncomiendaActualController {

	private MainApp mainApp;
	int i;
	Encomienda encomienda;
	
	@FXML
	private Text nombreEncomienda;
	

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
	
	private void Update(){
		nombreEncomienda.setText(encomienda.nombre);
		sucursalDestino.setText(encomienda.getSucursalDestino().getNombre());
		volumen.setText(Integer.toString(encomienda.getVolumen()));
		peso.setText(Integer.toString(encomienda.getPeso()));
		prioridad.setText(Integer.toString(encomienda.getPrioridad()));
		precio.setText(Integer.toString(encomienda.getPrecio()));
		
	}
	
	
	public void setMainApp(MainApp mainApp, int i, Encomienda encomienda) {
        this.mainApp = mainApp;  
        this.i = i;
        this.encomienda = encomienda;
        Update();
    }
}
