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
	int i;

	Boolean llenado1 = false;
	Boolean llenado2 = false;
	Boolean llenado3 = false;
	Boolean llenado4 = false;
	Boolean llenado5 = false;
	Boolean llenado6 = false;

	@FXML
	private ComboBox listaSucursales;

	@FXML
	private ComboBox listaPrioridades;


	@FXML
	private ComboBox tipo;

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
	private void handlerDireccion(){
		llenado1 = true;
	}

	@FXML
	private void handlerVolumen(){
		llenado2 = true;
	}

	@FXML
	private void handlerPeso(){
		llenado3 = true;
	}


	@FXML
	private void handlerTipo(){
		llenado6 = true;
	}

	@FXML
	private void handlerSucursal(){
		llenado5 = true;
	}

	@FXML
	private void handlerIngresarEncomiendas(){
		//
		if(llenado5 && llenado1 && llenado2 && llenado3 && llenado4 && llenado6){
		llenado5 = false;
		Sucursal sucursalOrigen = null;


		if (!volumen.getText().matches("[0-9]+") | volumen.getText().length() < 1) {
			mainApp.mostrarMessage("Ingresa un volumen/peso correcto");
			return;
		}
		if (!peso.getText().matches("[0-9]+") | peso.getText().length() < 1){
			mainApp.mostrarMessage("Ingresa un volumen/peso correcto");
			return;
		}
		mainApp.mostrarMessage("Haz ingresado exitosamente la encomienda, haz click en terminar cuando no quieras agregar m�s encomiendas");

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
		encomienda.setearTipo(tipo.getValue().toString());
		//Aqui se agrega la encomienda a la lista de encomiendas del pedido
	    pedido.getEncomiendasPedido().add(encomienda);
	    encomienda.setDireccionFinal(direccionFinal.getText());
	    System.out.println(pedido.getCosto());
	    System.out.println(encomienda);
	    System.out.println(sucursalOrigen);
	    System.out.println(pedido);
	    //Aqui se agrega la encomienda a la lista de encomiendas de la sucursal
	    //sucursalOrigen.getListaEncomiendas().add(encomienda);

		mainApp.mostrarInsertarEncomiendas(pedido, i);
		}else{
			mainApp.mostrarMessage("Seleccione bien los datos.");
		}
	}

	@FXML
	private void handlerTerminarPedido(){
		//mainApp.mostrarMessage("Haz ingresado exitosamente el pedido");
		//rellenar
		mainApp.mostrarDetallesPedido(pedido, i);
	}

	@FXML
    private void initialize() {
    	Update();
    }

	@FXML
	private void handlerPrecio(){
		if (!volumen.getText().matches("[0-9]+") | volumen.getText().length() < 1) {
			mainApp.mostrarMessage("Ingresa un volumen/peso correcto");
			return;
		}
		if (!peso.getText().matches("[0-9]+") | peso.getText().length() < 1){
			mainApp.mostrarMessage("Ingresa un volumen/peso correcto");
			return;
		}
		llenado4 = true;
		precio.setText(Integer.toString(Integer.parseInt(volumen.getText())*20+Integer.parseInt(peso.getText())*1000));
		//peso*1000 + volumen*20
	}

	public void Update(){
		ArrayList<String> lista = new ArrayList<>();
		for(String s : SistemaEncomienda.getInstance().getSucursalesNombre()) {
			if(s!=null && !s.equals(SistemaEncomienda.getInstance().getSucursalActual())){
				lista.add(s);
			}
		}

		listaSucursales.getItems().addAll(lista);
		precio.setText("");
		volumen.setText("0");
		peso.setText("0");
		listaPrioridades.getItems().addAll(1,2,3);
        tipo.getItems().add("Normal");
        tipo.getItems().add("Fragil");
        tipo.getItems().add("Frio");
        tipo.getItems().add("Caliente");
        tipo.getItems().add("Radiactivo");
	}


	public void setMainApp(MainApp mainApp, Pedido pedido, int i) {
        this.mainApp = mainApp;
        this.pedido = pedido;
        this.i = i;
    }
}
