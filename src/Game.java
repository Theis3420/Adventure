public class Game {

  Map map = new Map();
  Player player = new Player();
  UserInterface ui = new UserInterface(player);


  public void execute() {
    map.connectRooms();
    player.setUi(ui);
    player.setPosition(map.getStartRoom());
    ui.displayIntroduction();
    ui.displayRoomDescription();
    boolean gameRunning = true;
    while (gameRunning) {
      String playerInput = ui.getPlayerInput();
      switch (playerInput) {
        case "east", "west", "north", "south" -> player.move(playerInput);
        case "help" -> ui.displayHelp();
        case "look" -> ui.displayRoomDescription();
        case "exit" -> gameRunning = false;
      }
    }
  }
}