/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:44:06
* @Last Modified: 2017-10-12 18:43:46
* @File Name:  SingleHeal
* @Purpose:    Generate a list for all potential targets for healing
*/
 
package CombatTool.Controller;

import CombatTool.Model.Characters.Characters;
import CombatTool.Model.Characters.Team;
import java.io.Serializable;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class SingleHeal implements TargetSystem, Serializable
{
   public SingleHeal(){}

   @Override
   public String toString()
   {
      return "Single Target Heal";
   }

   @Override
   public JList setTargets(Characters character) 
   {
      JList<Characters> targets;
      Team allies = character.getTeam();
      DefaultListModel<Characters> listModel = new DefaultListModel<>();

      /** Add all allies to the possible target list */
      /*allies.getAllies().forEach((cha) -> {
         listModel.addElement(cha);
      });*/
      
      for (Characters cha: allies.getAllies()) {
         listModel.addElement(cha);
      }

      targets = new JList<>(listModel);

      /** Ensure that only 1 target is ever selected */
      targets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      targets.setSelectedIndex(0);

      return targets;

   }

   

}