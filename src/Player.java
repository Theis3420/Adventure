import java.util.ArrayList;
import java.util.Locale;

public class Player {
  private Room position;
  private UserInterface ui;
  private ArrayList<Item> inventory = new ArrayList<>();

  public void setUi(UserInterface ui) {
    this.ui = ui;
  }
  public void addItem(Item item) {
    this.inventory.add(item);
  }
  public ArrayList<Item> getInventory() {
    return this.inventory;
  }
  public void takeItem(String playerInput) {
    for (int i = 0; i < getPosition().getItems().size(); i++) {
      if (getPosition().getItems().get(i).getName().toLowerCase(Locale.ROOT).contains(playerInput.substring(5))) {
        ui.displayPickup(getPosition().getItems().get(i).getName());
        addItem(getPosition().getItems().get(i));
        getPosition().getItems().remove(i);
      }
    }
  }
  public void dropItem (String playerInput) {
    for (int i = 0; i < getInventory().size(); i++) {
      if (getInventory().get(i).getName().toLowerCase(Locale.ROOT).contains(playerInput.substring(5))) {
        ui.displayDrop(getInventory().get(i).getName());
        getPosition().getItems().add(getInventory().get(i));
        getInventory().remove(i);
      }
    }
  }

  public void move(String playerInput) {
    if (playerInput.equals("east") && getPosition().getRoomEast() != null) {
      setPosition(getPosition().getRoomEast());
      ui.displayRoomDescription();
      ui.displayItems();

    } else if (playerInput.equals("west") && getPosition().getRoomWest() != null) {
      setPosition(getPosition().getRoomWest());
      ui.displayRoomDescription();
      ui.displayItems();

    } else if (playerInput.equals("north") && getPosition().getRoomNorth() != null) {
      setPosition(getPosition().getRoomNorth());
      ui.displayRoomDescription();
      ui.displayItems();

    } else if (playerInput.equals("south") && getPosition().getRoomSouth() != null) {
      setPosition(getPosition().getRoomSouth());
      ui.displayRoomDescription();
      ui.displayItems();

    } else {
      ui.displayInvalidDirection();
    }
  }

  public Room getPosition() {
    return position;
  }

  public void setPosition(Room position) {
    this.position = position;
  }
}