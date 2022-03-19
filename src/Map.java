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

    Item torch = new Item("Torch");
    Item axe = new Item("Axe");
    Item key = new Item("Key");
    Item shield = new Item("Shield");
    Item sword = new Item("Sword");

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
        room1.addItem(torch);
        room2.addItem(axe);
        room3.addItem(key);
        room4.addItem(shield);
        room5.addItem(sword);
    }
}