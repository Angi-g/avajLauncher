package fr._42.avaj.simulator.vehicles;

import fr._42.avaj.simulator.WeatherTower;

public interface Flyable {

    void updateConditions();

    void registerTower(WeatherTower weatherTower);

    String whoAmI();
}
