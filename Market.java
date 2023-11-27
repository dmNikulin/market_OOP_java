package Market;
// Реализовать класс Market и все методы, которые он обязан реализовывать.
// Методы из интерфейса QueueBehaviour, имитируют работу очереди, MarketBehaviour – помещает и удаляет человека из очереди,
//  метод update – обновляет состояние магазина (принимает и отдаёт заказы)

import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehavior {

    List<Actor> queue = new ArrayList<>();

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " зашел в маркет.");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
       for (Actor actor : actors) {
        queue.remove(actor);
         System.out.println(actor.getName() + " вышел из маркета.");
       }
    }

    @Override
    public void update() {
        makeOrder();
        takeOrder();
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь.");
        queue.add(actor);
    }

    @Override
    public void makeOrder() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал заказ.");
            }
        }
    }

    @Override
    public void takeOrder() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил заказ.");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (Actor actor : queue) {
            if(actor.isTakeOrder){
                releaseActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди.");
            }
        }
        releaseFromMarket(releaseActors);
    }

}
