import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    Scanner in = new Scanner(System.in);

    public void displayPickup(String item) {
        if (item == null) {
            System.out.println("You failed to pick up anything");
        } else {
            System.out.println("You just picked up a " + item);
        }
    }
    public void displayDrop(String item) {
        if (item == null) {
            System.out.println("You failed to drop anything");
        } else {
            System.out.println("You just dropped a " + item);
        }
    }
    public void displayAttack (int damageNum, Enemy enemy) {
        if (damageNum == 0) {
            System.out.println("Your ranged weapon has run out of ammunition");
        } else if (damageNum == -1) {
            System.out.println("You attack nothing");
        } else {
            System.out.println("You dealt " + damageNum + " damage to the " + enemy.getName());
        }
    }
    public void displayHit (Enemy enemy) {
        System.out.println("The " + enemy.getName() + " attacked you for " + enemy.attack() + " damage");
    }
    public void displayCombatMovevement() {
        System.out.println("You are unable to move between rooms while in combat");
    }
    public void displayDeath() {
        System.out.println("You died, Game Over.");
    }
    public void displayEnemyDeath(Enemy enemy) {
        System.out.println("You have killed the " + enemy.getName());
    }
    public void displayEat(String item){
        if (item == null) {
            System.out.println("You failed to eat anything");
        } else {
            System.out.println("You just ate a " + item);
        }
    }
    public void displayEquip(String item){
        if (item == null) {
            System.out.println("You failed to equip anything");
        } else {
            System.out.println("You just equipped a " + item);
        }
    }
    public void displayUnEquip(String item){
        if (item == null) {
            System.out.println("You failed to unequip anything");
        } else {
            System.out.println("You just unequipped a " + item);
        }
    }
    public void displayHealthStatus(String healthStatus){
        System.out.println("You are currently in " + healthStatus + " condition");
    }
    public void displayHealthPoints(Player player){
        System.out.println("You have " + player.getHealthPoints() + " health points left");
    }
    public void displayInventory(Player player) {
        StringBuilder sb = new StringBuilder();
        System.out.println("You currently have these items in your inventory: ");
        for (int i = 0; i < player.getInventory().size(); i++) {
            sb.append(player.getInventory().get(i).getName());
            sb.append(" ");
        }
        System.out.println(String.valueOf(sb));
    }
    public void displayItems(Player player) {
        if (player.getPosition().getItems().size() > 0) {
            System.out.print("Lying in the room you see a ");
            for (int i = 0; i < player.getPosition().getItems().size(); i++) {
                if (i > 0) {
                    System.out.print(" and a ");
                }
                System.out.print(player.getPosition().getItems().get(i).getName());
            }
            System.out.println();
        }
    }
    public void displayEnemies(Player player) {
        if (player.getPosition().getEnemies().size() == 0) {
            System.out.println("There are no enemies nearby");
        } else {
            System.out.println("There is a hostile " + player.getPosition().getEnemies().get(0).getName() + " in the room");
        }
    }
    public void displayIntroduction() {
        System.out.println("You've entered the darkest Dungeon!");
        displayHelp();
    }

    public void displayHelp() {
        System.out.println("(1) To move around type a direction like \"North\" or East etc.\n(2) Type \"Look\" if you want to look around the room again \n(3) If you want to close the game type \"Exit\"\n(4) if you are stuck type \"Help\"");
    }

    public void displayRoomDescription(Player player) {
        System.out.println(player.getPosition().getDescription());
    }

    public void displayInvalidDirection(){
        System.out.println("You cannot go that way");
    }

    public String getPlayerInput(){
        return in.next().toLowerCase(Locale.ROOT);
    }
}