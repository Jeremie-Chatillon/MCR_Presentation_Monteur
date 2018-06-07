package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class VegBurgerBuilder extends BurgerBuilder {
	
	private static VegBurgerBuilder vegBurgerBuilderInstance = new VegBurgerBuilder();
	
	public static VegBurgerBuilder getInstance() {
		return vegBurgerBuilderInstance;
	}
	
	private VegBurgerBuilder() {
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.LETTUCE, Condiment.TOMATOE, Condiment.CHEESE, Condiment.LETTUCE, Condiment.BREAD_TOP));
	}
}
