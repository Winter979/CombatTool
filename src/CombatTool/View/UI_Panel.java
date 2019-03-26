/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:33:55
* @Last Modified: 2017-10-12 00:33:37
* @Purpose:    UI Class that is added to the MainFrame cardLayout
*/

package CombatTool.View;

import CombatTool.Controller.UI_Controller;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public abstract class UI_Panel extends javax.swing.JPanel 
{
   /** All GUIs must have an attacted controller to interact with */
   protected abstract UI_Controller getController();

   protected UI_Panel()
   {
      setStartOnShow();
   }

   /** When the UI is shown run the controllers start method */
   private void setStartOnShow()
   {
      this.addComponentListener ( new ComponentAdapter ()
      { 
         @Override
         public void componentShown ( ComponentEvent e )
         {
            getController().start();
         }
      });
   }
}