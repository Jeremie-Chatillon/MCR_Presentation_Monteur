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

public class VerticalProgressBar {
	private ProgressBar progressBar = new ProgressBar();
	private Group progressHolder = new Group(progressBar);
	private Timeline timer;
	private int max;
	private double oldValue = 0;
	private double newValue;
	
	public VerticalProgressBar(double width, double height, int max) {
		this.max = max;
		newValue = oldValue + 1.0 / max;
		
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
		newValue = oldValue + 1.0 / max;
		
		timer.playFromStart();
	}

	public void setProgress(double d){
		progressBar.setProgress(d);
	}

}
