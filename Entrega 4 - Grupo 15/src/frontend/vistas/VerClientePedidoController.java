package frontend.vistas;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import backend.Cliente;
import backend.Encomienda;
import backend.Pedido;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class VerClientePedidoController {

	MainApp mainApp = null;
	Cliente clienteActual;
	Pedido pedidoActual;
	Encomienda encomiendaActual;

    @FXML
    private Text estado;

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
    private Text tipo;
    
    @FXML
    private ComboBox listaClientes;

    @FXML
    private Text prioridad;

    @FXML
    private Label hora;

	@FXML
    private void initialize() {
    	UpdateClientes();
    }

	public void UpdateClientes(){
		listaClientes.getItems().addAll(SistemaEncomienda.getInstance().getClientesNombre());
	}

    @FXML
    void handlerListaClientes() {
    	clienteActual = SistemaEncomienda.getInstance().getClienteAPartirDeNombre(listaClientes.getValue().toString());
    	listaPedidos.getItems().addAll(clienteActual.getNombrePedidos());
    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuCajero();
    }

    @FXML
    void handlerListaPedidos() {
    	pedidoActual = SistemaEncomienda.getInstance().getPedidoAPartirDeNombre(listaPedidos.getValue().toString());
    	listaEncomiendas.getItems().addAll(pedidoActual.getNombresEncomiendas());
    }

    @FXML
    void handlerListaEncomiendas() {
    	if(encomiendaActual != null){
    	sucursalDestino.setText(encomiendaActual.getSucursalDestino().getNombre());
    	precio.setText(String.valueOf(encomiendaActual.precio));
    	direccionFinal.setText(encomiendaActual.getDireccionFinal());
    	peso.setText(Integer.toString(encomiendaActual.getPeso()));
    	volumen.setText(Integer.toString(encomiendaActual.getVolumen()));
    	prioridad.setText(Integer.toString(encomiendaActual.getPrioridad()));
    	estado.setText(encomiendaActual.getEstadoEncomiendaString());
    	hora.setText(encomiendaActual.getStrdate());
    	tipo.setText(encomiendaActual.nombreTipo());
    
    	} else {
    		mainApp.mostrarMessage("Error de eleccion de encomienda");
    	}
    }

	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}