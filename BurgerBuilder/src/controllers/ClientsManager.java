package controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import jdk.internal.org.objectweb.asm.Label;
import structure.Client;

import java.util.Iterator;
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
	private boolean gameIsRunning = true; // vaut true lorsqu'une partie est en cours, false sinon
	private Timeline timer;

	private GridPane waitingPane;
	private boolean tabUseClientGrid[];
	
	/**
	 * Construit un ClientsManager gérant la waitingQueue passée en paramètre et appelant des méthodes du mainViewController également passé en
	 * paramètre.
	 *
	 * @param waitingQueue,
	 * 		la HBox à gérer.
	 * @param mainViewController,
	 * 		une référence vers le mainViewController.
	 */
	public ClientsManager(HBox waitingQueue, MainViewController mainViewController, GridPane waitingPane) {
		this.waitingPane = waitingPane;
		tabUseClientGrid = new boolean[NB_MAX_CLIENTS];

		this.mainViewController = mainViewController;
		this.waitingQueue = waitingQueue;
		addNewClientToQueue(false, gameIsRunning); // on ajoute un client à la file d'attente
		remainingTime = 5000; // le 2ème client arrive après 5 secondes
		
		timer = new Timeline(new KeyFrame(
				Duration.millis(250),
				event -> {
					remainingTime -= 250;
					if (remainingTime <= 0) { // le timer s'est écoulé
						addNewClientToQueue(false, gameIsRunning); // on ajoute un client à la file d'attente
						
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
		if (this.selectedClient != null) { // vrai si un client est actuellement sélectionné
			this.selectedClient.startTimer(); // on redémarre le timer du client actuellement sélectionné
		} else { // vrai si aucun client n'est actuellement sélectionné
			this.selectedClient = selectedClient; // on sélectionne le nouveau client
			selectedClient.stopTimer();           // on arrête son timer
		}
	}

	public void unselectSelectedClient() {
		if(selectedClient != null) {
			this.selectedClient.startTimer();
			this.selectedClient = null;
		}

	}


	public Client selectClient(int i){

		if(tabUseClientGrid[i] == false){
			return null;
		}

		if (this.selectedClient != null) { // vrai si un client est actuellement sélectionné
			// FIXME:: ça sert à quoi ce if?
			this.selectedClient.startTimer(); // on redémarre le timer du client actuellement sélectionné
			return null;

		} else { // vrai si aucun client n'est actuellement sélectionné
			System.out.println("OKAY2" + Integer.toString(i));
			for (Node node : waitingPane.getChildren()) {
				if (waitingPane.getRowIndex(node) == 1 && waitingPane.getColumnIndex(node) == i) {
					if(node instanceof Client) {
						this.selectedClient = (Client) node;
						this.selectedClient.stopTimer();
						return (Client) node;
					} else {
						return null;
					}
				}
			}


		}
		return null;
	}
	
	/**
	 * Ajoute un nouveau client à la file d'attente. Sélectionne ce client si selectedNewClient vaut true et lance son timer si gameStarted vaut
	 * true.
	 *
	 * @param selectNewClient,
	 * 		si vaut true, sélectionne le nouveau client, sinon, ne fait rien.
	 * @param gameStarted,
	 * 		si vaut true, lance le timer du nouveau client, sinon, ne fait rien.
	 */
	private void addNewClientToQueue(boolean selectNewClient, boolean gameStarted) {

		int i = findFreeClientSpace();
		if (i != -1) {
			tabUseClientGrid[i] = true;
			Client client = new Client(mainViewController);
			waitingPane.add(client, i, 1);
			tabUseClientGrid[i] = true;

			if (selectNewClient) {
				setSelectedClient(client); // on sélectionne le client
			}
			if (gameStarted) {
				client.startTimer(); // démarre le timer du nouveau client
			}
		}
	}

	/**
	 * Cherche la première postion disponnible de la grid.
	 * @return la première position y libre. Sinon il n'y en a pas, retourne -1
	 */
	private int findFreeClientSpace(){

		for (int i = 0; i < NB_MAX_CLIENTS; ++i) {
			if (tabUseClientGrid[i] == false)
				return i;
		}
		return -1;
	}

	/**
	 * Supprime le client actuellement sélectionné de la file d'attente.
	 */
	public void removeSelectedClient() {
		removeClient(selectedClient);
		unselectSelectedClient();
	}
	
	/**
	 * Supprime le client reçu en paramètre de la file d'attente.
	 *
	 * @param client,
	 * 		le client à supprimer de la file d'attente.
	 */
	public void removeClient(Client client) {

		int col = waitingPane.getColumnIndex(client);
		tabUseClientGrid[col] = false;

		waitingPane.getChildren().remove(client);

	}
	
	/**
	 * Démarre le timer du clientManager (avant l'arrivée d'un nouveau client) ainsi que de tous les clients de la file d'attente (le temps avant
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
}