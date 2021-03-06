import java.util.ArrayList;
import java.util.Locale;

public class Player {
  private Room position;
  private ArrayList<Item> inventory = new ArrayList<>();
  private int healthPoints;
  private final int MAX_HEALTHPOINTS = 100, MIN_HEALTHPOINTS = 0;
  private Item weapon;
  private enum HealthStatus{
    HEALTHY,
    OK,
    CRITICAL,
    DEAD
  }
  private boolean hasHolyGrail = false;

  Player(){
    this.healthPoints = this.MAX_HEALTHPOINTS;
  }

  public String getHealthStatus(){

    if (this.healthPoints > 75){
      return HealthStatus.HEALTHY.name();
    } else if (this.healthPoints > 25){
      return HealthStatus.OK.name();
    } else if (this.healthPoints > 1){
      return HealthStatus.CRITICAL.name();
    } else {
      return HealthStatus.DEAD.name();
    }
  }

  public void addItem(Item item) {
    this.inventory.add(item);
  }

  public ArrayList<Item> getInventory() {
    return this.inventory;
  }

  public Room getPosition() {
    return position;
  }

  public boolean isHasHolyGrail() {
    return hasHolyGrail;
  }

  public void setPosition(Room position) {
    this.position = position;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints += healthPoints;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public String equipItem (String playerInput) {
    for (int i = 0; i < getInventory().size(); i++) {
      if (getInventory().get(i).getName().toLowerCase(Locale.ROOT).contains(playerInput.substring(6))) {
        if (this.weapon != null){
          addItem(this.weapon);
        }
        String itemName = getInventory().get(i).getName();
        this.weapon = getInventory().get(i);
        getInventory().remove(i);
        return itemName;
      }
    }
    return null;
  }

  public String unequipItem(){
    addItem(this.weapon);
    String itemName = this.weapon.getName();
    this.weapon = null;
    return itemName;
  }

  public int attack () {
    if (this.weapon == null) {
      return 2;
    }
    else if (((Weapon)this.weapon).isRanged()) {
      if (((RangedWeapon) this.weapon).getAmmo() < 0) {
        return 0;
      } else {
        ((RangedWeapon) this.weapon).setAmmo(-1);
        return ((Weapon) this.weapon).getDamage();
      }
    } else {
      return ((Weapon) this.weapon).getDamage();
    }
  }

  public void hit (int damage) {
    this.healthPoints -= damage;
  }

  public void eat(Food food){

    this.healthPoints += food.getHealthRestoration();
    if (this.healthPoints > 100){
      this.healthPoints = this.MAX_HEALTHPOINTS;
    } else if (this.healthPoints < 1){
    }
  }

  public String takeItem(String playerInput) {
    for (int i = 0; i < getPosition().getItems().size(); i++) {
      if (getPosition().getItems().get(i).getName().toLowerCase(Locale.ROOT).contains(playerInput.substring(5))) {
        String itemName = getPosition().getItems().get(i).getName();
        addItem(getPosition().getItems().get(i));
        getPosition().getItems().remove(i);
        if (itemName.equals("Holy Grail")){
          this.hasHolyGrail = true;
        }
        return itemName;
      }
    }
    return null;
  }

  public String dropItem (String playerInput) {
    for (int i = 0; i < getInventory().size(); i++) {
      if (getInventory().get(i).getName().toLowerCase(Locale.ROOT).contains(playerInput.substring(5))) {
        String itemName = getInventory().get(i).getName();
        getPosition().getItems().add(getInventory().get(i));
        getInventory().remove(i);
        return itemName;
      }
    }
    return null;
  }

  public String eatItem (String playerInput) {
    for (int i = 0; i < getInventory().size(); i++) {
      if (getInventory().get(i).getName().toLowerCase(Locale.ROOT).contains(playerInput.substring(4))) {
        String itemName = getInventory().get(i).getName();
        eat((Food)getInventory().get(i));
        getInventory().remove(i);

        return itemName;
      }
    }
    return null;
  }

  public boolean move(String playerInput) {
    if (playerInput.equals("east") && getPosition().getRoomEast() != null) {
      setPosition(getPosition().getRoomEast());
    } else if (playerInput.equals("west") && getPosition().getRoomWest() != null) {
      setPosition(getPosition().getRoomWest());
    } else if (playerInput.equals("north") && getPosition().getRoomNorth() != null) {
      setPosition(getPosition().getRoomNorth());
    } else if (playerInput.equals("south") && getPosition().getRoomSouth() != null) {
      setPosition(getPosition().getRoomSouth());
    } else {
      return false;
    }
    return true;
  }
}