public class Item {
   private String itemType;
   private boolean isEquipped;
   private boolean isWeapon;
   private final String[] itemTypes = {
            "RUSTY SWORD",
            "HEALING POTION",
            "TORCH",
            "ANCIENT SCROLL",
            "LEATHER ARMOR",
            "SILVER KEY",
            "MAGIC AMULET",
            "GOBLIN DAGGER",
            "SPELLBOOK OF FIRE",
            "BAG OF GOLD COINS",
            "MYSTERIOUS RUNE STONE",
            "SKELETON BONE",
            "CURSED RING",
            "POTION OF INVISIBILITY",
            "IRON SHIELD",
            "DRAGON EGG",
            "TRAP DISARMING KIT",
            "CRYSTAL ORB",
            "VENOMOUS DAGGER",
            "TATTERRED MAP"
        };

   public Item() {
      // TODO: Pick a random item type from itemTypes
      itemType = itemTypes[(int)(Math.random() * 20)];
      if (itemType == "RUSTY SWORD") {
         isWeapon = true;
      }
      else if (itemType == "HEALING POTION") {
         isWeapon = false;
      }
      else if (itemType == "TORCH") {
         isWeapon = true;
      }
      else if (itemType == "SILVER KEY") {
         isWeapon = false;
      }
      else if (itemType == "MAGIC AMULET") {
         isWeapon = true;
      }
      else if (itemType == "GOBLIN DAGGER") {
         isWeapon = true;
      }
      else if (itemType == "SPELLBOOK OF FIRE") {
         isWeapon = true;
      }
      else if (itemType == "BAG OF GOLD COINS") {
         isWeapon = false;
      }
      else if (itemType == "MYSTERIOUS RUNE STONE") {
         isWeapon = true;
      }
      else if (itemType == "SKELETON BONE") {
         isWeapon = true;
      }
      else if (itemType == "CURSED RING") {
         isWeapon = false;
      }
      else if (itemType == "POTION OF INVISIBILITY") {
         isWeapon = false;
      }
      else if (itemType == "IRON SHIELD") {
         isWeapon = false;
      }
      else if (itemType == "DRAGON EGG") {
         isWeapon = false;
      }
      else if (itemType == "TRAP DISARMING KIT") {
         isWeapon = false;
      }
      else if (itemType == "CRYSTAL ORB") {
         isWeapon = false;
      }
      else if (itemType == "VENOMOUS DAGGER") {
         isWeapon = true;
      }
      else if (itemType == "TATTERRED MAP") {
         isWeapon = false;
      }
      else if (itemType == "ANCIENT SCROLL") {
         isWeapon = true;
      }
      else if (itemType == "LEATHER ARMOR") {
         isWeapon = false;
      }
      else {
         isWeapon = false;
      }
   }
   
   public String getItemType() {
      return this.itemType;
   }
   public boolean weapon() {
      return isWeapon;
   }
   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return "Item: " + itemType;
   }
}