public class Weapon extends Item{

    private int damage;
    private boolean ranged;

    Weapon(String name, int damage, boolean ranged){
        super(name);
        this.damage = damage;
        this.ranged = ranged;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isRanged() {
        return ranged;
    }
}