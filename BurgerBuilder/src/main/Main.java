package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principale du programme.
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/mainView.fxml"));
		primaryStage.setTitle("Burger Builder");
		Scene scene = new Scene(root);
		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		
		//primaryStage.getIcons().add(new Image("/images/BlaajjPaint.jpg")); //TODO: add icon
		primaryStage.show();
	}
	
	/**
	 * Fonction main. Lance l'exécution du programme.
	 *
	 * @param args, arguments passés au programme.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
