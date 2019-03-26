/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:13
* @Last Modified: 2017-10-12 00:09:28
* @File Name:  InvalidCharacterException
* @Purpose:    Custom exception for when an invalid chartacter is made
*/
 
package CombatTool.Exceptions;

public class InvalidCharacterException extends Exception 
{

   public InvalidCharacterException() {}

   public InvalidCharacterException(String msg) 
   {
      super(msg);
   }
}
