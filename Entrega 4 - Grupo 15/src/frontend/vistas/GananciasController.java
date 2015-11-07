package frontend.vistas;

import java.awt.Button;

import backend.Encomienda;
import backend.Pedido;
import backend.SistemaEncomienda;
import backend.printEncomienda;
import frontend.MainApp;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GananciasController extends Application {

	public ObservableList<printEncomienda> data = FXCollections.observableArrayList();

    @FXML
    private TableColumn<printEncomienda, String> precio;

    @FXML
    private TableColumn<printEncomienda, String> volumen;

    @FXML
    private Label total;

    @FXML
    private TableColumn<printEncomienda, String> peso;

    @FXML
    private TableColumn<printEncomienda, String> sucursal_origen;

    @FXML
    private TableColumn<printEncomienda, String> sucursal_destino;

    @FXML
    private TableView<printEncomienda> table;

    @FXML
    private TableColumn<printEncomienda, String> prioridad;

    private MainApp mainApp;

    public int suma;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		UpdateTabla();
		}
	@Override
	public void start(Stage primaryStage) {

	}
	public void UpdateTabla(){
		for (Pedido p: SistemaEncomienda.getInstance().getListaPedidos()){
			for (Encomienda e: p.getEncomiendasPedido()){
				data.add(new printEncomienda(e.getSucursalOrigen().getNombre(), e.getSucursalDestino().getNombre(),e.getVolumen(), e.getPeso(), e.getPrioridad(), e.getPrecio()));
			}
		}
		sucursal_destino.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Destino"));
		sucursal_origen.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Origen"));
		peso.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Peso"));
		volumen.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Volumen"));
		precio.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Precio"));
		prioridad.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Prioridad"));
		table.setItems(data);

		for (printEncomienda p: data){
			suma += p.getPrecio();
		}
		total.setText(Integer.toString(suma));

	}

	@FXML
    void handlerAtras() {
		mainApp.mostrarMenuCajero();

    }
	public static void main(String[] args) {
		launch(args);
	}
}
