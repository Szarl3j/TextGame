package player;


import location.Direction;
import location.Location;

public class Player {
    private String name;
    private Location currentLocation;

    private int health;
    private int strength;


    public Player(String name, int health,int strength) {
        this.name = name;
        this.health = 100;
        this.strength = 6;
    }


    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public String getCurrentLocationDescription() {
        return this.currentLocation.getDescription();
    }

    public boolean move(Direction direction) {
        Location nextLocation = this.currentLocation.getNextLocation(direction);
        if (nextLocation != null) {
            this.currentLocation = nextLocation;
            return true;
        } else {
            return false;
        }
    }
}
