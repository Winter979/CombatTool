/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 00:45:03
* @Last Modified: 2017-10-12 00:02:24
* @Purpose:    The Main frame that contains all the other UI Panels
*/

package CombatTool.View;

import CombatTool.Controller.GameController;

public class UI_MainFrame extends javax.swing.JFrame
{
   private javax.swing.JPanel mainPanel; //The Main Panel that is used to switch between Panels

   private GameController gameController; //The game controller to control the ui switching
   
   public UI_MainFrame(GameController gameController) 
   {
      this.gameController = gameController;
      initComponents();
      gameController.setUI(mainPanel);
   }
   
   /** Create all GUI features */
   private void initComponents() 
   {
      mainPanel = new javax.swing.JPanel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setMinimumSize(new java.awt.Dimension(1000, 600));
      setResizable(false);
      setSize(new java.awt.Dimension(1000, 640));

      mainPanel.setMinimumSize(new java.awt.Dimension(1000, 600));
      mainPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
      mainPanel.setLayout(new java.awt.CardLayout());

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );

      pack();
   }


}
