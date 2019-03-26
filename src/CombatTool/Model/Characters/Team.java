/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:40:36
* @Last Modified: 2017-10-12 18:32:56
* @File Name:  Team
* @Purpose:    Constuct a Team object that knows its members and who the enemies are
*/
 
package CombatTool.Model.Characters;

import CombatTool.Controller.Observer;
import CombatTool.Controller.Subject;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Team implements Subject, Serializable
{ 
   private Observer observer = null;         //An observer that wants to know about the team 
   private List<Characters> members = null;  //The members of the team
   private List<Team> enemies = null;        //All the other teams that arent friendly
   private String teamName = null;           //The name of the team (Used as a key for MAP)

   public Team(String teamName)
   {
      this.teamName = teamName;
      enemies = new LinkedList<>();    //No enemies at start
      members = new LinkedList<>();    //No members at start
   }

   public void addEnemies(Team enemies)
   {
      this.enemies.add(enemies);
   }

   /** Construct a single list of all enemy characters */
   public List<Characters> getEnemies()
   {
      List<Characters> enemyList = new LinkedList<>();

      /** Add each enemy team characters to the list */
      /*enemies.forEach((enemy) -> {
         enemyList.addAll(enemy.getAllies());
      });*/

      for (Team enemy : enemies) {
         enemyList.addAll(enemy.getAllies());
      }

      return enemyList;
   }  
     
   public String getName()
   {
      return teamName;
   }  
   
   public List<Characters> getAllies()
   {
      return members;
   }

   /** Add a character to the team */
   public void addMember(Characters character)
   {
      members.add(character);
      character.setTeam(this);
   }

   /** Remove dead character from the team */
   public void imDead(Characters character)
   {
      members.remove(character);

      /** If there are no members then the team is completely dead */
      if(getCount() == 0)
         notifyObserver();
   }

   /** Let all members know that the team for a kill */
   public void teamKill()
   {
      /*members.forEach((cha) -> { 
         cha.killHeal();
      });*/

      for (Characters cha : members) {
         cha.killHeal();
      }
   }

   /** Get the amount of characters in the team */
   public int getCount()
   {
      return members.size();
   }

   @Override
   public String toString()
   {
      String result = "";
      
      for (Characters cha : members) 
      {
         result += cha.toString() + "\n";   
      }

      return result;
   }     

   @Override
   public void addObserver(Observer obs) 
   {
      this.observer = obs;
   }

   /** Tell the Observer that the team has died */
   @Override
   public void notifyObserver()
   {
      observer.update(this);
   }
}