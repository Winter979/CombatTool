/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 21:05:15
* @Last Modified: 2017-10-12 00:08:30
* @Purpose:    Main Class that starts the Program
*/
package CombatTool;

import CombatTool.View.UI_MainFrame;
import CombatTool.Controller.Factory;

public class CombatTool 
{
   public static void main(String[] args) 
   {

      /** Set the look and feel so that the GUI attributes look different (better) */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("GTK+".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
         //do nothing
      }
      
      /** Create a new factory that will make everything else */
      Factory factory = new Factory();

      /** Use the factory to create the GUI*/
      UI_MainFrame mainFrame = factory.createMainFrame();
      
      /** Start the GUI */
      mainFrame.setVisible(true);
   }
}
