/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:44:01
* @Last Modified: 2017-10-12 18:30:16
* @File Name:  SingleDamage
* @Purpose:    Generate a list for all potential targets for dealing damage to
*/
 
package CombatTool.Controller;

import CombatTool.Model.Characters.Characters;
import java.io.Serializable;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class SingleDamage implements TargetSystem, Serializable
{
   public SingleDamage(){}

   @Override
   public String toString()
   {
      return "Single Target Damage";
   }

   @Override
   public JList setTargets(Characters character) 
   {
      JList<Characters> targets;
      List<Characters> enemies = character.getTeam().getEnemies();
      DefaultListModel<Characters> listModel = new DefaultListModel<>();

      /** Add all enemies to the portential target list */
      /*enemies.forEach((cha) -> {
         listModel.addElement(cha);
      });*/
      
      for (Characters cha : enemies) {
         listModel.addElement(cha);
      }

      targets = new JList<>(listModel);

      /** Ensure that only one target is ever selected */
      targets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      targets.setSelectedIndex(0);

      return targets;
   }
}