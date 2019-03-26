/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:13
* @Last Modified: 2017-10-12 00:09:03
* @File Name:  GameLoadException
* @Purpose:    Custom Exception for when a game fails to load
*/
 
package CombatTool.Exceptions;

public class GameLoadException extends Exception 
{
   public GameLoadException() {}

   public GameLoadException(String msg) 
   {
      super(msg);
   }
}
