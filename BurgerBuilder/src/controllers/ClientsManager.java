package controllers;

import javafx.scene.layout.HBox;
import structure.Person;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class ClientsManager implements Runnable {
	private static final int NB_MAX_CLIENTS = 4;
	private HBox waitingQueue;
	private Person selectedClient;
	private Timer timer;
	Semaphore semaphore = new Semaphore(NB_MAX_CLIENTS);
	
	public ClientsManager(HBox waitingQueue) {
		this.waitingQueue = waitingQueue;
		
		selectedClient = new Person();
		waitingQueue.getChildren().add(selectedClient.getClientView());
	}
	
	public void setSelectedClient(Person selectedClient) {
		this.selectedClient = selectedClient;
	}
	
	@Override
	public void run() {
		
		// un nouveau client arrive toute les 30 secondes.
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// Your database code here
				
			}
		}, 60*1000);
	}
}
