package structure;

import builder.BurgerBuilder;
import controllers.MainViewController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import static structure.Rules.NB_MAX_MS_CLIENT_WAITING;

/**
 * Classe impémentant un client du restaurant. Hérite de la classe VBox de JavaFX afin qu'on puisse traiter un client comme un noeud JavaFX.
 */
public class Client extends VBox {
	
	private MainViewController mainViewController; // référence vers l'instance du mainViewController
	
	// le Timeline animant la barre d'attente du client. Le client s'en va en colère lorsque la barre est vide et qu'il n'a toujours pas été servi.
	private Timeline timer;
	
	private Menu menu; // le menu désiré par le client
	
	private Label desiredMenu; // le nom du menu désiré par le client
	
	private boolean gameIsRunning;
	
	private ImageView img; // l'image du client
	
	// la barre d'attente du client. Le client s'en va en colère lorsque la barre est vide et qu'il n'a toujours pas été servi.
	private ProgressBar timerProgressBar;
	
	/**
	 * Construit un client avec une référence vers le mainViewController.
	 * @param mainViewController, une référence vers le mainViewController.
	 */
	public Client(MainViewController mainViewController) {
		super();
		this.mainViewController = mainViewController;
		
		menu = Menu.getOneRandomMenu(); // détermine aléatoirement le menu désiré par le client
		
		timerProgressBar = new ProgressBar();
		// anime la barre d'attente du client
		timer = new Timeline(
				new KeyFrame(
						Duration.ZERO,
						new KeyValue(timerProgressBar.progressProperty(), 1)
				),
				new KeyFrame(
						Duration.millis(NB_MAX_MS_CLIENT_WAITING),
						new KeyValue(timerProgressBar.progressProperty(), 0)
				)
		);
		
		// évènement activé lorsque la barre d'attente du client est vide
		timer.setOnFinished(event -> {
			mainViewController.anAngryClientLeave(Client.this); // le client quitte le restaurant en colère
		});
		setAlignment(Pos.CENTER);
		
		img = new ImageView();
		img.setPreserveRatio(true);
		img.setSmooth(true);
		img.setFitHeight(100);
		img.setFitWidth(50);
		img.setImage(new Image("clientWaiting.png"));
		
		desiredMenu = new Label();
		desiredMenu.setText(menu.toString());
		
		getChildren().addAll(img, desiredMenu, timerProgressBar);
		
		if (gameIsRunning) {
			startTimer(); // lance le timer du client si le jeu est lancé
		}
		
		// évènement activé lorsque l'utilisateur clique sur un client avec la souris
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mainViewController.handleCustomer(Client.this); // sélectionne le client sur lequel a cliqué l'utilisateur
			}
		});
	}
	
	/**
	 * Démarre le timer du client.
	 */
	public void startTimer() {
		timer.play();
		gameIsRunning = true;
	}
	
	/**
	 * Met en pause le timer du client.
	 */
	public void pauseTimer() {
		timer.pause();
		gameIsRunning = true;
	}
	
	/**
	 * Stop et réinitialise le timer du client.
	 */
	public void stopTimer() {
		timer.stop();
		gameIsRunning = false;
	}
	
	/**
	 * Retourne le burgerBuilder associé au menu désiré par le client.
	 * @return le burgerBuilder associé au menu désiré par le client.
	 */
	public BurgerBuilder getBurgerBuilder() {
		return menu.getBurgerBuilder();
	}
	
	/**
	 * Retourne le menu désiré par le client.
	 * @return le menu désiré par le client.
	 */
	public Menu getMenu() {
		return menu;
	}
}
