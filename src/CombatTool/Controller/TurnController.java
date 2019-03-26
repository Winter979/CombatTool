/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 02:31:20
* @Last Modified: 2017-10-12 18:46:21
* @Purpose:    Controller that interacts with the Turn UI.
*/

package CombatTool.Controller;

import CombatTool.Model.Abilities.Ability;
import CombatTool.Model.Characters.Characters;
import CombatTool.Model.Characters.Player;
import CombatTool.View.UI_Panel;
import CombatTool.View.UI_TurnMenu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TurnController implements UI_Controller
{
   private GameController controller;        //The main controller used to change UI and get characters
   private UI_TurnMenu turnMenu;             //The UI that interacts directly with this controller

   private LinkedList<Characters> turnOrder; //The turn order that the characters take
   private Characters curCharacter;          //The current character who is taking its tun

   private Iterator<Characters> iter;        //The iterator used to iterate through the turnOrder

   public TurnController(GameController controller)
   {
      this.controller = controller;
   }

   @Override
   public void setUI(UI_Panel panel)
   {
      this.turnMenu = (UI_TurnMenu) panel;
   }

   @Override
   public void start()
   {
      /** Creat the turn order */
      setTurnOrder(controller.getLCharacters());

      /** Start iterating through the turns */
      iter = turnOrder.iterator();
      nextTurn();
   }

   public void nextTurn()
   {
      /** Go to the next character */
      if(iter.hasNext())
      {
         curCharacter = iter.next();
         /** Reset the UI to show the new characters info */
         turnMenu.resetUI(curCharacter);
      }
      else
      {
         //All Turns are done.
         controller.toRoundUI();
      }
   }

   /** Change UI back to show Round Menu */
   public void endRound()
   {
      controller.toRoundUI();
   }

   /** Create the turn order from all characters */
   public void setTurnOrder(List<Characters> characters)
   {
      //Reset the list
      turnOrder = new LinkedList<>();
      
      /*characters.forEach((cha) -> {
         if(cha instanceof Player )
         {
            //Players go first in combat
            turnOrder.addFirst(cha);
         }
         else //cha is a NonPlayer 
         {
            //Non players go last in combat
            turnOrder.addLast(cha);
         }
      });*/

      for (Characters cha : characters) {
         if(cha instanceof Player )
         {
            //Players go first in combat
            turnOrder.addFirst(cha);
         }
         else //cha is a NonPlayer 
         {
            //Non players go last in combat
            turnOrder.addLast(cha);
         }
      }
   }

   /** Setup the ability list */
   public JList setUpAbility(Characters character)
   {
      JList<Ability> abilityList;

      DefaultListModel<Ability> listModel = new DefaultListModel<>();

      /** Add all abilities to the list */
      /*character.getAbilities().forEach((ability) -> {
         listModel.addElement(ability);
      });*/

      for (Ability ability : character.getAbilities()) {
         listModel.addElement(ability);
      }

      abilityList = new JList<>(listModel);

      /** All a listener to the list */
      addSelectionListener(abilityList);

      /** Ensure that only 1 abilty can be selected */
      abilityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      abilityList.setSelectedIndex(0);
      
      return abilityList;
   }

   /** Run the targeting System to get all targets */
   public JList setUpTargets(TargetSystem target)
   {
      return target.setTargets(curCharacter);
   }

   /** Use the affect of an ability on all selected targets */
   public void useAbility(Ability ability, List<Characters> targets)
   {
      int value = ability.activate();
      
      /** Affect all targets */
      /*targets.forEach((character) -> {
         character.affect(value);

         /** If the character is dead the tell the current team to get kill Heal */
         /*if(character.getCurHP() == 0)
         {*/
            /*Trigger a team kill for the current characters team*/
            /*curCharacter.getTeam().teamKill();
         } 
      });*/

      for (Characters character : targets) {
         character.affect(value);

         /** If the character is dead the tell the current team to get kill Heal */
         if(character.getCurHP() == 0)
         {
            /*Trigger a team kill for the current characters team*/
            curCharacter.getTeam().teamKill();
         } 
      }
  
      /** Modify the GUI to show new health */
      turnMenu.abilityUsed();
   }

   public Characters getCharacter()
   {
      return curCharacter;
   }

   /** Add listener so when an ability is selected the targets are generated */
   public void addSelectionListener(final JList list)
   {
      /*ListSelectionListener listSelectionListener = (ListSelectionEvent listSelectionEvent) -> {
         turnMenu.showTargets(((Ability) list.getSelectedValue()).getTarget());
      };*/

      ListSelectionListener listSelectionListener = new ListSelectionListener()
      {
         @Override
         public void valueChanged(ListSelectionEvent e)
         {
            turnMenu.showTargets(((Ability) list.getSelectedValue()).getTarget());
         }
      };

      list.addListSelectionListener(listSelectionListener);
   }
}
