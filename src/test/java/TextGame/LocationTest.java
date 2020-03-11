package TextGame;

import NPC.Npc;
import location.Direction;
import location.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {

    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location(" ", " ");
        northLocation  = new Location("Second", "Long");
        Location southLocation = new Location("Third", "Long");
        mainLocation.addExit(Direction.N, northLocation);
        mainLocation.addExit(Direction.S, southLocation);
        Npc Orc1 = new Npc("Orc", 150, 4);
        mainLocation.addNpc(Orc1);
        Npc Orc2 = new Npc("Orc2", 100, 10);
        mainLocation.addNpc(Orc2);
    }

    @Test
    //Checking if program generate correctly description in location
    public void testGetDescription() {
        String description = mainLocation.getDescription();
        String vaildDescription = "Short\nLong\nVisibleExits: north, south \n orc1, orc2 ";
        Assert.assertEquals("Compare description", vaildDescription, description);
    }

    @Test
    public void testGetNextLocation() {
        //Checked if program correctly generate location or it's null location

        Location nextLoc = mainLocation.getNextLocation(Direction.N);
        Assert.assertEquals("Same object", northLocation, nextLoc);

        Location nullLoc = mainLocation.getNextLocation(Direction.E);
        Assert.assertNull("Non-existing location", nullLoc);
    }

    @Test
    public void testGetNPC() {
     //Checked if npc is in Location
        Npc getOrc = mainLocation.getNpc("Orc");
        Assert.assertEquals("Existing npc", "orc", getOrc.getName());
        Npc getOrc2 = mainLocation.getNpc("orc4");
        Assert.assertNull("Non-existing npc", getOrc2);
    }

}