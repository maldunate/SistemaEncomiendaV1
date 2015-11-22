package frontend.vistas;

import javafx.scene.control.TextField;
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
    private TextField clave;
	
    @FXML
    private ComboBox listaOperadores;

    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuComo(SistemaEncomienda.getInstance().getSucursalActual());
    }

    @FXML
    void handlerCambiarOperador() {
    	if(seleccionado == false){
    		mainApp.mostrarMessage("Elige un operador");	
    	}else if(clave.getText().equals(operador.clave)){
    		actual.setOperador(operador);
    		mainApp.mostrarMessage("Haz ingresado como " + operador.getNombre());
    		mainApp.mostrarMenuOperador();	
    	}else{
    		System.out.println(clave.getText());
    		System.out.println(operador.clave);
    		mainApp.mostrarMessage("La clave es incorrecta, intente denuevo");
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