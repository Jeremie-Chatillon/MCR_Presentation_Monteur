package burgerBuilder;


import burgerBuilder.burger.*;

public abstract class BurgerBuilder {



    protected Burger burger;

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
