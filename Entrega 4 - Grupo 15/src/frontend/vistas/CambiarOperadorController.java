package frontend.vistas;

import java.util.ArrayList;

import backend.Operador;
import backend.SistemaEncomienda;
import backend.Sucursal;
import frontend.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CambiarOperadorController {

	MainApp mainApp;
	
	Boolean seleccionado;
	
	Sucursal actual;
	
	Operador operador;
	
    @FXML
    private ComboBox listaOperadores;

    @FXML
    void handlerAtras() {
    	mainApp.mostrarAdministrarSistema();
    }

    @FXML
    void handlerCambiarOperador() {
    	if(seleccionado){
    		actual.setOperador(operador);
    		mainApp.mostrarMessage("Haz cambiado el operador de la sucurusal " + actual.getNombre() + " a " + operador.getNombre());
    		mainApp.mostrarAdministrarSistema();
    	}else{
    		mainApp.mostrarMessage("Elige un operador");
    	}
    }

    @FXML
    void handlerListaOperadores() {
    	seleccionado = true;
    	for(Operador o : actual.listaOperadores) {
			if(listaOperadores.getValue().equals(o.getNombre())){
				operador = o;
			}
		}
    }
    
    @FXML
    private void initialize() {
        actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());
        ArrayList<String> lista = new ArrayList<>();
		for(Operador o : actual.listaOperadores) {
			lista.add(o.getNombre());
		}
		listaOperadores.getItems().addAll(lista);
        seleccionado = false;
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());

    }
}