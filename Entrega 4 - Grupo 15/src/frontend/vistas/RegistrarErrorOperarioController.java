package frontend.vistas;


import backend.SistemaEncomienda;
import backend.Sucursal;
import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class RegistrarErrorOperarioController {

	private MainApp mainApp;
	
	Sucursal actual;
	
	Boolean cambiado;
	
    @FXML
    private TextArea Registro;
    
    @FXML
    void handlerTexto(){
    	cambiado = true;
    }

    @FXML
    void handlerRegistrar() {
    	if(cambiado){
    		//System.out.println(actual.getOperador().getNombre());
    		actual.listaErrores.add(SistemaEncomienda.getInstance().devolverMensaje(Registro.getText(), actual, actual, actual.getOperador().getNombre()));
    		mainApp.mostrarMenuOperador();
    		mainApp.mostrarMessage("Haz registrado el error");
    	}else{
    		mainApp.mostrarMessage("Escribe el error porfavor.");
    	}
    }

    @FXML
    void handlerAtras() {
    	mainApp.mostrarMenuOperador();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
        cambiado = false;
        actual = SistemaEncomienda.getInstance().compararSucursal(SistemaEncomienda.getInstance().getSucursalActual());
    }

}
