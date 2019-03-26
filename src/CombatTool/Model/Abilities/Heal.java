/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:32
* @Last Modified: 2017-10-12 11:44:53
* @File Name:  Heal
* @Purpose:    An ability that will be used to heal health
*/
 
package CombatTool.Model.Abilities;

import CombatTool.Controller.TargetSystem;
import CombatTool.Exceptions.InvalidAbilityException;

public class Heal extends Ability
{
   public Heal(String name, int baseAmt, int diceAmt, int sides, TargetSystem target) throws InvalidAbilityException
   {
      /** Constuct an ability as normal */
      super(name, baseAmt, diceAmt, sides, target);
   }

   /**
    * @return A positive balue to represent health increase
    */
   @Override
   public int activate()
   {
      return +super.activate();
   }
}