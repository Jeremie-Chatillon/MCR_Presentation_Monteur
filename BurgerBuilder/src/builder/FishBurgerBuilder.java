package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Classe implémentant un builder de FishBurger. Hérite de la classe abstraite BurgerBuilder. Implémente le modèle conceptuel Singleton.
 */
public class FishBurgerBuilder extends BurgerBuilder {
	
	private static FishBurgerBuilder fishBurgerBuilderInstance = new FishBurgerBuilder(); // l'instance unique du Singleton
	
	/**
	 * Retourne l'instance unique du Singleton.
	 *
	 * @return l'instance unique du singleton.
	 */
	public static FishBurgerBuilder getInstance() {
		return fishBurgerBuilderInstance;
	}
	
	/**
	 * Constructeur privé (modèle Singleton).
	 */
	private FishBurgerBuilder() {
		//FIXME: ne faudrait-il pas définir la liste condimentsBurgerMenu à partir du menu...?
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.PICKLE, Condiment.FISH, Condiment.TOMATOE, Condiment.CHEESE, Condiment.OGNON, Condiment.BREAD_TOP));
	}
}
