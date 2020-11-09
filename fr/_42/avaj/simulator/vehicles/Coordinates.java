package fr._42.avaj.simulator.vehicles;

public class Coordinates {

    private final int longitude;
    private final int latitude;
    private final int height;

    Coordinates(int longitude, int latitude, int height) {

        if (height < 0) {
            height = 0;
        }
        if (height > 100) {
            height = 100;
        }

        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
