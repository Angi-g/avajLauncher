package fr._42.avaj.simulator;

import fr._42.avaj.simulator.vehicles.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {

        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionChanged();
    }
}
