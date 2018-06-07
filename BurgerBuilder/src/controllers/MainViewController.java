package controllers;

import builder.BurgerBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import structure.Burger;
import structure.Client;
import structure.Condiment;
import structure.Menu;

import static controllers.Rules.MAX_ANGRY_BAR;
import static controllers.Rules.MAX_VAUMIT_BAR;


public class MainViewController {
	@FXML
	private HBox waitingQueue;
	
	@FXML
	private VBox builderVBox;
	
	@FXML
	private VBox angryVBox;
	
	@FXML
	private VBox vomitVBox;
	
	@FXML
	private VBox menuVBox;
	
	@FXML
	private Label menuLabel;
	
	@FXML
	private Label cash;
	
	private VerticalProgressBar vomitBar;
	
	private VerticalProgressBar angryBar;
	
	private BurgerBuilder burgerBuilder;
	private int nbVaumit;
	private int nbHangry;
	private int nbCondiments;
	
	private ClientsManager clientsManager;
	
	@FXML
	private void initialize() {
		vomitBar = new VerticalProgressBar(80, 400, MAX_VAUMIT_BAR);
		angryBar = new VerticalProgressBar(80, 400, MAX_ANGRY_BAR);
		
		vomitVBox.getChildren().add(vomitBar.getProgressHolder());
		angryVBox.getChildren().add(angryBar.getProgressHolder());
		
		clientsManager = new ClientsManager(waitingQueue, this);
		clientsManager.startTimers();
	}
	
	@FXML
	private void handleOnKeyPressed(KeyEvent event) {
		// raccourci clavier permettant de créer un nouveau projet
		
		
		switch (event.getCode()) {
			case A:
				handleSauce();
				break;
			case B:
				handleLettuce();
				break;
			case C:
				handleOgnon();
				break;
			case D:
				handlePickle();
				break;
			case E:
				handleCheese();
				break;
			case F:
				handleTomatoe();
				break;
			case G:
				handleFish();
				break;
			case H:
				handleChicken();
				break;
			case I:
				handleBeef();
				break;
			case J:
				handleBreadTop();
				break;
			case K:
				handleBreadBot();
				break;
			case ENTER:
				handleDeliver();
				break;
			case BACK_SPACE:
				handleCancel();
				break;
			
		}
	}
	
	@FXML
	private void handleSauce() {
		addCondiment(Condiment.SAUCE);
	}
	
	@FXML
	private void handleLettuce() {
		addCondiment(Condiment.LETTUCE);
	}
	
	@FXML
	private void handleOgnon() {
		addCondiment(Condiment.OGNON);
	}
	
	@FXML
	private void handlePickle() {
		addCondiment(Condiment.PICKLE);
	}
	
	@FXML
	private void handleCheese() {
		addCondiment(Condiment.CHEESE);
	}
	
	@FXML
	private void handleTomatoe() {
		addCondiment(Condiment.TOMATOE);
	}
	
	@FXML
	private void handleFish() {
		addCondiment(Condiment.FISH);
	}
	
	@FXML
	private void handleChicken() {
		addCondiment(Condiment.CHICKEN);
	}
	
	@FXML
	private void handleBeef() {
		addCondiment(Condiment.BEEF);
	}
	
	@FXML
	private void handleBreadTop() {
		addCondiment(Condiment.BREAD_TOP);
	}
	
	@FXML
	private void handleBreadBot() {
		addCondiment(Condiment.BREAD_BOT);
	}
	
	@FXML
	public void handleCancel() {
		nbCondiments = 0;
		resetBuilderAndView();
	}
	
	@FXML
	public void handleDeliver() {
		if (burgerBuilder != null) {
			// fixme: ce try catch devrait être fait dans la classe client je dirais...
			try {
				Burger burger = burgerBuilder.build();
				updateCashValue(getCashValue() + burger.getPrice());
				clientsManager.removeSelectedClient();
				resetBuilderAndView();
			} catch (IllegalArgumentException e) {
				aClientVomitedAndLeave();
				resetBuilderAndView();
			}
		}
	}
	
	@FXML
	public void handleCustomer(Client client) {
		if (burgerBuilder == null) {
			menuLabel.setText("Vite, réalisez la commande du client avant qu'il ne s'impatiente!");
			clientsManager.setSelectedClient(client);
			burgerBuilder = client.getNewBurgerBuilder();
			updateMenuView(client);
		}
	}
	
	public void anAngryClientLeave(Client client) {
		angryBar.addToValue();
		clientsManager.removeClient(client);
		resetBuilderAndView();
	}
	
	public void aClientVomitedAndLeave() {
		vomitBar.addToValue();
		clientsManager.removeSelectedClient();
	}
	
	private int getCashValue() {
		return Integer.parseInt(cash.getText());
	}
	
	private void updateCashValue(int newCashValue) {
		cash.setText(String.valueOf(newCashValue));
	}
	
	private void addCondiment(Condiment c) {
		if (burgerBuilder != null && nbCondiments < 10) {
			nbCondiments++;
			updateCashValue(getCashValue() - c.getPrice());
			burgerBuilder.addCondiment(c);
			updateBurgerBuilderView(c.getImage());
		}
	}
	
	private void updateBurgerBuilderView(Image image) {
		final ImageView imv = new ImageView();
		imv.setFitHeight(100);
		imv.setFitWidth(200);
		imv.setImage(image);
		
		builderVBox.getChildren().add(imv);
		imv.toBack();
	}
	
	private void resetView() {
		builderVBox.getChildren().clear();
		menuVBox.getChildren().clear();
	}
	
	private void resetBuilderAndView() {
		menuLabel.setText("Sélectionnez un client pour traiter sa commande");
		if (burgerBuilder != null) {
			burgerBuilder.reset();
			burgerBuilder = null;
		}
		resetView();
	}
	
	private void updateMenuView(Client client) {
		Menu wantedMenu = client.getMenu();
		menuVBox.getChildren().clear();
		menuVBox.getChildren().add(wantedMenu.getBurger().getBurgerVBox());
	}
}