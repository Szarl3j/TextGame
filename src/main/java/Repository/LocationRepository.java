package Repository;

import Characters.Npc.Npc;
import location.Direction;
import location.Location;

public class LocationRepository {
    private Location startLoc;

    public LocationRepository() {
        startLoc = new Location("Small room","You're in small, dark room. Single bed standing next to the wall is only furniture in here. " +
                "Some clothes lying on floor. You put them on. " +
                "You look around and see a vague figure at the other end of the room. You come closer and recognize the Orc. ");
        Location secondLocation = new Location("Corridor","In dim, flickering lights you're not able to see much. Narrow space of the corridor is surrounded by steel walls. " +
                "You try to keep going anyway ");

        startLoc.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S,startLoc);

        Npc orc = new Npc("Orc",50,5);

        startLoc.addNpc(orc);

    }

    public Location getStartLocation() {
        return this.startLoc;
    }



}