/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:37
* @Last Modified: 2017-10-11 22:13:57
* @File Name:  SaveState
* @Purpose:    A object that stores all the important information to be saved for serialization
*/
 
package CombatTool.Model;

import CombatTool.Model.Abilities.Ability;
import CombatTool.Model.Characters.TeamManager;
import java.io.Serializable;
import java.util.Map;

public class SaveState implements Serializable
{
   TeamManager characters = null;
   Map<String, Ability> abilities = null;

   public SaveState(){}

   public void setCharacters(TeamManager characters)
   {
      this.characters = characters;
   }

   public void setAbilities(Map<String, Ability> abilities)
   {
      this.abilities = abilities;
   }

   public TeamManager getCharacters()
   {

      return characters;
   }

   public Map<String, Ability> getAbilities()
   {
      return abilities;
   }
}
   