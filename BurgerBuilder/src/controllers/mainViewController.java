package controllers;

import builder.BurgerBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import structure.Condiment;

import static javafx.scene.input.KeyCode.*;


public class mainViewController{
	
	@FXML
	private Button cancel;
	
	@FXML
	private ImageView chicken;
	
	@FXML
	private ImageView imgClient;
	
	@FXML
	private ImageView breadTop;
	
	@FXML
	private VBox clientView;
	
	@FXML
	private Label timerClient;
	
	@FXML
	private Button deliver;
	
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
	private HBox waitingQueue;
	
	@FXML
	private ImageView tomatoe;
	
	@FXML
	private VBox builderVBox;
	
	@FXML
	private VBox satisfactionVBox;
	
	@FXML
	private ImageView fish;
	
	@FXML
	private ImageView breadBottom;
	
	@FXML
	private HBox ProgressBarHBox;
	
	@FXML
	private VBox vomitVBox;
	
	@FXML
	private ImageView ognon;
	
	@FXML
	private Label menuClient;
	
	@FXML
	private Label cash;
	
	private VerticalProgressBar vomitBar;
	
	private VerticalProgressBar satisfactionBar;
	
	private BurgerBuilder burgerBuilder;
	
	private int nbCondiments;
	
	private ClientsManager clientsManager;
	
	@FXML
	void initialize() {
		vomitBar = new VerticalProgressBar(80, 400);
		satisfactionBar = new VerticalProgressBar(80, 400);
		
		vomitVBox.getChildren().add(vomitBar.getProgressHolder());
		satisfactionVBox.getChildren().add(satisfactionBar.getProgressHolder());
/*
        bind(KeyEvent.VK_A, );
        bind(KeyEvent.VK_B, );
        bind(KeyEvent.VK_C, );
        bind(KeyEvent.VK_D, );
        bind(KeyEvent.VK_E, );
        bind(KeyEvent.VK_F, );
        bind(KeyEvent.VK_G, );
        bind(KeyEvent.VK_H, );
        bind(KeyEvent.VK_I, );
        bind(KeyEvent.VK_J, );
        bind(KeyEvent.VK_K, );
       */


		
		clientsManager = new ClientsManager(waitingQueue);
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

            case BACK_SPACE:
                handleCancel();
                break;
        }


    }
	
	@FXML
	void handleSauce() {
		addCondiment(Condiment.SAUCE);
	}
	
	@FXML
	void handleLettuce() {
		addCondiment(Condiment.LETTUCE);
	}
	
	@FXML
	void handleOgnon() {
		addCondiment(Condiment.OGNON);
	}
	
	@FXML
	void handlePickle() {
		addCondiment(Condiment.PICKLE);
	}
	
	@FXML
	void handleCheese() {
		addCondiment(Condiment.CHEESE);
	}
	
	@FXML
	void handleTomatoe() {
		addCondiment(Condiment.TOMATOE);
	}
	
	@FXML
	void handleFish() {
		addCondiment(Condiment.FISH);
	}
	
	@FXML
	void handleChicken() {
		addCondiment(Condiment.CHICKEN);
	}
	
	@FXML
	void handleBeef() {
		addCondiment(Condiment.BEEF);
	}
	
	
	@FXML
	void handleBreadTop() {
		addCondiment(Condiment.BREAD_TOP);
	}
	
	@FXML
	void handleBreadBot() {
		addCondiment(Condiment.BREAD_BOT);
	}
	
	@FXML
	public void handleCancel() {
		/*
		if (burgerBuilder == null) {
			return;
		}
		*/
		
		//burgerBuilder.clear();
		burgerBuilder = null;
		nbCondiments = 0;
		builderVBox.getChildren().clear();
	}
	
	@FXML
	public void handleDeliver() {
        handleCustomer();
		if (burgerBuilder == null) {
			return;
		}
		
		if (burgerBuilder.build() == null) {
			// vaumitBar.add(1);
		}
		
		//updateCashValue(getCashValue() + curentCustomer.getPriceOrder());
		
		burgerBuilder = null;
	}
	
	@FXML
	private void handleCustomer() {
		if (burgerBuilder == null) {
			clientsManager.setSelectedClient();
		}
		
		
		//currentCustomer = c;
		//burgerBuilder = customer.getBurgerBuilder();
	}
	
	private void addCondimentInBurger(Image image) {
		final ImageView imv = new ImageView();
		imv.setFitHeight(100);
		imv.setFitWidth(200);
		imv.setImage(image);
		
		builderVBox.getChildren().add(imv);
		imv.toBack();
	}
	
	public void updateCashValue(int newCashValue) {
		cash.setText(String.valueOf(newCashValue));
	}
	
	public int getCashValue() {
		return Integer.parseInt(cash.getText());
	}
	
	private void addCondiment(Condiment c) {
		/*
		if (burgerBuilder == null) {
			return;
		}
		*/
		
		if (nbCondiments < 10) {
			nbCondiments++;
			updateCashValue(getCashValue() - c.getPrice());
			
			//burgerBuilder.addCondiment(c);
			addCondimentInBurger(c.getImage());
		}
	}
}