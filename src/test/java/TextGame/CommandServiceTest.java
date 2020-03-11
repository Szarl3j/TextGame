package TextGame;

import ProjectService.CommandService;
import location.Direction;
import location.Location;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import player.Player;

public class CommandServiceTest {
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
    public void testCommandService() {
        Player newPlayer = new Player("piotr", 100, 10);
        CommandService cs = new CommandService();
        CommandService spyCs = Mockito.spy(cs);
        newPlayer.setCurrentLocation(mainLocation);
        spyCs.actOnComand("north", newPlayer);
        Mockito.verify(spyCs, Mockito.times(1)).move(Direction.N, newPlayer);
    }

    @Test
    public void testCommandServiceKill() {
        Player newPlayer = new Player("piotr", 100, 10);
        CommandService cs = new CommandService();
        CommandService spyCs = Mockito.spy(cs);
        newPlayer.setCurrentLocation(mainLocation);
        spyCs.actOnComand("kill orc", newPlayer);
        Mockito.verify(spyCs, Mockito.times(1)).attack("orc", newPlayer);
    }
}
