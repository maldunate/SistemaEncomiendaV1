package frontend.vistas;


import backend.*;
import frontend.MainApp;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SistemaController {

	@FXML
	private Label bienvenido;
	
	@FXML
	private ComboBox<String> listaSucursales;
	
	@FXML
	private Button ingresar;
	

	private MainApp mainApp;

	public SistemaController(){}
	
	@FXML
    private void initialize() {
		

    }
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
//		for (Sucursal s : mainApp.sist.getListaSucursales()) {
//			listaSucursales.getItems().add(s.getNombre());
//		}
    }
	
//	public void start(Stage primaryStage) {

//	}

/*	public static void main(String[] args) {

		launch(args);
		}
	*/
}