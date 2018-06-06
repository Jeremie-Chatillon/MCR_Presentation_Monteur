package builder;

import structure.Burger;
import structure.Condiment;

import java.util.LinkedList;
import java.util.List;

public abstract class BurgerBuilder {
    
    protected List<Condiment> condiments;
    private List<Condiment> condimentsOrder;     // List de condiments voulus par le client



    public BurgerBuilder(List<Condiment> condimentsOrder){
        condiments = new LinkedList<Condiment>();
        this.condimentsOrder = condimentsOrder;
    }

    public List<Condiment> getCondiments(){
        List<Condiment> l = new LinkedList<>(getGarintures());
        l.add(Condiment.BREAD_TOP);
        l.add(0,Condiment.BREAD_BOT);

        return l;
    }

    abstract protected List<Condiment> getGarintures();

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
