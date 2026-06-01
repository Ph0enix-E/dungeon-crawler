public class Monster {
private String monsterType;
private int monsterHealth;
   private final String[] monsterTypes = {
            "GOBLIN",
            "SKELETON WARRIOR",
            "ZOMBIE",
            "ORC",
            "DARK SORCERER",
            "GIANT SPIDER",
            "VAMPIRE BAT",
            "SLIME",
            "MIMIC",
            "LICH",
            "TROLL",
            "WEREWOLF",
            "GARGOYLE",
            "WRAITH",
            "MINOTAUR",
            "BASILISK",
            "DOPPELGANGER",
            "DEMON HOUND",
            "CAVE SERPENT",
            "ANCIENT DRAGON"
        };

   public Monster() {
      // TODO: Pick a random monster type from monsterTypes
      monsterType = monsterTypes[(int)(Math.random() * 20)];
      if (monsterType == "GOBLIN") {
         monsterHealth = 20;
      }
      else if (monsterType == "SKELETON WARRIOR") {
         monsterHealth = 100;
      }
      else if (monsterType == "ZOMBIE") {
         monsterHealth = 50;
      }
      else if (monsterType == "ORC") {
         monsterHealth = 80;
      }
      else if (monsterType == "DARK SORCERER") {
         monsterHealth = 40;
      }
      else if (monsterType == "GIANT BAT") {
         monsterHealth = 30;
      }
      else if (monsterType == "VAMPIRE BAT") {
         monsterHealth = 50;
      }
      else if (monsterType == "SLIME") {
         monsterHealth = 80;
      }
      else if (monsterType == "MIMIC") {
         monsterHealth = 100;
      }
      else if (monsterType == "LICH") {
         monsterHealth = 150;
      }
      else if (monsterType == "TROLL") {
         monsterHealth = 200;
      }
      else if (monsterType == "WEREWOLF") {
         monsterHealth = 130;
      }
      else if (monsterType == "GARGOYLE") {
         monsterHealth = 120;
      }
      else if (monsterType == "WRAITH") {
         monsterHealth = 100;
      }
      else if (monsterType == "MINOTAUR") {
         monsterHealth = 110;
      }
      else if (monsterType == "BASILISK") {
         monsterHealth = 150;
      }
      else if (monsterType == "DOPPELGANGER") {
         monsterHealth = 100;
      }
      else if (monsterType == "DEMON HOUND") {
         monsterHealth = 90;
      }
      else if (monsterType == "CAVE SPERPENT") {
         monsterHealth = 200;
      }
      else if (monsterType == "ANCIENT DRAGON") {
         monsterHealth = 500;
      }
      else {
         monsterHealth = 0;
      }
   }
   
   
   public String getMonsterType() {
      return this.monsterType;
   }
   public int getHealth() {
      return monsterHealth;
   }
   public void takeDamage(int d) {
      monsterHealth -= d;
   }
   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return "Monster: " + monsterType;
   }
}