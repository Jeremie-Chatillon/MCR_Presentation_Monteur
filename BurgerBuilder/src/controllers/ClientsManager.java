package controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import structure.Client;

import java.util.Random;

import static controllers.Rules.NB_MAX_CLIENTS;
import static controllers.Rules.NB_MS_BEFORE_NEW_CLIENT;

public class ClientsManager {
	private MainViewController mainViewController;
	
	private HBox waitingQueue;
	private Client selectedClient;
	private Timeline timer;
	private int remainingTime;
	private int nbClientsWaiting = 0;
	private Random random = new Random();
	
	public ClientsManager(HBox waitingQueue, MainViewController mainViewController) {
		this.mainViewController = mainViewController;
		this.waitingQueue = waitingQueue;
		selectedClient = addNewClientToQueue();
		remainingTime = 5000;
		
		timer = new Timeline(new KeyFrame(
				Duration.millis(250),
				event -> {
					remainingTime -= 250;
					//drawClient(); // TODO: à vérifier si utile
					
					if (remainingTime <= 0) {
						System.out.println("Un nouveau client est arrivé dans la queue!");
						addNewClientToQueue();
						remainingTime = random.nextInt((NB_MS_BEFORE_NEW_CLIENT - 10000) + 1000) + 10000;
						System.out.println(remainingTime);
						
					}
				}
		));
		timer.setCycleCount(Animation.INDEFINITE);
	}
	
	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}
	
	private Client addNewClientToQueue() {
		Client client = null;
		if (waitingQueue.getChildren().size() < NB_MAX_CLIENTS) {
			client = new Client(mainViewController);
			waitingQueue.getChildren().add(client);
			nbClientsWaiting++;
			client.startTimer();
		}
		return client;
	}
	
	public void removeClient(Client client) {
		waitingQueue.getChildren().remove(client);
	}
	
	public void startTimers() {
		timer.play();
		ObservableList<Client> children = (ObservableList)waitingQueue.getChildren();
		for (Client c : children) {
			c.startTimer();
		}
	}
}