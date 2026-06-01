import java.util.ArrayList;

public class Room {
   private ArrayList<Item> itemsInRoom;
   private ArrayList<Monster> monstersInRoom;
   private String description;
   private int totalNumItems;
   private int totalNumMonsters;
   private final int maxNumberOfMonsters = 2;
   private final int maxNumberOfItems = 2;
   
   public Room() {
      // TODO: Generate a random number of monsters and items between 1 and max (inclusive)
      int numMonsters = (int)((Math.random() * maxNumberOfMonsters) + 1);
      int numItems = (int)((Math.random() * maxNumberOfItems) + 1);
      totalNumItems = numItems;
      totalNumMonsters = numMonsters;
      // TODO: Create the ArrayLists to hold the Items and Monsters in the Room and populate them with Monsters and Items
      itemsInRoom = new ArrayList<Item>();
      int i = 0;
      while (i < numItems) {
         itemsInRoom.add(new Item());
         i += 1;
      }
      monstersInRoom = new ArrayList<Monster>();
      int j = 0;
      while (j < numMonsters) {
         monstersInRoom.add(new Monster());
         j += 1;
      }
      description = randomDescription();
   }
   
   public String toString() {
      String returnString = description + "\nItems in room: ";
      int i = 0;
      while (i < itemsInRoom.size()) {
         returnString += "\n" + itemsInRoom.get(i);
         i += 1;
      }
      returnString += "\n" + "Monsters in room:";
      int j = 0;
      while (j < monstersInRoom.size()) {
         returnString += "\n" + monstersInRoom.get(j);
         j += 1;
      }
      // TODO: build a returnString that nicely formats the Monsters and Items in the Room
      // HINT: Use a for-each loop to go through the ArrayLists
      return returnString;
   }
   public Item getItems(int i) {
      return itemsInRoom.get(i);
   }
   public int getNumItems() {
      return totalNumItems;
   }
   public int getNumMonsters() {
      return totalNumMonsters;
   }
   public void removeItem(Item item) {
      int i = 0;
      while (i < itemsInRoom.size()) {
         if (item.getItemType().equals(itemsInRoom.get(i).getItemType())) {
            itemsInRoom.remove(i);
         }
         i += 1;
      }
   }
   public void removeMonster(Monster monster) {
      int i = 0;
      while (i < monstersInRoom.size()) {
         if (monster.getMonsterType().equals(monstersInRoom.get(i).getMonsterType())) {
            monstersInRoom.remove(i);
         }
         i += 1;
      }
   }
   public void addItem(Item item) {
      itemsInRoom.add(item);
   }
   public Monster getMonster(int i) {
      return monstersInRoom.get(i);
   }
   public String randomDescription() {
      int randomNum = (int)(Math.random() * 10);
      if (randomNum == 0) {
         return "Description 1";
      }
      if (randomNum == 1) {
         return "Description 2";
      }
      if (randomNum == 2) {
         return "Description 3";
      }
      if (randomNum == 3) {
         return "Description 4";
      }
      if (randomNum == 4) {
         return "Description 5";
      }
      if (randomNum == 5) {
         return "Description 6";
      }
      if (randomNum == 6) {
         return "Description 7";
      }
      if (randomNum == 7) {
         return "Description 8";
      }
      if (randomNum == 8) {
         return "Description 9";
      }
      if (randomNum == 9) {
         return "Description 10";
      }
      else {
         return null;
      }
   }



   }