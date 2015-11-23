package frontend.vistas;

import backend.Cliente;
import backend.Pedido;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.Stage;

public class MenuClienteController extends Application {

	private MainApp mainApp;
	
	Cliente cliente;
	int i = 1;
	
	@Override
	public void start(Stage primaryStage) {
		
	}
	
	public MenuClienteController() {

	}
	
	@FXML
	private void handlerVerPedidos(){
		mainApp.mostrarVerPedidosCliente(cliente);
	}
	
	@FXML 
	private void handlerCrearPedido(){
		Pedido pedido = new Pedido(cliente);
		mainApp.mostrarInsertarEncomiendas(pedido, i);
	}
	
	@FXML 
	private void handlerAtras(){
		mainApp.mostrarMenuComo(SistemaEncomienda.getInstance().getSucursalActual());
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
    private void initialize() {


    }
	
	public void setMainApp(MainApp mainApp, Cliente cliente) {
        this.mainApp = mainApp;
        this.cliente = cliente;
    }
}