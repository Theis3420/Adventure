public class Player {
  private Room position;

  Player(Room position) {
    setPosition(position);
  }
  public Room getPosition() {
    return position;
  }

  public void setPosition(Room position) {
    this.position = position;
  }
}
