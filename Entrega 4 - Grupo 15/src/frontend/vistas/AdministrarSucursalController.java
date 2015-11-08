package frontend.vistas;

import backend.Cajero;
import backend.Operador;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdministrarSucursalController extends Application {

	MainApp mainApp;
	
	@FXML
	private TextField nombre;
	   
    @FXML
    private Label sucursal;

    @FXML
    void handlerOperador() {
    	SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual()).setOperador(new Operador(nombre.getText()));
    	mainApp.mostrarMessage("Haz seteado al operador " + nombre.getText() + " en " + SistemaEncomienda.getInstance().getSucursalActual());
    }

    @FXML
    void handlerCajero() {
    	SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual()).setCajero(new Cajero(nombre.getText(), SistemaEncomienda.getInstance()));
    	mainApp.mostrarMessage("Haz seteado al cajero " + nombre.getText() + " en " + SistemaEncomienda.getInstance().getSucursalActual());
    }

    @FXML
    void handlerAgregarOQuitarCamiones() {
    	mainApp.mostrarAdministrarCamiones();
    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarAdministrarSistema();
    }
    
	public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        sucursal.setText(SistemaEncomienda.getInstance().getSucursalActual());
    }
	
	@Override
	public void start(Stage primaryStage) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
