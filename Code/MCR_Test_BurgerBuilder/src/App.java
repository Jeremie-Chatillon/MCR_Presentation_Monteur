import Utils.Menu;
import burgerBuilder.BurgerBuilder;
import burgerBuilder.VegBuilder;
import burgerBuilder.burger.Burger;
import burgerBuilder.burger.Condiment;
import burgerBuilder.burger.Item;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {
       System.out.println("Welcome");

        BurgerBuilder bb = new VegBuilder();
        //BurgerBuilder bb2 = new VegBuilder();
        bb.addBeef();
        bb.addCheez();
        bb.addLettuce();


        Burger b = bb.build();


        Menu m = new Menu(VegBuilder.class);

        BurgerBuilder bb2 = m.getNewBurgerBuilder();

        bb2.addBread();
        bb2.addCheez();
        bb2.addLettuce();
        bb2.addCheez();
        bb2.addBread();

        Burger b2 = bb2.build();


        System.out.println(b + " " + b.isValid());
        System.out.println(b2 + " " + b2.isValid());

        List<Item> items = new LinkedList(Arrays.asList(Item.BREAD, Item.CHEEZ, Item.LETTUCE, Item.CHEEZ, Item.BREAD));
        LinkedList<Item> tmp = new LinkedList<>(items);
        tmp.addAll(items.indexOf(Item.CHEEZ), new LinkedList(Arrays.asList(Item.CHEEZ, Item.CHEEZ, Item.CHEEZ)));

        System.out.println("\n" + items);
        System.out.println(tmp);

    }
}
