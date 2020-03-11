package Repository;

import NPC.Npc;
import location.Direction;
import location.Location;

public class LocationRepository {
    private Location startLocation;

    public LocationRepository() {
        Location statLocation = new Location("Small room ", "You' re wake up in small dark room. " +
                "Single bed standing next to the wall is only furniture  and some clothes laying on the floor. ");
        Location secondLocation = new Location("corridor", "\"Corridor\",\"In dim, flickering" +
                " lights you're not able to see much. Narrow space of the corridor is surrounded by steel walls.\");");

        statLocation.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S, statLocation);

        Npc orc = new Npc("Orc", 150, 5);
        statLocation.addNpc(orc);

    }

    public Location getStartLocation() {
        return this.startLocation;
    }
}
