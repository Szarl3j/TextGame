package NPC;

public class Npc {
    private String name;

    private int health;
    private int strength;

    public Npc(String name, int health, int strength) {
        this.name = name;
        this.health = 125;
        this.strength = 3;
    }

    public String getName() {
        return name;
    }

    public boolean isAllive() {
        return health > 0;
    }

    public int getStrength() {
        return strength;
    }

    public void damageTaken(int hit) {
        this.health = this.health - hit;
    }
}
