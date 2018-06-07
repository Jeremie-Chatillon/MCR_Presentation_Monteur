package structure;



import java.util.LinkedList;

public class Burger {
    private String name;

    private LinkedList<Condiment> items;

    public Burger(LinkedList<Condiment> items){

        this.items = items;
        name = "UnknowBurger";
    }


    public void setName(String name) {
        this.name = name;
    }


    public LinkedList<Condiment> getItems() {
        return items;
    }

    public String toString(){
        return name + ": " + items.toString();
    }
}