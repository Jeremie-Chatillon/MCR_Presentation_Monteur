package structure;


import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.LinkedList;

import static controllers.Rules.CONDIMENT_BENEF;

public class Burger {
	private String name;
	private final LinkedList<Condiment> items;
	
	public Burger(LinkedList<Condiment> items) {
		this.items = items;
		name = "Undefined Burger";
	}
	
	public Burger(Condiment... condiments) {
		this.items = new LinkedList<>();
		this.items.addAll(Arrays.asList(condiments));
		name = "Undefined Burger";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LinkedList<Condiment> getItems() {
		return items;
	}
	
	public int getPrice(){
		int brugerPrice = 0;
		for (Condiment c: items) {
			brugerPrice += c.getPrice() + CONDIMENT_BENEF;
		}
		return brugerPrice;
	}
	
	@Override
	public String toString() {
		return name + ": " + items.toString();
	}
	
	/**
	 * Retourne un objet vbox contenant les images du burger. Permet de dessiner le burger.
	 *
	 * @return une vbox contenant les images des éléments du burger.
	 */
	public VBox getBurgerVBox() {
		VBox vbox = new VBox();
		for (Condiment c : items) {
			ImageView imageView = new ImageView();
			imageView.setFitHeight(50);
			imageView.setFitWidth(100);
			imageView.setImage(c.getImage());
			
			vbox.getChildren().add(imageView);
			imageView.toBack();
		}
		return vbox;
	}
}