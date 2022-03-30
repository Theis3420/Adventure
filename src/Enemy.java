import java.util.ArrayList;

public class Enemy {
  private String name;
  private int health;
  private Item weapon;

  Enemy(String name, int health, Item weapon) {
    this.name = name;
    this.health = health;
    this.weapon = weapon;
  }
  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public void hit(int damage) {
    this.health -= damage;
  }

  public int attack () {
    return ((Weapon)this.weapon).getDamage();
  }

  public void dropWeapon(ArrayList<Item> items) {
    items.add(this.weapon);
  }
}