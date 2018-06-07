package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class FullMeatBurgerBuilder extends BurgerBuilder {
	
	private static FullMeatBurgerBuilder fullMeatBurgerBuilderInstance = new FullMeatBurgerBuilder();
	
	public static FullMeatBurgerBuilder getInstance() {
		return fullMeatBurgerBuilderInstance;
	}
	
	private FullMeatBurgerBuilder() {
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.BEEF, Condiment.CHICKEN, Condiment.SAUCE, Condiment.FISH, Condiment.SAUCE, Condiment.CHICKEN, Condiment.BEEF, Condiment.BREAD_TOP));
	}
}
