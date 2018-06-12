package main;

import controllers.MainViewController;
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
		FXMLLoader fxmlLoaderMainViewController = new FXMLLoader(getClass().getResource("/fxml/mainView.fxml"));
		Parent root = fxmlLoaderMainViewController.load();
		primaryStage.setTitle("Burger Builder");
		Scene scene = new Scene(root);
		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		
		MainViewController mainViewController = fxmlLoaderMainViewController.getController();
		primaryStage.show();
		
		mainViewController.handleRestart();
	}
	
	/**
	 * Fonction main. Lance l'exécution du programme.
	 *
	 * @param args,
	 * 		arguments passés au programme.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
