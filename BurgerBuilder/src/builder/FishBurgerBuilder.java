package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class FishBurgerBuilder extends BurgerBuilder {

    static LinkedList<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.PICKLE, Condiment.FISH, Condiment.TOMATOE, Condiment.CHEESE, Condiment.OGNON));

    public FishBurgerBuilder(LinkedList<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected LinkedList<Condiment> getGarintures() {
        return garnutures;
    }
}
