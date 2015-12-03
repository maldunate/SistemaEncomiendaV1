package frontend.vistas;

import backend.Encomienda;
import backend.Pedido;
import backend.SistemaEncomienda;
import backend.printEncomienda;
import frontend.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PedidosSucursalController {

	public ObservableList<printEncomienda> data = FXCollections.observableArrayList();

    @FXML
    private TableColumn<printEncomienda, String> fecha1;

    @FXML
    private TableColumn<printEncomienda, String> estado1;

    @FXML
    private TableColumn<printEncomienda, String> sucursal1;

    @FXML
    private Button aceptar;

    @FXML
    private TableView<printEncomienda> tabla;

    @FXML
    private TableColumn<printEncomienda, String> nombre1;

	private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		inicio();
		}

    @FXML
    void handlerAceptar() {
    	mainApp.mostrarMenuCajero();

    }

    public void inicio(){
    	data.clear();
    	for (Pedido p : SistemaEncomienda.getInstance().getListaPedidos()){
    		for (Encomienda e : p.getEncomiendasPedido()){
    			if (e.getSucursalOrigen().getNombre().equals(SistemaEncomienda.getInstance().getSucursalActual())){
    				data.add(new printEncomienda(e.getSucursalOrigen().getNombre(), e.getSucursalDestino().getNombre(),e.getVolumen(), e.getPeso(), e.getPrioridad(), e.getPrecio(), e.nombreTipo(), e.getStrdate(), e.getNombre(), e.getEstadoEncomiendaString()));
    			}
    		}
    	}
    	sucursal1.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("destino"));
		fecha1.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Fecha"));
		nombre1.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("nombre"));
		estado1.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("estado"));

		tabla.setItems(data);

    }

}
