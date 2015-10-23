package frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

import backend.SistemaEncomienda;
import frontend.vistas.SistemaController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
//	public SistemaEncomienda sist = new SistemaEncomienda();
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Sistema de Encomiendas");
		
		initRootLayout();
		
		showBienvenida();
	}
	
	public void initRootLayout(){
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Cargar escena de la venta principal
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showBienvenida(){
        try {
            // Load bienvenida
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/Sistema.fxml"));
            AnchorPane Sistema = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(Sistema);
             
            // Dar acceso al controlador de login
            SistemaController controllerView = loader.getController();
            controllerView.setMainApp(this);

            
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}