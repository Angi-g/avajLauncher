package fr._42.avaj.simulator.vehicles;

public class Aircraft {

    protected long id;
    protected String name;
    protected String type;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
        this.type = "basic";
    }

    /**
     * Increment the idCounter
     * @return the idCounter incremented
     */
    private long nextId() {

        return Aircraft.idCounter++;
    }

    /**
     * @return the type, name and matricule of the aircraft
     */
    public String whoAmI() {
        return this.type + "#" + this.name + "(" + this.id + ")";
    }
}
