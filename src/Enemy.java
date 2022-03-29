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
  public void dropWeapon(ArrayList<Item> items) {
    items.add(this.weapon);
  }
  public int attack () {
    return ((Weapon)this.weapon).getDamage();
    /*
    player.setHealthPoints(-((Weapon)player.getPosition().getEnemies().get(0).getWeapon()).getDamage());
     */
  }
  public void hit(int damage) {
    this.health -= damage;
  }

  public String getName() {
    return name;
  }

  public Item getWeapon() {
    return weapon;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int damage) {
    this.health += damage;
  }
}
