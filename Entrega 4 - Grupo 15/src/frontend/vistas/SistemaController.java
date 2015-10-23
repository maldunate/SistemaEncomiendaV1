package frontend.vistas;


import java.awt.EventQueue;

import javax.swing.JOptionPane;

import backend.*;
import frontend.MainApp;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SistemaController {

	@FXML
	private ComboBox listaSucursales;

	private MainApp mainApp;

	
	public SistemaController(){}
	
	@FXML
    private void initialize() {
	
		UpdateSucursales();
		
    }
	
	public void UpdateSucursales(){
	
		listaSucursales.getItems().addAll(SistemaEncomienda.getInstance().getSucursalesNombre());
		
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        
    }
	
	@FXML
	private void buttonHandler(){
		System.out.println(listaSucursales.getValue());
		if(listaSucursales.getValue()!= null){
			mainApp.mostrarMenuComo(listaSucursales.getValue().toString());
		} else {
			mostrarMessage("Elige sucursal");
		}
	}
	
	private void mostrarMessage(String message) {
	    EventQueue.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            JOptionPane.showMessageDialog(null, message);
	        }
	    });
	}
		
	public void start(Stage primaryStage) {

	}

/*	public static void main(String[] args) {

		launch(args);
		}
	*/
}
