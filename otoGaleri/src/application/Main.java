package application;
	
import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("girisEkrani.fxml"));
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*private URL getClass(Object source) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getSource(String string) {
		// TODO Auto-generated method stub
		return null;
	}*/

	public static void main(String[] args) {
		launch(args);
	}
}
