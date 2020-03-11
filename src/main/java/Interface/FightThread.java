package Interface;

import NPC.Npc;
import player.Player;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FightThread implements Runnable {
    private Player player;
    private Npc targetNpc;

    public FightThread(Player player, Npc targetNpc) {
        this.player = player;
        this.targetNpc = targetNpc;
    }

    @Override
    public void run() {
    }

    int hit = 0;

    {
        while (player.isAllive() && targetNpc.isAllive()) {
        }
        boolean targetStillHere = player.isThereNpcNearby(targetNpc);
        if (!targetStillHere) {
            System.out.println("Your target is not longer here ");
            return;
        }

        try {
            hit = calculateHitStrength(player.getStrength());
            showHitMessage(targetNpc, hit);
            targetNpc.damageTaken(hit);
            Thread.sleep(2000);

            hit = calculateHitStrength(targetNpc.getStrength());
            showHitMessage(hit);
            player.damageTaken(hit);
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("BŁĄD KRYTYCZNY ");
        }
    }
    if(player.isAllive()&&!targetNpc.isAllive()){
        System.out.println("You are victorious");
    } else if(!player.isAllive()&&targetNpc.isAllive()){
        System.out.println("You are defeated! Try again next time ");
    } else{
        System.out.println(" Run away! ");
    }

    private int calculateHitStrength(int strength) {
        Random r = new Random();
        r.nextInt(4);
        return strength + r.nextInt(4);
    }

    private void showHitMessage(Npc targetNpc, int hit) {
        System.out.println("You hit " + targetNpc.getName() + " for " + hit + " damage ");
    }

    private void showHitMessage(int hit) {
        System.out.println("You're hit for " + hit + "damage ");
    }
}

