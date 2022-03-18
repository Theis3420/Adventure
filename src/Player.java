public class Player {
  private Room position;

  private UserInterface ui;

  public void setUi(UserInterface ui) {
    this.ui = ui;
  }

  public void move(String playerInput) {
    if (playerInput.equals("east") && getPosition().getRoomEast() != null) {
      setPosition(getPosition().getRoomEast());
      ui.displayRoomDescription();
    } else if (playerInput.equals("west") && getPosition().getRoomWest() != null) {
      setPosition(getPosition().getRoomWest());
      ui.displayRoomDescription();
    } else if (playerInput.equals("north") && getPosition().getRoomNorth() != null) {
      setPosition(getPosition().getRoomNorth());
      ui.displayRoomDescription();
    } else if (playerInput.equals("south") && getPosition().getRoomSouth() != null) {
      setPosition(getPosition().getRoomSouth());
      ui.displayRoomDescription();
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