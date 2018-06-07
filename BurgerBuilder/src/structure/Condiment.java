package structure;

import javafx.scene.image.Image;

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
	
	private Image img;
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public Image getImage() {
		return img;
	}
	
	Condiment(String name, int price, String pathToImage) {
		this.name = name;
		this.price = price;
		this.img = new Image(pathToImage);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}

