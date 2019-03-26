/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 22:16:45
* @Last Modified: 2017-10-11 22:48:47
* @File Name:  UI_EndMenu
* @Purpose:    The UI that will be used to interact with the EndController
*/
 
package CombatTool.View;

import CombatTool.Controller.EndController;
import CombatTool.Controller.UI_Controller;

public class UI_EndMenu extends UI_Panel
{
   private javax.swing.JButton btn_ExitGame;    //The Button used to trigger exiting
   private javax.swing.JButton btn_LoadGame;    //The Button used to trigger loading
   private javax.swing.JList<String> list_Characters; //The List of characters in the winning team
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel lbl_Winners;
   private javax.swing.JScrollPane characterScrollPane;

   private EndController endController = null;

   public UI_EndMenu(UI_Controller ui_Controller) 
   {
      super();
      this.endController = (EndController) ui_Controller;
      initComponents();
      endController.setUI(this);
   }

   /** Setup the UI for the new information */
   public void setup()
   {
      list_Characters = endController.setUpCharacters();
      
      characterScrollPane.setViewportView(list_Characters);
      
      lbl_Winners.setText(endController.getTeamName() + " Win");
   }
      
   @Override
   protected UI_Controller getController() 
   {
      return endController;
   }

   /** Perform a method when the loadGame button is selected */
   private void btn_LoadGameActionPerformed(java.awt.event.ActionEvent evt) 
   {
      endController.loadGame();
   }

   /** Perform a method when the exitGame button is selected */
   private void btn_ExitGameActionPerformed(java.awt.event.ActionEvent evt) 
   {
      endController.exitGame();
   }

   /** Generates and prepared the GUI */
   private void initComponents() 
   {
      jLabel1 = new javax.swing.JLabel();
      btn_LoadGame = new javax.swing.JButton();
      btn_ExitGame = new javax.swing.JButton();
      characterScrollPane = new javax.swing.JScrollPane();
      list_Characters = new javax.swing.JList<>();
      jLabel3 = new javax.swing.JLabel();
      lbl_Winners = new javax.swing.JLabel();

      setBackground(new java.awt.Color(40, 40, 40));
      setMaximumSize(new java.awt.Dimension(1000, 600));
      setMinimumSize(new java.awt.Dimension(1000, 600));
      setPreferredSize(new java.awt.Dimension(1000, 600));

      jLabel1.setFont(new java.awt.Font("Open Sans", 0, 40)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(254, 254, 254));
      jLabel1.setText("GAME IS COMPLETE");

      btn_LoadGame.setText("New Game");
      btn_LoadGame.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_LoadGameActionPerformed(evt);
         }
      });

      btn_ExitGame.setText("Exit Game");
      btn_ExitGame.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_ExitGameActionPerformed(evt);
         }
      });

      list_Characters.setBackground(new java.awt.Color(254, 254, 254));
      characterScrollPane.setViewportView(list_Characters);

      jLabel3.setIcon(new javax.swing.ImageIcon("images/pikachu.png")); // NOI18N

      lbl_Winners.setBackground(new java.awt.Color(255, 0, 0));
      lbl_Winners.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
      lbl_Winners.setForeground(new java.awt.Color(56, 185, 31));
      lbl_Winners.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lbl_Winners.setText("You WIN :)");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(84, 84, 84)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btn_LoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(btn_ExitGame, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(characterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(39, 39, 39)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(lbl_Winners, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(54, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(276, 276, 276))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addComponent(jLabel1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(characterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(btn_LoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(btn_ExitGame, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(17, 17, 17))
               .addGroup(layout.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addComponent(lbl_Winners)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel3)
                  .addGap(44, 44, 44))))
      );
   }                      
}
