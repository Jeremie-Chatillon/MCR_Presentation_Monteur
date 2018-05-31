package controllers;

import Builder.BurgerBuilder;
import Structure.Condiment;
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
		handleCondiment(Condiment.SAUCE);
	}
	
	@FXML
	void handleLettuce() {
		handleCondiment(Condiment.LETTUCE);
	}
	
	@FXML
	void handleOgnon() {
		handleCondiment(Condiment.OGNON);
	}
	
	@FXML
	void handlePickle() {
		handleCondiment(Condiment.PICKLE);
	}
	
	@FXML
	void handleCheese() {
		handleCondiment(Condiment.CHEESE);
	}
	
	@FXML
	void handleTomatoe() {
		handleCondiment(Condiment.TOMATOE);
	}
	
	@FXML
	void handleFish() {
		handleCondiment(Condiment.FISH);
	}
	
	@FXML
	void handleChicken() {
		handleCondiment(Condiment.CHICKEN);
	}
	
	@FXML
	void handleBeef() {
		handleCondiment(Condiment.BEEF);
	}


	@FXML
	void handleBreadTop() {
		handleCondiment(Condiment.BREAD_TOP);
	}
	@FXML
	void handleBreadBot() {
		handleCondiment(Condiment.BREAD_BOT);
	}
	
	void updateCashValue(int newCashValue) {
		cash.setText(String.valueOf(newCashValue));
	}
	
	int getCashValue() {
		return Integer.parseInt(cash.getText());
	}

	void addCash(int amount){
		cash.setText(String.valueOf(getCashValue() + amount));
	}

	private BurgerBuilder burgerBuilder;

	private void handleCondiment(Condiment c){

		System.out.println(c);
		addCash(-c.getPrice());

		if(burgerBuilder == null)
			return;

		addCash(-c.getPrice());


		burgerBuilder.addCondiment(c);
	}

	private void handleCustomer(){



		if(burgerBuilder != null)
			return;

		//currentCustomer = c;
		//burgerBuilder = customer.getBurgerBuilder();
	}

	private void handleDelete(){
		if(burgerBuilder == null)
			return;

		burgerBuilder.clear();
		burgerBuilder = null;
	}

	private void handleBuild(){
		if(burgerBuilder == null)
			return;

		if(burgerBuilder.build() == null){
			// vaumitBar.add(1);
		}

		//updateCashValue(getCashValue() + curentCustomer.getPriceOrder());

		burgerBuilder = null;
	}
}