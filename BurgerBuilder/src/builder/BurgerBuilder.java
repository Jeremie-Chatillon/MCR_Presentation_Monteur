package builder;

import structure.Burger;
import structure.Condiment;

import java.util.LinkedList;

/**
 * Classe abstraite implémentant un builder de burger. Implémente le modèle conceptuel du Builder.
 */
public abstract class BurgerBuilder {
	
	// liste des condiments que contient le burger exemple du menu
	protected LinkedList<Condiment> condimentsBurgerMenu;
	
	// liste des condiments que contient le burger en cours de création dans le builder
	protected LinkedList<Condiment> condiments = new LinkedList<>();
	
	/**
	 * Construit un burger à partir de <b>condiments</b>, la liste des condiments actuellement contenus dans le builder.
	 * <br>Vérifie que cette liste corresponde à la liste <b>condimentsBurgerMenu</b>. Si c'est le cas, retourne le
	 * Burger.
	 * <br>Sinon, lève une IllegalArgumentException et interrompt la création du burger.
	 *
	 * @throws IllegalArgumentException
	 * 		si le burger ne peut pas être créé car la liste de condiment <b>condiments</b> ne correspond pas à celle du burger exemple du menu
	 * 		(<b>condimentsBurgerMenu</b>.
	 */
	public Burger build() throws IllegalArgumentException {
		if (check()) {
			return createBurger();
		} else {
			throw new IllegalArgumentException("Le burger construit n'est pas un burger du menu!");
		}
	}
	
	/**
	 * Crée un burger exemple tel que défini dans le menu.
	 *
	 * @return un burger.
	 */
	public Burger createBurger() {
		return new Burger(condimentsBurgerMenu);
	}
	
	/**
	 * Retourne true si le burger en construction dans le builder contient exactement les mêmes condiments (et dans le même ordre) que le burger
	 * exemple du menu, false sinon.
	 *
	 * @return
	 */
	protected boolean check() {
		return condimentsBurgerMenu.equals(condiments);
	}
	
	/**
	 * Ajoute le condiment passé en paramètre au sommet du burger en création dans le builder.
	 *
	 * @param c,
	 * 		le condiment à ajouter au burger.
	 */
	public void addCondiment(Condiment c) {
		condiments.add(c);
	}
	
	/**
	 * Réinitialise le builder en vidant la liste de condiment du burger.
	 */
	public void reset() {
		condiments.clear();
	}
	
	/**
	 * Retourne true si le burger actuellement en construction est vide, false sinon.
	 * @return true si le burger actuellement en construction est vide, false sinon.
	 */
	public boolean burgerIsEmpty() {
		return condiments.size() == 0;
	}
}
