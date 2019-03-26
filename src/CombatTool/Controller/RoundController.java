/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:47:58
* @Last Modified: 2017-10-12 18:47:15
* @Purpose:    Controller to interact with the RoundMenu UI
*/

package CombatTool.Controller;

import CombatTool.Model.Abilities.Ability;
import CombatTool.Model.Characters.Characters;
import CombatTool.Exceptions.GameSaveException;
import CombatTool.View.UI_Panel;
import CombatTool.View.UI_RoundMenu;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RoundController implements UI_Controller
{  
   private GameController controller;     //GameController used to change UI
   private UI_RoundMenu roundMenu = null; //UI that this controller interacts with

   private List<Characters> characters;   //List of characters in the game

   private String filename;               //The filename used for saving

   public RoundController(GameController controller)
   {
      this.controller = controller;
   }

   @Override
   public void start()
   {
      characters = controller.getLCharacters();
      roundMenu.showCharacter();
      roundMenu.setError("");
   }

   @Override
   public void setUI(UI_Panel panel)
   {
      this.roundMenu = (UI_RoundMenu) panel;
   }

   /** Tell the GameController to change to the TurnUI */
   public void startTurns() 
   {
      controller.toTurnUI();
   }

   /** Create a list of characters to be displayed */
   public JList setUpCharacters()
   {
      JList<Characters> characterList;

      DefaultListModel<Characters> listModel = new DefaultListModel<>();
      /*
      characters.forEach((character) -> {
         listModel.addElement(character);
      });
*/
      for (Characters character : characters) {
         listModel.addElement(character);
      }

      characterList = new JList<>(listModel);

      addSelectionListener(characterList);

      characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      return characterList;
   }

   /** Add listener so when Character is selected the appropiate Abilities are shown */
   public void addSelectionListener(final JList list)
   {
      /*ListSelectionListener listSelectionListener = (ListSelectionEvent listSelectionEvent) -> {
         roundMenu.showAbilities((Characters) list.getSelectedValue());
      };*/

      ListSelectionListener listSelectionListener = new ListSelectionListener()
      {
         @Override
         public void valueChanged(ListSelectionEvent e)
         {
            roundMenu.showAbilities((Characters) list.getSelectedValue());
         }
      };

      list.addListSelectionListener(listSelectionListener);
   }
   
   /** Create the ability list of imported character for the UI */
   public JList setUpAbility(Characters character)
   {
      JList<Ability> abilityList = null;
      if(character != null)
      {

         DefaultListModel<Ability> listModel = new DefaultListModel<>();
         
         /*character.getAbilities().forEach((ability) -> {
            listModel.addElement(ability);
         });*/

         for (Ability ability : character.getAbilities()) {
            listModel.addElement(ability);
         }

         abilityList = new JList<>(listModel);

         abilityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      }

      return abilityList;
   }

   /** Tell the gameController to save the game */
   public void saveGame(String filename)
   {
      try
      {
         if(filename != null && !filename.trim().isEmpty())
            controller.saveGame(filename + ".sve");
         else
            throw new GameSaveException("Save filename cannot be empty");
      }
      catch (GameSaveException e)
      {
         roundMenu.setError(e.getMessage());
         
      }
   }
   
   /** Tell the GameController to load a new game */
   public void loadGame()
   {
      controller.toMainUI();
   }

   /** tell the GameController to exit the game */
   public void exitGame()
   {
      controller.exitGame();
   }
}
