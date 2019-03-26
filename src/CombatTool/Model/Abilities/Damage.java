/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:32
* @Last Modified: 2017-10-12 11:44:58
* @File Name:  Damage
* @Purpose:    An ability that will be used to cause damage.
*/
 
package CombatTool.Model.Abilities;

import CombatTool.Controller.TargetSystem;
import CombatTool.Exceptions.InvalidAbilityException;

public class Damage extends Ability
{
   public Damage(String name, int baseAmt, int diceAmt, int sides, TargetSystem target) throws InvalidAbilityException
   {
      // Construct an ability as normal
      super(name, baseAmt, diceAmt, sides, target);
   }

   /**
    * @return A negative value to represent health decrease
    */
   @Override
   public int activate()
   {
      return -super.activate();
   }
}