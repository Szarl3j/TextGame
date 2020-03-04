import NPC.Npc;
import location.Direction;
import location.Location;
import player.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(" What's your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Player player = new Player("szarlej");
        Location statLocation = new Location("Small room ", "You' re wake up in small dark room. " +
                "Single bed standing next to the wall is only furniture  and some clothes laying on the floor. ");
        Location secondLocation = new Location("corridor", "...");

        statLocation.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S, statLocation);

        Npc orc = new Npc("Orc");
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
        switch (command) {
            case "n":
            case "north":
                move(Direction.N, player);
                break;
            case "s":
            case"south":
                move(Direction.S,player);
                break;
            case "e":
            case"east":
                move(Direction.E,player);
                break;
            case "w":
            case"West":
                move(Direction.W, player);
                break;
            default:
                System.out.println("Nieznana komenda");
                break;
        }
    }

    private static void move(Direction direction, Player player) {
        boolean hasMoved = player.move( direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println(" You can't go this way ");
        }

    }
}
