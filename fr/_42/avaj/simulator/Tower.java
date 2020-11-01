package fr._42.avaj.simulator;

import fr._42.avaj.simulator.vehicles.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
        }
        Logger.writeLine("Tower",flyable.whoAmI() + " registered to weather tower.");

    }

    public void unregister(Flyable flyable) {
            observers.remove(flyable);
        Logger.writeLine("Tower",flyable.whoAmI() + " unregistered from weather tower.");

    }

    protected void conditionChanged() {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }
}
