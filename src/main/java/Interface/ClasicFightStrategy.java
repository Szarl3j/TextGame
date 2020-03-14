package Interface;

import Characters.Npc.Npc;
import Characters.player.Player;

import java.util.Random;

public class ClasicFightStrategy implements  FightStrategy{

    public  ClasicFightStrategy() {
    }



    @Override
    public void fight(Player player, Npc targetNpc) {
        int hit=0;
        while(player.isAlive() && targetNpc.isAlive()) {

            boolean targetStillHere = player.isThereNPCNearby(targetNpc);

            if(!targetStillHere) {
                System.out.println("Your target is no longer here.");
                return;
            }

            try {
                hit = calculateHitStrength(player.getStrength());
                showHitMessage(targetNpc,hit);
                targetNpc.damageTaken(hit);
                Thread.sleep(2000);
                hit = calculateHitStrength(targetNpc.getStrength());
                showHitMessage(hit);
                player.damageTaken(hit);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Caly terror rozpetal error");
            }
        }

        if(player.isAlive() && !targetNpc.isAlive()) {
            System.out.println("You are victorious!");
        } else if((!player.isAlive() && targetNpc.isAlive())) {
            System.out.println("Try harder next time");
        } else {
            System.out.println("Run away!");
        }
    }

    private int calculateHitStrength(int strength) {
        Random r = new Random();
        return strength + r.nextInt(4);
    }

    private void showHitMessage(Npc targetNPC, int hit) {
        System.out.println("You hit " + targetNPC.getName() + " for " + hit + " damage.");
    }

    private void showHitMessage(int hit) {
        System.out.println("You're hit for " + hit + " damage.");
    }

}