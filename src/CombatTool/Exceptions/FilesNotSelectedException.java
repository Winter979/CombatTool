/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:13
* @Last Modified: 2017-10-12 00:08:49
* @Purpose:    Exception to show that a selected file is invalid
*/

package CombatTool.Exceptions;

public class FilesNotSelectedException extends Exception 
{

   public FilesNotSelectedException() {}

   public FilesNotSelectedException(String msg) 
   {
      super(msg);
   }
}
