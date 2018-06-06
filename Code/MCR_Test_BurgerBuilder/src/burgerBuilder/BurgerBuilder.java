package burgerBuilder;


import burgerBuilder.burger.*;

import java.util.List;

public abstract class BurgerBuilder {

    protected List<Condiment> condiments;

    public List<Condiment> getCondiments(){
        return Condiment.BREAD_TOP;
    }

    public BurgerBuilder(){
        burger = new Burger();
    }

    public void addBeef(){
        burger.addItem(Item.BEEF);
    }

    public void addCheez(){
        burger.addItem(Item.CHEEZ);
    }

    public void addLettuce(){
        burger.addItem(Item.LETTUCE);
    }

    public void addBread(){
        burger.addItem(Item.BREAD);
    }

    public abstract Burger build();
}
