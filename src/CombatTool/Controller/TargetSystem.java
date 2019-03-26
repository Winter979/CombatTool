/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 21:29:52
* @Last Modified: 2017-10-12 11:40:16
* @File Name:  TargetSystem
* @Purpose:    Create a targeting system that will be used to generate possible targets
*/
 
package CombatTool.Controller;

import CombatTool.Model.Characters.Characters;
import javax.swing.JList;

public interface TargetSystem
{
   /**
    * Generates a JList with the appropriate settings for the target System
    * @param  character The Character who is using the abilities targeting
    * @return           The potential targets
    */
   public JList setTargets(Characters character);
   
   @Override
   public String toString();
}