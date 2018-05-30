package burgerBuilder.burger;

public class Beef extends Item{


    private static String NAME = "Beef";

    public static Item BEEF = new Beef();

    int count;

    public Beef(){
        super(NAME, false, 10);
    }
}
