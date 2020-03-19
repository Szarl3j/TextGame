import Characters.Npc.Npc;
import Characters.player.Player;
import ProjectService.MoveCommand;
import location.Direction;
import location.Location;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveTest {

    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addExit(Direction.N, northLocation);
        Npc orc = new Npc("orc");
        mainLocation.addNpc(orc);
    }

    @Test
    //There should be next Location in North direction
    public void moveIfProperDirectionIsSend() {
        Player p = new Player("TestingPlayer");
        p.setCurrentLocation(mainLocation);
        MoveCommand move = new MoveCommand(Direction.N,p);
        String result = move.execute();
        assertEquals(northLocation.getDescription(),result);
    }

    @Test
    // There should not be location in south direction.
    public void returnInfoIfThereIsNoLocationInGivenDirection() {
        Player p = new Player("TestPlayer");
        p.setCurrentLocation(mainLocation);
        MoveCommand move = new MoveCommand(Direction.S, p);
        String result = move.execute();
        assertEquals("You can't go that way.", result);
    }

}