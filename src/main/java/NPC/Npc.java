package NPC;

public class Npc {
    private String name;

    private int health;
    private int strength;

    public Npc(String name, int health,int strength) {
        this.name = name;
        this.health =150;
        this.strength=4;
    }

    public String getName() {
        return name;
    }
}
