package frontend.vistas;

import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import backend.Cliente;
import backend.Pedido;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class VerClientePedidoController {

	MainApp mainApp = null;
	
    @FXML
    private Text sucursalDestino;

    @FXML
    private Text precio;

    @FXML
    private Text direccionFinal;

    @FXML
    private ComboBox listaEncomiendas;

    @FXML
    private ComboBox listaPedidos;

    @FXML
    private Text peso;

    @FXML
    private Text volumen;

    @FXML
    private ComboBox listaClientes;

    @FXML
    private Text prioridad;

	@FXML
    private void initialize() {
    	UpdateClientes();
    }
	
	public void UpdateClientes(){
		listaClientes.getItems().addAll(SistemaEncomienda.getInstance().getClientesNombre());
	}
	
    @FXML
    void handlerListaClientes() {
  //  	listaPedidos.getItems().addAll(SistemaEncomienda.getInstance().)

    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuCajero();
    }

    @FXML
    void handlerListaPedidos() {

    }

    @FXML
    void handlerListaEncomiendas() {

    }
    
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }

}