package fr._42.avaj.simulator.vehicles;

import fr._42.avaj.simulator.WeatherTower;

public interface Flyable {

    public void updateConditions();

    public void registerTower(WeatherTower WeatherTower);
}
