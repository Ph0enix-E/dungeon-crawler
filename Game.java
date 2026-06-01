import java.util.Scanner;

public class Game {   
   public static void main(String[] args) {
      boolean exitGame = false;
      Game game = new Game();
      Map dungeonMap = new Map(5, 6);
            
      Scanner scanner = new Scanner(System.in);
      
      // TODO: Create a Map which populates each element of the grid with a Room
      // that contains a random assortment of Monsters and Items
      
      // TODO: Create a Player at a random location in the Map
      // HINT: Generate random row/column values using Math.random()
      // and pass them into the Player constructor
      int randomX = (int)(Math.random() * dungeonMap.getNumRows());
      int randomY = (int)(Math.random() * dungeonMap.getNumCols());
      Player player = new Player(100, "Hero", randomX, randomY);
            
      while (exitGame != true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().toUpperCase();
            boolean invisible = false;
                        
            if (input.equals("EXIT")) {
                System.out.println("Exiting game. Goodbye!");
                exitGame = true;
            }
            else if (input.equals("LOOK") || input.equals("SEARCH")) {
               System.out.println(player.look(dungeonMap));
            }
            // TODO: get the player movement working correctly. It should NOT let the player
            // move beyond the boundaries of the map, and provide the user with descriptions
            // of what is happening. You'll have to change the if/else/if statements here to 
            // do this.
            else if (input.startsWith("MOVE ")) {
               String direction = input.substring(5);
               if (direction.equals("UP") && player.getCurrentY() != dungeonMap.getNumCols() - 1) {
                  player.moveTo(player.getCurrentX(), player.getCurrentY() + 1);
               } else if (direction.equals("DOWN") && player.getCurrentY() != 0) {
                  player.moveTo(player.getCurrentX(), player.getCurrentY() - 1);
               } else if (direction.equals("LEFT") && player.getCurrentX() != 0) {
                  player.moveTo(player.getCurrentX() - 1, player.getCurrentY());    
               } else if (direction.equals("RIGHT") && player.getCurrentX() != dungeonMap.getNumRows() - 1) {
                  player.moveTo(player.getCurrentX() + 1, player.getCurrentY());
               } else {
                  System.out.println("You're trying to move in an invalid direction. Please choose UP, DOWN, LEFT or RIGHT");
               }
               System.out.println("Position: (" + player.getCurrentX() + ", " + player.getCurrentY() + ")");
            }
            else if (input.startsWith("TAKE ")) {
               Room currentRoom = dungeonMap.getRoom(player.getCurrentX(), player.getCurrentY());
               Item item = currentRoom.getItems(0);
               if (input.substring(5).equals(item.getItemType())) {
                  player.addItemToInventory(item);
                  currentRoom.removeItem(item);
                  String itemType = item.getItemType();
                  System.out.println("Added " + itemType + " to inventory");
               }
               else if (currentRoom.getNumItems() == 2) {
                  item = currentRoom.getItems(1);
                  if (input.substring(5).equals(item.getItemType())) {
                     player.addItemToInventory(item);
                     currentRoom.removeItem(item);
                     String itemType = item.getItemType();
                     System.out.println("Added " + itemType + " to inventory");
                  }
               }
               else {
                  System.out.println("Item not found");
               }
            }
            else if (input.startsWith("DROP ")) {
               if (player.hasItem(input.substring(5)) == true) {
                  String itemName = input.substring(5);
                  Item item = player.getItem(itemName);
                  Room currentRoom = dungeonMap.getRoom(player.getCurrentX(), player.getCurrentY());
                  player.removeItemFromInventory(item);
                  currentRoom.addItem(item);
                  System.out.println("Dropped: " + itemName);
               }
               else {
                  System.out.println("Item not found in inventory");
               }
            }
            else if (input.startsWith("EQUIP ")) {
               String itemName = input.substring(6);
               if (player.hasItem(itemName) == true) {
                  Item item = player.getItem(itemName);
                  if (item.weapon() == true) {
                     System.out.println(itemName + " is equipped");
                     player.setDamageModifier(itemName);
                  }
                  else {
                     System.out.println(itemName + " isn't a weapon");
                  }
               }
               else {
                  System.out.println("Item not found in inventory");
               }
            }
            else if (input.startsWith("FIGHT ")) {
               String monsterName = input.substring(6);
               Monster monster = dungeonMap.getRoom(player.getCurrentX(), player.getCurrentY()).getMonster(0);
               Room currentRoom = dungeonMap.getRoom(player.getCurrentX(), player.getCurrentY());
               if (monsterName.equals(monster.getMonsterType())) {
                  int monsterHealth = monster.getHealth();
                  int damage = 0;
                  while (monsterHealth > 0) {
                     damage = (int)(Math.random() * 25 * player.getDamageModifier());
                     monsterHealth -= damage;
                     monster.takeDamage(damage);
                     if (player.getHealth() > 0) {
                        System.out.println(monsterName + " takes " + damage + " damage");
                     }
                     if (monsterHealth > 0) {
                        int playerDamage = 0;
                        if (invisible == true) {
                           playerDamage = monster.getHealth() / 8;
                        }
                        else {
                           playerDamage = monster.getHealth() / 4;
                        }
                        player.takeDamage(playerDamage);
                        if (player.getHealth() > 0) {
                           System.out.println("You take " + playerDamage + " damage");
                        }
                     }
                  }
                  if (player.getHealth() > 0) {
                     System.out.println("Monster Defeated\nCurrent Health: " + player.getHealth());
                     currentRoom.removeMonster(monster);
                     invisible = false;
                     if (monsterName.equals("ANCIENT DRAGON")) {
                        System.out.println("You Win the Game");
                        System.out.println("GOLD: " + player.getGold());
                        exitGame = true;
                     }
                  }
                  else {
                     System.out.println("You Died");
                     System.out.println("Exiting game. Goodbye!");
                     exitGame = true;
                  }
               }
               else if (currentRoom.getNumMonsters() == 2) {
                  monster = currentRoom.getMonster(1);
                  if (monsterName.equals(monster.getMonsterType())) {
                     int monsterHealth = monster.getHealth();
                     int damage = 0;
                     while (monsterHealth > 0) {
                        damage = (int)(Math.random() * 25 * player.getDamageModifier());
                        monsterHealth -= damage;
                        monster.takeDamage(damage);
                        if (player.getHealth() > 0) {
                           System.out.println(monsterName + " takes " + damage + " damage");
                        }
                        if (monsterHealth > 0) {
                           int playerDamage = 0;
                           if (invisible == true) {
                              playerDamage = monster.getHealth() / 8;
                           }
                          else {
                             playerDamage = monster.getHealth() / 4;
                          }
                           player.takeDamage(playerDamage);
                           if (player.getHealth() > 0) {
                              System.out.println("You take " + playerDamage + " damage");
                           }
                        }
                     }
                     if (player.getHealth() > 0) {
                        System.out.println("Monster Defeated\nCurrent Health: " + player.getHealth());
                        currentRoom.removeMonster(monster);
                        invisible = false;
                        if (monsterName.equals("ANCIENT DRAGON")) {
                           System.out.println("You Win the Game");
                           System.out.println("GOLD: " + player.getGold());
                           exitGame = true;
                        }
                     }
                     else {
                        System.out.println("You Died");
                        System.out.println("Exiting game. Goodbye!");
                        exitGame = true;
                     }
                  } 
                  else {
                     System.out.println("Monster Not Found");
                  }
               }
               else {
                  System.out.println("Monster Not Found");
               }
            }
            else if (input.startsWith("USE ")) {
               String itemName = input.substring(4);
               if (player.hasItem(itemName) == true) {
                  if (itemName.equals("HEALING POTION")) {
                     player.heal();
                     System.out.println("Current Health: " + player.getHealth());
                     Item potion = player.getItem("HEALING POTION");
                     player.removeItemFromInventory(potion);
                  }
                  else if (itemName.equals("SILVER KEY")) {
                     int gold = (int)((Math.random() * 50) + 5);
                     System.out.println("SILVER KEY is worth " + gold + " gold");
                     player.addGold(gold);
                     System.out.println("GOLD: " + player.getGold());
                     Item key = player.getItem("SILVER KEY");
                     player.removeItemFromInventory(key);
                  }
                  else if (itemName.equals("BAG OF GOLD COINS")) {
                     int gold = (int)((Math.random() * 100) + 100);
                     player.addGold(gold);
                     System.out.println("GOLD: " + player.getGold());
                     Item bagCoins = player.getItem("BAG OF GOLD COINS");
                     player.removeItemFromInventory(bagCoins);
                  }
                  else if (itemName.equals("CURSED RING")) {
                     player.takeDamage(25);
                     System.out.println("Current Health: " + player.getHealth());
                     if (player.getHealth() <= 0) {
                        System.out.println("Exiting game. Goodbye!");
                        exitGame = true;
                     }
                  }
                  else if (itemName.equals("POTION OF INVISIBILITY")) {
                     invisible = true;
                     System.out.println("You are invisible");
                     Item potion = player.getItem("POTION OF INVISIBILITY");
                     player.removeItemFromInventory(potion);
                  }
                  else if (itemName.equals("TATTERRED MAP")) {
                     System.out.println("Position: (" + player.getCurrentX() + ", " + player.getCurrentY() + ")");
                  }
                  else {
                     System.out.println("Item has no special use");
                  }
               }
               else {
                  System.out.println("Item not found");
               }
            }
         // TODO: display a message to the user telling them their current coordinates every time they move
       }
   }
}