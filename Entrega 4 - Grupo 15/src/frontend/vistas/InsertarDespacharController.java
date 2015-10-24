package frontend.vistas;

import backend.Camion;
import backend.SistemaEncomienda;
import backend.Sucursal;
import backend.main;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InsertarDespacharController {

	private MainApp mainApp;

	Camion cam = null;
	
	@FXML
	private Label volumenTotal;
	
	@FXML
	private Label nombreSucursalActual;
	
	@FXML
	private Label sucursalDestino;
	
	@FXML
	private Label volumenOcupado;
	
	@FXML
	private ComboBox listaCamiones;
	
	@FXML
	private ComboBox listaEncomiendas;
	
	Sucursal suc = null;
	
	public InsertarDespacharController() {
		
	}

	public void start(Stage primaryStage) {
		
	}


	
	@FXML
    private void initialize() {
		
		for (Sucursal s : SistemaEncomienda.getInstance().getListaSucursales()) {
			if(s.getNombre().equals(SistemaEncomienda.getInstance().getSucursalActual())){
				suc = s;
				break;
			}
		}
		
		listaCamiones.getItems().addAll(SistemaEncomienda.getInstance().getCamionesNombre(suc));
		nombreSucursalActual.setText(SistemaEncomienda.getInstance().getSucursalActual());
	
		
    }
	
	@FXML
	private void handlerIngresarEncomienda(){
		//mainApp.mostrarMessage("Haz insertado exitosamente la encomienda");//encomienda x
		mainApp.mostrarInsertarEncomiendaCamion(cam);

	
	}
	
	@FXML
	private void handlerListaCamiones(){
		Update();
	
	}
	
	public void Update(){
		
		for (Camion c : suc.getListaCamiones()) {
			if(c.getPatente().equals(listaCamiones.getValue().toString())){
				cam = c;
				break;
			}
		}
		volumenTotal.setText(Integer.toString(cam.getCapacidad()));
		volumenOcupado.setText(Integer.toString(cam.calcularCapacidad()));
		sucursalDestino.setText(cam.getSucursalDestino().getNombre());
		listaEncomiendas.getItems().addAll(cam.getEncomiendaNombres());
		
	}
	
	@FXML
	private void handlerDespachar(){
		mainApp.mostrarMessage("Haz despachado el cami�n");
		//rellenar
		mainApp.mostrarMenuOperador();
	}
	
	@FXML
	private void handlerEncomiendaActual(){
		mainApp.mostrarEncomiendaActual(0);

	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
