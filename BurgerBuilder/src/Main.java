import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	/**
	 * Initialise et affiche l'interface graphique.
	 *
	 * @param primaryStage,
	 * 		la scène principale
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Burger builder");
		//this.primaryStage.getIcons().add(new Image("/images/BlaajjPaint.jpg")); //TODO: add icon
		
		initRootLayout();
	}
	
	/**
	 * Initialise la fenêtre de base avec tous ses fxmls ainsi que tous les controllers associés.
	 */
	private void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			//loader.setBuilderFactory(new JavaFXBuilderFactory());
			
			//loader.setLocation(getClass().getResource("fxml/mainView.fxml"));
			//loader.setControllerFactory(controllerClass -> new MainViewController());
			rootLayout = FXMLLoader.load(getClass().getResource("fxml/mainView.fxml"), null, new JavaFXBuilderFactory());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Permet de récupérer la scène principale.
	 *
	 * @return la scène principale.
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * Fonction main. Lance l'exécution du programme.
	 *
	 * @param args
	 * 		- Arguments passés au programme.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
