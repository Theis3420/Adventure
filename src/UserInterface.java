import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    Scanner in = new Scanner(System.in);

    private Player player;

    UserInterface(Player player){
        this.player = player;
    }


    public void displayIntroduction() {
        System.out.println("You've entered the darkest Dungeon!");
        displayHelp();
    }

    public void displayHelp() {
        System.out.println("(1) To move around type a direction like \"North\" or East etc.\n(2) Type \"Look\" if you want to look around the room again \n(3) If you want to close the game type \"Exit\"\n(4) if you are stuck type \"Help\"");
    }

    public void displayRoomDescription() {
        System.out.println(player.getPosition().getDescription());
    }

    public void displayInvalidDirection(){
        System.out.println("You cannot go that way");
    }

    public String getPlayerInput(){
        return in.next().toLowerCase(Locale.ROOT);
    }
}