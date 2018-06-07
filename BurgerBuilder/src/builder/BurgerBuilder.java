package builder;

import structure.Burger;
import structure.Condiment;

import java.util.LinkedList;

public abstract class BurgerBuilder {
    
    protected LinkedList<Condiment> condiments;
    private LinkedList<Condiment> condimentsOrder;     // LinkedList de condiments voulus par le client



    public BurgerBuilder(LinkedList<Condiment> condimentsOrder){
        condiments = new LinkedList<>();
        this.condimentsOrder = condimentsOrder;
    }

    public LinkedList<Condiment> getCondiments(){
        LinkedList<Condiment> l = new LinkedList<>(getGarintures());
        l.add(Condiment.BREAD_TOP);
        l.add(0,Condiment.BREAD_BOT);

        return l;
    }

    abstract protected LinkedList<Condiment> getGarintures();

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
