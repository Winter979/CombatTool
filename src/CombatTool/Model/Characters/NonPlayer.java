/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 11:08:50
* @Last Modified: 2017-10-12 11:41:12
* @File Name:  NonPlayer
* @Purpose:    A NonPlayer Character that the game has.
*/
 
package CombatTool.Model.Characters;

import CombatTool.Exceptions.InvalidCharacterException;
import CombatTool.Model.Abilities.Ability;
import java.util.LinkedList;

public class NonPlayer extends Characters
{
   /** The amount of health % to be gained on team kill */
   private static final double HEAL_AMT = 1.10;

   public NonPlayer(String name, int maxHP, LinkedList<Ability> abilities) throws InvalidCharacterException
   {
      super(name, maxHP, abilities);
   }

   /** Gain Health according to healAmt */
   @Override
   public void killHeal()
   {
      curHP += (int) Math.ceil(maxHP * HEAL_AMT);

      /** Check health to ensure it isnt above max */
      checkHP();
   }

   @Override
   public String toString()
   {
      return "NonPlayer: " + super.toString();
   }

   @Override
   public String getTeamName() {
      return "NonPlayers";
   }
}