import java.util.ArrayList;
public class Room {
private String name;
private String description;
private Room roomEast, roomWest, roomNorth, roomSouth, thisRoom;
private ArrayList<Item> items = new ArrayList<>();

Room (String description) {
  setDescription(description);
}
  public void addItem(Item item) {
    this.items.add(item);
  }
  public ArrayList<Item> getItems() {
    return this.items;
  }
  public String getItemName(int index) {
    return getItems().get(index).getName();
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getDescription() {
    return description;
  }
  public void setRoomEast(Room roomEast) {
    this.roomEast = roomEast;
    if (roomEast.getRoomWest() == null){
      this.roomEast.setRoomWest(this.thisRoom);
    }
  }

  public Room getRoomEast() {
    return roomEast;
  }

  public void setRoomWest(Room roomWest) {
    this.roomWest = roomWest;
    if (roomWest.getRoomEast() == null){
      this.roomWest.setRoomEast(this.thisRoom);
    }
  }
  public Room getRoomWest() {
    return roomWest;
  }

  public void setRoomNorth(Room roomNorth) {
    this.roomNorth = roomNorth;
    if (roomNorth.getRoomSouth() == null){
      this.roomNorth.setRoomSouth(this.thisRoom);
    }
  }
  public Room getRoomNorth() {
    return roomNorth;
  }

  public void setRoomSouth(Room roomSouth) {
    this.roomSouth = roomSouth;
    if (roomSouth.getRoomNorth() == null){
      this.roomSouth.setRoomNorth(this.thisRoom);
    }
  }
  public Room getRoomSouth() {
    return roomSouth;
  }

  public void setThisRoom(Room thisRoom) {
    this.thisRoom = thisRoom;
  }
  public Room getThisRoom() {
    return thisRoom;
  }
}
