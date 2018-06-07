package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import static controllers.Rules.MAX_VAUMIT_HANGRY_BAR;

public class VerticalProgressBar {
	private ProgressBar progressBar = new ProgressBar();
	private Group progressHolder = new Group(progressBar);
	private Timeline timer;
	
	private double oldValue = 0;
	private double newValue = oldValue + 1.0 / MAX_VAUMIT_HANGRY_BAR;
	
	public VerticalProgressBar(double width, double height) {
		progressBar.setMinSize(StackPane.USE_PREF_SIZE, StackPane.USE_PREF_SIZE);
		progressBar.setPrefSize(height, width);
		progressBar.setMaxSize(StackPane.USE_COMPUTED_SIZE, StackPane.USE_COMPUTED_SIZE);
		progressBar.getTransforms().setAll(
				new Translate(0, width),
				new Rotate(-90, 0, 0)
		);
		progressBar.setProgress(oldValue);
		
		
		timer = new Timeline(
				new KeyFrame(
						Duration.ZERO,
						new KeyValue(progressBar.progressProperty(), oldValue)
				),
				new KeyFrame(
						Duration.seconds(2),
						new KeyValue(progressBar.progressProperty(), newValue)
				)
		);
	}
	
	public ProgressBar getProgressBar() {
		return progressBar;
	}
	
	public Group getProgressHolder() {
		return progressHolder;
	}
	
	public void addToValue() {
		if (oldValue <= MAX_VAUMIT_HANGRY_BAR) {
			timer = new Timeline(
					new KeyFrame(
							Duration.ZERO,
							new KeyValue(progressBar.progressProperty(), oldValue)
					),
					new KeyFrame(
							Duration.seconds(2),
							new KeyValue(progressBar.progressProperty(), newValue)
					)
			);
			oldValue = newValue;
			newValue = oldValue + 1.0 / MAX_VAUMIT_HANGRY_BAR;
			
			timer.playFromStart();
		} else {
			System.out.println("La barre de vomit ou celle de satisfaction est plein! --> Perdu!");
			// TODO: mettre fin au jeu!
		}
	}
}