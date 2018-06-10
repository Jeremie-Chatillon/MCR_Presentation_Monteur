package structure;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

/**
 * Implémente une ProgressBar verticale.
 */
public class VerticalProgressBar {
	private ProgressBar progressBar = new ProgressBar();
	private Group progressHolder = new Group(progressBar); // le contenant javaFX de la ProgressBar
	private Timeline timer; // le timer animant le remplissage de la progressBar
	private double increment; // la valeur qui sera ajouté à chaque modification de la valeur de la progressBar.
	private double oldValue = 0; // la valeur de la progressBar avant le début de son incrémentation de +increment.
	private double newValue; // la valeur de la progressBar à la fin de son incrémentation de +increment.
	
	/**
	 * Crée une verticalProgressBar de la largeur et la hauteur reçue en paramètre et nécessitant max appels à la méthode addToValue pour être
	 * remplie.
	 *
	 * @param width,
	 * 		la largeur de la verticalProgressBar.
	 * @param height,
	 * 		la hauteur de la verticalProgressBar.
	 * @param max,
	 * 		le nombre d'appels à la méthode addToValue nécessaires afin de remplir la verticalProgressBar.
	 */
	public VerticalProgressBar(double width, double height, int max) {
		increment = 1.0 / max;
		newValue = oldValue + increment;
		progressBar.setProgress(oldValue);
		
		// on effectue les transformations nécessaire pour placer la progressBar verticalement
		progressBar.setMinSize(StackPane.USE_PREF_SIZE, StackPane.USE_PREF_SIZE);
		progressBar.setPrefSize(height, width);
		progressBar.setMaxSize(StackPane.USE_COMPUTED_SIZE, StackPane.USE_COMPUTED_SIZE);
		progressBar.getTransforms().setAll(
				new Translate(0, width),
				new Rotate(-90, 0, 0)
		);
		
		// le timer animant le remplissage de la verticalProgressBar
		timer = new Timeline(
				new KeyFrame(
						Duration.ZERO,
						new KeyValue(progressBar.progressProperty(), oldValue)
				),
				new KeyFrame(
						Duration.seconds(1),
						new KeyValue(progressBar.progressProperty(), newValue)
				)
		);
	}
	
	/**
	 * Retourne le noeud javaFX contenant la verticalProgressBar.
	 *
	 * @return le noeud javaFX contenant la verticalProgressBar.
	 */
	public Group getProgressHolder() {
		return progressHolder;
	}
	
	/**
	 * Incrémente la valeur de la verticalProgressBar de +1.0/max.
	 */
	public void addToValue() {
		// le timer animant le remplissage de la verticalProgressBar
		timer = new Timeline(
				new KeyFrame(
						Duration.ZERO,
						new KeyValue(progressBar.progressProperty(), oldValue)
				),
				new KeyFrame(
						Duration.seconds(1),
						new KeyValue(progressBar.progressProperty(), newValue)
				)
		);
		// on update oldValue et newValue
		oldValue = newValue;
		newValue = oldValue + increment;
		
		timer.play(); // on démarre le timer -> anime le remplissage de la verticalProgressBar
	}
	
	/**
	 * Réinitialise la ProgressBar.
	 */
	public void reset(){
		oldValue = 0;
		newValue = oldValue + increment;
		progressBar.setProgress(0);
	}
}
