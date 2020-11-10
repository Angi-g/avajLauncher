package fr._42.avaj.simulator.vehicles;

import fr._42.avaj.simulator.InvalideArgumentException;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws InvalideArgumentException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch (type.toLowerCase()) {
            case "baloon":
                return new Baloon(name, coordinates);
            case "helicopter":
                return new Helicopter(name, coordinates);
            case "jetplane":
                return new JetPlane(name, coordinates);
            default:
                throw new InvalideArgumentException("The scenario file is incorrect, the type " + type + " is unknown");
        }
    }
}
