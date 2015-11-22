package frontend.vistas;

import java.util.ArrayList;

import backend.Cajero;
import backend.Operador;
import backend.SistemaEncomienda;
import backend.Sucursal;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CambiarCajeroController extends Application {

MainApp mainApp;
	
	Boolean seleccionado;
	
	Sucursal actual;
	
	Cajero cajero;
	
    @FXML
    private ComboBox listaCajeros;

    @FXML
    void handlerAtras() {
    	mainApp.mostrarAdministrarSistema();
    }

    @FXML
    void handlerCambiarCajero() {
    	if(seleccionado){
    		actual.setCajero(cajero);
    		mainApp.mostrarMessage("Haz cambiado el cajero de la sucurusal " + actual.getNombre() + " a " + cajero.getNombre());
    		mainApp.mostrarAdministrarSistema();
    	}else{
    		mainApp.mostrarMessage("Elige un cajero");
    	}
    }

    @FXML
    void handlerListaCajeros() {
    	seleccionado = true;
    	for(Cajero c : actual.listaCajeros) {
			if(listaCajeros.getValue().equals(c.getNombre())){
				cajero = c;
			}
		}
    }
    
    @FXML
    private void initialize() {
        actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());
        ArrayList<String> lista = new ArrayList<>();
		for(Cajero c : actual.listaCajeros) {
			lista.add(c.getNombre());
		}
		listaCajeros.getItems().addAll(lista);
        seleccionado = false;
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());

    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
