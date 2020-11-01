package fr._42.avaj.simulator.vehicles;

import fr._42.avaj.simulator.Logger;
import fr._42.avaj.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super (name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        String weatherMessage = "";

        if("SUN".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 2,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 4
            );
            weatherMessage = "Yay, I didn't forgot my sunglasses !";
        } else if("RAIN".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 5
            );
            weatherMessage = "Arh, baloon, best flying umbrella ever !";
        } else if ("FOG".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 3
            );
            weatherMessage = "the floor is closer than before no ?";
        } else if ("SNOW".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 15
            );
            weatherMessage = "I thing I should drop some lest ...";
        }
        Logger.writeLine(this.whoAmI(), weatherMessage);

        if (this.coordinates.getHeight() == 0) {
            this.weatherTower.unregister(this);
            Logger.writeLine(this.whoAmI(), "Help ! I'm crashing !");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
