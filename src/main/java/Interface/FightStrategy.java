package Interface;

import Characters.Npc.Npc;
import Characters.player.Player;

public interface FightStrategy {



    public void fight(Player player, Npc targetNPC);

}