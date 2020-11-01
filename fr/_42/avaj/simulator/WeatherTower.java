package fr._42.avaj.simulator;

import fr._42.avaj.simulator.vehicles.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        WeatherProvider.getProvider().getCurrentWeather(coordinates);
        return null;
    }

    void changeWeather() {
        this.conditionChanged();
    }
}
