package player;


import location.Direction;
import location.Location;

public class Player {
    private String name;
    private Location currentLocation;


    public Player(String name) {
        this.name = name;
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
        if (nextLocation!= null){
            this.currentLocation = nextLocation;
            return true;
        }else{
            return false;
        }
    }
}
