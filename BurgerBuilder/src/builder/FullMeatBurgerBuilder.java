package builder;

import structure.Condiment;

import java.util.Arrays;
import java.util.LinkedList;

public class FullMeatBurgerBuilder extends BurgerBuilder {

    static LinkedList<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.BEEF, Condiment.CHICKEN, Condiment.SAUCE, Condiment.FISH, Condiment.SAUCE, Condiment.CHICKEN, Condiment.BEEF));

    public FullMeatBurgerBuilder(LinkedList<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected LinkedList<Condiment> getGarintures() {
        return garnutures;
    }
}
