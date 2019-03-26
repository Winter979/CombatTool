/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:08:58
* @Last Modified: 2017-10-12 00:16:53
* @File Name:  Subject
* @Purpose:    A class that will be observed by another
*/
 
package CombatTool.Controller;

public interface Subject
{
   /** Add an observer to the subject */
   public void addObserver(Observer obs);

   /** Notify all observers of something */
   public void notifyObserver();
}