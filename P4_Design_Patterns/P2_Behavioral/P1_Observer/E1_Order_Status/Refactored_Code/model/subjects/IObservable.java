package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.subjects;

import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.IClient;

public interface IObservable {
    public void attach(IClient obs);

    public void detach(IClient obs);

    public void notifyObservers();
}
