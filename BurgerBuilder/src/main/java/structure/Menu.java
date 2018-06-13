package structure;

import builder.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Classe implémentant les menus proposés par le restaurant.
 */
public class Menu {
	// liste statique contenant tous les menus proposés par le restaurant
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
	
	// l'instance du singleton du burgerBuilder associé au menu -> chaque menu implémente sa propre sous-classe de burgerBuilder
	private BurgerBuilder builder;
	
	private Burger burger; // le burger exemple associé au menu
	
	/**
	 * Crée un menu avec le nom et l'instance du singleton de BurgerBuilder passée en paramètre.
	 *
	 * @param name, le nom à donner au menu.
	 *
	 * @param burgerBuilder, le builder concret qui sera utilisé pour construire se menu.
	 */
	private Menu(String name, BurgerBuilder burgerBuilder) {
		this.name = name + " Burger";
		this.builder = burgerBuilder;
		burger = builder.createBurger(); // le burger est construit à l'aide du burgerBuilder
	}
	
	/**
	 * Retourne un menu choisi aléatoirement parmi tous les menus proposés par le restaurant.
	 *
	 * @return un menu choisi aléatoirement.
	 */
	public static Menu getOneRandomMenu() {
		Random random = new Random();
		int i = random.nextInt(menus.size()); // sélectionne un entier dans l'intervalle [0; menu.size()[
		
		return menus.get(i);
	}
	
	/**
	 * Retourne le burgerBuilder associé au menu.
	 *
	 * @return le burgerBuilder associé au menu.
	 */
	public BurgerBuilder getBurgerBuilder() {
		return builder;
	}
	
	/**
	 * Retourne le burger assoccié au menu.
	 *
	 * @return le burger associé au menu.
	 */
	public Burger getBurger() {
		return burger;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

