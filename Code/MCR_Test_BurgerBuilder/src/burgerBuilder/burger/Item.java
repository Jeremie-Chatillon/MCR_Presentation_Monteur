package burgerBuilder.burger;

public abstract class Item {

    public static Item BEEF = new Beef();
    public static Item CHEEZ = new Cheez();
    public static Item LETTUCE = new Lettuce();
    public static Item BREAD = new Bread();

    protected String name;
    protected boolean isVegan;
    protected int price;

    public String getName(){
        return name;
    }

    public boolean isVegan(){
        return isVegan;
    }

    public Item(String name, boolean isVegan, int price){
        this.name = name;
        this.isVegan = isVegan;
    }

    @Override
    public String toString() {
        return name;
    }
}
