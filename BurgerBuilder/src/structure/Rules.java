package structure;

/**
 * Classe contenant les divers réglages du programme.
 */
public class Rules {
	public static final int START_MONNEY = 100; // fond de caisse au début du jeu
	public static final int NB_MAX_CLIENTS = 6; // nombre max de clients dans la file d'attente
	public static final int NB_MS_MIN_BEFORE_NEW_CLIENT = 2000; // en ms -> 2 secondes
	public static final int NB_MS_MAX_BEFORE_NEW_CLIENT = 5000; // en ms -> 5 secondes
	public static final int NB_MAX_MS_CLIENT_WAITING = 15000; // en ms -> 15 secondes
	public static final int NB_MAX_CONDIMENT = 10; // nombre max de condiment qu'il peut y avoir dans un burger
	public static final int MAX_VAUMIT_BAR = 10; // nombre max de client pouvant vomir avant de perdre la partie
	public static final int MAX_ANGRY_BAR = 10; // nombre max de client pouvant partir sans leur commande avant de perdre la partie
	public static final int CONDIMENT_BENEF = 2; // bénéfice par condiment (formule: prix du condiment + CONDIMENT_BENEF pour chaque condiment du burger)
	
	
	/*
	public static final KeyCode TOUCHE_SAUCE = A;
	public static final KeyCode TOUCHE_LETTUCE = B;
	public static final KeyCode TOUCHE_OGNON = C;
	public static final KeyCode TOUCHE_PICKLE = D;
	public static final KeyCode TOUCHE_CHEESE = E;
	public static final KeyCode TOUCHE_TOMATOE = F;
	public static final KeyCode TOUCHE_FISH = G;
	public static final KeyCode TOUCHE_CHICKEN = H;
	public static final KeyCode TOUCHE_BEEF = I;
	public static final KeyCode TOUCHE_BREADTOP = J;
	public static final KeyCode TOUCHE_BREADBOTTOM = K;
	public static final KeyCode TOUCHE_DELIVER = ENTER;
	public static final KeyCode TOUCHE_CANCEL = BACK_SPACE;
	*/
}
