package Structure;

public enum     Condiment {

    BREAD_TOP("Bread_top", 1), BREAD_BOT("Bread_bot", 1), BEEF("Beef", 7), CHICKEN("Chicken", 7), FISH("Fish", 8), TOMATOE("Tomatoe", 3), CHEESE("Cheese", 3), PICKLE("Pickle", 2), OGNON("Ognon", 2), LETTUCE("Lettuce", 1), SAUCE("Sauce", 1);

    private String name;

    private int price;

    public String getName(){
        return name;
    }

    public int getPrice() {
        return price;
    }

    private Condiment(String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

}

