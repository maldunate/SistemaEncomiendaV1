package frontend.vistas;

import backend.Cliente;
import backend.Pedido;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ElegirClienteController  {

	@FXML
	private ComboBox listaClientes;
	
	@FXML
    private TextField clave;

	private MainApp mainApp;
	
	Boolean elegido;
	
	Cliente cliente = null;
	
	int i;

	public ElegirClienteController() {
		
	}

	public void start(Stage primaryStage) {

	}
	
	@FXML
	private void handlerElegirCliente(){
		elegido = true;
		for (Cliente c : SistemaEncomienda.getInstance().getListaClientes()) {
		if(c.getNombre().equals(listaClientes.getValue())){
			cliente = c;
			}
		}
	}

	@FXML
	private void handlerIngresarEncomiendas(){
		if(elegido == false){
			mainApp.mostrarMessage("Elija un Cliente");		
		}else if(clave.getText().equals(cliente.clave)){
			mainApp.mostrarMenuCliente(cliente);
			mainApp.mostrarMessage("Haz ingresado como " + cliente.getNombre());
			elegido = false;
		}else{
			mainApp.mostrarMessage("La clave es incorrecta, intente denuevo.");
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