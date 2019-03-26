/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:13
* @Last Modified: 2017-10-12 00:09:15
* @File Name:  InvalidAbilityException
* @Purpose:    Custom exception for when an invalid ability is made
*/
 
package CombatTool.Exceptions;

public class InvalidAbilityException extends Exception 
{

   public InvalidAbilityException() {}

   public InvalidAbilityException(String msg) 
   {
      super(msg);
   }
}
