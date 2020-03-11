import Interface.FightThread;
import NPC.Npc;
import ProjectService.CommandService;
import Repository.LocationRepository;
import location.Direction;
import location.Location;
import player.Player;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        LocationRepository locationRepository= new LocationRepository();

        System.out.println(" What's your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Player player = new Player("szarlej", 100, 10);


        player.setCurrentLocation(locationRepository.getStartLocation);

        System.out.println(player.getCurrentLocationDescription());

        String command = "...";
        while (!command.equals("zakończ")) {
            command = readPlayerInput(scanner);
            CommandService.actOnComand(command, player);
        }
        System.out.println("Do zobaczenia!");
    }

    private static String readPlayerInput(Scanner scanner) {
        System.out.println(">");
        String command = scanner.nextLine();
        return command;

    }




   }