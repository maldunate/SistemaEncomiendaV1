package frontend.vistas;

import backend.*;
import java.util.ArrayList;

import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class VerMensajeController  {

	@FXML
	private ComboBox listaMensajes; //listaSucursales
	
	@FXML
	private TextArea mensaje;
	
	@FXML
	private Label sucursal;
	
	private MainApp mainApp;
	
	Mensaje temp;
	
	public VerMensajeController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerEliminar(){
		mainApp.mostrarMessage("Haz eliminado el mensaje");
		
		ArrayList<Mensaje> lista = SistemaEncomienda.getInstance().getMensajes(SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual()));
		
		for(Mensaje m : lista){
			if(m.asunto == listaMensajes.getValue().toString()){
				temp = m;
			}
		}
		SistemaEncomienda.getInstance().eliminarMensaje(SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual()), temp);
		
		mainApp.mostrarVerMensaje();
	}
	
	@FXML
	private void handlerSalir(){
		mainApp.mostrarMenuOperador();
	}
	
	@FXML
    private void initialize() {
    	UpdateAsuntos();
    }
	
	@FXML
	private void handlerCombobox(){
		Actualizar();
	}
	
	private void Actualizar(){
		ArrayList<Mensaje> lista = SistemaEncomienda.getInstance().getMensajes(SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual()));
		
		for(Mensaje m : lista){
			if(m.asunto == listaMensajes.getValue().toString()){
				temp = m;
			}
		}
		mensaje.setText(temp.texto);
		sucursal.setText(temp.origen.getNombre());
	}
	
	public void UpdateAsuntos(){
		
		listaMensajes.getItems().addAll(SistemaEncomienda.getInstance().getMensajesAsuntos(SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual())));
		
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
