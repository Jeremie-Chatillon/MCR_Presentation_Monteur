package builder;

import structure.Burger;
import structure.Condiment;

import java.util.LinkedList;

public abstract class BurgerBuilder {
	
	protected LinkedList<Condiment> condimentsBurgerMenu; // liste des aliments que contient le burger type
	
	protected LinkedList<Condiment> condiments = new LinkedList<>(); // liste des aliments contenus dans le burger en cours de création
	
	public Burger build() {
		if (check()) {
			return createBurger();
		} else {
			throw new IllegalArgumentException("Le burger construit n'est pas un burger du menu!");
		}
	}
	
	public Burger createBurger() {
		return new Burger(condimentsBurgerMenu);
	}
	
	protected boolean check() {
		return condimentsBurgerMenu.equals(condiments);
	}
	
	public void addCondiment(Condiment c) {
		condiments.add(c);
	}
	
	public void reset() {
		condiments.clear();
	}
}
