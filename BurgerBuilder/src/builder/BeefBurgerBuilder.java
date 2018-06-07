package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.LinkedList;

public class BeefBurgerBuilder extends BurgerBuilder {

    static LinkedList<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.LETTUCE, Condiment.BEEF, Condiment.CHEESE, Condiment.SAUCE));

    public BeefBurgerBuilder(LinkedList<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected LinkedList<Condiment> getGarintures() {
        return garnutures;
    }
}
