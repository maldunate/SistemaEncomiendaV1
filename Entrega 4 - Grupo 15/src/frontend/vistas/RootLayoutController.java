package frontend.vistas;

import frontend.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class RootLayoutController extends Application {

	MainApp mainApp;
	@Override
	public void start(Stage primaryStage) {
		
	}
	
	@FXML
	private void close(){
		mainApp.close();
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;   
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
