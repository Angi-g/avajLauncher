package fr._42.avaj.simulator.vehicles;

import fr._42.avaj.simulator.Logger;
import fr._42.avaj.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super (name, coordinates);
        this.type = this.name;
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        String weatherMessage = "";

        if("SUN".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 10,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 2
            );
            weatherMessage = "the sky is soooo blue !";
        } else if("RAIN".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 5,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight()
            );
            weatherMessage = "I hope this will not rust my rotor";
        } else if ("FOG".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 1,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight()
            );
            weatherMessage = "WTF, god is smoking hard";
        } else if ("SNOW".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 12
            );
            weatherMessage = "JingleBell, JingleBell...";
        }
        Logger.writeLine(this.whoAmI(), weatherMessage);

        if (this.coordinates.getHeight() == 0) {
            this.weatherTower.unregister(this);
            Logger.writeLine(this.whoAmI(), "Landing, need some " +
                    "rest, this thing is so loud !");
        }
    }


    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

}
