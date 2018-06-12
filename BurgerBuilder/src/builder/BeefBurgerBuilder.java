package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Classe implémentant un builder de BeefBurger. Hérite de la classe abstraite BurgerBuilder. Implémente le modèle conceptuel Singleton.
 */
public class BeefBurgerBuilder extends BurgerBuilder {
	
	private static BeefBurgerBuilder beefBurgerBuilderInstance = new BeefBurgerBuilder(); // l'instance unique du Singleton
	
	/**
	 * Retourne l'instance unique du Singleton.
	 *
	 * @return l'instance unique du singleton.
	 */
	public static BeefBurgerBuilder getInstance() {
		return beefBurgerBuilderInstance;
	}
	
	/**
	 * Constructeur privé (modèle Singleton).
	 */
	private BeefBurgerBuilder() {
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.LETTUCE, Condiment.BEEF, Condiment.CHEESE, Condiment.SAUCE, Condiment.BREAD_TOP));
	}
}