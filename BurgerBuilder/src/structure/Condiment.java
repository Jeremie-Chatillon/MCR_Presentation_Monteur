package structure;

import javafx.scene.image.Image;

/**
 * Énumération définissant les condiments utilisés pour créer les burgers.
 */
public enum Condiment {
	BREAD_TOP("Bread_top", 1, "breadTop.png"),
	BREAD_BOT("Bread_bot", 1, "breadBottom.png"),
	BEEF("Beef", 8, "beef.png"),
	CHICKEN("Chicken", 7, "chicken.png"),
	FISH("Fish", 8, "fish.png"),
	TOMATOE("Tomatoe", 3, "tomatoe.png"),
	CHEESE("Cheese", 3, "cheese.png"),
	PICKLE("Pickle", 2, "pickle.png"),
	OGNON("Ognon", 2, "ognon.png"),
	LETTUCE("Lettuce", 1, "lettuce.png"),
	SAUCE("Sauce", 1, "sauce.png");
	
	private String name;
	
	private int price;
	
	private Image img; // l'image permettant d'afficher le condiment dans la GUI
	
	/**
	 * Construit un condiment avec le nom, le prix et le chemin jusq'à l'image du condiment reçus en paramètres.
	 *
	 * @param name,
	 * 		le nom du condiment.
	 * @param price,
	 * 		le prix à l'achat du condiment. Ce prix est débité de la caisse lorsque le condiment est utilisé dans un burger.
	 * @param pathToImage,
	 * 		le chemin menant jusqu'à l'image à utiliser pour dessiner le condiment dans la GUI.
	 */
	Condiment(String name, int price, String pathToImage) {
		this.name = name;
		this.price = price;
		this.img = new Image(pathToImage);
	}
	
	/**
	 * Retourne le nom du consiment sous forme de String.
	 *
	 * @return une string, le nom du condiment
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Retourne le prix à l'achat du condiment. Ce prix est débité de la caisse lorsque le condiment est utilisé dans un burger.
	 *
	 * @return le prix du condiment.
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Retourne l'image permettant de dessiner le condiment dans la GUI.
	 *
	 * @return une Image, l'image du condiment.
	 */
	public Image getImage() {
		return img;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}

