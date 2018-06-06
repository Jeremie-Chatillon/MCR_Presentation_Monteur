package structure;


import builder.BeefBurgerBuilder;
import builder.BurgerBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Menu {

    static List<Menu> menus = new ArrayList<>(Arrays.asList(new Menu("Beef Burger", BeefBurgerBuilder.class)));



    private String name;
    // Si on a des classes abstraites pour les menus
    private Class<? extends BurgerBuilder> burgerBuilderClass;

    /** Test pour la class en variable
    public Menu(Class<? extends BurgerBuilder> burgerBuilderClass){
        this.burgerBuilderClass = burgerBuilderClass;
    }
     */

    public Menu(String name, Class<? extends BurgerBuilder> burgerBuilderClass) {
        this.name = name;
        this.burgerBuilderClass = burgerBuilderClass;
    }
    
    public static List<Menu> getAllMenus() {
        return menus;
    }
    
    public static Menu getOneRandomMenu() {
        Random random = new Random();
        int i = random.nextInt() % menus.size();
        
        return menus.get(i);
    }
    
    // Si on a des classes abstraites pour les menus
    public BurgerBuilder getNewBurgerBuilder(){
        try {
            return burgerBuilderClass.newInstance();
        } catch (Exception e){
            System.err.println(e);
            return null;
        }
    }


    /*
    public BurgerBuilder getBurgerBuilder(LinkedList<Condiment> supplement){
        LinkedList<Condiment> tmp = new LinkedList<Condiment>(supplement);
        if(supplement != null)
            tmp.addAll(supplement.indexOf(Condiment.BREAD_TOP), supplement);

        return new BurgerBuilder(tmp);
    }
    */
}

