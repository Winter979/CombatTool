/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:41:30
* @Last Modified: 2017-10-12 11:44:29
* @File Name:  Ability
* @Purpose:    An Ability that will affect other players through a targeting System
*/
 
package CombatTool.Model.Abilities;

import CombatTool.Exceptions.InvalidAbilityException;
import CombatTool.Controller.TargetSystem;
import java.io.Serializable;
import java.util.Random;

public abstract class Ability implements Serializable
{
   private static final int MINDICE = 1;     //The minimum amount of dice an ability can have (inclusive)
   private static final int MAXDICE = 10;    //The maximum amount of dice an ability can have (inclusive)

   private String name;          //The name of the ability (must be unique to other abilities)
   private int baseAmt;          //The base amount added to the affect total
   private int diceAmt;          //The amount of dice that will be used to add to the affect total
   private int sides;            //The 'n' number of sides the dice used will have
   private TargetSystem target;  //The type of targeting System that the ability will use to get targets

   private static final int[] validSides = {2,4,6,8,10,12,3};  //Valid sides amount for the diec
   private static final Random rand = new Random();            //The random number generator to simulate a dice roll

   /** Constuct an Ability object */
   public Ability(String name, int baseAmt, int diceAmt, int sides, TargetSystem target) throws InvalidAbilityException
   {
      this.name = name;

      /** Ensure positive base amount */
      if(baseAmt < 0)
         throw new InvalidAbilityException("Base Amount: " + baseAmt);
      this.baseAmt = baseAmt;

      //Have to have atleast 1 dice
      if(diceAmt < MINDICE || diceAmt > MAXDICE)
         throw new InvalidAbilityException("Dice Amount: " + diceAmt);
      this.diceAmt = diceAmt;

      setDice(sides);
      this.target = target;
   }

   private void setDice(int sides) throws InvalidAbilityException
   {
      //If more dice are added then this method will have to be changed
      if(sides != 3)
         if(validSides[sides/2-1] != sides)
            throw new InvalidAbilityException("Sides: " + sides);

      this.sides = sides;

   }

   public TargetSystem getTarget()  
   {
      return target;
   }

   /** Activate the ability and return the affecgt amount */
   public int activate()
   {  
      int affect = baseAmt;

      /** Roll the dice 'diceAmt' times */
      for (int ii = 0; ii < diceAmt; ii++) 
      {
         affect += rand.nextInt(sides)+1; //Add 1 since nextInt(4) will generate 0-3
      }

      return affect;
   }

   @Override
   public String toString()
   {
      return String.format("%s : %d + %dd%d %s", 
                           name, baseAmt, diceAmt, sides,target.toString());
   }
}