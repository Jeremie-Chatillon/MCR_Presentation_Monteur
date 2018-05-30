package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class mainViewController {
	
	@FXML
	private VBox satisfactionVBox;
	
	@FXML
	private VBox vomitVBox;
	
	@FXML
	private ImageView chicken;
	
	@FXML
	private Label menuClient4;
	
	@FXML
	private ImageView breadTop;
	
	@FXML
	private Label menuClient3;
	
	@FXML
	private Label menuClient2;
	
	@FXML
	private Label menuClient1;
	
	@FXML
	private ImageView beef;
	
	@FXML
	private ImageView sauce;
	
	@FXML
	private ImageView lettuce;
	
	@FXML
	private ImageView pickle;
	
	@FXML
	private ImageView cheese;
	
	@FXML
	private ImageView tomatoe;
	
	@FXML
	private VBox builderVBox;
	
	@FXML
	private ImageView fish;
	
	@FXML
	private ImageView breadBottom;
	
	@FXML
	private HBox ProgressBarHBox;
	
	@FXML
	private ImageView imgClient4;
	
	@FXML
	private ImageView ognon;
	
	@FXML
	private ImageView imgClient3;
	
	@FXML
	private ImageView imgClient2;
	
	@FXML
	private HBox imgClient1;
	
	@FXML
	private Label cash;
	
	@FXML
	private VerticalProgressBar vomitBar;
	
	@FXML
	private VerticalProgressBar satisfactionBar;
	
	@FXML
	void initialize() {
		vomitBar = new VerticalProgressBar(80, 400);
		satisfactionBar= new VerticalProgressBar(80, 400);
		
		vomitVBox.getChildren().add(vomitBar.getProgressHolder());
		satisfactionVBox.getChildren().add(satisfactionBar.getProgressHolder());
		
	}
	
	@FXML
	void handleSauce() {
	
	}
	
	@FXML
	void handleLettuce() {
	
	}
	
	@FXML
	void handleOgnon() {
	
	}
	
	@FXML
	void handlePickle() {
	
	}
	
	@FXML
	void handleCheese() {
	
	}
	
	@FXML
	void handleTomatoe() {
	
	}
	
	@FXML
	void handleFish() {
	
	}
	
	@FXML
	void handleChicken() {
	
	}
	
	@FXML
	void handleBeef() {
	
	}
	
	@FXML
	void handleBread() {
	
	}
	
	void updateCashValue(int newCashValue) {
		cash.setText(String.valueOf(newCashValue));
	}
	
	int getCashValue() {
		return Integer.parseInt(cash.getText());
	}
}