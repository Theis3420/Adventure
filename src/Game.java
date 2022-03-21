import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Game {

  Scanner in = new Scanner(System.in);
  Map map = new Map();
  Player player = new Player();
  UserInterface ui = new UserInterface();


  public void execute() {
    map.connectRooms();
    map.addItemsToRoom();
    player.setPosition(map.getStartRoom());
    ui.displayIntroduction();
    ui.displayRoomDescription(player);
    boolean gameRunning = true;
    while (gameRunning) {
      String playerInput = in.nextLine().toLowerCase();
      switch (playerInput) {
        case "east", "west", "north", "south" -> {
          boolean moving = player.move(playerInput);
          if (moving) {
            ui.displayRoomDescription(player);
            ui.displayItems(player);
          } else {
            ui.displayInvalidDirection();
          }
        }
        case "help" -> ui.displayHelp();
        case "look" -> {
          ui.displayRoomDescription(player);
          ui.displayItems(player);
        }
        case "inventory" -> ui.displayInventory(player);
        case "exit" -> gameRunning = false;
      }
      if (playerInput.contains("take")) {
        ui.displayPickup(player.takeItem(playerInput));
      } else if (playerInput.contains("drop")) {
        ui.displayDrop(player.dropItem(playerInput));
      }
    }
  }
}