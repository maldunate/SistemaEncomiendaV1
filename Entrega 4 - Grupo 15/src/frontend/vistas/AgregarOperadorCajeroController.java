package frontend.vistas;

import java.util.ArrayList;

import backend.*;
import frontend.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AgregarOperadorCajeroController {

    @FXML
    private TextField clave;

    @FXML
    private ComboBox opcion;

    @FXML
    private TextField nombre;
    
    Sucursal actual;
    
    Boolean cambiadoNombre;
    Boolean cambiadoClave;
    
    int eleccion;
    
    MainApp mainApp;

    @FXML
    void handlerAgregar() {
    	if(eleccion == 0){
    		mainApp.mostrarMessage("Elige el tipo que quieres crear");
    	}else if(cambiadoNombre == false){
    		mainApp.mostrarMessage("Elige un nombre");
    	}else if(cambiadoClave == false){
    		mainApp.mostrarMessage("Elige una clave");
    	}else if(eleccion == 1){
    		Operador operador = new Operador(nombre.getText(), clave.getText());
    		actual.listaOperadores.add(operador);
        	mainApp.mostrarMessage("Haz agregado al operador " + nombre.getText() + " a la sucursal " + SistemaEncomienda.getInstance().getSucursalActual());
        	mainApp.mostrarAdministrarSucursal();       	
    	}else if(eleccion == 2){
    		Cajero cajero = new Cajero(nombre.getText(), SistemaEncomienda.getInstance(), clave.getText());
    		actual.listaCajeros.add(cajero);
    		mainApp.mostrarMessage("Elige una clave");
        	mainApp.mostrarMessage("Haz agregado al cajero " + nombre.getText() + " a la sucursal " + SistemaEncomienda.getInstance().getSucursalActual());
        	mainApp.mostrarAdministrarSucursal();
    	}else{
    		mainApp.mostrarMessage("Hay un error, intente denuevo.");
    	}
    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarAdministrarSucursal();
    }
    
    @FXML
    void handlerNombre() {
    	cambiadoNombre = true;
    }
    
    @FXML
    void handlerClave() {
    	cambiadoClave = true;
    }

    @FXML
    void handlerOpcion() {
    	if(opcion.getValue().equals("Operador")){ //Eleccion 1 es operador.
    		eleccion = 1;
    	}else if(opcion.getValue().equals("Cajero")){ //Eleccion 2 es cajero.
    		eleccion = 2;
    	}
    }
    
    @FXML
    private void initialize() {	
		eleccion = 0;
		cambiadoNombre = false;
		cambiadoClave = false;
		nombre.setText(null);
		clave.setText(null);
		ArrayList<String> temp = new ArrayList<>();
		temp.add("Operador");
		temp.add("Cajero");
		opcion.getItems().addAll(temp);
		actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
        actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());
    }

}