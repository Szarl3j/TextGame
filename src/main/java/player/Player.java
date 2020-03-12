package player;

import Interface.Statistics;
import Npc.Npc;
import location.Direction;
import location.Location;
public class Player {

    private String name;
    private Location currentLocation;

    private Statistics stats;

    public Player(String name) {
        this.name = name;
        this.stats = new Statistics(100,5,10);
    }

    public Player(String name, int health, int strength) {
        this.name = name;
        this.stats = new Statistics(health,strength,10);
    }

    public Player(String name, int health, int strength, int agility) {
        this.name = name;
        this.stats = new Statistics(health,strength,agility);
    }

    public String getName() {
        return name;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public String getCurrentLocationDescription() {
        return this.currentLocation.getDescription();
    }

    public boolean move(Direction direction) {
        Location nextLocation = this.currentLocation.getNextLocation(direction);
        if(nextLocation!=null) {
            this.currentLocation = nextLocation;
            return true;
        } else {
            return false;
        }
    }

    public Npc getNearbyNpc(String NpcName) {
        return this.currentLocation.getNpc(NpcName);
    }

    public boolean isAlive() {
        return stats.getHealth()>0;
    }

    public int getStrength() {
        return stats.getStrength();
    }

    public void damageTaken(int hit) {
        this.stats.setHealth(this.stats.getHealth() - hit);
    }

    public int getAgility() {
        return this.stats.getAgility();
    }

    public boolean isThereNPCNearby(Npc targetNpc) {
        return this.currentLocation.isThereNPC(targetNpc.getName());
    }




}