package Utils;

import burgerBuilder.BurgerBuilder;
import burgerBuilder.burger.Condiment;
import burgerBuilder.burger.Item;

import java.util.Comparator;
import java.util.LinkedList;


public class Menu {
    private String name;
    private int prix;
    private LinkedList<Condiment> condiments;


    private Class<? extends BurgerBuilder> burgerBuilderClass;

    /** Test pour la class en variable **/
    public Menu(Class<? extends BurgerBuilder> burgerBuilderClass){
        this.burgerBuilderClass = burgerBuilderClass;
    }

    public Menu(String name, LinkedList<Condiment> condiments, Class<BurgerBuilder> burgerBuilderClass) {
        this.name = name;
        this.prix = 0;
        this.condiments = condiments;
        this.burgerBuilderClass = burgerBuilderClass;

        for(Condiment c: condiments){
            prix += c.getPrice();
        }
    }

        public BurgerBuilder getNewBurgerBuilder(){
        try {
            return burgerBuilderClass.newInstance();

        } catch (Exception e){
            System.err.println(e);
            return null;
        }
    }
}
