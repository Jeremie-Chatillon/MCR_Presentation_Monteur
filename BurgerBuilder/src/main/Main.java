package main;

import controllers.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Classe principale du programme.
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoaderMainViewController = new FXMLLoader(getClass().getResource("../fxml/mainView.fxml"));
		Parent root = fxmlLoaderMainViewController.load();
		primaryStage.setTitle("Burger Builder");
		Scene scene = new Scene(root);
		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		
		MainViewController mainViewController = fxmlLoaderMainViewController.getController();
		
		//primaryStage.getIcons().add(new Image("/images/BlaajjPaint.jpg")); //TODO: add icon
		primaryStage.show();
		
		// Ouvre une boite de dialogue permettant de démarrer le jeu
		Alert alert = new Alert(Alert.AlertType.NONE);
		alert.setTitle("BurgerBuilder");
		alert.setHeaderText("Démarrer une nouvelle partie");
		
		ButtonType buttonTypeOne = new ButtonType("Jouer"); // ajoute un bouton "jouer" à la boite de dialogue
		alert.getButtonTypes().add(buttonTypeOne);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne) {
			mainViewController.startGame(); // démarre le jeu lorsqu'on clique sur le bouton de la boite de dialogue
		}
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
