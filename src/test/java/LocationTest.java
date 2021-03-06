import Characters.Npc.Npc;
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
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "Long");
        Location southLocation = new Location("Third", "Long");
        mainLocation.addExit(Direction.N, northLocation);
        mainLocation.addExit(Direction.S, southLocation);
        Npc orc = new Npc("orc");
        Npc secondOrk = new Npc("orc2");
        mainLocation.addNpc(orc);
        mainLocation.addNpc(secondOrk);
    }

    @Test
    public void testDescription() {
     //Checking if description method works correctly.
        String description = mainLocation.getDescription();
        String validDescription = "Short\nLong\nVisible exits: North, South\norc, orc2";
        Assert.assertEquals("Compare descritpion", validDescription, description);

    }

    @Test
    public void testGetNextLocation() {
     //Checking if move t next location works right.
        Location nextLoc = mainLocation.getNextLocation(Direction.N);
        Assert.assertEquals("Same object", northLocation, nextLoc);

        Location nullLoc = mainLocation.getNextLocation(Direction.E);
        Assert.assertNull("Non-existing location", nullLoc);
    }

    @Test
    public void testGetNpc() {
     //Checking if generate new npc works correctly
        Npc getOrc = mainLocation.getNpc("orc");
        Assert.assertEquals("Existing npc", "orc", getOrc.getName());
        Npc getOrc2 = mainLocation.getNpc("orc4");
        Assert.assertNull("Non-existing npc", getOrc2);
    }

}