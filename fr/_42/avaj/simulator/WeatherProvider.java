package fr._42.avaj.simulator;

import fr._42.avaj.simulator.vehicles.Coordinates;

public class WeatherProvider {

    private WeatherProvider weatherProvider;
    private String[] weather = {
            "RAIN",
            "FOG",
            "SUN",
            "SNOW"
    };

    private WeatherProvider() {
    }

    /**
     * Singleton for getting the weatherProvider
     * @return the weatherProvider
     */
    public WeatherProvider getWeatherProvider() {
        if (weatherProvider == null) {
            return new WeatherProvider();
        }
        return weatherProvider;
    }

    /**
     * Generate current weather based on current coordinate
     * @param coordinates the coordinate used to generate weather
     * @return the weather, can be RAIN, FOG, SUN, SNOW
     */
    public String getCurrentWeather(Coordinates coordinates) {
        int seed = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        return weather[seed % 4];
    }
}
