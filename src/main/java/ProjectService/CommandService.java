package ProjectService;

import Interface.FightThread;
import Npc.Npc;
import location.Direction;
import player.Player;

public class CommandService {
    public void actOnComand(String command, Player player){
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
    public void move(Direction direction, Player player) {
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println(" You can't go this way ");
        }

    }

     public void attack(String target, Player player) {
        Npc targetNpc = player.getNearbyNpc(target);
        if (targetNpc != null) {
            beginCombat(player, targetNpc);

        } else {
            System.out.println("There is none target to attack. ");
        }
    }

    private void beginCombat(Player player, Npc targetNpc) {
        FightThread ft = new FightThread(player, targetNpc);
        Thread thread = new Thread(ft);
        thread.start();
    }

}

