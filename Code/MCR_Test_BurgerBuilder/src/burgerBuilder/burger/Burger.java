package burgerBuilder.burger;

import java.util.LinkedList;
import java.util.List;

public class Burger {
    private String name;
    private int price;
    private boolean isValide;

    private List<Item> items;

    public Burger(){
        items = new LinkedList<Item>();
        name = "UnknowBurger";
        isValide = false;
    }

    public void addItem(Item i){
        items.add(i);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setValide(boolean valide) {
        isValide = valide;
    }

    public boolean isValid(){
        return isValide;
    }

    public List<Item> getItems() {
        return items;
    }

    public String toString(){
        return name + ": " + items.toString();
    }
}
