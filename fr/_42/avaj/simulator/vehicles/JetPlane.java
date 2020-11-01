package fr._42.avaj.simulator.vehicles;

import fr._42.avaj.simulator.Logger;
import fr._42.avaj.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super (name, coordinates);
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
            weatherMessage = "Remember, you ar not Icarus !";
        } else if("RAIN".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 5,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight()
            );
            weatherMessage = "Erf, I'm wet";
        } else if ("FOG".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 1,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight()
            );
            weatherMessage = "It's like walking on cloud !";
        } else if ("SNOW".equals(weather)) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 7
            );
            weatherMessage = "Soo..o .. co..o..ld";
        }
        Logger.writeLine(this.whoAmI(), weatherMessage);

        if (this.coordinates.getHeight() == 0) {
            this.weatherTower.unregister(this);
            Logger.writeLine(this.whoAmI(), "Landing, break a leg");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
