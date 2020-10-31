package fr._42.avaj.simulator.vehicles;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    /**
     * Increment the idCounter
     * @return the idCounter incremented
     */
    private long nextId() {

        return Aircraft.idCounter++;
    }
}
