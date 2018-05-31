package Structure;

import Builder.BurgerBuilder;

import java.util.LinkedList;

public class Menu {
    private String name;
    private int prix;
    private LinkedList<Condiment> condiments;

    // Si on a des classes abstraites pour les menus
    //private Class<? extends BurgerBuilder> burgerBuilderClass;

    /** Test pour la class en variable
    public Menu(Class<? extends BurgerBuilder> burgerBuilderClass){
        this.burgerBuilderClass = burgerBuilderClass;
    }
     */

    public Menu(String name, LinkedList<Condiment> condiments) {
        this.name = name;
        this.prix = 0;
        this.condiments = condiments;

        for(Condiment c: condiments){
            prix += c.getPrice();
        }
    }

    /*
    // Si on a des classes abstraites pour les menus
    public BurgerBuilder getNewBurgerBuilder(){
        try {
            return burgerBuilderClass.newInstance();

        } catch (Exception e){
            System.err.println(e);
            return null;
        }
    }
    */

    public BurgerBuilder getBurgerBuilder(LinkedList<Condiment> supplement){
        LinkedList<Condiment> tmp = new LinkedList<>(condiments);
        if(supplement != null)
            tmp.addAll(condiments.indexOf(Condiment.BREAD_TOP), supplement);

        return new BurgerBuilder(tmp);
    }
}

