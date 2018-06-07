package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class BeefBurgerBuilder extends BurgerBuilder {
	
	private static BeefBurgerBuilder beefBurgerBuilderInstance = new BeefBurgerBuilder();
	
	public static BeefBurgerBuilder getInstance() {
		return beefBurgerBuilderInstance;
	}
	
	private BeefBurgerBuilder() {
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.LETTUCE, Condiment.BEEF, Condiment.CHEESE, Condiment.SAUCE, Condiment.BREAD_TOP));
	}
}