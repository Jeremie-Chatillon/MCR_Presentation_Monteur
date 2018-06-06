package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FishBurgerBuilder extends BurgerBuilder {

    static List<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.PICKLE, Condiment.FISH, Condiment.TOMATOE, Condiment.CHEESE, Condiment.OGNON));

    public FishBurgerBuilder(List<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected List<Condiment> getGarintures() {
        return garnutures;
    }
}
