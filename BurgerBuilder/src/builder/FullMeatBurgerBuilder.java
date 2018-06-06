package builder;

import structure.Condiment;
import structure.Condiment.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FullMeatBurgerBuilder extends BurgerBuilder {

    static List<Condiment> garnutures = new LinkedList<>(Arrays.asList(Condiment.BEEF, Condiment.CHICKEN, Condiment.SAUCE, Condiment.FISH, Condiment.SAUCE, Condiment.CHICKEN, Condiment.BEEF));

    public FullMeatBurgerBuilder(List<Condiment> condimentsOrder) {
        super(condimentsOrder);
    }

    @Override
    protected List<Condiment> getGarintures() {
        return garnutures;
    }
}
