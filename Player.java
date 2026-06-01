import java.util.ArrayList;

public class Player {
   private ArrayList<Item> inventory;
   private String playerName;
   private int health;
   private int gold;
   private int currentX;
   private int currentY;
   private int damageModifier;


   public Player(int health, String playerName, int startingX, int startingY) {
      // set the health and playerName to the passed parameters
      this.health = health;
      this.playerName = playerName;      
      
      // TODO: create the empty Inventory
      inventory = new ArrayList<Item>();
      // TODO: set the startingX and Y of the player
      this.currentX = startingX;
      this.currentY = startingY;
      damageModifier = 1;
      gold = 0;
   }

   public int getCurrentX() {
      return currentX;
   }
   public int getCurrentY() {
      return currentY;
   }
   public Item getItem(String itemName) {
      int i = 0;
      while (i < inventory.size()) {
         if (itemName.equals(inventory.get(i).getItemType())) {
            return inventory.get(i);
         }
         i += 1;
      }
      return null;
   }
   public void setDamageModifier(String itemName) {
      if (itemName.equals("RUSTY SWORD")) {
         damageModifier = 5;
      }
      else if (itemName.equals("TORCH")) {
         damageModifier = 4;
      }
      else if (itemName.equals("MAGIC AMULET")) {
         damageModifier = 7;
      }
      else if (itemName.equals("GOBLIN DAGGER")) {
         damageModifier = 3;
      }
      else if (itemName.equals("SPELLBOOK OF FIRE")) {
         damageModifier = 9;
      }
      else if (itemName.equals("MYSTERIOUS RUNE STONE")) {
         damageModifier = 10;
      }
      else if (itemName.equals("SKELETON BONE")) {
         damageModifier = 2;
      }
      else if (itemName.equals("VENOMOUS DAGGER")) {
         damageModifier = 6;
      }
      else if (itemName.equals("ANCIENT SCROLL")) {
         damageModifier = 8;
      }
      else {
         System.out.println("ERROR");
      }
   }
   public int getDamageModifier() {
      return damageModifier;
   }
   public void addItemToInventory(Item item) {
      // TODO: add an item to inventory
      inventory.add(item);
   }
   
   public Item removeItemFromInventory(Item item) {
      // TODO: remove an item to inventory. Return the Item so it can returned to the Room that it is in
      int i = 0;
      while (i < inventory.size()) {
         if (item == inventory.get(i)) {
            inventory.remove(i);
            return item;
         }
         i += 1;
      }
      return null;
   }
   
   
   public boolean hasItem(String itemName) {
      int i = 0;
      while (i < inventory.size()) {
         if (itemName.equals(inventory.get(i).getItemType())) {
            return true;
         }
         i += 1;
      }
      return false;
   }
   
   
   public String look(Map map) {
      // TODO: This method will take the player's current X and Y, and return the contents of the room
      // they are in with a descriptive String
      // HINT: Use map.getRoom(currentX, currentY) and call toString()
      return map.getRoom(currentX, currentY).toString();
   }
   public void moveTo(int x, int y) {
      // TODO: Update the Player's currentX and currentY values.
      currentX = x;
      currentY = y;
   }
   
   public Room getRoom(Map map) {
      // TODO: return the room object that the player is currently in, given the Map that was passed
      return map.getRoom(currentX, currentY);
   }
   public void takeDamage(int d) {
      health -= d;
   }
   public int getHealth() {
      return health;
   }
   public void heal() {
      health += 50;
   }
   public void addGold(int i) {
      gold += i;
   }
   public int getGold() {
      return gold;
   }

}