package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class GreekBurgerBuilder extends BurgerBuilder {

    static LinkedList<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.SAUCE));

    public GreekBurgerBuilder(LinkedList<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected LinkedList<Condiment> getGarintures() {
        return garnutures;
    }
}
