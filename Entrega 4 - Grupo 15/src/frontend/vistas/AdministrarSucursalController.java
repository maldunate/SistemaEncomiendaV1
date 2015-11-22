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
    	Operador op = new Operador(nombre.getText());
    	SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual()).listaOperadores.add(op);
    	mainApp.mostrarMessage("Haz agregado al operador " + nombre.getText() + " a la sucursal " + SistemaEncomienda.getInstance().getSucursalActual());
    }
    
    @FXML
    void handlerCambiarOperador() {
    	mainApp.mostrarCambiarOperador();
    }

    @FXML
    void handlerCajero() {
    	Cajero cajero = new Cajero(nombre.getText(), SistemaEncomienda.getInstance());
    	SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual()).listaCajeros.add(cajero);
    	mainApp.mostrarMessage("Haz agregado al cajero " + nombre.getText() + " a la sucursal " + SistemaEncomienda.getInstance().getSucursalActual());
    }
    
    @FXML
    void handlerCambiarCajero() {
    	mainApp.mostrarCambiarCajero();
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
