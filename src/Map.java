import java.util.ArrayList;

public class Map {
    private Room startRoom;
    //Creating rooms
    Room room1 = new Room("You enter a room with two Doors, one leading East and another leading South");
    Room room2 = new Room("You enter a room with two Doors, one leading East and another leading West");
    Room room3 = new Room("You enter a room with two Doors, one leading West and another leading South");
    Room room4 = new Room("You enter a room with two Doors, one leading North and another leading south");
    Room room5 = new Room("You enter a room with the holy grail");
    Room room6 = new Room("You enter a room with two Doors, one leading North and another leading South");
    Room room7 = new Room("You enter a room with two Doors, one leading North and another leading East");
    Room room8 = new Room("You enter a room with three Doors, one leading East, one leading North and another leading West");
    Room room9 = new Room("You enter a room with two Doors, one leading East and another leading North");

    ArrayList<Room> rooms = new ArrayList<>();

    // Creating Food
    Item potion = new Food("Potion",20);
    Item apple = new Food("Apple",10);
    Item deadRat = new Food("Dead Rat",-50);
    Item porkchop = new Food("Porkchop", 60);
    Item cheese = new Food("Cheese", 20);
    Item bread = new Food("Bread", 15);
    Item holyGrail = new Food("Holy Grail", 2000);

    // Creating Weapons
    Item sword = new MeleeWeapon("Sword",10, false);
    Item hammer = new MeleeWeapon("Hammer",20, false);
    Item divineSword = new MeleeWeapon("Divine Sword", 40, false);
    Item pitchFork = new MeleeWeapon("Pitchfork", 5,false);
    Item club = new MeleeWeapon("Club", 5,false);
    Item bow = new RangedWeapon("Bow", 20, true, 5);
    Item tomeOfMagicMissile = new RangedWeapon("Tome Of Magic Missile", 30,true,4);

    // Creating Enemies
    Enemy zombie = new Enemy("Zombie", 20, sword);
    Enemy goblin = new Enemy("Goblin",15,hammer);
    Enemy skeleton = new Enemy("Skeleton", 40,sword);
    Enemy darkWizard = new Enemy("Dark Wizard", 15, tomeOfMagicMissile);
    Enemy ogre = new Enemy("Ogre", 150, club);

    Map (){
        this.startRoom = room1;
    }

    public Room getStartRoom() {
        return startRoom;
    }

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

        rooms.add(room2);
        rooms.add(room6);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room9);
        rooms.add(room7);
        rooms.add(room8);
    }

    public void addItemsToRoom(){
        room1.addItem(club);
        room1.addItem(apple);
        room1.addItem(potion);
        room1.addItem(potion);
        room1.addItem(potion);

        room5.addItem(holyGrail);
        room5.addItem(porkchop);
        room5.addItem(divineSword);

        room6.addItem(bread);
        room7.addItem(deadRat);

        room8.addItem(cheese);
        room8.addItem(bow);

        room9.addItem(pitchFork);
    }

    public void addEnemiestoRooms() {
        room2.addEnemy(zombie);
        room3.addEnemy(goblin);
        room4.addEnemy(zombie);
        room5.addEnemy(ogre);
        room6.addEnemy(darkWizard);
        room7.addEnemy(goblin);
        room8.addEnemy(skeleton);
    }

    public void createMap(){
        connectRooms();
        addItemsToRoom();
        addEnemiestoRooms();
    }

    public void respawnEnemy(){
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getEnemies().isEmpty()){
                rooms.get(i).addEnemy(skeleton);
            }
        }
    }
}