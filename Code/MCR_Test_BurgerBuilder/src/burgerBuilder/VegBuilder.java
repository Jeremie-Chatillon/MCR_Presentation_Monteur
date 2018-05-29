package burgerBuilder;

import burgerBuilder.burger.Burger;
import burgerBuilder.burger.Cheez;
import burgerBuilder.burger.Item;
import burgerBuilder.burger.Lettuce;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VegBuilder extends BurgerBuilder {

    private static List<Item> items = new LinkedList(Arrays.asList(Item.BREAD, Item.CHEEZ, Item.LETTUCE, Item.CHEEZ, Item.BREAD));
    private static String NAME = "VegBurger";
    private static int PRICE = 50;

    public  VegBuilder(){
        super();
    }

    @Override
    public Burger build() {
        burger.setName(NAME);
        burger.setPrice(50);
        burger.setValide(items.equals(burger.getItems()));

        return burger;
    }
}
