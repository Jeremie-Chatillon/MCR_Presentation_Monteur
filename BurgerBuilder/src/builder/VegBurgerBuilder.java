package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.LinkedList;

public class VegBurgerBuilder extends BurgerBuilder {

    static LinkedList<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.LETTUCE, Condiment.TOMATOE, Condiment.CHEESE, Condiment.LETTUCE));

    public VegBurgerBuilder(LinkedList<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected LinkedList<Condiment> getGarintures() {
        return garnutures;
    }
}
