package controllers;

import javafx.scene.layout.HBox;
import structure.Person;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static controllers.Rules.NB_MAX_CLIENTS;
import static controllers.Rules.NB_MS_BEFORE_NEW_CLIENT;

public class ClientsManager implements Runnable {
	private MainViewController mainViewController;
	
	private HBox waitingQueue;
	private Person selectedClient;
	private ArrayList<Person> waitingClients;
	private Timer timer;
	private int nbClientsWaiting = 0;
	
	public ClientsManager(HBox waitingQueue, MainViewController mainViewController) {
		this.mainViewController = mainViewController;
		
		this.waitingQueue = waitingQueue;
		waitingClients = new ArrayList<>(NB_MAX_CLIENTS);
		selectedClient = addNewClientToQueue();
	}
	
	public void setSelectedClient(Person selectedClient) {
		this.selectedClient = selectedClient;
	}
	
	private Person addNewClientToQueue() {
		Person p = new Person(mainViewController);
		waitingQueue.getChildren().add(p.getPersonNode());
		waitingClients.add(p);
		nbClientsWaiting++;
		return p;
	}
	
	@Override
	public void run() {
		
		// un nouveau client arrive toute les 30 secondes.
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					wait(NB_MS_BEFORE_NEW_CLIENT);
					addNewClientToQueue();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}, 60*1000);
	}
	
}