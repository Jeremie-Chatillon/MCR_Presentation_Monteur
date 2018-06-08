package controllers;

import builder.BurgerBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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

import java.util.Optional;

import static controllers.Rules.*;

/**
 * Contrôleur associé au fichier mainView.fxml. Gère l'ensemble du jeu et de sa GUI.
 */
public class MainViewController {
	@FXML
	private HBox waitingQueue; // La HBox contenant la file d'attente de clients
	
	@FXML
	private VBox builderVBox; // La VBox contenant le builder de burger
	
	@FXML
	private VBox angryVBox; // La VBox contenant la verticalProgressBar de colère des clients
	
	@FXML
	private VBox vomitVBox; // La VBox contenant la verticalProgressBar de vmoit des clients
	
	@FXML
	private VBox menuVBox; // La VBox contenant le menu désiré par le client sur lequel l'utilsiateur a cliqué
	
	@FXML
	private Label menuLabel; // Label affiché au dessus du menu désiré par le client sur lequel l'utilsiateur a cliqué
	
	@FXML
	private Label cash; // Label affichant l'argent restant au joueur
	
	private VerticalProgressBar vomitBar; // la verticalProgressBar de vomit
	
	private VerticalProgressBar angryBar; // la verticalProgressBar de colère
	
	private BurgerBuilder burgerBuilder;
	
	private int nbVaumit;
	
	private int nbAngry;
	
	private int nbCondiments;
	
	private ClientsManager clientsManager; // le manager de client gérant la file d'attente des clients
	
	/**
	 * Méthode appelée par JavaFX et initialisant le contrôleur et le fichier FXML associé.
	 */
	@FXML
	private void initialize() {
		vomitBar = new VerticalProgressBar(80, 400, MAX_VAUMIT_BAR);
		angryBar = new VerticalProgressBar(80, 400, MAX_ANGRY_BAR);
		
		vomitVBox.getChildren().add(vomitBar.getProgressHolder());
		angryVBox.getChildren().add(angryBar.getProgressHolder());
	}
	
	/**
	 * Méthode appelée par JavaFX lorsque l'utilisateur appuie sur une touche du clavier.
	 *
	 * @param event,
	 * 		l'évènement généré par l'appui sur une touche du clavier par l'utilisateur
	 */
	@FXML
	private void handleOnKeyPressed(KeyEvent event) {
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
	
	/**
	 *
	 */
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
		clientsManager.unselectSelectedClient();
		resetBuilderAndView();
	}
	
	@FXML
	public void handleDeliver() {
		if (burgerBuilder != null) {
			// fixme: ce try catch devrait être fait dans la classe client je dirais...
			try {
				if (!burgerBuilder.burgerIsEmpty()) {
					Burger burger = burgerBuilder.build();
					updateCashValue(getCashValue() + burger.getPrice());
					clientsManager.removeSelectedClient();
					resetBuilderAndView();
				}
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
		nbAngry++;
		angryBar.addToValue();
		clientsManager.removeClient(client);
		//resetBuilderAndView();				//FIXME: Pas besoin de supprimer
		
		if (nbAngry >= MAX_ANGRY_BAR) {
			showLooseAlert("Trop de client en colère ont quitté votre restaurant!");
		}
	}
	
	public void aClientVomitedAndLeave() {
		nbVaumit++;
		vomitBar.addToValue();
		clientsManager.removeSelectedClient();
		
		if (nbVaumit >= MAX_VAUMIT_BAR) {
			showLooseAlert("Trop de client ont reçu une mauvaise commande et ont quitté votre restaurant en vaumissant!");
		}
	}
	
	public void startGame() {
		cash.setText(String.valueOf(START_MONNEY));
		clientsManager = new ClientsManager(waitingQueue, this);
		clientsManager.startTimers();
	}
	
	private void showLooseAlert(String message) {
		stopGame();
		waitingQueue.getChildren().clear();
		nbVaumit = 0;
		nbAngry = 0;
		
		// Ouvre une boite de dialogue annonçant la fin de la partie
		Alert alert = new Alert(Alert.AlertType.NONE);
		alert.setTitle("BurgerBuilder");
		alert.setHeaderText("Vous avez perdu!");
		alert.setContentText(message);
		
		ButtonType buttonTypeOne = new ButtonType("Rejouer"); // ajoute un bouton "Rejouer" à la boite de dialogue
		alert.getButtonTypes().add(buttonTypeOne);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne) {
			vomitBar.reset();
			angryBar.reset();
			resetBuilderAndView();
			startGame(); // démarre le jeu lorsqu'on clique sur le bouton de la boite de dialogue
		}
	}
	
	private void stopGame() {
		clientsManager.stopTimers();
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
		nbCondiments = 0;
		resetView();
	}
	
	private void updateMenuView(Client client) {
		Menu wantedMenu = client.getMenu();
		menuVBox.getChildren().clear();
		menuVBox.getChildren().add(wantedMenu.getBurger().getBurgerVBox());
	}
}