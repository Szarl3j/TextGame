package location;


import NPC.Npc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    private String shortDescription;
    private String longDescription;
    private Map<Direction, Location> exit;
    private List<Npc> npcs;


    public Location(String shortDescription, String longDescription) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.exit = new HashMap<Direction, Location>();
        this.npcs = new ArrayList<>();
    }

    public String getDescription() {

        return this.shortDescription + "\n" + this.longDescription + "\n" + "Visible exits " + getExitString()
                + "\n" + getNpcString();
    }

    public void addExit(Direction direction, Location location) {
        this.exit.put(direction, location);
    }

    public Location getNextLocation(Direction direction) {
        boolean exists = this.exit.containsKey(direction);
        if (exists) {
            return this.exit.get(direction);
        } else {
            return null;
        }
    }

    private String getExitString() {
        String exitsString = "";
        for (Direction direction : exit.keySet()) {
            exitsString += direction.getDirectionDescription() + " ";
        }
        return exitsString;

    }

    public void addNpc(Npc npc) {
        this.npcs.add(npc);
    }

    private String getNpcString() {
        String result = "";
        for (Npc npc : this.npcs) {
            result = result + npc.getName() + " ";
        }
        return result;

    }
}
