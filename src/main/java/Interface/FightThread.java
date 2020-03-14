package Interface;

import Characters.Npc.Npc;
import Characters.player.Player;

public class FightThread implements Runnable {

    private Player player;
    private Npc targetNpc;
    FightStrategy fightStrategy;

    public FightThread(Player player, Npc targetNpc, FightStrategy fightStrategy) {
        this.player = player;
        this.targetNpc = targetNpc;
        this.fightStrategy = fightStrategy;
    }

    @Override
    public void run() {
        fightStrategy.fight(player,targetNpc);
    }

}