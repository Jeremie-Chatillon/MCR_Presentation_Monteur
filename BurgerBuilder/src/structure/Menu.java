package structure;

import builder.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Menu {
	public static LinkedList<Menu> menus = new LinkedList<>(
			Arrays.asList(
					new Menu("Beef", BeefBurgerBuilder.getInstance()),
					new Menu("Chicken", ChickenBurgerBuilder.getInstance()),
					new Menu("Fish", FishBurgerBuilder.getInstance()),
					new Menu("Full Meat", FullMeatBurgerBuilder.getInstance()),
					new Menu("Greek", GreekBurgerBuilder.getInstance()),
					new Menu("Vegan", VegBurgerBuilder.getInstance())
			)
	);
	
	private String name;
	
	private BurgerBuilder builder;
	
	private Burger burger;
	
	/**
	 * Test pour la classe en variable public Menu(Class<? extends BurgerBuilder> burgerBuilderClass){ this.burgerBuilderClass = burgerBuilderClass; }
	 */
	public Menu(String name, BurgerBuilder burgerBuilder) {
		this.name = name + " Burger";
		this.builder = burgerBuilder;
		burger = builder.createBurger();
	}
	
	public LinkedList<Menu> getAllMenus() {
		return menus;
	}
	
	public static Menu getOneRandomMenu() {
		Random random = new Random();
		int i = random.nextInt(menus.size());
		
		return menus.get(i);
	}
	
	public BurgerBuilder getBurgerBuilder() {
		return builder;
	}
	
	public Burger getBurger() {
		return burger;
	}
	
	public String toString() {
		return name;
	}
}

