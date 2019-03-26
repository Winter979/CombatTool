/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 02:31:51
* @Last Modified: 2017-10-12 18:50:18
* @File Name:  TeamManager
* @Purpose:    To manage all the teams that the game has
*/
 
package CombatTool.Model.Characters;

import CombatTool.Controller.Factory;
import CombatTool.Controller.Observer;
import CombatTool.Controller.Subject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class TeamManager implements Observer, Subject, Serializable
{
   private HashMap<String, Team> teams = null;  //The teams in the game with the key being their name
   
   private transient Observer observer = null;  //An observer that cares when the team Manager has changed
   private transient Factory factory = null;    //The factory used to create a new Team

   public TeamManager()
   {
      teams = new HashMap<>();   //Create an empty 
   }  

   public void setFactory(Factory factory)
   {
      this.factory = factory;
   }

   /** Return all the teams as a list */
   public ArrayList<Team> toTeamList()
   {
      return new ArrayList<>(teams.values());
   }

   /** Return a single list containing all characters in all teams */
   public List<Characters> toCharList()
   {
      List<Characters> characters = new ArrayList<>();

      /*teams.values().forEach((team) -> {  //Iterate trough all teams
         team.getAllies().forEach((cha) -> {
            characters.add(cha);
         });
      });*/

      for (Team team : teams.values()) 
      {
         for (Characters cha: team.getAllies()) 
         {
            characters.add(cha);      
         }   
      }

      return characters;
   }

   /** Add a character to the game. */
   public void addCharacter(Characters cha)
   {
      /*Check to see if the team for the character is already present*/
      if(!teams.containsKey(cha.getTeamName().toLowerCase()))
      {
         /** Create a new team for the character */
         Team newTeam = factory.createTeam(cha.getTeamName());
         newTeam.addObserver(this);

         /*teams.values().forEach((team) -> {
            newTeam.addEnemies(team);
            team.addEnemies(newTeam);
         });*/

         for (Team team : teams.values()) {
            /** Add the new team to the enemy list of all the teams */
            newTeam.addEnemies(team);
            /** Add the enemies to the new team */
            team.addEnemies(newTeam);
         }

         /*Add new team to the map*/
         teams.put(cha.getTeamName().toLowerCase(), newTeam);
      }

      /** Add the character to their team */
      teams.get(cha.getTeamName().toLowerCase()).addMember(cha);
   }

   @Override
   public void addObserver(Observer obs) 
   {
      this.observer = obs;
   }

   /** Get the amount of teams in the game */
   public int getTeamCount()
   {
      return teams.size();
   }
      
   @Override
   public String toString()
   {
      String result = "";
      for (Map.Entry<String, Team> entry : teams.entrySet()) 
      {
         result += "Team: " + entry.getKey() +" Characters: " + entry.getValue().getCount() + "\n";
      }

      return result;
   }

   /** Let the Observer know that the game only has 1 team left */
   @Override
   public void notifyObserver() 
   {
      observer.update(this);
   }

   /** Remove a team from the game that has been killed*/
   @Override
   public void update(Subject sub)
   {
      if(sub instanceof Team)
      {
         teams.remove(((Team)sub).getName().toLowerCase());
         /** Check to see if more teams are still in play */
         if(getTeamCount() == 1)
         {
            notifyObserver();
         }
      }
   }
}