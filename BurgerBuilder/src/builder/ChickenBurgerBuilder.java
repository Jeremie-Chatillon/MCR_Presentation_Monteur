package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ChickenBurgerBuilder extends BurgerBuilder {

    static List<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.OGNON,  Condiment.SAUCE, Condiment.CHICKEN, Condiment.TOMATOE));

    public ChickenBurgerBuilder(List<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected List<Condiment> getGarintures() {
        return garnutures;
    }
}
