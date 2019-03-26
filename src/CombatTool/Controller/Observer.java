/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 21:16:21
* @Last Modified: 2017-10-12 00:23:14
* @File Name:  Observer
* @Purpose:    Object observes a subject
*/
 
package CombatTool.Controller;

public interface Observer
{
   /** Gets notified by the subject */
   public void update(Subject sub);
}