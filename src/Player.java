import java.util.ArrayList;
import java.util.Locale;

public class Player {
  private Room position;
  private ArrayList<Item> inventory = new ArrayList<>();

  public void addItem(Item item) {
    this.inventory.add(item);
  }
  public ArrayList<Item> getInventory() {
    return this.inventory;
  }
  public String takeItem(String playerInput) {
    for (int i = 0; i < getPosition().getItems().size(); i++) {
      if (getPosition().getItems().get(i).getName().toLowerCase(Locale.ROOT).contains(playerInput.substring(5))) {
        String itemName = getPosition().getItems().get(i).getName();
        addItem(getPosition().getItems().get(i));
        getPosition().getItems().remove(i);
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

  public Room getPosition() {
    return position;
  }

  public void setPosition(Room position) {
    this.position = position;
  }
}