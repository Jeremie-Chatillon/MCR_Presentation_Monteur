package controllers;

import javafx.scene.Group;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class VerticalProgressBar {
	private ProgressBar progressBar = new ProgressBar();
	private Group progressHolder = new Group(progressBar);

	double MAX = 1;
	double value = 0;

	public VerticalProgressBar(double width, double height) {
		progressBar.setMinSize(StackPane.USE_PREF_SIZE, StackPane.USE_PREF_SIZE);
		progressBar.setPrefSize(height, width);
		progressBar.setMaxSize(StackPane.USE_COMPUTED_SIZE, StackPane.USE_COMPUTED_SIZE);
		progressBar.getTransforms().setAll(
				new Translate(0, width),
				new Rotate(-90, 0, 0)
		);

		progressBar.setProgress(value);
	}
	
	public ProgressBar getProgressBar() {
		return progressBar;
	}
	
	public Group getProgressHolder() {
		return progressHolder;
	}

	void setProgress(double value){
		progressBar.setProgress(value);
	}
}