package Interface;

import Npc.Npc;
import player.Player;

public interface FightStrategy {



    public void fight(Player player, Npc targetNPC);

}