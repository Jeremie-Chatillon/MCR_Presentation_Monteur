package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Controller {
	
	@FXML
	private ImageView chicken;
	
	@FXML
	private ImageView breadTop;
	
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
	private ImageView fish;
	
	@FXML
	private ImageView breadBottom;
	
	@FXML
	private HBox ProgressBarHBox;
	
	@FXML
	private ImageView ognon;
	
	@FXML
	private Label cash;
	
	@FXML
	void handleSauce(ActionEvent event) {
	
	}
	
	@FXML
	void handleLettuce(ActionEvent event) {
	
	}
	
	@FXML
	void handleOgnon(ActionEvent event) {
	
	}
	
	@FXML
	void handlePickle(ActionEvent event) {
	
	}
	
	@FXML
	void handleCheese(ActionEvent event) {
	
	}
	
	@FXML
	void handleTomatoe(ActionEvent event) {
	
	}
	
	@FXML
	void handleFish(ActionEvent event) {
	
	}
	
	@FXML
	void handleChicken(ActionEvent event) {
	
	}
	
	@FXML
	void handleBeef(ActionEvent event) {
	
	}
	
	@FXML
	void handleBread(ActionEvent event) {
	
	}
	
	void updateCashValue(int newCashValue){
		cash.setText(String.valueOf(newCashValue));
	}
	
	int getCashValue(){
		return Integer.parseInt(cash.getText());
	}
}
