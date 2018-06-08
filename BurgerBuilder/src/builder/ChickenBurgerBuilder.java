package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Classe implémentant un builder de ChickenBurger. Hérite de la classe abstraite BurgerBuilder. Implémente le modèle conceptuel Singleton.
 */
public class ChickenBurgerBuilder extends BurgerBuilder {
	
	private static ChickenBurgerBuilder chickenBurgerBuilderInstance = new ChickenBurgerBuilder(); // l'instance unique du Singleton
	
	/**
	 * Retourne l'instance unique du Singleton.
	 *
	 * @return l'instance unique du singleton.
	 */
	public static ChickenBurgerBuilder getInstance() {
		return chickenBurgerBuilderInstance;
	}
	
	/**
	 * Constructeur privé (modèle Singleton).
	 */
	private ChickenBurgerBuilder() {
		//FIXME: ne faudrait-il pas définir la liste condimentsBurgerMenu à partir du menu...?
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.OGNON, Condiment.SAUCE, Condiment.CHICKEN, Condiment.TOMATOE, Condiment.BREAD_TOP));
	}
}
