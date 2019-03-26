/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 02:37:24
* @Last Modified: 2017-10-12 18:27:28
* @Purpose:    Manage the UI input from the UI_EndMeny
*/

package CombatTool.Controller;

import CombatTool.Model.Characters.Characters;
import CombatTool.View.UI_EndMenu;
import CombatTool.View.UI_Panel;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class EndController implements UI_Controller
{
   private GameController controller = null; //The main controller 
   private UI_EndMenu endMenu = null;        //The UI that this controller interacts with

   private List<Characters> characters = null;  //The characters to be displayed

   public EndController(GameController controller)
   {
      this.controller = controller;
   }

   @Override
   public void setUI(UI_Panel panel)
   {
      this.endMenu = (UI_EndMenu) panel;
   }

   @Override
   public void start()
   {
      characters = controller.getLCharacters();
      endMenu.setup();
   }

   public String getTeamName()
   {
      return characters.get(0).getTeamName();
   }
   
   public void loadGame()
   {
      controller.toMainUI();
   }

   public void exitGame()
   {
      controller.exitGame();
   }

   /** Create a list of Characters to be displayed */
   public JList setUpCharacters()
   {
      JList<Characters> characterList;

      DefaultListModel<Characters> listModel = new DefaultListModel<>();
      
      /*characters.forEach((character) -> {
         listModel.addElement(character);
      });*/

      for (Characters character : characters) {
         listModel.addElement(character);
      }

      characterList = new JList<>(listModel);

      return characterList;
   }
}