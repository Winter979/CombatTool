/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 00:28:16
* @Last Modified: 2017-10-12 18:54:30
* @Purpose:    Controller that interacts with the MainMenu UI
*/

package CombatTool.Controller;

import CombatTool.Exceptions.*;
import CombatTool.Model.Abilities.Ability;
import CombatTool.Model.Characters.TeamManager;
import CombatTool.View.UI_MainMenu;
import CombatTool.View.UI_Panel;
import java.awt.Dimension;
import java.io.File;
import java.util.Map;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JFileChooser;

public class MainMenuController implements UI_Controller
{
   private Factory factory= null;            //The Factory used to create a game

   private GameController controller = null; //The gameController that controls main UI

   private UI_MainMenu mainMenu = null;      //UI that this controller interacts with

   private JFileChooser fileChooser = null; //File chooser used to select files

   //New Game files
   private File fCharacter = null;  //The file used to generate Characters
   private File fAbility = null;    //The file used to generate Abilities

   //Load Game files
   private File fSave = null;       //The file used to load a saveState

   public MainMenuController(GameController controller)
   {
      fileChooser = new JFileChooser("resources");
      fileChooser.setPreferredSize(new Dimension(800, 500)); //Set size of fileChooser
      this.controller = controller;

      factory = controller.getFactory();
   }

   public void setFactory(Factory factory)
   {
      this.factory = factory;
   }

   @Override
   public void setUI(UI_Panel panel)
   {
      this.mainMenu = (UI_MainMenu) panel;
   }

   /** Show the fileChooser to select an ability */
   public void selectFile(String arg)
   {
      int returnVal = fileChooser.showOpenDialog(null);
   
      if (returnVal == JFileChooser.APPROVE_OPTION) 
      {
         File selectedFile = fileChooser.getSelectedFile();
         switch(arg)
         {
            case "Character":
               fCharacter = selectedFile;
               mainMenu.setCharacterFile(selectedFile.getName());
               break;
            case "Ability":
               fAbility = selectedFile;
               mainMenu.setAbilityFile(selectedFile.getName());
               break;
            case "Save":
               fSave = selectedFile;
               mainMenu.setSaveFile(selectedFile.getName());
               break;
            default:
               throw new IllegalArgumentException("Argument not supported");
         }
      }
   }

   @Override
   public void start()
   {
      mainMenu.setup();
   }
   
   /** Load a game by using the GameController and the inserted Save File*/
   public void loadGame()
   {
      try
      {
         if(fSave == null)
            throw new FilesNotSelectedException("Must Select a Save file to continue");
         
         controller.loadGame(fSave);

         controller.toRoundUI();
      }
      catch (GameLoadException | FilesNotSelectedException e)
      {
         mainMenu.setError("Error: " + e.getMessage());
      }
   }

   /** Create a new game from inserted Character and ability file */
   public void createGame()
   {
      try
      {
         if(fCharacter == null)
            throw new FilesNotSelectedException("Must Select a Character file to continue");
         if(fAbility == null)
            throw new FilesNotSelectedException("Must Select an Ability file to continue");
         
         Map<String, Ability> abilities = factory.createAbilities(fAbility);
         controller.setAbilities(abilities);

         TeamManager allCharacters = factory.makeCharacters(fCharacter, abilities);
         
         controller.setCharacters(allCharacters);

         controller.toRoundUI();
      }
      catch(FilesNotSelectedException | InvalidCharacterException | InvalidAbilityException e)
      {
         mainMenu.setError("Error: " + e.getMessage());
      }
   }

}
