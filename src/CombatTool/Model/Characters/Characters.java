/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:37
* @Last Modified: 2017-10-11 22:15:59
* @File Name:  Characters
* @Purpose:    A Character object that is to be used in the game
*/
 
package CombatTool.Model.Characters;

import CombatTool.Exceptions.InvalidCharacterException;
import CombatTool.Model.Abilities.Ability;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class Characters implements Serializable
{
   protected static final int MINMAXHP = 20; //The minimum value a characters maxHP can be (inclusive)

   private String name;    //The Characters name 
   protected int maxHP;    //The max health of the character
   protected int curHP;    //The current health 0-maxHP (starts at max)
   private Team allies;    //The team that this characer is apart of and its allies
   private List<Ability> abilities; //The abilities that the Characters knows. (Must know atleast1)

   public abstract void killHeal();
   public abstract String getTeamName();
   
   protected Characters(String name, int maxHP, LinkedList<Ability> abilities) throws InvalidCharacterException
   {
      this.name = name;

      if(maxHP < MINMAXHP)
         throw new InvalidCharacterException("Max health has to be above: " + MINMAXHP);
      this.maxHP = maxHP;

      /*You start hax health*/
      curHP = maxHP;

      if(abilities.size()  == 0)
         throw new InvalidCharacterException("Character " + name + " cannot contain no abilities");

      this.abilities = abilities;
   }

   public String getName()
   {
      return name;
   }
   
   public void setTeam(Team team)
   {
      this.allies = team;
   }

   public Team getTeam()
   {
      return allies;
   }

   public int getCurHP()
   {
      return curHP;
   }

   public List<Ability> getAbilities()
   {
      return abilities;
   }

   /** Run an affect on the character */
   public void affect(int affect)
   {
      curHP += affect;

      /** HP as been modified. check it */
      checkHP();
   }

   /** Ensures that the current HP doesnt go above the maxHP or if it has hit 0 */
   protected void checkHP()
   {
      if(curHP > maxHP)
      {
         curHP = maxHP;
      }
      else if(curHP <= 0)
      {
         curHP = 0;
         /** Notify your team that you have died */
         allies.imDead(this);
      }
   }

   @Override
   public String toString()
   {
      return String.format("%-10s  %s",name, (curHP <= 0? "DEAD" : String.format("%d/%d HP", curHP, maxHP)));
   }
}