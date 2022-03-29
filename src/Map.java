import java.util.Scanner;

public class Map {
    private Room startRoom;
    Room room1 = new Room("(Room 1) You see an empty room with two Doors, one leading East and another leading South");
    Room room2 = new Room("(Room 2) You see an empty room with two Doors, one leading East and another leading West");
    Room room3 = new Room("(Room 3) You see an empty room with two Doors, one leading West and another leading South");
    Room room4 = new Room("(Room 4) You see an empty room with two Doors, one leading North and another leading south");
    Room room5 = new Room("(Room 5) You see an empty room with one Door leading South");
    Room room6 = new Room("(Room 6) You see an empty room with two Doors, one leading North and another leading South");
    Room room7 = new Room("(Room 7) You see an empty room with two Doors, one leading North and another leading East");
    Room room8 = new Room("(Room 8) You see an empty room with three Doors, one leading East, one leading North and another leading West");
    Room room9 = new Room("(Room 9) You see an empty room with two Doors, one leading East and another leading North");

    Item apple = new Food("Apple",10);
    Item poison = new Food("Poison",-50);
    Item sword = new MeleeWeapon("Sword",10, false);
    Item hammer = new MeleeWeapon("Hammer",20, false);
    Item bow = new RangedWeapon("Bow", 20, true, 5);

    Enemy zombie = new Enemy("Zombie", 20, hammer);


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
    }

    public void addItemsToRoom(){
        //room1.addItem(torch);
        //room2.addItem(axe);
        room1.addItem(sword);
        room1.addItem(apple);
        room1.addItem(poison);
        room1.addItem(hammer);
        room1.addItem(bow);
        //room3.addItem(key);
        //room4.addItem(shield);
        //room5.addItem(sword);
    }

    public void addEnemiestoRooms() {
        room1.addEnemy(zombie);
    }
}