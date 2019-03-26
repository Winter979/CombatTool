/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 22:29:18
* @Last Modified: 2017-10-12 11:43:59
* @File Name:  UI_TurnMenu
* @Purpose:    The UI that will be displayed to show Turns
*/
 
package CombatTool.View;

import CombatTool.Controller.TurnController;
import CombatTool.Controller.UI_Controller;
import CombatTool.Controller.TargetSystem;
import CombatTool.Model.Abilities.Ability;
import CombatTool.Model.Characters.Characters;

public class UI_TurnMenu extends UI_Panel
{
   private javax.swing.JButton btn_EndRound;             //The button that will trigger ending the round
   private javax.swing.JButton btn_SkipTurn;             //The button that will trigger skipping a turn
   private javax.swing.JButton btn_UseAbility;           //The button that will trigger an ability being used
   private javax.swing.JList<Ability> list_Abilities;    //List to represent Abilities
   private javax.swing.JList<Characters> list_Targets;   //List to represent possible targets
   private javax.swing.JLabel lbl_TeamTxt;
   private javax.swing.JLabel lbl_AbilityTitle; 
   private javax.swing.JLabel lbl_CharacterTitle;
   private javax.swing.JLabel lbl_TargetTitle;
   private javax.swing.JLabel lbl_CharacterName;
   private javax.swing.JLabel lbl_Team;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel5;
   private javax.swing.JScrollPane abilityScrollPane; 
   private javax.swing.JScrollPane targetScrollPane;     

   private TurnController turnController;    //The controller that the UI will interact with
   
   public UI_TurnMenu(UI_Controller turnController) 
   {
      super();
      this.turnController = (TurnController) turnController;
      initComponents();
      turnController.setUI(this);
   }

   /** Refresh the UI for next turn */
   public void resetUI(Characters character)
   {
      lbl_CharacterName.setText(character.getName());
      lbl_Team.setText(character.getTeamName());

      btn_SkipTurn.setText("Skip Turn");
      btn_UseAbility.setEnabled(true);

      list_Abilities = turnController.setUpAbility(character);
   
      abilityScrollPane.setViewportView(list_Abilities);
   }

   /** Display the potential targets */
   public void showTargets(TargetSystem targets)
   {
      list_Targets = turnController.setUpTargets(targets);

      targetScrollPane.setViewportView(list_Targets);
   }

   /** Display the abiilities */
   public void abilityUsed()
   {
      list_Targets.repaint();

      btn_UseAbility.setEnabled(false);
      btn_SkipTurn.setText("Continue");
   }

   @Override
   protected UI_Controller getController() {
      return turnController;
   }

   /** [btn_SkipTurnActionPerformed description] */
   private void btn_SkipTurnActionPerformed(java.awt.event.ActionEvent evt) 
   {
      turnController.nextTurn();
   }

   private void btn_UseAbilityActionPerformed(java.awt.event.ActionEvent evt) 
   {                                               
      turnController.useAbility(list_Abilities.getSelectedValue(), list_Targets.getSelectedValuesList());
   }                                              

   private void btn_EndRoundActionPerformed(java.awt.event.ActionEvent evt) 
   {
      turnController.endRound();
   }
                   
   /** Set up the GUI Components */
   private void initComponents() 
   {
      jPanel1 = new javax.swing.JPanel();
      abilityScrollPane = new javax.swing.JScrollPane();
      list_Abilities = new javax.swing.JList<>();
      jPanel5 = new javax.swing.JPanel();
      targetScrollPane = new javax.swing.JScrollPane();
      list_Targets = new javax.swing.JList<>();
      btn_SkipTurn = new javax.swing.JButton();
      lbl_CharacterTitle = new javax.swing.JLabel();
      lbl_CharacterName = new javax.swing.JLabel();
      btn_UseAbility = new javax.swing.JButton();
      lbl_TeamTxt = new javax.swing.JLabel();
      lbl_Team = new javax.swing.JLabel();
      btn_EndRound = new javax.swing.JButton();
      lbl_AbilityTitle = new javax.swing.JLabel();
      lbl_TargetTitle = new javax.swing.JLabel();

      setBackground(new java.awt.Color(40, 40, 40));
      setMaximumSize(new java.awt.Dimension(1000, 600));
      setMinimumSize(new java.awt.Dimension(1000, 600));
      setPreferredSize(new java.awt.Dimension(1000, 600));

      jPanel1.setBackground(new java.awt.Color(56, 185, 31));
      jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

      abilityScrollPane.setViewportView(list_Abilities);

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(3,3,3)
            .addComponent(abilityScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addGap(3,3,3))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(3,3,3)
            .addComponent(abilityScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
            .addGap(3,3,3))
      );

      jPanel5.setBackground(new java.awt.Color(56, 185, 31));
      jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

      targetScrollPane.setViewportView(list_Targets);

      javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
      jPanel5.setLayout(jPanel5Layout);
      jPanel5Layout.setHorizontalGroup(
         jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel5Layout.createSequentialGroup()
            .addGap(3,3,3)
            .addComponent(targetScrollPane)
            .addGap(3,3,3))
      );
      jPanel5Layout.setVerticalGroup(
         jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel5Layout.createSequentialGroup()
            .addGap(3,3,3)
            .addComponent(targetScrollPane)
            .addGap(3,3,3))
      );

      btn_SkipTurn.setText("Skip Turn");
      btn_SkipTurn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_SkipTurnActionPerformed(evt);
         }
      });

      lbl_CharacterTitle.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
      lbl_CharacterTitle.setForeground(new java.awt.Color(254, 254, 254));
      lbl_CharacterTitle.setText("Character: ");

      lbl_CharacterName.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
      lbl_CharacterName.setForeground(new java.awt.Color(254, 254, 254));
      lbl_CharacterName.setText("**name**");

      btn_UseAbility.setText("Use Ability");
      btn_UseAbility.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_UseAbilityActionPerformed(evt);
         }
      });

      lbl_TeamTxt.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
      lbl_TeamTxt.setForeground(new java.awt.Color(254, 254, 254));
      lbl_TeamTxt.setText("Team: ");

      lbl_Team.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
      lbl_Team.setForeground(new java.awt.Color(254, 254, 254));
      lbl_Team.setText("**team**");

      btn_EndRound.setText("End Round");
      btn_EndRound.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_EndRoundActionPerformed(evt);
         }
      });

      lbl_AbilityTitle.setBackground(new java.awt.Color(244, 255, 0));
      lbl_AbilityTitle.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
      lbl_AbilityTitle.setForeground(new java.awt.Color(56, 185, 31));
      lbl_AbilityTitle.setText("Select Ability");

      lbl_TargetTitle.setBackground(new java.awt.Color(244, 255, 0));
      lbl_TargetTitle.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
      lbl_TargetTitle.setForeground(new java.awt.Color(56, 185, 31));
      lbl_TargetTitle.setText("Select Targets");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(lbl_CharacterTitle)
               .addComponent(lbl_TeamTxt))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(lbl_Team, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(lbl_CharacterName, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_TargetTitle)
            .addGap(163, 163, 163))
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(176, 176, 176)
                  .addComponent(lbl_AbilityTitle)
                  .addGap(173, 173, 173))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                  .addGap(12, 12, 12)
                  .addComponent(btn_UseAbility, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(42, 42, 42)
                  .addComponent(btn_SkipTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                  .addComponent(btn_EndRound, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(lbl_CharacterTitle)
                     .addComponent(lbl_CharacterName))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(lbl_TeamTxt)
                     .addComponent(lbl_Team)))
               .addComponent(lbl_TargetTitle, javax.swing.GroupLayout.Alignment.TRAILING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(lbl_AbilityTitle)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(btn_SkipTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(btn_UseAbility, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(btn_EndRound, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(9, 9, 9)))
            .addContainerGap(20, Short.MAX_VALUE))
      );
   }
}
