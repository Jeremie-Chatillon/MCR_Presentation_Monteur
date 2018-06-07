package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class GreekBurgerBuilder extends BurgerBuilder {
	
	private static GreekBurgerBuilder greekBurgerBuilderInstance = new GreekBurgerBuilder();
	
	public static GreekBurgerBuilder getInstance() {
		return greekBurgerBuilderInstance;
	}
	
	private GreekBurgerBuilder() {
		condimentsBurgerMenu = new LinkedList<>(Arrays.asList(Condiment.BREAD_BOT, Condiment.SAUCE, Condiment.BREAD_TOP));
	}
}
