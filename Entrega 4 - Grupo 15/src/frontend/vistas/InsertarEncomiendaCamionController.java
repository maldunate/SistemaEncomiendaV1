package frontend.vistas;

import java.util.ArrayList;

import backend.Camion;
import backend.Cliente;
import backend.Encomienda;
import backend.SistemaEncomienda;
import backend.Sucursal;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsertarEncomiendaCamionController {

	private MainApp mainApp;

	Camion cam = null;

	Sucursal actual;

	Boolean elegido;

	ArrayList<String> encomiendasPosibles = new ArrayList<>();

	ArrayList<Encomienda> encomiendas = new ArrayList<>();

	@FXML
	private ComboBox listaEncomiendas;


	@FXML
	private Text sucursalDestino;

	@FXML
	private Text tipo;

	@FXML
	private Text direccionFinal;

	@FXML
	private Text peso;

	@FXML
	private Text precio;

	@FXML
	private Text volumen;

	@FXML
	private Text prioridad;

	public InsertarEncomiendaCamionController() {



	}

	public void start(Stage primaryStage) {



	}

	//Crea una lista (encomiendas) con las encomiendas que coinciden con el destino del camion
	//actual, y luego se crea una lista de strings con los nombres respectivos.
	private ArrayList<String> crearListaEncomiendasOrigen(){
		encomiendas.clear();
		encomiendasPosibles.clear();
		actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());

		//System.out.println(cam.getSucursalDestino().getNombre());

		for (Encomienda e : actual.getListaEncomiendas()) {
			if(e.getSucursalDestino().equals(cam.getSucursalDestino())){
				encomiendas.add(e);
			}
		}


    	for (Encomienda e : encomiendas) {
				encomiendasPosibles.add(e.nombre);
		}
    	return encomiendasPosibles;
	}

	@FXML
	private void handlerListaEncomiendas(){
		//System.out.println(listaEncomiendas.getValue());
		for (Encomienda e : encomiendas) {
			if(e.nombre.equals(listaEncomiendas.getValue())){
				sucursalDestino.setText(e.getSucursalDestino().getNombre());
				peso.setText(Integer.toString(e.getPeso()));
				precio.setText(String.valueOf(e.getPrecio()));
				volumen.setText(Integer.toString(e.getVolumen()));
				prioridad.setText(Integer.toString(e.getPrioridad()));
			    tipo.setText(e.nombreTipo());
			}
		}
		elegido = true;
	}

	@FXML
	private void handlerAtras(){
		elegido = false;
		mainApp.mostrarInsertarDespachar();
	}


	@FXML
	private void handlerInsertar(){

		Boolean camionEncomienda = false;
		//rellenar
		if(elegido == true){
			for (Encomienda e : encomiendas) {
				if(e.nombre.equals(listaEncomiendas.getValue())){
					if(e.nombreTipo().equals(cam.nombreTipo())){
						camionEncomienda = true;
						e.setEstadoEnTransito();
						cam.enCamion.add(e);
						actual.getListaEncomiendas().remove(e);
					}else {
						mainApp.mostrarMessage("El cami�n solo puede llevar " + cam.nombreTipo() + " y esta encomienda es de tipo " + e.nombreTipo() + " por lo tanto cambiar cami�n o encomienda para que sean del mismo tipo. Gracias");
					}
				}
			}
			if(camionEncomienda){
				mainApp.mostrarMessage("Haz insertado la encomienda");
				mainApp.mostrarInsertarDespachar();
			}
		}else{
			mainApp.mostrarMessage("Porfavor, elija una encomienda");
		}
	}

	@FXML
    private void initialize() {


		}



	/*	ArrayList<String> encomiendasPosibles = new ArrayList<>();
    	for (Encomienda s : cam.getSucursalOrigen().getListaEncomiendas()) {
    		System.out.println(s);
			if(s.getSucursalDestino().equals(cam.getSucursalDestino())){
				encomiendasPosibles.add(s.nombre);
				System.out.println(s);
			}
		}

		listaEncomiendas.getItems().addAll(encomiendasPosibles);
	*/



	public void setMainApp(MainApp mainApp, Camion camion) {
        this.mainApp = mainApp;
        this.cam = camion;
        listaEncomiendas.getItems().addAll(crearListaEncomiendasOrigen());
        elegido = false;

    }
}
