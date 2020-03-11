package Interface;

import NPC.Npc;
import player.Player;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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