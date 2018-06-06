package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GreekBurgerBuilder extends BurgerBuilder {

    static List<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.SAUCE));

    public GreekBurgerBuilder(List<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected List<Condiment> getGarintures() {
        return garnutures;
    }
}
