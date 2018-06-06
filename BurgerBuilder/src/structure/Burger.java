package structure;



import java.util.List;

public class Burger {
    private String name;

    private List<Condiment> items;

    public Burger(List<Condiment> items){

        this.items = items;
        name = "UnknowBurger";
    }


    public void setName(String name) {
        this.name = name;
    }


    public List<Condiment> getItems() {
        return items;
    }

    public String toString(){
        return name + ": " + items.toString();
    }
}