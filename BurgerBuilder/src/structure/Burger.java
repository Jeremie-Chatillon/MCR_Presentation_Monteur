package structure;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

import static structure.Rules.CONDIMENT_BENEF;

/**
 * Classe implémentant un burger.
 */
public class Burger {
	
	private String name;
	private final LinkedList<Condiment> content; // liste contenant tous les condiments du burger
	
	/**
	 * Construit un burger défini par la liste de condiments passée en paramètre.
	 *
	 * @param content,
	 * 		la liste de condiment définissant le burger.
	 */
	public Burger(LinkedList<Condiment> content) {
		this.content = content;
		name = "Undefined Burger";
	}
	
	/**
	 * Retourne le prix que doit payer le client pour acheter ce burger.
	 *
	 * @return un entier, le prix que doit payer le client pour acheter ce burger.
	 */
	public int getPrice() {
		int brugerPrice = 0;
		for (Condiment c : content) {
			brugerPrice += c.getPrice() + CONDIMENT_BENEF;
		}
		return brugerPrice;
	}
	
	@Override
	public String toString() {
		return name + ": " + content.toString();
	}
	
	/**
	 * Permet de dessiner le burger. Retourne une VBox contenant les images du burger.
	 *
	 * @return une VBox contenant les images des condiments constituant le burger.
	 */
	public VBox getBurgerVBox() {
		VBox vbox = new VBox();
		for (Condiment c : content) {
			ImageView imageView = new ImageView();
			imageView.setFitHeight(60);
			imageView.setFitWidth(120);
			imageView.setImage(c.getImage());
			
			vbox.getChildren().add(imageView);
			imageView.toBack();
			vbox.setAlignment(Pos.CENTER);
		}
		return vbox;
	}
}