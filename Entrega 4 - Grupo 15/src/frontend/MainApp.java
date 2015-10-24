package frontend;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JOptionPane;

import backend.Deserialize;
import backend.Pedido;
import backend.SerializeDemo;
import backend.SistemaEncomienda;
import frontend.vistas.CajeroOperadorController;
import frontend.vistas.EncomiendaActualController;
import frontend.vistas.EnviarMensajeController;
import frontend.vistas.InsertarDespacharController;
import frontend.vistas.InsertarEncomiendaCamionController;
import frontend.vistas.InsertarEncomiendasController;
import frontend.vistas.MenuCajeroController;
import frontend.vistas.MenuIngresarClienteController;
import frontend.vistas.MenuIngresarPedidoController;
import frontend.vistas.MenuOperadorController;
import frontend.vistas.RecibirCamionController;
import frontend.vistas.RootLayoutController;
import frontend.vistas.SistemaController;
import frontend.vistas.VerMensajeController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	public SistemaEncomienda sist = null;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Sistema de Encomiendas");
		//try {
		//	Deserialize.deserialize(sist.getInstance());
		//} catch (Throwable e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		sist = new SistemaEncomienda();
		initRootLayout();
		
		showBienvenida();
	}
	
	public void initRootLayout(){
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            
            RootLayoutController controllerView = loader.getController();
            controllerView.setMainApp(this);
            
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
            AnchorPane bienvenida = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(bienvenida);
             
            // Dar acceso al controlador de bienvenida
            SistemaController controllerView = loader.getController();
            controllerView.setMainApp(this);

            
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public void mostrarMenuComo(String sucursal){
        try {
            // Load bienvenida
        	this.primaryStage.setTitle("Sistema de Encomiendas: Sucursal " + sucursal);
        	SistemaEncomienda.getInstance().setSucursalActual(sucursal);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/CajeroOperador.fxml"));
            AnchorPane cajeroOperador = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(cajeroOperador);

            // Dar acceso al controlador de bienvenida
            CajeroOperadorController controllerView = loader.getController();
            controllerView.setMainApp(this);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public void mostrarMenuOperador(){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/MenuOperador.fxml"));
            AnchorPane menuOperador = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(menuOperador);

            // Dar acceso al controlador de bienvenida
            MenuOperadorController controllerView = loader.getController();
            controllerView.setMainApp(this);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public void mostrarMenuCajero(){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/MenuCajero.fxml"));
            AnchorPane menuCajero = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(menuCajero);

            // Dar acceso al controlador de bienvenida
            MenuCajeroController controllerView = loader.getController();
            controllerView.setMainApp(this);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarInsertarDespachar(){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/InsertarDespachar.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            InsertarDespacharController controllerView = loader.getController();
            controllerView.setMainApp(this);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarRecibirCamion(){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/RecibirCamion.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            RecibirCamionController controllerView = loader.getController();
            controllerView.setMainApp(this);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarEncomiendaActual(int i){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/EncomiendaActual.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            EncomiendaActualController controllerView = loader.getController();
            controllerView.setMainApp(this,i);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarMenuIngresarCliente(){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/MenuIngresarCliente.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            MenuIngresarClienteController controllerView = loader.getController();
            controllerView.setMainApp(this);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
	public void mostrarMenuIngresarPedido(){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/MenuIngresarPedido.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            MenuIngresarPedidoController controllerView = loader.getController();
            controllerView.setMainApp(this);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarInsertarEncomiendas(Pedido pedido){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();   
            loader.setLocation(MainApp.class.getResource("vistas/InsertarEncomiendas.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();
            System.out.println("estupido3");

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            InsertarEncomiendasController controllerView = loader.getController();
            
            controllerView.setMainApp(this, pedido);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarInsertarEncomiendaCamion(){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/InsertarEncomiendaCamion.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            InsertarEncomiendaCamionController controllerView = loader.getController();
            controllerView.setMainApp(this);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarEnviarMensaje(){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();       
            loader.setLocation(MainApp.class.getResource("vistas/EnviarMensaje.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            EnviarMensajeController controllerView = loader.getController();
            
            controllerView.setMainApp(this);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarVerMensaje(){
        try {
            // Load bienvenida
        	
            FXMLLoader loader = new FXMLLoader();       
            loader.setLocation(MainApp.class.getResource("vistas/VerMensajes.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            VerMensajeController controllerView = loader.getController();
            
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
	
	public void mostrarMessage(String message) {
	    EventQueue.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            JOptionPane.showMessageDialog(null, message);
	        }
	    });
	}
	
    @Override
    public void stop(){
        System.out.println("Stage is closing");
        SerializeDemo.serialize(sist);
    }
	
	
}
