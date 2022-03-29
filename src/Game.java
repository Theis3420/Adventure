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
    map.addEnemiestoRooms();
    player.setPosition(map.getStartRoom());
    ui.displayIntroduction();
    ui.displayRoomDescription(player);
    boolean gameRunning = true;
    while (gameRunning) {
      String playerInput = in.nextLine().toLowerCase();
      switch (playerInput) {
        case "east", "west", "north", "south" -> {
          if (player.getPosition().getEnemies().isEmpty()) {
            boolean moving = player.move(playerInput);
            if (moving) {
              ui.displayRoomDescription(player);
              ui.displayItems(player);
              ui.displayEnemies(player);
            } else {
              ui.displayInvalidDirection();
            }
          } else {
            ui.displayCombatMovevement();
          }

        }
        case "help" -> ui.displayHelp();
        case "look" -> {
          ui.displayRoomDescription(player);
          ui.displayItems(player);
          ui.displayEnemies(player);
        }
        case "inventory" -> ui.displayInventory(player);
        case "exit" -> gameRunning = false;
        case "health" -> ui.displayHealthPoints(player);
        case "attack" -> attack();
      }
      if (playerInput.contains("take")) {
          ui.displayPickup(player.takeItem(playerInput));
        } else if (playerInput.contains("drop")) {
          ui.displayDrop(player.dropItem(playerInput));
        } else if (playerInput.contains("eat")) {
          ui.displayEat(player.eatItem(playerInput));
          ui.displayHealthStatus(player.getHealthStatus());
          ui.displayHealthPoints(player);
      } else if (playerInput.contains("unequip")){
            ui.displayUnEquip(player.unequipItem());
        } else if (playerInput.contains("equip")){
          ui.displayEquip(player.equipItem(playerInput));
        }
      if (player.getHealthPoints() < 1) {
        gameRunning = false;
        ui.displayDeath();
      }
    }
  }

    public void attack() {
      if (!player.getPosition().getEnemies().isEmpty()) {
        firstEnemy().hit(player.attack());
        ui.displayAttack(player.attack(), firstEnemy());
        player.hit(firstEnemy().attack());
        ui.displayHit(firstEnemy());
        if (firstEnemy().getHealth() < 1) {
          ui.displayEnemyDeath(firstEnemy());
          firstEnemy().dropWeapon(player.getPosition().getItems());
          player.getPosition().getEnemies().remove(0);
        }
      } else {
        ui.displayAttack(-1, null);
      }
    }
    public Enemy firstEnemy() {
      return player.getPosition().getEnemies().get(0);
    }
  }
