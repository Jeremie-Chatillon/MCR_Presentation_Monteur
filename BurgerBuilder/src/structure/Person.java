package structure;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Timer;

public class Person {
	private static int nbClients;
	
	private int id;
	private Menu menu;
	private Timer timer;
	
	private VBox vbox;
	private ImageView img;
	private Label desiredMenu;
	private Label timerLabel;
	
	public Person() {
		this.id = ++nbClients;
		menu = Menu.getOneRandomMenu();
		timer = new Timer();
		
		vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		
		img = new ImageView();
		img.setPreserveRatio(true);
		img.setSmooth(true);
		img.setFitHeight(100);
		img.setFitWidth(50);
		img.setImage(new Image("clientWaiting.png"));
		
		desiredMenu = new Label();
		desiredMenu.setText(Menu.getOneRandomMenu().toString());
		
		timerLabel = new Label();
		timerLabel.setText(timer.toString());
		
		vbox.getChildren().addAll(img, desiredMenu, timerLabel);
	}
	
	public Node getClientView() {
		//drawClient();
		return vbox;
	}
	
	public void drawClient() {
		vbox.getChildren().clear();
		drawVBox();
	}
	
	private void drawVBox() {
		vbox.getChildren().addAll(img, desiredMenu, timerLabel);
	}
}
