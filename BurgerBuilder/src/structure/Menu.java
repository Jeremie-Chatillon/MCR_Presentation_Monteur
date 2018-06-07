package structure;


import builder.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Menu {
	
	static List<Menu> menus = new ArrayList<>(Arrays.asList(
			new Menu("Beef", BeefBurgerBuilder.class),
			new Menu("Chicken", ChickenBurgerBuilder.class),
			new Menu("Fish", FishBurgerBuilder.class),
			new Menu("Full Meat", FullMeatBurgerBuilder.class),
			new Menu("Greek", GreekBurgerBuilder.class),
			new Menu("Vegan", VegBurgerBuilder.class)
	));
	
	private String name;
	
	// Si on a des classes abstraites pour les menus
	private Class<? extends BurgerBuilder> burgerBuilderClass;
	
	/**
	 * Test pour la class en variable public Menu(Class<? extends BurgerBuilder> burgerBuilderClass){ this.burgerBuilderClass = burgerBuilderClass; }
	 */
	
	public Menu(String name, Class<? extends BurgerBuilder> burgerBuilderClass) {
		this.name = name + " Burger";
		this.burgerBuilderClass = burgerBuilderClass;
	}
	
	public static List<Menu> getAllMenus() {
		return menus;
	}
	
	public static Menu getOneRandomMenu() {
		Random random = new Random();
		int i = random.nextInt(menus.size());
		
		return menus.get(i);
	}
	
	// Si on a des classes abstraites pour les menus
	public BurgerBuilder getNewBurgerBuilder() {
		try {
			return burgerBuilderClass.newInstance();
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	
	public String toString() {
		return name;
	}
}

