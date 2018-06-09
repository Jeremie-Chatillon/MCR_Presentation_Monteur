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

/**
 * Classe implémentant la gestion et l'affichage de la file d'attente des clients.
 */
public class ClientsManager {
	private MainViewController mainViewController; // référence vers l'instance du mainViewController
	
	private Random random = new Random();
	private HBox waitingQueue;
	private Client selectedClient;
	private int remainingTime;
	private boolean gameIsRunning = false; // vaut true lorsqu'une partie est en cours, false sinon
	private Timeline timer;
	
	/**
	 * Construit un ClientsManager gérant la waitingQueue passée en paramètre et appelant des méthodes du mainViewController également passé en
	 * paramètre.
	 *
	 * @param waitingQueue,
	 * 		la HBox à gérer.
	 * @param mainViewController,
	 * 		une référence vers le mainViewController.
	 */
	public ClientsManager(HBox waitingQueue, MainViewController mainViewController) {
		this.mainViewController = mainViewController;
		this.waitingQueue = waitingQueue;
		addNewClientToQueue(gameIsRunning); // on ajoute un client à la file d'attente
		remainingTime = 5000; // le 2ème client arrive après 5 secondes
		
		timer = new Timeline(new KeyFrame(
				Duration.millis(250),
				event -> {
					remainingTime -= 250;
					if (remainingTime <= 0) { // le timer s'est écoulé
						addNewClientToQueue(gameIsRunning); // on ajoute un client à la file d'attente
						
						// on défini aléatoirement un temps entre NB_MS_MIN_BEFORE_NEW_CLIENT et NB_MS_MAX_BEFORE_NEW_CLIENT ms devant s'écouler
						// avant l'apparition du prochain client.
						remainingTime = random.nextInt(NB_MS_MAX_BEFORE_NEW_CLIENT - NB_MS_MIN_BEFORE_NEW_CLIENT) + NB_MS_MIN_BEFORE_NEW_CLIENT;
					}
				}
		));
		timer.setCycleCount(Animation.INDEFINITE); // le timer boucle à l'infini
	}
	
	/**
	 * Permet de sélectionner le client passé en paramètre afin de réaliser sa commande.
	 *
	 * @param selectedClient,
	 * 		le client à sélectionner.
	 */
	public void setSelectedClient(Client selectedClient) {
		if (this.selectedClient == null) { // vrai si aucun client n'est actuellement sélectionné
			this.selectedClient = selectedClient; // on sélectionne le nouveau client
			selectedClient.pauseTimer();           // on arrête son timer
		}
	}
	
	/**
	 * Ajoute un nouveau client à la file d'attente. Lance son timer si gameStarted vaut true.
	 *
	 * @param gameStarted,
	 * 		si vaut true, lance le timer du nouveau client, sinon, ne fait rien.
	 */
	private void addNewClientToQueue(boolean gameStarted) {
		if (waitingQueue.getChildren().size() < NB_MAX_CLIENTS) { // vrai si il y a moins de NB_MAX_CLIENTS dans la file d'attente
			Client client = new Client(mainViewController);
			waitingQueue.getChildren().add(client); // ajoute le client à la vue
			
			if (gameStarted) {
				client.startTimer(); // démarre le timer du nouveau client
			}
		}
	}
	
	/**
	 * Désélectionne le client actuellement sélectionné.
	 */
	public void unselectSelectedClient() {
		if (selectedClient != null) {
			selectedClient.startTimer();
			selectedClient = null;
		}
	}
	
	/**
	 * Supprime le client actuellement sélectionné de la file d'attente.
	 */
	public void removeSelectedClient() {
		removeClient(selectedClient);
		selectedClient = null;
	}
	
	/**
	 * Supprime le client reçu en paramètre de la file d'attente.
	 *
	 * @param client,
	 * 		le client à supprimer de la file d'attente.
	 */
	public void removeClient(Client client) {
		waitingQueue.getChildren().remove(client);
		
		// FIXME: C'est quoi le problème?
		System.err.println(waitingQueue.getChildren().size()); //FIXME
	}
	
	/**
	 * Démarre le timer du clientManager (avant l'arrivée d'un nouveau client) ainsi que de tout les clients de la file d'attente (le temps avant
	 * qu'ils s'impatientent et partent fachés).
	 */
	public void startTimers() {
		gameIsRunning = true;
		timer.play();
		
		// on cast tous les éléments de la waitingQueue en Client. Ne pose pas de problème car waitingQueue ne contient que des objets de type Client
		ObservableList<Client> children = (ObservableList) waitingQueue.getChildren();
		for (Client c : children) {
			c.startTimer(); // démarre le timer de chaque client
		}
	}
	
	/**
	 * Arrête le timer du clientManager ainsi que ceux de tout les clients de la file d'attente.
	 */
	public void stopTimers() {
		gameIsRunning = true;
		timer.stop();
		
		// on cast tous les éléments de la waitingQueue en Client. Ne pose pas de problème car waitingQueue ne contient que des objets de type Client
		ObservableList<Client> children = (ObservableList) waitingQueue.getChildren();
		for (Client c : children) {
			c.stopTimer(); // démarre le timer de chaque client
		}
	}
}