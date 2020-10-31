package fr._42.avaj.simulator.vehicles;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {

    }

    private long nextId() {

        return 0;
    }
}
