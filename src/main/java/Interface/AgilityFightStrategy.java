package Interface;

import Characters.Npc.Npc;
import Characters.player.Player;
import java.util.Random;
public class AgilityFightStrategy implements FightStrategy {


    @Override
    public void fight(Player player, Npc targetNpc) {
        int hit=0;
        while(player.isAlive() && targetNpc.isAlive()) {

            boolean targetStillHere = player.isThereNpcNearby(targetNpc);

            if(!targetStillHere) {
                System.out.println("Your target is no longer here.");
                return;
            }

            try {
                if(calculateHitChance(player, targetNpc)) {
                    hit = calculateHitStrength(player.getStrength());
                    showHitMessage(targetNpc,hit);
                    targetNpc.damageTaken(hit);
                } else {
                    System.out.println("You missed by attacking " + targetNpc.getName());
                }

                Thread.sleep(2000);

                if(calculateHitChance(targetNpc, player)) {
                    hit = calculateHitStrength(targetNpc.getStrength());
                    showHitMessage(hit);
                    player.damageTaken(hit);
                } else {
                    System.out.println(targetNpc.getName() +"'s hit misses you" );
                }

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

    private void showHitMessage(Npc targetNpc, int hit) {
        System.out.println("You hit " + targetNpc.getName() + " for " + hit + " damage.");
    }

    private void showHitMessage(int hit) {
        System.out.println("You're hit for " + hit + " damage.");
    }

    private boolean calculateHitChance(Npc targetNpc, Player player) {
        int rand = new Random().nextInt(20);
        return (targetNpc.getAgility()+rand)>player.getAgility();
    }

    private boolean calculateHitChance(Player player, Npc targetNpc) {
        int rand = new Random().nextInt(40);
        return (player.getAgility()+rand)>targetNpc.getAgility();
    }


}