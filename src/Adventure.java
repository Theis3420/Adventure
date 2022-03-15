import java.util.Locale;
import java.util.Scanner;

public class Adventure {
  Room room1 = new Room("(Room 1) You see an empty room with two Doors, one leading East and another leading South");
  Room room2 = new Room("(Room 2) You see an empty room with two Doors, one leading East and another leading West");
  Room room3 = new Room("(Room 3) You see an empty room with two Doors, one leading West and another leading South");
  Room room4 = new Room("(Room 4) You see an empty room with two Doors, one leading North and another leading south");
  Room room5 = new Room("(Room 5) You see an empty room with one Door leading South");
  Room room6 = new Room("(Room 6) You see an empty room with two Doors, one leading North and another leading South");
  Room room7 = new Room("(Room 7) You see an empty room with two Doors, one leading North and another leading East");
  Room room8 = new Room("(Room 8) You see an empty room with three Doors, one leading East, one leading North and another leading West");
  Room room9 = new Room("(Room 9) You see an empty room with two Doors, one leading East and another leading North");
  Player player = new Player(room1);
  Scanner in = new Scanner(System.in);

  public void connectRooms() {
    room1.setThisRoom(room1);
    room2.setThisRoom(room2);
    room3.setThisRoom(room3);
    room4.setThisRoom(room4);
    room5.setThisRoom(room5);
    room6.setThisRoom(room6);
    room7.setThisRoom(room7);
    room8.setThisRoom(room8);
    room9.setThisRoom(room9);

    room1.setRoomEast(room2);
    room1.setRoomSouth(room4);

    room2.setRoomEast(room3);

    room3.setRoomSouth(room6);

    room4.setRoomSouth(room7);

    room5.setRoomSouth(room8);

    room6.setRoomSouth(room9);

    room7.setRoomEast(room8);

    room8.setRoomEast(room9);
  }
  void move(String playerInput) {
    if (playerInput.equals("east") && player.getPosition().getRoomEast() != null) {
      player.setPosition(player.getPosition().getRoomEast());
      displayRoomDescription();
    } else if (playerInput.equals("west") && player.getPosition().getRoomWest() != null) {
      player.setPosition(player.getPosition().getRoomWest());
      displayRoomDescription();
    } else if (playerInput.equals("north") && player.getPosition().getRoomNorth() != null) {
      player.setPosition(player.getPosition().getRoomNorth());
      displayRoomDescription();
    } else if (playerInput.equals("south") && player.getPosition().getRoomSouth() != null) {
      player.setPosition(player.getPosition().getRoomSouth());
      displayRoomDescription();
    } else {
      System.out.println("You cannot go that way");
    }
  }
  void introduction() {
    System.out.println("You've entered the darkest Dungeon!");
    help();
  }
  void help() {
    System.out.println("(1) To move around type a direction like \"North\" or East etc.\n(2) Type \"Look\" if you want to look around the room again \n(3) If you want to close the game type \"Exit\"\n(4) if you are stuck type \"Help\"");
  }
  void displayRoomDescription() {
    System.out.println(player.getPosition().getDescription());
  }
  void execute() {
    connectRooms();
    introduction();
    displayRoomDescription();
    while (true) {
      String playerInput = in.next().toLowerCase(Locale.ROOT);
      switch (playerInput) {
        case "east", "west", "north", "south" -> move(playerInput);
        case "help" -> help();
        case "look" -> displayRoomDescription();
        case "exit" -> {
          System.out.println("Exiting game.");
          System.exit(0);
        }
      }
    }
  }
  public static void main(String[] args) {
    new Adventure().execute();
  }
}
