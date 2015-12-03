package frontend.vistas;

import java.util.ArrayList;

import backend.*;
import frontend.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class VerErroresOperariosController {

    @FXML
    private TextArea Registro;

    @FXML
    private ComboBox listaOperadores;

    @FXML
    private ComboBox Errores;
    
    MainApp mainApp = new MainApp();
    
    Sucursal actual;
    Operador operador;
    MensajeError mensaje;
    
    Boolean seleccionado;

    @FXML
    void handlerEliminar() {

    	if(seleccionado){
    		operador.listaErrores.remove(mensaje);
    		mainApp.mostrarMessage("Haz eliminado el mensaje");
    	mainApp.mostrarVerErroresOperarios();
    	}else{
    		mainApp.mostrarMessage("Elija un mensaje que eliminar.");
    	}

    	
    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuOperador();
    }

    @FXML
    void handlerTexto() {

    }

    @FXML
    void handlerListaOperadores() {
    	for(Operador o : actual.listaOperadores){
    		if(o.getNombre().equals(listaOperadores.getValue())){
    			operador = o;
    		}
    	}
    	ArrayList<String> lista = new ArrayList<>();
		for(MensajeError m : operador.listaErrores) {
			lista.add(Integer.toString(m.i));	
		}
		Errores.getItems().addAll(lista);
    }

    @FXML
    void handlerErrores() {
    	for(MensajeError m : operador.listaErrores){
    		if(Errores.getValue().equals(Integer.toString(m.i))){
    			mensaje = m;
    		}
    	}
    	Registro.setText(mensaje.mensaje);
    	seleccionado = true;
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
