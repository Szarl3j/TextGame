package Interface;

import NPC.Npc;
import player.Player;

public interface FightStrategy {

    public void fight(Player player, Npc targetNPC);

}