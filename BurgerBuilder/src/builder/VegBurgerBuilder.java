package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Classe implémentant un builder de VegBurger. Hérite de la classe abstraite BurgerBuilder. Implémente le modèle conceptuel Singleton.
 */
public class VegBurgerBuilder extends BurgerBuilder {
	
	private static VegBurgerBuilder vegBurgerBuilderInstance = new VegBurgerBuilder(); // l'instance unique du Singleton
	
	/**
	 * Retourne l'instance unique du Singleton.
	 *
	 * @return l'instance unique du singleton.
	 */
	public static VegBurgerBuilder getInstance() {
		return vegBurgerBuilderInstance;
	}
	
	/**
	 * Constructeur privé (modèle Singleton).
	 */
	private VegBurgerBuilder() {
		
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.LETTUCE, Condiment.TOMATOE, Condiment.CHEESE, Condiment.LETTUCE, Condiment.BREAD_TOP));
	}
}
