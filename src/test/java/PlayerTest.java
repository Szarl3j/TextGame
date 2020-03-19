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
        mainLocation = new Location("Short","Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addExit(Direction.N, northLocation);
    }
}