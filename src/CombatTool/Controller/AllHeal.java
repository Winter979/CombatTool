/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 21:31:23
* @Last Modified: 2017-10-12 18:46:47
* @File Name:  AllHeal
* @Purpose:    A targeting system that targets all allies
*/
 
package CombatTool.Controller;

import CombatTool.Model.Characters.Characters;
import CombatTool.Model.Characters.Team;
import java.io.Serializable;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AllHeal implements TargetSystem, Serializable
{

   public AllHeal(){}

   @Override
   public String toString()
   {
      return "Multi Target Heal";
   }

   @Override
   public JList setTargets(Characters character) 
   {
      JList<Characters> targets;
      Team allies = character.getTeam();
      DefaultListModel<Characters> listModel = new DefaultListModel<>();

      //Add all allies to the target list.
      /*allies.getAllies().forEach((cha) -> {
         listModel.addElement(cha);
      });*/
    
      for (Characters cha : allies.getAllies()) {
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