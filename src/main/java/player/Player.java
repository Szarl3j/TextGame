package player;


import NPC.Npc;
import location.Direction;
import location.Location;

public class Player {
    private String name;
    private Location currentLocation;

    private int health;
    private int strength;


    public Player(String name, int health, int strength) {
        this.name = name;
        this.health = 100;
        this.strength = 6;
    }


    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
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

    public Npc getNearbyNpc(String npcName) {
        return this.currentLocation.getNpc(npcName);
    }

    public boolean isAllive() {
        return health > 0;
    }

    public int getStrength() {
        return strength;
    }

    public void damageTaken(int hit) {
        this.health = this.health - hit;
    }


    public boolean isThereNpcNearby(Npc targetNpc) {
        return this.currentLocation.isThereNPC(targetNpc.getName());
    }
}