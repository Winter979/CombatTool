/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:13
* @Last Modified: 2017-10-12 10:35:33
* @File Name:  GameSaveException
* @Purpose:    Custom Exception for when a game fails to save
*/
 
package CombatTool.Exceptions;

public class GameSaveException extends Exception 
{
   public GameSaveException() {}

   public GameSaveException(String msg) 
   {
      super(msg);
   }
}
