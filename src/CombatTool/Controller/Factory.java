/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 23:55:36
* @Last Modified: 2017-10-12 18:54:18
* @File Name:  Factory
* @Purpose:    To create all required classes for the system.
*/
 
package CombatTool.Controller;

import CombatTool.Exceptions.InvalidAbilityException;
import CombatTool.Exceptions.InvalidCharacterException;
import CombatTool.Model.Abilities.*;
import CombatTool.Model.Characters.*;
import CombatTool.Model.SaveState;
import CombatTool.View.*;
import CombatTool.View.UI_EndMenu;
import CombatTool.View.UI_Panel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Factory
{
   public Factory(){}

   /** Create an ability object an ensure its valid */
   private Ability makeAbility(String name, String target, String affect, int baseAmt, int diceAmt, int sides ) throws InvalidAbilityException
   {
      Ability ability = null;
      TargetSystem targetSystem = null;

      try
      {
         /**Get the required targeting system */
         targetSystem = makeTarget(target, affect);

         /** Check to see what type of Ability it is */
         switch(affect)
         {
            case "H":
               ability = new Heal(name, baseAmt, diceAmt, sides, targetSystem);
            break;
            case "D":
               ability = new Damage(name, baseAmt, diceAmt, sides, targetSystem);
            break;
         }
      }
      catch (InvalidAbilityException e)
      {
            throw new InvalidAbilityException("Invalid Ability could not be generated. Name: " + name +" "+ e.getMessage());
      }


      return ability;
   }

   /** Read a Character file and create all present characters */
   protected TeamManager makeCharacters(File file, Map<String, Ability> abilityMap) throws InvalidCharacterException 
   {
      FileInputStream fileStrm = null;
      InputStreamReader rdr;
      BufferedReader bufRdr;
      String line = "";
      String[] lineSplit;
      Ability ability;
      TeamManager teams = null;

      /** The expected first line contents */
      String[] fileHeader = {"Type", "Name", "HP", "Abilities"};

      try
      {
         fileStrm = new FileInputStream(file);
         rdr = new InputStreamReader(fileStrm);
         bufRdr = new BufferedReader(rdr);

         LinkedList<Ability> abilities;
         teams = createAllCharacters();

         line = bufRdr.readLine();

         lineSplit = line.split(",[ ]*");

         if(lineSplit.length != fileHeader.length)
            throw new InvalidCharacterException("Character file '" + file.getName() +"' is not in correct format");
         
         for(int ii = 0; ii < lineSplit.length; ii++)
         {
            if(!lineSplit[ii].equals(fileHeader[ii]))
               throw new InvalidCharacterException("Character file '" + file.getName()+ "' is not in correct format");
         }


         line = bufRdr.readLine(); 

         while(line!=null)
         {
            /** Create a new ability list for the new character */
            abilities = new LinkedList<>();
            lineSplit = line.split(",[ ]*");
            for(int ii = 3; ii < lineSplit.length; ii++)
            {
               ability = abilityMap.get(lineSplit[ii]);
               if(ability == null)
                  throw new InvalidCharacterException(
                     "Character '" + lineSplit[1] + "' has invalid ability '" + lineSplit[ii] + "'");

               abilities.addLast(ability);
            }
            /** Add the new character the to teamManager */
            teams.addCharacter(makeCharacter( 
                        lineSplit[0],  //tpye
                        lineSplit[1],  //name
                        Integer.parseInt(lineSplit[2]), //maxHP
                        abilities));   //abilities
            
            /** Get the next line */
            line = bufRdr.readLine();
         }

         /** There have to be more than 1 team to play the game */
         if(teams.getTeamCount() == 1)
            throw new InvalidCharacterException("Character File " + file.getName() + " only consists of 1 team");
      }
      catch (IOException e)
      {
         throw new IllegalArgumentException("Invalid file:" + e.getMessage());
      }
      finally
      {
         if (fileStrm != null)
         {
            try
            {
               fileStrm.close();
            }
            catch (IOException ex2){} //cant do anything
         }
      }

      return teams;
   }

   /** Read a file to create all present abilities */
   protected HashMap<String, Ability> createAbilities(File file) throws InvalidAbilityException
   {
      FileInputStream fileStrm = null;
      InputStreamReader rdr;
      BufferedReader bufRdr;
      String line = "";
      String[] lineSplit;

      HashMap<String, Ability> abilities = new HashMap<>();

      /** Expected header attributes of file */
      String[] fileHeader = {"Type","Name","Target","Base","NumDice","Faces"};

      try
      {
         fileStrm = new FileInputStream(file);
         rdr = new InputStreamReader(fileStrm);
         bufRdr = new BufferedReader(rdr);

         //Clear first line
         line = bufRdr.readLine();

         lineSplit = line.split(",[ ]*");

         if(lineSplit.length != fileHeader.length)
            throw new InvalidAbilityException("Ability file '" + file.getName() +"' is not in correct format");
         
         for(int ii = 0; ii < lineSplit.length; ii++)
         {
            if(!lineSplit[ii].equals(fileHeader[ii]))
               throw new InvalidAbilityException("Ability file '" + file.getName()+ "' is not in correct format");
         }

         line = bufRdr.readLine();

         while(line != null)
         {
            lineSplit = line.split(",[ ]*");
            abilities.put(
               lineSplit[1],     //name (key)
               makeAbility(        //(Attributes)
                  lineSplit[1],    //name
                  lineSplit[2],    //target
                  lineSplit[0],    //affect
                  Integer.parseInt(lineSplit[3]),  //baseAmt
                  Integer.parseInt(lineSplit[4]),  //diceAmt
                  Integer.parseInt(lineSplit[5]))  //diceSides
               );
            line = bufRdr.readLine();
                                                            
         }

      }
      catch (IOException e)
      {
         throw new InvalidAbilityException("Invalid file:" + e.getMessage());
      }
      finally
      {
         if (fileStrm != null)
         {
            try
            {
               fileStrm.close();
            }
            catch (IOException ex2){} //cant do anything
         }
      }
      
      return abilities;
   }

   /** Create an appropiate targetSystem to be used for an Ability */
   private TargetSystem makeTarget(String target, String affect) throws InvalidAbilityException
   {
      TargetSystem mTarget;

      /** Select the targetting system */
      switch (target) 
      {
         case "S":
            if(affect.equals("H")) //Single Heal
            {
               mTarget = new SingleHeal();
            }
            else if (affect.equals("D")) // Single Damage
            {
               mTarget = new SingleDamage();
            }
            else
            {
               throw new InvalidAbilityException(" Affect: " + affect);
            }
         break;
         case "M":
            if(affect.equals("H")) //Multi Heal
            {
               mTarget = new AllHeal();
            }
            else if (affect.equals("D")) //Multi Damage
            {
               mTarget = new AllDamage();
            }
            else
            {
               throw new InvalidAbilityException(" Affect: " + affect);
            }
         break;
         default:
            throw new InvalidAbilityException(" Target: " + target);
      }

      return mTarget;
   }

   /** Create a Character object */
   protected Characters makeCharacter(String type, String name, int maxHP, LinkedList<Ability> abilities) throws InvalidCharacterException
   {
      Characters character;

      /** Create an appropiate type of character */
      switch (type) 
      {
         case "P":
            character = new Player(name, maxHP, abilities);
            break;
         case "N":
            character = new NonPlayer(name, maxHP, abilities);
            break;
         default:
            throw new InvalidCharacterException("name:" + name + " Type: " + type);
      }

      return character;
   }  

   /** Create and set up all the required GUI and controllers that will be used */
   public UI_MainFrame createMainFrame()
   {
      //Controllers to be used
      GameController gameController = new GameController(this);
      gameController.setSaveState(createSaveState());
      gameController.setSavingMethod(createSavingMethod());


      /*Controllers for the individual UIs*/
      UI_Controller menuController = new MainMenuController(gameController);
      UI_Controller roundController = new RoundController(gameController);
      UI_Controller turnController = new TurnController(gameController);
      UI_Controller endController = new EndController(gameController);

      //All UI that are needed for the game
      UI_Panel uiMainMenu = new UI_MainMenu(menuController);
      UI_Panel uiRoundMenu = new UI_RoundMenu(roundController);
      UI_Panel uiTurnMenu = new UI_TurnMenu(turnController);
      UI_Panel uiEndMenu = new UI_EndMenu(endController);

      /*Main Frame that holds all the Panels in card layout format*/
      UI_MainFrame mainFrame = new UI_MainFrame(gameController);

      /*Add UIs to the gameController*/
      gameController.addMainUI(uiMainMenu);
      gameController.addRoundUI(uiRoundMenu);      
      gameController.addTurnUI(uiTurnMenu);
      gameController.addEndUI(uiEndMenu);

      gameController.toMainUI();

      return mainFrame;
   }

   /** Create The savingMethod class */
   private Saving createSavingMethod()
   {
      return new Saving();
   }

   /** Create the TeamManager object that the game uses */
   protected TeamManager createAllCharacters()
   {
      TeamManager teams = new TeamManager();
      teams.setFactory(this);

      return teams;
   }

   /** Create a new saveState */
   private SaveState createSaveState()
   {
      return new SaveState();
   }
   
   /** Create a new empty team */
   public Team createTeam(String teamName)
   {
      return new Team(teamName);
   }
}