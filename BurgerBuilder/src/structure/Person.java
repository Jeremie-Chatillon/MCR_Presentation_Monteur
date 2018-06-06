package structure;

import controllers.MainViewController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controllers.Rules.MAX_TIME_CLIENT_WAINTING;

public class Person {
	private static int nbClients;
	
	private static MainViewController mainViewController;
	private int id;
	private int remainingTime;
	private Timer timer;
	private Menu menu;
	
	private VBox vbox;
	private ImageView img;
	private Label desiredMenu;
	private ProgressBar timerProgressBar;
	
	public Person(MainViewController mainViewController) {
		this.mainViewController = mainViewController;
		
		this.id = ++nbClients;
		menu = Menu.getOneRandomMenu();
		
		remainingTime = MAX_TIME_CLIENT_WAINTING;
		ActionListener onTimerUpdate = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remainingTime -= 250;
				timerProgressBar.setProgress(remainingTime);
				//drawClient(); // TODO: à vérifier si utile
				
				if (remainingTime == 0) {
					mainViewController.aClientLeave(Person.this);
				}
			}
		};
		
		timer = new Timer(250, onTimerUpdate);
		
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
		
		timerProgressBar = new ProgressBar();
		timerProgressBar.setProgress(remainingTime);
		
		vbox.getChildren().addAll(img, desiredMenu, timerProgressBar);
		timer.start();
	}
	
	public Node getPersonNode() {
		//drawClient();
		return vbox;
	}
	
	public void drawClient() {
		vbox.getChildren().clear();
		drawVBox();
	}
	
	private void drawVBox() {
		vbox.getChildren().addAll(img, desiredMenu, timerProgressBar);
	}
}
