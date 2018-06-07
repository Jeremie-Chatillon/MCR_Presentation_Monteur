package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BeefBurgerBuilder extends BurgerBuilder {

    static List<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.LETTUCE, Condiment.BEEF, Condiment.CHEESE, Condiment.SAUCE));

    public BeefBurgerBuilder(List<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected List<Condiment> getGarintures() {
        return garnutures;
    }
}
