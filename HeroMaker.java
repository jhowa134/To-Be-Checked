import java.util.Random;
import java.util.Scanner;

class Battle{
   //Make an array the displays where each of the elements is a character, with the one currently active in capital letters(m,r,w,M,R,W), 
   //as well as enemies, obstacles, and a way to interact with the hero classes move and attack.
}

class Character{
   //A character inhabits a battle array, all methods for character are related to movement in the array
   
}

class Hero extends Character{
   boolean ally = true;
   String name;
   String role;
   int attack;
   int spell;
   int mSlots;
   int cSlots;
   double range;
   int maxHealth;
   double curHealth;
   double regen;
   int def;
   int xp;
   int level = 1;
   int speed;
   
   public Hero(String n){name = n;}  //Dont directly call this ever, unless bad 
   
   String getName(){return name;}
   
   void stats(){
      System.out.println(""+name+"'s Stats ("+role+") :");
      System.out.println("Attack damage: "+attack+"\n"+"Spell Power: "+spell+"\n"+"Spell slots: " + cSlots+"/"+mSlots+"\n"+"Range: "+range+"\n"+"Health: "+ curHealth+"/"+maxHealth+"\n"+"Defense: " +def+"\n"+"XP needed for next level: " +((level*100)-xp)+"\n");
      // put the prints for all the things   
   }
   
   boolean isAlly(){return ally;}
   
   int getDmg(){
      Random r = new Random();
      int ret = r.nextInt(8)+attack;
      System.out.println(name+" attacked for "+ret+" damage");
      return ret;
   }
   
   int hurt(int ouch){
      if(ouch-def <=1){
         curHealth--;
         System.out.println(name+" took a measly 1 damage. HP:"+curHealth+"/"+maxHealth);
         return 1;
      }
      else{
         ouch = ouch-def;
         curHealth-=ouch;
         System.out.println(name+" took "+ouch+ " damage. HP:"+curHealth+"/"+maxHealth);
         return ouch;
      }  
   }
   
}

class Mage extends Hero{
   
   //Build the growth rates for when the hero levels up
   int sG = 4;
   double raG = 0.25;
   int hG = 3;
   double reG = 0.4;
   int defG = 1;  
   
   public Mage(String n, int x){
      super(n);
      xp = x;
      
      role = "Mage";
      attack = 1;
      spell = 6;
      mSlots = 3;
      cSlots = mSlots;
      range = 3;
      maxHealth = 10;  
      regen = 0.6;
      def = 1;
      speed = 2;
      
      while(xp > (level*100)){
         level++;
         xp = xp -(level*100);     
      }
      
      
      //Level up the character based on how many times they have leveled up
      for(int i = 1; i<level; i++){
         spell+=sG;
         range+=raG;
         maxHealth+=hG;
         regen+=reG;
         mSlots++;
         cSlots++;
      }      
      
      curHealth = maxHealth;   
   }
   
   void addXp(int add){
      xp+=add;
      System.out.println(""+name+" earned "+add+" experience!");
      
      while(xp >= (level*100)){
         xp = xp -(level*100);
         level++;
         
         spell+=sG;
         range+=raG;
         maxHealth+=hG;
         regen+=reG;
         curHealth+=hG;
         mSlots++;
         cSlots++;
         
         System.out.println(""+name+" leveled up to level "+level+"!"+"\n");      
      }
      
      
      
      //SPELLS
      
      
   }
}

class Ranger extends Hero{
   
   //Build the growth rates for when the hero levels up
   int aG = 3;
   int sG = 2;
   double raG = 0.5;
   int hG = 5;
   double reG = 0.6;
   int dG = 1;  
   
   public Ranger(String n, int x){
      super(n);
      xp = x;
      
      role = "Ranger";
      attack = 4;
      spell = 2;
      mSlots = 2;
      cSlots = mSlots;
      range = 3;
      maxHealth = 12;  
      regen = 0.6;
      def = 1;
      speed = 3;
      
      while(xp > (level*100)){
         level++;
         xp = xp -(level*100);     
      }
      
      
      //Level up the character based on how many times they have leveled up
      for(int i = 1; i<level; i++){
         attack+=aG;
         spell+=sG;
         range+=raG;
         maxHealth+=hG;
         def+=dG;
         regen+=reG;
         mSlots++;
         cSlots++;
      }      
      
      curHealth = maxHealth;   
   }
   
   void addXp(int add){
      xp+=add;
      System.out.println(""+name+" earned "+add+" experience!");
      
      while(xp >= (level*100)){
         xp = xp -(level*100);
         level++;
         
         attack+=aG;
         spell+=sG;
         range+=raG;
         maxHealth+=hG;
         def+=dG;
         regen+=reG;
         curHealth+=hG;
         mSlots++;
         cSlots++;
         
         System.out.println(""+name+" leveled up to level "+level+"!"+"\n");      
      } 
   }
   
   
   
   //Spells
   
   
}


class Warrior extends Hero{
   
   int aG = 4;
   int hG = 7;
   int dG = 2;
   double reG = .8;
   
     
   public Warrior(String n, int x){
      super(n);
      xp = x;
      
      role = "Warrior";
      attack = 5;
      mSlots = 2;
      cSlots = mSlots;
      range = 2;
      maxHealth = 20;  
      regen = 1.2;
      def = 2;
      speed = 2;
      
      while(xp > (level*100)){
         level++;
         xp = xp -(level*100);     
      }

      for(int i = 1; i<level; i++){
         attack+=aG;
         maxHealth+=hG;
         regen+=reG;
         def+=dG;
         mSlots++;
         cSlots++;
      }      
      
      curHealth = maxHealth;   
   
   }
   
   void addXp(int add){
      xp+=add;
      System.out.println(""+name+" earned "+add+" experience!");
      
      while(xp >= (level*100)){
         xp = xp -(level*100);
         level++;
         
         maxHealth+=hG;
         regen+=reG;
         curHealth+=hG;
         def+=dG;
         attack+=aG;
         mSlots++;
         cSlots++;
         
         System.out.println(""+name+" leveled up to level "+level+"!"+"\n");      
      }
   }
   
   
   //SPELLS
   
}

class Enemy extends Character{
   boolean ally = false;
   String name;
   int attack;
   int spell;
   int mSlots;
   int cSlots;
   double range;
   int maxHealth;
   double curHealth;
   double regen;
   int def;
   int speed;
   
   Random r = new Random();
   
   
   
   boolean isAlly(){return ally;}
}

class Consumable{
   
}

class Healing extends Consumable{

}

class Damage extends Consumable{

}



class Inventory{
   int money = 10;
   
   //Array holding different consumable objects, up to 15.

   void changeMoney(int x){money+=x;}
   
   boolean checkQuest(Quest q){ //The only time you should ever call q.check, and should be called when in quest board.
      int carrier = q.check();
      if(carrier!=0){
         money+=carrier;
         return true;
      }
      else{return false;}      
   }   
}

class Quest{
   int current;
   int needed;
   String description;
   int reward;
   boolean active = true;
   
   public Quest(int c, int n, String d, int r){
        current = c; needed = n; description = d; reward = r;
   }
   
   void progress(int progress){current+=progress;}
   //Need help figuring out how to do logic here....
   //Theres the issue of wanting to have a specific quest for each type of enemy, but 
   //i cant call koboldQuest.progress(1); in the kobold subclass, because that quest doesnt exist untill the main.
   
   int check(){  
      if(current>=needed & active){
         active = false;
         return reward;
      }   
      else{return 0;}
   }     
}

public class HeroMaker{
   public static void main(String[] args){
      Scanner S = new Scanner(System.in);
      
      System.out.println("There once was a party of 3 adventureres. ");
      System.out.print("The first, a mighty combat mage, whos name was ");
      String nameM = S.nextLine();
      System.out.println("who could torch any foes that stand in their way.\n");
      System.out.print("The second, the cunning and resourceful ranger ");
      String nameR = S.nextLine();
      System.out.println("who always had a trick up their sleave.\n");
      System.out.print("And third, the powerfull and couragous warrior, ");
      String nameW = S.nextLine();
      System.out.println("who swore to protect all innocence.\n");
   
   
      Inventory p = new Inventory();
      Mage m = new Mage(nameM, 0); 
      Ranger r = new Ranger(nameR,0);
      Warrior w = new Warrior(nameW, 0);
     
     
      //Tests 
      m.stats();
      r.stats();
      w.stats();
      
      m.getDmg();
      r.getDmg();
      w.getDmg();
            
      m.addXp(160);
      r.addXp(160);
      w.addXp(160);
      
      m.stats();
      r.stats();
      w.stats(); 
      
      m.getDmg();
      r.getDmg();
      w.getDmg();
      
      m.addXp(180);
      r.addXp(180);
      w.addXp(160);  
      
      m.stats();
      r.stats();
      w.stats();
      
      m.getDmg();
      r.getDmg();
      w.getDmg();
       
      m.hurt(5);
      m.hurt(4);
      r.hurt(8);
      r.hurt(1);
      w.hurt(9);
      w.hurt(9);
      
      
      
      
      //End of tests
      
while(true){
   
   //TOWN  All of the actuall core of the game takes place here, in this mega loop, where you keep taking the user input for the entire rest of the code.
   //Has options to do adventure things, like party, rest, shop, or adventure   
      //Adventure            
         //Explore, A chance of any of the following happening, with some adventures having a requirement to set a quest counter to be true. 
            //Chance of traps, 
            
            //COMBAT
               //Make a while loop that cycles an array of all the combatants, most of 10 people, with any that are not active being a 0, which is ignored in turn order. 
               //Order is always ranger, then mage, then warrior, then enemies. Establish a variable that keeps track of the current target.
               //If the target is friendly, ask user for an input of what action to perform, re asking if it is not one of the expected actions.
               //If target is hostile, call the aiAct() method.
         
         //Rest
            //Restore Spell Slots
      //Shop
         //Display items available in each shop
      //Quests
         //Check
            //Checks the quest, and if true, tell them they earned the money, and if false, give them info on the current quest
      //Party
         //Grant well rested buff
         //Remove some gold
         //Chance for cool events
      //Sleep
         //Deviate prices in the shop slightly compared to the previous day.
         //Restore Spell Slots
         //Remove some gold from pool    
         
   }     
   }//Ignore this, its just the core of the loop being pushed in 
}