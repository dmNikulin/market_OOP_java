package Market;

public interface ActorBehaviour {

    void setMakeOrder(boolean makeOrder);
    void setTakeOrder(boolean takeOrder);
    boolean isTakeOrder();
    boolean isMakeOrder();
    
}
