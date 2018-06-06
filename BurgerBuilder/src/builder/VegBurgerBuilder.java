package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class VegBurgerBuilder extends BurgerBuilder {

    static List<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.LETTUCE, Condiment.TOMATOE, Condiment.CHEESE, Condiment.LETTUCE));

    public VegBurgerBuilder(List<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected List<Condiment> getGarintures() {
        return garnutures;
    }
}
