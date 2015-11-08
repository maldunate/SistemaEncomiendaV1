package frontend.vistas;

import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IngresarSucursalController extends Application {


	MainApp mainApp;
	
    @FXML
    private TextField direccion;

    @FXML
    private TextField nombre;

    @FXML
    void handlerIngresarSucursal() {
    	if(direccion.getText().length() > 1 && nombre.getText().length() > 1){
    		SistemaEncomienda.getInstance().agregarUnaSucursal(nombre.getText(), direccion.getText());
    		mainApp.mostrarAdministrarSistema();
    	} else {
    		mainApp.mostrarMessage("Ingresa bien los datos cara de poto o pon un nombre más largo");
    	}
    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarAdministrarSistema();
    }
	
	@Override
	public void start(Stage primaryStage) {
		
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
       // System.out.println("El texto es: ." + nombre.getText() + ".");   
        //System.out.println(direccion.getText());
    }

	public static void main(String[] args) {
		launch(args);
	}
}
