package frontend.vistas;

import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdministrarCamionesController extends Application {

	MainApp mainApp;
	
	Boolean selected = false;
	
    @FXML
    private ComboBox sucursalDestino;

    @FXML
    private ComboBox listaCamiones;
    
    @FXML
    private ComboBox tipoCamion;

    @FXML
    private Label nombreSucursalActual;

    @FXML
    private TextField patente;

    @FXML
    private TextField capacidad;

    @FXML
    void handlerListaCamiones() {
    	selected = true;
    	patente.setText(SistemaEncomienda.getInstance().getCamionAPartirDeNombre(listaCamiones.getValue().toString(), SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual())).getPatente());
    	capacidad.setText(Integer.toString(SistemaEncomienda.getInstance().getCamionAPartirDeNombre(listaCamiones.getValue().toString(), SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual())).getCapacidad()));
    	sucursalDestino.setValue(SistemaEncomienda.getInstance().getCamionAPartirDeNombre(listaCamiones.getValue().toString(), SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual())).getSucursalDestino().getNombre());
    }

    @FXML
    void handlerQuitar() {
    	if(selected){
    		SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual()).getListaCamiones().remove(SistemaEncomienda.getInstance().getCamionAPartirDeNombre(listaCamiones.getValue().toString(), SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual())));
    		mainApp.mostrarAdministrarSucursal();
    	} else {
    		mainApp.mostrarMessage("Elige un camion");
    	}
    }

    @FXML
    void handlerAgregar() {
    	if(!selected && isInteger(capacidad.getText()) && SistemaEncomienda.getInstance().isTipo(tipoCamion.getValue().toString())){
    		SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual()).agregarCamion(patente.getText(), Integer.parseInt(capacidad.getText()), SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(sucursalDestino.getValue().toString()), tipoCamion.getValue().toString());
    		mainApp.mostrarMessage("Haz agregado el camion exitosamente!");
    		mainApp.mostrarAdministrarSucursal();
    	} else {
    		mainApp.mostrarMessage("No selecciones un camion");
    		mainApp.mostrarAdministrarCamiones();
    	}
    }
    
    @FXML
    void handlerTipo() {

    }
    
    @FXML
    void handlerSucursalDestino() {
  
    
    }
    
    public boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarAdministrarSucursal();
    }
    
	@Override
	public void start(Stage primaryStage) {
		
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;  
        
        nombreSucursalActual.setText(SistemaEncomienda.getInstance().getSucursalActual());
        if (SistemaEncomienda.getInstance().getCamionesNombre(SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual())) != null) {
        	listaCamiones.getItems().addAll(SistemaEncomienda.getInstance().getCamionesNombre(SistemaEncomienda.getInstance().getSucursalAPartirDeNombre(SistemaEncomienda.getInstance().getSucursalActual())));
        }
        sucursalDestino.getItems().addAll(SistemaEncomienda.getInstance().getSucursalesNombre());
        tipoCamion.getItems().add("Normal");
        tipoCamion.getItems().add("Fragil");
        tipoCamion.getItems().add("Frio");
        tipoCamion.getItems().add("Caliente");
        tipoCamion.getItems().add("Radiactivo");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
