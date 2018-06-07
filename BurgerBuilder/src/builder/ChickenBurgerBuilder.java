package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class ChickenBurgerBuilder extends BurgerBuilder {
	
	private static ChickenBurgerBuilder chickenBurgerBuilderInstance = new ChickenBurgerBuilder();
	
	public static ChickenBurgerBuilder getInstance() {
		return chickenBurgerBuilderInstance;
	}
	
	private ChickenBurgerBuilder() {
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.OGNON, Condiment.SAUCE, Condiment.CHICKEN, Condiment.TOMATOE, Condiment.BREAD_TOP));
	}
}
