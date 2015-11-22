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
    private TextField Clave;

	@FXML
	private TextField numero;
	
	Boolean nombreCambiado;
	Boolean direccionCambiada;
	Boolean numeroCambiado;
	Boolean claveCambiada;
	
	public MenuIngresarClienteController() {
		
	}

	public void start(Stage primaryStage) {
		
	}
	
	@FXML
    void handlerClave() {
		claveCambiada = true;
    }

	@FXML
	private void handlerInsertarDespachar(){
		mainApp.mostrarInsertarDespachar();
	}
	
	@FXML
	private void handlerNombre(){
		nombreCambiado = true;
	}
	
	@FXML
	private void handlerDireccion(){
		direccionCambiada = true;
	}
	
	@FXML
	private void handlerNumero(){
		numeroCambiado = true;
	}
	
	@FXML
    private void initialize() {
    	//nombre.setText("Nombre Cliente");
    	//direccion.setText("Direccion Cliente");
    	//numero.setText("Numero Cliente");
    	
    	nombreCambiado = false;
    	direccionCambiada = false;
    	numeroCambiado = false;
    	claveCambiada = false;
    }
	
	@FXML
	private void handlerIngresarCliente(){ //Nose porque no toma bien las comparaciones, arreglar para tomar cuando se ingresan datos vacios.
		System.out.println(nombre.getText());
		System.out.println(direccion.getText());
		System.out.println(numero.getText());
		if(nombreCambiado == false){
			mainApp.mostrarMessage("Ingresa el nombre del Cliente");
		}else if(direccionCambiada == false){
			mainApp.mostrarMessage("Ingresa la direccion del Cliente");
		}else if(numeroCambiado == false){
			mainApp.mostrarMessage("Ingresa el numero del Cliente");
		}else if(claveCambiada == false){
			mainApp.mostrarMessage("Ingresa la clave");
		}else{
			mainApp.mostrarMessage("Haz ingresado al cliente");
			SistemaEncomienda.getInstance().agregarCliente(nombre.getText(), numero.getText(), direccion.getText(), Clave.getText());
			mainApp.mostrarMenuCajero();
		}
	}
	
	@FXML
	private void handlerMensajes(){
//		mainApp.mostrarMensajes();

	}
	
    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuCajero();
    }
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
