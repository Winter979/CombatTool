/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 21:21:05
* @Last Modified: 2017-10-12 18:46:06
* @File Name:  AllDamage
* @Purpose:    A targeting System that targets all enemies
*/
 
package CombatTool.Controller;

import CombatTool.Model.Characters.Characters;
import java.io.Serializable;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AllDamage implements TargetSystem, Serializable
{
   
   public AllDamage(){}
   
   @Override
   public String toString()
   {
      return "Multi Target Damage";
   }

   @Override
   public JList setTargets(Characters character) 
   {
      JList<Characters> targets;
      List<Characters> enemies = character.getTeam().getEnemies();
      DefaultListModel<Characters> listModel = new DefaultListModel<>();

      //Add all enemies that the team has to the target list.
      /*enemies.forEach((cha) -> {
         listModel.addElement(cha);
      });*/
      
      for (Characters cha : enemies) {
        listModel.addElement(cha);
      }

      targets = new JList<>(listModel);

      targets.setSelectionInterval(0, targets.getModel().getSize()-1);

      enforseAllSelection(targets);

      return targets;
   }

   /**
    * Ensures that all possible targets are always selected as this targeting system
    *    automatically targets all.
    * @param list The list to be listened to. 
    */
   public void enforseAllSelection(final JList list)
   {
      ListSelectionListener listSelectionListener = new ListSelectionListener() 
      {
         /**
          * When the list has been modifed in anyway, reselct everything
          */
         @Override
         public void valueChanged(ListSelectionEvent listSelectionEvent) 
         {
            list.setSelectionInterval(0, list.getModel().getSize()-1);
         }
      };

      list.addListSelectionListener(listSelectionListener);
   }
}