/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:13
* @Last Modified: 2017-10-12 00:09:43
* @File Name:  InvalidSaveFileException
* @Purpose:    Custom exception for when saving fails
*/
 
package CombatTool.Exceptions;

public class InvalidSaveFileException extends Exception 
{
   public InvalidSaveFileException() {}

   public InvalidSaveFileException(String msg) 
   {
      super(msg);
   }
}
