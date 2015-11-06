package frontend.vistas;

import java.util.ArrayList;

import backend.Encomienda;
import backend.Pedido;
import backend.SistemaEncomienda;
import backend.Sucursal;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsertarEncomiendasController {

	Pedido pedido = null;
	private MainApp mainApp;
	
	@FXML
	private ComboBox listaSucursales;
	
	@FXML
	private ComboBox listaPrioridades;
	
	@FXML
	private TextField volumen;

	@FXML
	private TextField peso;
	
	@FXML
	private Text precio;

	@FXML
	private TextField direccionFinal;


	
	public InsertarEncomiendasController() {
	
	}

	public void start(Stage primaryStage) {
		
	}

	@FXML
	private void handlerIngresarEncomiendas(){
		mainApp.mostrarMessage("Haz ingresado exitosamente la encomienda, haz click en terminar cuando no quieras agregar más encomiendas");
		Sucursal sucursalOrigen = null;
		
		for (Sucursal s : SistemaEncomienda.getInstance().getListaSucursales()) {
			if(s.getNombre().equals(SistemaEncomienda.getInstance().getSucursalActual())){
				sucursalOrigen = s;
				break;
			}
		}
		
		Sucursal sucursalDestino = null;
		for (Sucursal s : SistemaEncomienda.getInstance().getListaSucursales()) {
			if(s.getNombre().equals(listaSucursales.getValue())){
				sucursalDestino = s;
				break;
			}
		}
		System.out.println(sucursalOrigen.getNombre());
		System.out.println(sucursalDestino.getNombre());
		System.out.println(Integer.parseInt(volumen.getText()));
		System.out.println(Integer.parseInt(peso.getText()));
		System.out.println(Integer.parseInt(listaPrioridades.getValue().toString()));
		//Aqui se crea la encomienda con los datos rellenados
		Encomienda encomienda = new Encomienda(sucursalOrigen, sucursalDestino, Integer.parseInt(volumen.getText()), Integer.parseInt(peso.getText()), Integer.parseInt(listaPrioridades.getValue().toString()));
		//Aqui se agrega la encomienda a la lista de encomiendas del pedido
	    pedido.getEncomiendasPedido().add(encomienda);
	    System.out.println(pedido.getCosto());
	    System.out.println(encomienda);
	    System.out.println(sucursalOrigen);
	    System.out.println(pedido);
	    //Aqui se agrega la encomienda a la lista de encomiendas de la sucursal
	    sucursalOrigen.getListaEncomiendas().add(encomienda);
	    
		mainApp.mostrarInsertarEncomiendas(pedido);
	}
	
	@FXML
	private void handlerTerminarPedido(){
		mainApp.mostrarMessage("Haz ingresado exitosamente el pedido");
		//rellenar
		mainApp.mostrarMenuCajero();
	}
	
	@FXML
    private void initialize() {
    	Update();
    }
	
	public void Update(){
		ArrayList<String> lista = new ArrayList<>();
		for(String s : SistemaEncomienda.getInstance().getSucursalesNombre()) {
			if(s!=null && !s.equals(SistemaEncomienda.getInstance().getSucursalActual())){
				lista.add(s);
			}
		}
		listaSucursales.getItems().addAll(lista);
		precio.setText("1000");
		listaPrioridades.getItems().addAll(1,2,3);
	}
	
	
	public void setMainApp(MainApp mainApp, Pedido pedido) {
        this.mainApp = mainApp;   
        this.pedido = pedido;
    }
}
