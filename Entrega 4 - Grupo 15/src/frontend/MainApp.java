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

import backend.Camion;
import backend.Cliente;
import backend.Deserialize;
import backend.Encomienda;
import backend.Pedido;
import backend.SerializeDemo;
import backend.SistemaEncomienda;
import frontend.vistas.AdministrarCamionesController;
import frontend.vistas.AdministrarSistemaController;
import frontend.vistas.AdministrarSucursalController;
import frontend.vistas.CajeroOperadorController;
import frontend.vistas.CambiarCajeroController;
import frontend.vistas.CambiarOperadorController;
import frontend.vistas.DetallesPedidoController;
import frontend.vistas.ElegirClienteController;
import frontend.vistas.EncomiendaActualController;
import frontend.vistas.EnviarMensajeController;
import frontend.vistas.GananciasController;
import frontend.vistas.IngresarSucursalController;
import frontend.vistas.InsertarDespacharController;
import frontend.vistas.InsertarEncomiendaCamionController;
import frontend.vistas.InsertarEncomiendasController;
import frontend.vistas.MenuCajeroController;
import frontend.vistas.MenuClienteController;
import frontend.vistas.MenuIngresarClienteController;
import frontend.vistas.MenuIngresarPedidoController;
import frontend.vistas.MenuOperadorController;
import frontend.vistas.RecibirCamionController;
import frontend.vistas.RegistrarErrorOperarioController;
import frontend.vistas.RootLayoutController;
import frontend.vistas.SistemaController;
import frontend.vistas.VerClientePedidoController;
import frontend.vistas.VerErroresOperariosController;
import frontend.vistas.VerMensajeController;
import frontend.vistas.VerPedidosClienteController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	public SistemaEncomienda sist = null;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Sistema de Encomiendas");

		try {
			//Deserialize.deserialize(SistemaEncomienda.getInstance());
			//Deserialize.deserialize2(SistemaEncomienda.getInstance());
			SistemaEncomienda.getInstance().deserialize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sist = new SistemaEncomienda();
		
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
            this.primaryStage.setTitle("Sistema de Encomiendas");

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(bienvenida);

            // Dar acceso al controlador de bienvenida
            SistemaController controllerView = loader.getController();
            controllerView.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public void mostrarMenuCliente(Cliente cliente){
        try {
            // Load bienvenida
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/MenuCliente.fxml"));
            AnchorPane menuCliente = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(menuCliente);

            // Dar acceso al controlador de bienvenida
            MenuClienteController controllerView = loader.getController();
            controllerView.setMainApp(this, cliente);


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

	public void mostrarEncomiendaActual(int i, Encomienda encomienda){
        try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/EncomiendaActual.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            EncomiendaActualController controllerView = loader.getController();
            controllerView.setMainApp(this,i,encomienda);


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

	public void mostrarVerClientePedido(){
        try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/VerClientePedido.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            VerClientePedidoController controllerView = loader.getController();
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
            controllerView.setMainApp(this, 0);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarMenuIngresarPedidoCliente(){
        try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/ElegirCliente.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            ElegirClienteController controllerView = loader.getController();
            controllerView.setMainApp(this, 1);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void mostrarInsertarEncomiendas(Pedido pedido, int i){
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

            controllerView.setMainApp(this, pedido, i);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void mostrarInsertarEncomiendaCamion(Camion camion){
        try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/InsertarEncomiendaCamion.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();

            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            InsertarEncomiendaCamionController controllerView = loader.getController();
            controllerView.setMainApp(this, camion);


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
	
	public void mostrarDetallesPedido(Pedido pedido, int i){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/resumenPedido.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            DetallesPedidoController controllerView = loader.getController();
            System.out.println(pedido.getCosto());
            controllerView.setMainApp(this, pedido, i);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarVerPedidosCliente(Cliente cliente){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/VerPedidosCliente.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            VerPedidosClienteController controllerView = loader.getController();
            controllerView.setMainApp(this, cliente);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarRegistrarError(){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/RegistrarErrorOperario.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            RegistrarErrorOperarioController controllerView = loader.getController();
            controllerView.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarVerErroresOperarios(){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/VerErroresOperarios.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            VerErroresOperariosController controllerView = loader.getController();
            controllerView.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarGanancias(){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/Ganancias.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            GananciasController controllerView = loader.getController();
            controllerView.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarAdministrarSistema(){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/AdministrarSistema.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            AdministrarSistemaController controllerView = loader.getController();
            controllerView.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarCambiarOperador(){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/CambiarOperador.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            CambiarOperadorController controllerView = loader.getController();
            controllerView.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarCambiarCajero(){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/CambiarCajero.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            CambiarCajeroController controllerView = loader.getController();
            controllerView.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void mostrarIngresarSucursal(){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/IngresarSucursal.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            IngresarSucursalController controllerView = loader.getController();
            controllerView.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarAdministrarSucursal(){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/AdministrarSucursal.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            AdministrarSucursalController controllerView = loader.getController();
            controllerView.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void mostrarAdministrarCamiones(){
		try {
            // Load bienvenida

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("vistas/AdministrarCamiones.fxml"));
            AnchorPane generico = (AnchorPane)loader.load();


            // Poner la vista del login en el centro de la ventana principal
            rootLayout.setCenter(generico);

            // Dar acceso al controlador de bienvenida
            AdministrarCamionesController controllerView = loader.getController();
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
        System.out.println(SistemaEncomienda.getInstance());
        //SerializeDemo.serialize(SistemaEncomienda.getInstance());
        //SerializeDemo.serialize2(SistemaEncomienda.getInstance());
        SistemaEncomienda.getInstance().serialize();
    }


}
