import java.util.Locale;
import java.util.Scanner;

public class Game {

  Scanner in = new Scanner(System.in);
  Map map = new Map();
  Player player = new Player();
  UserInterface ui = new UserInterface(player);

  public void move(String playerInput) {
    if (playerInput.equals("east") && player.getPosition().getRoomEast() != null) {
      player.setPosition(player.getPosition().getRoomEast());
      ui.displayRoomDescription();
    } else if (playerInput.equals("west") && player.getPosition().getRoomWest() != null) {
      player.setPosition(player.getPosition().getRoomWest());
      ui.displayRoomDescription();
    } else if (playerInput.equals("north") && player.getPosition().getRoomNorth() != null) {
      player.setPosition(player.getPosition().getRoomNorth());
      ui.displayRoomDescription();
    } else if (playerInput.equals("south") && player.getPosition().getRoomSouth() != null) {
      player.setPosition(player.getPosition().getRoomSouth());
      ui.displayRoomDescription();
    } else {
      ui.displayInvalidDirection();
    }
  }
  public void execute() {
    map.connectRooms();
    player.setPosition(map.getStartRoom());
    ui.displayIntroduction();
    ui.displayRoomDescription();
    boolean gameRunning = true;
    while (gameRunning) {
      String playerInput = in.next().toLowerCase(Locale.ROOT);
      switch (playerInput) {
        case "east", "west", "north", "south" -> move(playerInput);
        case "help" -> ui.displayHelp();
        case "look" -> ui.displayRoomDescription();
        case "exit" -> gameRunning = false;
      }
    }
  }
}