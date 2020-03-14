package TextGame;
import location.Direction;
import location.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Characters.player.Player;

public class PlayerTest {
Location mainLocation;
Location northLocation;
    @Before
    public void initTest() {
        mainLocation = new Location(" ", " ");
        northLocation = new Location("Second", "Long");
        Location location3 = new Location("Third", "Long");
        mainLocation.addExit(Direction.N, northLocation);
    }
    @Test
    public void testPlayerMove(){
        Player player = new Player("Szymon ",100,10);
        player.setCurrentLocation(mainLocation);
        player.move(Direction.N);
        Assert.assertEquals("This same location", northLocation, player.getCurrentLocationDescription());
    }

}
