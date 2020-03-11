package NPC;

public class Npc {
    private String name;

    private int health;
    private int strength;
    private int agility;

    public Npc(String name, int health, int strength,int agility) {
        this.name = name;
        this.health = 125;
        this.strength = 3;
        this.agility=5;
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
    @Override
    public String toString(){
        return this.name;
    }
}
