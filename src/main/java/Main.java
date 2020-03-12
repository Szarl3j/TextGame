import ProjectService.CommandService;
import Repository.LocationRepository;
import player.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        LocationRepository locationRepository = new LocationRepository();
        CommandService parser = new CommandService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName, 100, 10, 20);

        player.setCurrentLocation(locationRepository.getStartLocation());

        System.out.println(player.getCurrentLocationDescription());

        String command = "";
        while(!command.equals("quit")) {
            command = readPlayerInput(scanner);
            parser.actOnComand(command,player);
        }

        System.out.println("Goodbye!");
    }

    private static String readPlayerInput(Scanner scanner) {
        System.out.print(">");
        String command = scanner.nextLine();
        return command;
    }
}