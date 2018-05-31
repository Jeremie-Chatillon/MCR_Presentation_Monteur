package Builder;

import Structure.Burger;
import Structure.Condiment;

import java.util.LinkedList;
import java.util.List;

public class BurgerBuilder {


    protected List<Condiment> condiments;
    private List<Condiment> condimentsOrder;     // List d'items voulus par le client


    public BurgerBuilder(List<Condiment> condimentsOrder){
        condiments = new LinkedList<Condiment>();
        this.condimentsOrder = condimentsOrder;
    }

    public Burger build(){

        if(check()) {
            return new Burger(condiments);
        } else {
            return null;
        }
    }

    public void addCondiment(Condiment c){
        condiments.add(c);
    }

    private boolean check(){

        return condiments.equals(condimentsOrder);
    }

    public void clear(){
        condiments.clear();
    }

}
