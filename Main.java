package Market;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Human human1 = new Human("Дмитрий");
        Human human2 = new Human("Василий");
        market.acceptToMarket(human1);
        market.acceptToMarket(human2);
        market.update();

    }
}
