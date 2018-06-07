package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Classe implémentant un builder de FullMeatBurger. Hérite de la classe abstraite BurgerBuilder. Implémente le modèle conceptuel Singleton.
 */
public class FullMeatBurgerBuilder extends BurgerBuilder {
	
	private static FullMeatBurgerBuilder fullMeatBurgerBuilderInstance = new FullMeatBurgerBuilder(); // l'instance unique du Singleton
	
	/**
	 * Retourne l'instance unique du Singleton.
	 *
	 * @return l'instance unique du singleton.
	 */
	public static FullMeatBurgerBuilder getInstance() {
		return fullMeatBurgerBuilderInstance;
	}
	
	/**
	 * Constructeur privé (modèle Singleton).
	 */
	private FullMeatBurgerBuilder() {
		//FIXME: ne faudrait-il pas définir la liste condimentsBurgerMenu à partir du menu...?
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.BEEF, Condiment.CHICKEN, Condiment.SAUCE, Condiment.FISH, Condiment.SAUCE, Condiment.CHICKEN, Condiment.BEEF, Condiment.BREAD_TOP));
	}
}
