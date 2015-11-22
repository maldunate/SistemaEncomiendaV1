package frontend.vistas;


import java.util.ArrayList;
import javafx.scene.control.TextField;

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
    private TextField clave;

    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuComo(SistemaEncomienda.getInstance().getSucursalActual());
    }

    @FXML
    void handlerCambiarCajero() {
    	if(seleccionado == false){
    		mainApp.mostrarMessage("Elige un cajero");	
    	}else if(clave.getText().equals(cajero.clave)){
    		actual.setCajero(cajero);
    		mainApp.mostrarMessage("Haz ingresado como " + cajero.getNombre());
    		mainApp.mostrarMenuCajero();	
    	}else{
    		System.out.println(clave.getText());
    		System.out.println(cajero.clave);
    		mainApp.mostrarMessage("La clave es incorrecta, intente denuevo");
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
