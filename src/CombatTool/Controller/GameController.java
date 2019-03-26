/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 23:47:26
* @Last Modified: 2017-10-12 10:53:28
* @Purpose:    The Main Controller of the game that manages which UI is shown
*                and the main Models of the game (characters and abilities)
*/

package CombatTool.Controller;

import CombatTool.Exceptions.GameLoadException;
import CombatTool.Exceptions.GameSaveException;
import CombatTool.Model.Abilities.Ability;
import CombatTool.Model.Characters.TeamManager;
import CombatTool.Model.Characters.Characters;
import CombatTool.Model.Characters.Team;
import CombatTool.Model.SaveState;
import CombatTool.View.UI_Panel;
import java.awt.CardLayout;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameController implements Observer, Serializable
{
   public static final String MAIN_MENU = "Main Menu";   //Key used to goto the Main Menu
   public static final String ROUND_MENU = "Round Menu"; //Key used to goto the Round Menu
   public static final String TURN_MENU = "Turn Menu";   //Key used to goto the Turn Meny
   public static final String END_MENU = "End Menu";     //Key used to goto the End Meny

   private TeamManager allCharacters = null;       //All Characters that are in the game
   private Map<String, Ability> abilities = null;  //All abilities that are in the game

   private Saving saving = null;       //The method of saving that is being used
   private SaveState saveState = null; //The state of the game as is to be saved

   private Factory factory = null;     //Factory used to generate all required objects
      
   private JPanel ui;                  //The Main UI that manages the other UIs
   
   public GameController(Factory factory)
   {
      this.factory = factory;
      allCharacters = factory.createAllCharacters();
      allCharacters.addObserver(this);
      abilities = new HashMap<>();
   }

   public void setUI(JPanel ui)
   {
      this.ui = ui;
   }

   public void setFactory(Factory factory)
   {
      this.factory = factory;
   }
   
   public Factory getFactory()
   {
      return factory;
   }
   
   public void setSaveState(SaveState saveState)
   {
      this.saveState = saveState;
      this.saveState.setCharacters(allCharacters);
      this.saveState.setAbilities(abilities);
   }

   public void setSavingMethod(Saving saving)
   {
      this.saving = saving;
   }

   public void addMainUI(UI_Panel pane)
   {
      addPanel(pane ,MAIN_MENU);
   }  

   public void addRoundUI(UI_Panel pane)
   {
      addPanel(pane ,ROUND_MENU);
   }

   public void addTurnUI(UI_Panel pane)
   {
      addPanel(pane ,TURN_MENU);
   }

   public void addEndUI(UI_Panel pane)
   {
      addPanel(pane, END_MENU);
   }

   private void addPanel(UI_Panel  pane, String key)
   {
      ui.add(pane, key);   
   }

   public void toMainUI()
   {
      switchTo(MAIN_MENU);
   }  

   public void toRoundUI() 
   {
      switchTo(ROUND_MENU);
   }

   public void toTurnUI()
   {
      switchTo(TURN_MENU);
   }

   /** End Menu can only be chosen when teams are down to 1 */
   @Override
   public void update(Subject sub)
   {
      switchTo(END_MENU);
   }

   /** Change cardLahout to selected Panel (frameName) */
   private void switchTo(String frameName)
   {
      CardLayout cl = (CardLayout)ui.getLayout();
      cl.show(ui, frameName);
   }
   
   /** Get the gameState to use the new characters and abilities */
   public void resetSaveState()
   {
      allCharacters = factory.createAllCharacters();
      abilities = new HashMap<>();
      allCharacters.addObserver(this);

      saveState.setCharacters(allCharacters);
      saveState.setAbilities(abilities);
   }

   public TeamManager getCharacters()
   {
      return allCharacters;
   }

   public List<Team> getLTeam()
   {
      return allCharacters.toTeamList();
   }

   public List<Characters> getLCharacters()
   {
      return allCharacters.toCharList();
   }

   public Map<String, Ability> getAbilities()
   {
      return abilities;   
   }

   public void setAbilities(Map<String, Ability> abilities)
   {
      this.abilities = abilities;   
      saveState.setAbilities(this.abilities);
   }

   public void setCharacters(TeamManager allCharacters)
   {
      this.allCharacters = allCharacters;  
      this.allCharacters.addObserver(this);
      /** Modify the saveState */
      saveState.setCharacters(this.allCharacters);
   }

   /** Save the game through the saving method */
   public void saveGame(String filename) throws GameSaveException
   {
      saving.saveGame(saveState, filename);
   }

   /** Load a game though the loading method */
   public void loadGame(File saveFile) throws GameLoadException
   {
      saveState = saving.loadGame(saveFile);
      allCharacters = saveState.getCharacters();
      allCharacters.addObserver(this);
      allCharacters.setFactory(factory);
      abilities = saveState.getAbilities();
   }

   /** Close the GUI to exit the game */
   public void exitGame()
   {
      ((JFrame)SwingUtilities.windowForComponent(ui)).dispose();
   }
}
