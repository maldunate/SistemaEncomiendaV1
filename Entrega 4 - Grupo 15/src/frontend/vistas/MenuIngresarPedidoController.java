package frontend.vistas;

import backend.Cliente;
import backend.Pedido;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class MenuIngresarPedidoController  {

	@FXML
	private ComboBox listaClientes;
	
	private MainApp mainApp;
	
	public MenuIngresarPedidoController() {
		
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerIngresarEncomiendas(){
		Cliente cliente = null;
		//System.out.println(listaClientes.getValue());
		for (Cliente c : SistemaEncomienda.getInstance().getListaClientes()) {
			if(c.getNombre().equals(listaClientes.getValue())){
				cliente = c;
			}
		}
		Pedido pedido = new Pedido(cliente);
		SistemaEncomienda.getInstance().getListaPedidos().add(pedido);
		//System.out.println(pedido.getCliente().getNombre());
		mainApp.mostrarInsertarEncomiendas(pedido);
	}
	
	@FXML
    private void initialize() {
    	UpdateClientes();
    }
	
    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuCajero();
    }
	
	public void UpdateClientes(){
		listaClientes.getItems().addAll(SistemaEncomienda.getInstance().getClientesNombre());
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
}
