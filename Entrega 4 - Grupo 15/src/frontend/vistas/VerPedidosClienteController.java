package frontend.vistas;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

import backend.Cliente;
import backend.Encomienda;
import backend.Pedido;
import backend.SistemaEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class VerPedidosClienteController {

	MainApp mainApp = null;
	Cliente cliente;
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
    private Text prioridad;

	@FXML
    private void initialize() {
		
    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuCliente(cliente);
    }

    @FXML
    void handlerListaPedidos() {
    	pedidoActual = SistemaEncomienda.getInstance().getPedidoAPartirDeNombre(listaPedidos.getValue().toString());
    	listaEncomiendas.getItems().clear();
    	listaEncomiendas.getItems().addAll(pedidoActual.getNombresEncomiendas());
    }

    @FXML
    void handlerListaEncomiendas() {
    	encomiendaActual = pedidoActual.getEncomiendaAPartirDeNombre(listaEncomiendas.getValue().toString());
    	sucursalDestino.setText(encomiendaActual.getSucursalDestino().getNombre());
    	precio.setText(String.valueOf(encomiendaActual.precio));
    	direccionFinal.setText(encomiendaActual.getDireccionFinal());
    	peso.setText(Integer.toString(encomiendaActual.getPeso()));
    	volumen.setText(Integer.toString(encomiendaActual.getVolumen()));
    	prioridad.setText(Integer.toString(encomiendaActual.getPrioridad()));
    	estado.setText(encomiendaActual.getEstadoEncomiendaString());
    }

	public void setMainApp(MainApp mainApp, Cliente cliente) {
        this.mainApp = mainApp;
        this.cliente = cliente;
        listaPedidos.getItems().addAll(cliente.getNombrePedidos());
    }

}