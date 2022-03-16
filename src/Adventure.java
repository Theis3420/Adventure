import java.util.Locale;
import java.util.Scanner;

public class Adventure {

  Scanner in = new Scanner(System.in);
  Map map = new Map();
  Player player = new Player(map.room1);
  UserInterface ui = new UserInterface();

  public void move(String playerInput) {
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

  public void displayRoomDescription() {
    System.out.println(player.getPosition().getDescription());
  }

  public void execute() {
    map.connectRooms();
    ui.introduction();
    displayRoomDescription();
    boolean gameRunning = true;
    while (gameRunning) {
      String playerInput = in.next().toLowerCase(Locale.ROOT);
      switch (playerInput) {
        case "east", "west", "north", "south" -> move(playerInput);
        case "help" -> ui.help();
        case "look" -> displayRoomDescription();
        case "exit" -> gameRunning = false;
      }
    }
  }
}