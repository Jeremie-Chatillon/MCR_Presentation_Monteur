package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class ChickenBurgerBuilder extends BurgerBuilder {

    static LinkedList<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.OGNON,  Condiment.SAUCE, Condiment.CHICKEN, Condiment.TOMATOE));

    public ChickenBurgerBuilder(LinkedList<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected LinkedList<Condiment> getGarintures() {
        return garnutures;
    }
}
