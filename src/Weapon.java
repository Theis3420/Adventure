public class Weapon extends Item{

    private int durability, damage;

    Weapon(String name, int durability, int damage){
        super(name);
        this.damage = damage;
        this.durability = durability;
    }

    public int getDamage() {
        return damage;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}