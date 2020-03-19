import Characters.Npc.Npc;
import Characters.player.Player;
import ProjectService.KillCommand;
import location.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

public class KillTest {

    private Location mainLocation;
    Npc orc;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        orc = new Npc("orc");
        mainLocation.addNpc(orc);
    }

    @Test
    // Checking if Player's Character can begins combat with enemy npc
    public void beginCombatIfTargetIsThere() {
        Player testPlayer = new Player("TestingPlayer");
        testPlayer.setCurrentLocation(mainLocation);
        KillCommand kill = new KillCommand("orc", testPlayer);
        KillCommand killSpy = Mockito.spy(kill);
        killSpy.execute();
        Mockito.verify(killSpy, times(1)).beginCombat(testPlayer, orc);
    }

    @Test
    // There should not be  any target to attack.
    public void returnTargetNotThereInfoIfTargetIsNoOnLocation() {
        Player testPlayer = new Player("TestPlayer");
        testPlayer.setCurrentLocation(mainLocation);
        KillCommand kill = new KillCommand("Werewolf", testPlayer);
        String result = kill.execute();
        assertEquals("There's no one like that around.",result);
    }
}