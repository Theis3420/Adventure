import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Game {

  Scanner in = new Scanner(System.in);
  Map map = new Map();
  Player player = new Player();
  UserInterface ui = new UserInterface(player);


  public void execute() {
    map.connectRooms();
    map.addItemsToRoom();
    player.setUi(ui);
    player.setPosition(map.getStartRoom());
    ui.displayIntroduction();
    ui.displayRoomDescription();
    boolean gameRunning = true;
    while (gameRunning) {
      String playerInput = in.nextLine().toLowerCase(Locale.ROOT);
      switch (playerInput) {
        case "east", "west", "north", "south" -> player.move(playerInput);
        case "help" -> ui.displayHelp();
        case "look" -> {
          ui.displayRoomDescription();
          ui.displayItems();
        }
        case "inventory" -> ui.displayInventory();
        case "exit" -> gameRunning = false;
      }
      if (playerInput.contains("take")) {
        player.takeItem(playerInput);
      } else if (playerInput.contains("drop")) {
        player.dropItem(playerInput);
      }
    }
  }
}