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
import javafx.stage.Stage;
import structure.*;

import java.util.Optional;

import static structure.Rules.*;

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
	
	@FXML
	private Label labelNbClientsDelivred; // Label affichant le nombre de clients qui sont repartis à temps avec la commande qu'ils souhaitaient
	
	@FXML
	private Label labelNbClientsVomited; // Label affichant le nombre de clients qui ont reçu la mauvaise commande et l'ont vomie
	
	@FXML
	private Label labelNbClientsAngry; // Label affichant le nombre de clients qui n'ont pas été servis à temps
	
	private VerticalProgressBar vomitBar; // la verticalProgressBar de vomit
	
	private VerticalProgressBar angryBar; // la verticalProgressBar de colère
	
	private BurgerBuilder burgerBuilder;
	
	
	private int nbCondiments = 0;
	
	private int nbClientsDelivred = 0; // nombre de clients qui sont repartis à temps avec la commande qu'ils souhaitaient
	
	private int nbClientsVomited = 0; // nombre de clients qui ont reçu la mauvaise commande et l'ont vomie
	
	private int nbClientsAngry = 0; // nombre de clients qui n'ont pas été servis à temps
	
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
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute la sauce au burgerBuilder.
	 */
	@FXML
	private void handleSauce() {
		addCondiment(Condiment.SAUCE);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute la salade au burgerBuilder.
	 */
	@FXML
	private void handleLettuce() {
		addCondiment(Condiment.LETTUCE);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute les oignons au burgerBuilder.
	 */
	@FXML
	private void handleOgnon() {
		addCondiment(Condiment.OGNON);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute le cornichon au burgerBuilder.
	 */
	@FXML
	private void handlePickle() {
		addCondiment(Condiment.PICKLE);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute le fromage au burgerBuilder.
	 */
	@FXML
	private void handleCheese() {
		addCondiment(Condiment.CHEESE);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute la tomate au burgerBuilder.
	 */
	@FXML
	private void handleTomatoe() {
		addCondiment(Condiment.TOMATOE);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute le poisson au burgerBuilder.
	 */
	@FXML
	private void handleFish() {
		addCondiment(Condiment.FISH);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute le poulet au burgerBuilder.
	 */
	@FXML
	private void handleChicken() {
		addCondiment(Condiment.CHICKEN);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute la viande au burgerBuilder.
	 */
	@FXML
	private void handleBeef() {
		addCondiment(Condiment.BEEF);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute le pain du haut au burgerBuilder.
	 */
	@FXML
	private void handleBreadTop() {
		addCondiment(Condiment.BREAD_TOP);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur l'image correspondant dans la barre des condiments à gauche de la GUI ou appuie sur
	 * la touche du clavier correspondante.
	 * <br>Ajoute le pain du bas au burgerBuilder.
	 */
	@FXML
	private void handleBreadBot() {
		addCondiment(Condiment.BREAD_BOT);
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur le bouton <b>Annuler la commande</b>, sur la touche du clavier correspondante ou
	 * sur le menu Builder -> Annuler la commande.
	 * Réinitialise le burgerBuilder et désélectionne le client actuellement sélectionné.
	 */
	@FXML
	public void handleCancel() {
		clientsManager.unselectSelectedClient();
		resetMenuView();
		resetBurgerBuilder();
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur le bouton <b>Livrer au client</b> ou sur la touche du clavier correspondante. Livre
	 * le burger au client actuellement sélectionné. Si le burger est correct, incrémente la caisse du restaurant. Si le burger est incorrect,
	 * augmente la jauge de vomit du restaurant et réinitialise le burgerBuilder. Si la jauge devient pleine, la partie est perdue.
	 */
	@FXML
	public void handleDeliver() {
		if (burgerBuilder != null) {
			// fixme: ce try catch devrait être fait dans la classe client je dirais...
			try {
				if (!burgerBuilder.burgerIsEmpty()) {
					Burger burger = burgerBuilder.build();
					updateCashValue(getCashValue() + burger.getPrice());
					clientsManager.removeSelectedClient();
					labelNbClientsDelivred.setText(String.valueOf(++nbClientsDelivred));
				}
			} catch (IllegalArgumentException e) {
				aClientVomitedAndLeave();
			} finally {
				resetBurgerBuilder();
				resetMenuView();
			}
		}
	}
	
	/**
	 * Méthode appelé par JavaFX lorsque l'utilisateur clique sur un client de la file d'attente ou sur la touche du clavier correspondante.
	 * Sélectionne le client.
	 */
	@FXML
	public void handleCustomer(Client client) {
		if (burgerBuilder == null) {
			menuLabel.setText("Vite, réalisez la commande du client avant qu'il ne s'impatiente!");
			clientsManager.setSelectedClient(client);
			burgerBuilder = client.getBurgerBuilder();
			updateMenuView(client);
		}
	}
	
	/**
	 * Méthode appelée par JavaFX lorsque l'utilisateur clique sur le menu Fichier -> Quitter.
	 * Quitte le programme.
	 */
	@FXML
	private void handleQuit() {
		Stage stage = (Stage) builderVBox.getScene().getWindow();
		stage.close(); // ferme la fenêtre
	}
	
	
	/**
	 * Méthode appelée par JavaFX lorsque l'utilisateur clique sur le menu Aide -> Règles du jeu.
	 * Ouvre une fenêtre affichant les règles du jeu et mettant le jeu en pause.
	 */
	@FXML
	private void handleHelp() {
		pauseGame();
		
		// Ouvre une boite de dialogue affichant les règles
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("BurgerBuilder");
		alert.setHeaderText("Règles du jeu");
		alert.setContentText("Le but du jeu est de servir autant de client que possible afin que votre restaurant de burger fasse fortune !" +
				"\nMais attention! Si vous tardez trop à servir un client, il s'en ira en colère, et si vous lui ne donnez pas ce qu'il demande, " +
				"il vomira!\nDans les deux cas, la jauge correspondante augmentera. Remplissez une des deux jauge et c'est perdu !" +
				"\nAttention également à ne pas gaspiller les condiments. Ceux-ci vous coutent et si le cash de votre restaurant arrive à 0, ça sera" +
				" la faillite! \n\n" +
				"Utilisez les touches du clavier pour jouer. Les touches numérotées vous permettent de sélectionner le client que vous souhaitez " +
				"servir. \n La touche Enter livre le burger au client.\nEffacer supprime le burger actuel.\nAppuyez sur la touche correspondante au " +
				"condiment que vous souhaitez ajouter à votre burger. ATTENTION! L'ordre des condiments est important!");
		
		ButtonType buttonTypeOne = new ButtonType("C'est compris"); // ajoute un bouton "C'est compris" à la boite de dialogue
		alert.getButtonTypes().clear();
		alert.getButtonTypes().add(buttonTypeOne);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne) {
			continueGame(); // relance le jeu là où il avit été interrompu lorsqu'on clique sur le bouton de la boite de dialogue
		}
	}
	
	/**
	 * Méthode appelée lorsqu'un client s'impatiente (à la fin de son timer) et quitte le restaurant en colère sans avoir reçu sa commande. Incrémente
	 * la jauge de colère des clients. Si la jauge devient pleine, la partie est perdue.
	 *
	 * @param client,
	 * 		le client impatient qui quitte le restaurant en colère.
	 */
	public void anAngryClientLeave(Client client) {
		nbClientsAngry++;
		labelNbClientsAngry.setText(String.valueOf(nbClientsAngry));
		angryBar.addToValue();
		clientsManager.removeClient(client);
		
		if (nbClientsAngry >= MAX_ANGRY_BAR) {
			showLooseAlert("Trop de client en colère ont quitté votre restaurant!");
		}
	}
	
	/**
	 * Méthode appelée lorsque le joueur livre à un client un burger incorrect. Un burger est considéré incorrect si ses composants ne contiennent pas
	 * exactement les mêmes que ceux du burger type du menu et qu'ils ne sont pas exactement dans le même ordre. Le client quitte le restaurant sans
	 * payer, vomit, et incrémente la jauge de vomit des clients. Si la jauge devient pleine, la partie est perdue.
	 */
	public void aClientVomitedAndLeave() {
		++nbClientsVomited;
		labelNbClientsVomited.setText(String.valueOf(nbClientsVomited));
		vomitBar.addToValue();
		clientsManager.removeSelectedClient();
		
		if (nbClientsVomited >= MAX_VAUMIT_BAR) {
			showLooseAlert("Trop de client ont reçu une mauvaise commande et ont quitté votre restaurant en vaumissant!");
		}
	}
	
	/**
	 * Démarre le jeu en lançant les timers des clients et de la file d'attente.
	 */
	public void startGame() {
		cash.setText(String.valueOf(START_MONNEY));
		clientsManager = new ClientsManager(waitingQueue, this);
		clientsManager.startTimers();
	}
	
	/**
	 * Affiche une boite de dialogue annonçant la fin de la partie. S'affiche lorsque la jauge de vomit ou celle de colère est pleine, ou lorsque le
	 * restaurant n'a plus d'argent.
	 *
	 * @param message,
	 * 		le message à afficher indiquant la raison de la défaite.
	 */
	private void showLooseAlert(String message) {
		stopGame();
		waitingQueue.getChildren().clear();
		
		// Ouvre une boite de dialogue annonçant la fin de la partie
		Alert alert = new Alert(Alert.AlertType.NONE);
		alert.setTitle("BurgerBuilder");
		alert.setHeaderText("Vous avez perdu!");
		alert.setContentText(message +
				"\nArgent restant : " + cash.getText() +
				"\nNombre de clients servis : " + nbClientsDelivred +
				"\nNombre de clients ayant vomi : " + nbClientsVomited +
				"\nNombre de clients n'ayant pas été servis à temps : " + nbClientsAngry);
		
		nbClientsVomited = 0;
		nbClientsAngry = 0;
		
		ButtonType buttonTypeOne = new ButtonType("Rejouer"); // ajoute un bouton "Rejouer" à la boite de dialogue
		alert.getButtonTypes().add(buttonTypeOne);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne) {
			vomitBar.reset();
			angryBar.reset();
			resetBurgerBuilder();
			resetMenuView();
			startGame(); // démarre le jeu lorsqu'on clique sur le bouton de la boite de dialogue
		}
	}
	
	/**
	 * Met en pause la partie en arrêant temporairement tous les timers.
	 */
	private void pauseGame() {
		clientsManager.pauseTimers();
	}
	
	
	/**
	 * Relance la partie là où elle a été interrompue en redémarrant tous les timers.
	 */
	private void continueGame() {
		clientsManager.startTimers();
	}
	
	/**
	 * Arrête la partie en arrêant et réinitialisant tous les timers.
	 */
	private void stopGame() {
		clientsManager.stopTimers();
	}
	
	/**
	 * Retourne l'argent disponible dans la caisse du restaurant.
	 *
	 * @return l'argent de la caisse du restaurant.
	 */
	private int getCashValue() {
		return Integer.parseInt(cash.getText());
	}
	
	/**
	 * Met à jour l'argent disponible dans la caisse du restaurant avec la valeur passée en paramètres.
	 *
	 * @param newCashValue,
	 * 		la nouvelle valeur de la caisse du restaurant.
	 */
	private void updateCashValue(int newCashValue) {
		cash.setText(String.valueOf(newCashValue));
		if (newCashValue <= 0) {
			cash.setText("0");
			showLooseAlert("Votre restaurant n'a plus d'argent! Vous avez perdu!");
		}
	}
	
	/**
	 * Ajoute le condiment reçu en paramètre au burgerBuilder et retire le prix du condiment de la caisse du restaurant.
	 *
	 * @param c,
	 * 		le condiment à ajouter au burger.
	 */
	private void addCondiment(Condiment c) {
		if (burgerBuilder != null && nbCondiments < NB_MAX_CONDIMENT) {
			nbCondiments++;
			burgerBuilder.addCondiment(c);
			addCondimentImageToBurgerBuilderView(c.getImage());
			updateCashValue(getCashValue() - c.getPrice());
		}
	}
	
	/**
	 * Ajoute l'image du condiment à la vue du burgerBuilder dans la GUI.
	 *
	 * @param image,
	 * 		l'image du condiment à ajouter.
	 */
	private void addCondimentImageToBurgerBuilderView(Image image) {
		final ImageView imv = new ImageView();
		double imgHeight = builderVBox.getHeight() / NB_MAX_CONDIMENT;
		double imgWidth = imgHeight * 2;
		imv.setFitHeight(imgHeight);
		imv.setFitWidth(imgWidth);
		imv.setImage(image);
		
		builderVBox.getChildren().add(imv);
		imv.toBack();
	}
	
	/**
	 * Réinitialise le burgerBuilder et son affichage au centre de la GUI.
	 */
	private void resetBurgerBuilder() {
		menuLabel.setText("Sélectionnez un client pour traiter sa commande");
		if (burgerBuilder != null) {
			burgerBuilder.reset();
			burgerBuilder = null;
		}
		nbCondiments = 0;
		builderVBox.getChildren().clear();
	}
	
	/**
	 * Réinitialise l'affichage du menu à la gauche de la GUI.
	 */
	private void resetMenuView() {
		menuVBox.getChildren().clear();
	}
	
	/**
	 * Met à jour le menu à gauche de la GUI. Affiche le burger exemple du burger désiré par le client passé en paramètre.
	 *
	 * @param client,
	 * 		le client dont on souhaite afficher le burger commandé.
	 */
	private void updateMenuView(Client client) {
		Menu wantedMenu = client.getMenu();
		menuVBox.getChildren().clear();
		menuVBox.getChildren().add(wantedMenu.getBurger().getBurgerVBox());
	}
}