public class UserInterface {

    public void introduction() {
        System.out.println("You've entered the darkest Dungeon!");
        help();
    }
    public void help() {
        System.out.println("(1) To move around type a direction like \"North\" or East etc.\n(2) Type \"Look\" if you want to look around the room again \n(3) If you want to close the game type \"Exit\"\n(4) if you are stuck type \"Help\"");
    }
}
