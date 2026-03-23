package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.subjects.impl;

import java.util.HashSet;
import java.util.Set;

import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.IClient;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.subjects.IObservable;

public class Order implements IObservable {
    private Set<IClient> observers = new HashSet<>();
    private int id;
    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "Order Placed";
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void attach(IClient obs) {
        observers.add(obs);
    }

    @Override
    public void detach(IClient obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (IClient obs : observers) {
            obs.update(this);
        }
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        notifyObservers();
    }
}
