import NPC.Npc;
import location.Direction;
import location.Location;
import player.Player;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        System.out.println(" What's your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Player player = new Player("szarlej", 100, 10);
        Location statLocation = new Location("Small room ", "You' re wake up in small dark room. " +
                "Single bed standing next to the wall is only furniture  and some clothes laying on the floor. ");
        Location secondLocation = new Location("corridor", "...");

        statLocation.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S, statLocation);

        Npc orc = new Npc("Orc", 150, 5);
        statLocation.addNpc(orc);

        player.setCurrentLocation(statLocation);

        System.out.println(player.getCurrentLocationDescription());

        String command = "...";
        while (!command.equals("zakończ")) {
            command = readPlayerInput(scanner);
            actOnCommand(command, player);
        }
        System.out.println("Do zobaczenia!");
    }

    private static String readPlayerInput(Scanner scanner) {
        System.out.println(">");
        String command = scanner.nextLine();
        return command;

    }

    private static void actOnCommand(String command, Player player) {
        command = command.toLowerCase();
        String[] splited = command.split(" ");

        switch (splited[0]) {
            case "n":
            case "north":
                move(Direction.N, player);
                break;
            case "s":
            case "south":
                move(Direction.S, player);
                break;
            case "e":
            case "east":
                move(Direction.E, player);
                break;
            case "w":
            case "West":
                move(Direction.W, player);
                break;
            case "kill":
                attack(splited[1], player);
                break;
            default:
                System.out.println("Unknown comand ");
                break;
        }
    }

    private static void move(Direction direction, Player player) {
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println(" You can't go this way ");
        }

    }

    private static void attack(String target, Player player) {
        Npc targetNpc = player.isThereNPCNearby(target);
        if (targetNpc != null) {
            beginCombat(player, targetNpc);

        } else {
            System.out.println("There is none target to attack. ");
        }
    }

    private static void beginCombat(Player player, Npc targetNpc) {
        int hit = 0;
        while (player.isAllive() && targetNpc.isAllive())
            try{
            hit = calculateHitStrength(player.getStrength());
            showHitMessage(targetNpc, hit);
            targetNpc.damageTaken(hit);
            Thread.sleep(2000);

            hit = calculateHitStrength(targetNpc.getStrength());
            showHitMessage(hit);
            player.damageTaken(hit);
            Thread.sleep(2000);
        }catch (InterruptedException ex){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (player.isAllive()) {
            System.out.println("You are victorious");
        } else {
            System.out.println("You are defeated! Try again next time ");
        }
    }

    private static int calculateHitStrength(int strength) {
        Random r = new Random();
        r.nextInt(4);
        return strength + r.nextInt(4);
    }

    private static void showHitMessage(Npc targetNpc, int hit) {
        System.out.println("You hit " + targetNpc.getName() + " for " + hit + " damage ");
    }

    private static void showHitMessage( int hit) {
        System.out.println("You're hit for " + hit + "damage ");
    }
}