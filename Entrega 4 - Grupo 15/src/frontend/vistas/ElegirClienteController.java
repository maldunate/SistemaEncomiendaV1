package frontend.vistas;

import backend.Cliente;
import backend.Pedido;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ElegirClienteController  {

	@FXML
	private ComboBox listaClientes;

	private MainApp mainApp;
	
	Boolean elegido;
	
	int i;

	public ElegirClienteController() {
		
	}

	public void start(Stage primaryStage) {

	}
	
	@FXML
	private void handlerElegirCliente(){
		elegido = true;
	}

	@FXML
	private void handlerIngresarEncomiendas(){
		if(elegido){
			Cliente cliente = null;
			//System.out.println(listaClientes.getValue());
			for (Cliente c : SistemaEncomienda.getInstance().getListaClientes()) {
			if(c.getNombre().equals(listaClientes.getValue())){
				cliente = c;
				}
			}
			mainApp.mostrarMenuCliente(cliente);
			elegido = false;
		}else{
			mainApp.mostrarMessage("Elija un Cliente");
		}
	}

	@FXML
    private void initialize() {
    	UpdateClientes();
    	elegido = false;
    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuComo(SistemaEncomienda.getInstance().getSucursalActual());;
    }

	public void UpdateClientes(){
		listaClientes.getItems().addAll(SistemaEncomienda.getInstance().getClientesNombre());
	}

	public void setMainApp(MainApp mainApp, int i) {
        this.mainApp = mainApp;
        this.i = i;
    }
}