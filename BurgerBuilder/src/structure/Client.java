package structure;

import builder.BurgerBuilder;
import controllers.MainViewController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.DefaultProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import static controllers.Rules.NB_MAX_MS_CLIENT_WAITING;

@DefaultProperty(value = "waitingQueue")
public class Client extends VBox {
	
	private static int nbClients;
	
	private MainViewController mainViewController;
	private int id;
	private Timeline timer;
	private Menu menu;
	private boolean gameIsRunning;
	
	private ImageView img;
	private Label desiredMenu;
	private ProgressBar timerProgressBar;
	
	public Client(MainViewController mainViewController) {
		super();
		this.mainViewController = mainViewController;
		
		this.id = ++nbClients;
		menu = Menu.getOneRandomMenu();
		
		timerProgressBar = new ProgressBar();
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
		
		timer.setOnFinished(event -> {
			System.out.println("Un client a attendu trop longtemps et s'en va pas content!");
			mainViewController.anAngryClientLeave(Client.this);
		});
		setAlignment(Pos.CENTER);
		
		img = new ImageView();
		img.setPreserveRatio(true);
		img.setSmooth(true);
		img.setFitHeight(100);
		img.setFitWidth(50);
		img.setImage(new Image("clientWaiting.png"));
		
		desiredMenu = new Label();
		desiredMenu.setText(Menu.getOneRandomMenu().toString());
		
		getChildren().addAll(img, desiredMenu, timerProgressBar);
		
		if (gameIsRunning) {
			startTimer();
		}
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mainViewController.handleCustomer(Client.this);
			}
		});
	}
	
	public void startTimer() {
		timer.playFromStart();
		gameIsRunning = true;
	}
	
	public BurgerBuilder getNewBurgerBuilder(){
		return menu.getBurgerBuilder();
	}
	
	public Menu getMenu() {
		return menu;
	}
}
