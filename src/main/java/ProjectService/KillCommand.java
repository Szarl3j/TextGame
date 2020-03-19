package ProjectService;

import Interface.AgilityFightStrategy;
import Interface.FightStrategy;
import Interface.FightThread;
import Characters.Npc.Npc;
import Characters.player.Player;

public class KillCommand implements Command{

    private String targetName;
    private Player player;

    public KillCommand(String targetName, Player player) {
        this.targetName = targetName;
        this.player = player;
    }

    @Override
    public String execute() {

        String result = "";

        Npc targetNpc = player.getNearbyNpc(targetName);
        if (targetNpc != null) {
            result = "You are attacking " + targetName;
            beginCombat(player, targetNpc);
        } else {
            result = "There's no one of this kind.";
        }

        return result;
    }

    public void beginCombat(Player player, Npc targetNpc) {

        FightStrategy fs = new AgilityFightStrategy();

        FightThread ft = new FightThread(player, targetNpc, fs);
        Thread t = new Thread(ft);

        t.start();
    }

}