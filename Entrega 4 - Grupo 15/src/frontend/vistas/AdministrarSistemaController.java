package frontend.vistas;

import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class AdministrarSistemaController {

	
	MainApp mainApp;
	Boolean selected = false;
	
    @FXML
    private ComboBox listaSucursales;

    @FXML
    void buttonAdministrarSucursal() {
    	if(selected){
    		//System.out.println(listaSucursales.getValue());
    		SistemaEncomienda.getInstance().setSucursalActual(listaSucursales.getValue().toString());
    		mainApp.mostrarAdministrarSucursal();
    	} else {
    		mainApp.mostrarMessage("Selecciona una sucursal brother");
    	}
    }

    @FXML
    void buttonAgragarSucursal() {
    	mainApp.mostrarIngresarSucursal();
    }

    @FXML
    void handlerMenuPrincipal() {
    	mainApp.showBienvenida();
    }
    
    @FXML
    void handlerListaSucursales() {
    	selected = true;
    }

    private void initialize() {
		UpdateSucursales();		
    }
	
	public void UpdateSucursales(){
	
		listaSucursales.getItems().addAll(SistemaEncomienda.getInstance().getSucursalesNombre());
		
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        initialize();
        
    }

}
