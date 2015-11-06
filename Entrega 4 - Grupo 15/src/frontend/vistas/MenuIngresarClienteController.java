package frontend.vistas;

import javax.xml.ws.Dispatch;

import com.sun.javafx.property.adapter.Disposer;

import backend.Cliente;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuIngresarClienteController {

	private MainApp mainApp;
	
	@FXML
	private TextField nombre;

	@FXML
	private TextField direccion;

	@FXML
	private TextField numero;
	
	public MenuIngresarClienteController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerInsertarDespachar(){
		mainApp.mostrarInsertarDespachar();
	}
	
	@FXML
    private void initialize() {
    	nombre.setText("Nombre Cliente");
    	direccion.setText("Direccion Cliente");
    	numero.setText("Numero Cliente");
    }
	
	@FXML
	private void handlerIngresarCliente(){ //Nose porque no toma bien las comparaciones, arreglar para tomar cuando se ingresan dato vacios.
		System.out.println(nombre.getText());
		System.out.println(direccion.getText());
		System.out.println(numero.getText());
		if(nombre.getText() == "Nombre Cliente"){
			mainApp.mostrarMessage("Ingresa el nombre del Cliente");
		}else if(direccion.getText() == "Direccion Cliente"){
			mainApp.mostrarMessage("Ingresa la direccion del Cliente");
		}else if(numero.getText() == "Numero Cliente"){
			mainApp.mostrarMessage("Ingresa el numero del Cliente");
		}else{
			mainApp.mostrarMessage("Haz ingresado al cliente");
			SistemaEncomienda.getInstance().agregarCliente(nombre.getText(), numero.getText(), direccion.getText());
			mainApp.mostrarMenuCajero();
		}
	}
	
	@FXML
	private void handlerMensajes(){
//		mainApp.mostrarMensajes();

	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
