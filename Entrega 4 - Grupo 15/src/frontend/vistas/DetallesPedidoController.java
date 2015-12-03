package frontend.vistas;

import frontend.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import backend.Encomienda;
import backend.Pedido;
import backend.SistemaEncomienda;
import backend.Sucursal;
import backend.printEncomienda;


public class DetallesPedidoController {


	public Pedido pedido;
	int i;

	public ObservableList<printEncomienda> data = FXCollections.observableArrayList();

    @FXML
    private TableColumn<printEncomienda, String> vol;

    @FXML
    private TableColumn<printEncomienda, String> precio;

    @FXML
    private TableColumn<printEncomienda, String> tipo;

    @FXML
    private Button cancelar;

    @FXML
    private TableColumn<printEncomienda, String> peso;

    @FXML
    private TableColumn<printEncomienda, String> sucursal;

    @FXML
    private Label precio_final;

    @FXML
    private Button aceptar;

    @FXML
    private TableView<printEncomienda> tabla;

    @FXML
    private TableColumn<printEncomienda, String> prioridad;

    public int suma;

    private MainApp mainApp;

    @FXML
    private void initialize() {

    }

	public void setMainApp(MainApp mainApp, Pedido pedido, int i) {
		this.mainApp = mainApp;
		this.pedido = pedido;
		this.i = i;
		System.out.println(pedido);
		UpdateTabla();
		}

	public void UpdateTabla(){
		pedido.getCliente().setCoeficiente_frecuente();
		for (Encomienda e: pedido.encomiendasPedido){
			e.setPrecio(e.getPrecio(), pedido.getCliente().getCoeficiente_frecuente());
			data.add(new printEncomienda(e.getSucursalOrigen().getNombre(), e.getSucursalDestino().getNombre(),e.getVolumen(), e.getPeso(), e.getPrioridad(), e.getPrecio(), e.nombreTipo(), e.getStrdate(), e.getNombre(), pedido.getCliente().getNombre()));
		}

		sucursal.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Destino"));
		peso.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Peso"));
		vol.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Volumen"));
		precio.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Precio"));
		prioridad.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Prioridad"));
		tipo.setCellValueFactory(
                new PropertyValueFactory<printEncomienda, String>("Tipo"));

		tabla.setItems(data);

		for (printEncomienda p: data){
			suma += p.getPrecio();
		}
		precio_final.setText(Integer.toString(suma));
	}

    @FXML
    void handlerAceptar() {
    	for (Encomienda e : pedido.getEncomiendasPedido()){
    		e.getSucursalOrigen().getListaEncomiendas().add(e);
    	}
    	SistemaEncomienda.getInstance().getListaPedidos().add(pedido);
    	if(i == 0){
    		mainApp.mostrarMenuCajero();
    	}else{
    		mainApp.mostrarMenuComo(SistemaEncomienda.getInstance().getSucursalActual());
    	}
    }

    @FXML
    void handlerCancel() {
    	mainApp.mostrarMenuCajero();

    }


}

