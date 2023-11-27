package Market;

public interface QueueBehaviour {
    void takeInQueue(Actor actor);
    void makeOrder();
    void takeOrder();
    void releaseFromQueue();

}
