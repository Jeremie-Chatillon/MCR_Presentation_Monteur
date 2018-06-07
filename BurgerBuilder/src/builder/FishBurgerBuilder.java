package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class FishBurgerBuilder extends BurgerBuilder {
	
	private static FishBurgerBuilder fishBurgerBuilderInstance = new FishBurgerBuilder();
	
	public static FishBurgerBuilder getInstance() {
		return fishBurgerBuilderInstance;
	}
	
	private FishBurgerBuilder() {
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.PICKLE, Condiment.FISH, Condiment.TOMATOE, Condiment.CHEESE, Condiment.OGNON, Condiment.BREAD_TOP));
	}
}
