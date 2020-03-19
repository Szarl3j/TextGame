import Characters.player.Player;
import ProjectService.LookCommand;
import location.Location;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LookTest {

    private Location mainLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
    }

    @Test
    // Checking if LookCommand works correctly.
    public void lookTest() {
        Player p = new Player("TestingPlayer");
        p.setCurrentLocation(mainLocation);
        LookCommand look = new LookCommand(p);
        String result = look.execute();
        assertEquals(mainLocation.getDescription(), result);
    }

}