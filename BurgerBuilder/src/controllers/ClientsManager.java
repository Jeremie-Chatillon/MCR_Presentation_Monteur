package controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import structure.Client;

import java.util.Random;

import static controllers.Rules.*;

public class ClientsManager {
	private MainViewController mainViewController;
	
	private HBox waitingQueue;
	private Client selectedClient;
	private Timeline timer;
	private int remainingTime;
	private Random random = new Random();
	private boolean gameIsRunning = false;
	
	public ClientsManager(HBox waitingQueue, MainViewController mainViewController) {
		this.mainViewController = mainViewController;
		this.waitingQueue = waitingQueue;
		addNewClientToQueue(true, gameIsRunning);
		remainingTime = 5000;
		
		timer = new Timeline(new KeyFrame(
				Duration.millis(250),
				event -> {
					remainingTime -= 250;
					
					if (remainingTime <= 0) {
						System.out.println("Un nouveau client est arrivé dans la queue!");
						addNewClientToQueue(false, gameIsRunning);
						remainingTime = random.nextInt(NB_MS_MAX_BEFORE_NEW_CLIENT - NB_MS_MIN_BEFORE_NEW_CLIENT) + NB_MS_MIN_BEFORE_NEW_CLIENT;
						System.out.println(remainingTime);
						
					}
				}
		));
		timer.setCycleCount(Animation.INDEFINITE);
	}
	
	public void setSelectedClient(Client selectedClient) {
		if(this.selectedClient != null) {
			this.selectedClient.startTimer();     // on redémarre le timer du client actuellement sélectionné
		}

		this.selectedClient = selectedClient; // on sélectionne le nouveau client
		selectedClient.stopTimer();           // on arrête son timer
	}
	
	private void addNewClientToQueue(boolean selectNewClient, boolean gameStarted) {
		if (waitingQueue.getChildren().size() < NB_MAX_CLIENTS) {
			Client client = new Client(mainViewController);
			waitingQueue.getChildren().add(client);
			
			if (selectNewClient) {
				selectedClient = client;
			}
			if (gameStarted) {
				client.startTimer();
			}
		}
	}
	
	public void removeSelectedClient() {
		removeClient(selectedClient);
	}
	
	public void removeClient(Client client) {
		waitingQueue.getChildren().remove(client);

		System.err.println(waitingQueue.getChildren().size());	//FIXME
	}
	
	public void startTimers() {
		gameIsRunning = true;
		timer.play();
		ObservableList<Client> children = (ObservableList) waitingQueue.getChildren();
		for (Client c : children) {
			c.startTimer();
		}
	}
}