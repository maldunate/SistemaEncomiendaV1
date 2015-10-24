package frontend.vistas;

import backend.SistemaEncomienda;

//import backend.*;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnviarMensajeController {

private MainApp mainApp;
	
	@FXML
	private ComboBox combo; //listaSucursales
	
	@FXML
	private TextArea mensaje;
	
	@FXML
	private TextField asunto;
	
	
	public EnviarMensajeController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerEnviar(){
		if(combo.getValue() != "Sucursal"){
			SistemaEncomienda.getInstance().enviarMensaje(SistemaEncomienda.getInstance().compararSucursal(combo.getValue().toString()), SistemaEncomienda.getInstance().devolverMensaje(mensaje.getText(), SistemaEncomienda.getInstance().compararSucursal(combo.getValue().toString()), SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual()), asunto.getText()));
			mainApp.mostrarMenuComo(SistemaEncomienda.getInstance().getSucursalActual());
			mainApp.mostrarMessage("Haz enviado un mensaje");
		}else{
			mainApp.mostrarMessage("Elige una sucursal");
		}
	}
	
	
	@FXML
	private void handlerCancelar(){
		mainApp.mostrarMenuOperador();
	}
	
	@FXML
    private void initialize() {
		combo.setValue("Sucursal");
    	mostrarSucursales();
    }
	
	private void mostrarSucursales(){
		combo.getItems().addAll(SistemaEncomienda.getInstance().getSucursalesNombre());
	}
	
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
