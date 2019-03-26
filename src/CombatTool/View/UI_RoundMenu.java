/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 22:47:33
* @Last Modified: 2017-10-12 18:31:00
* @File Name:  UI_RoundMenu
* @Purpose:    The UI that will be dispayed to interact with the RoundController
*/
 
package CombatTool.View;

import CombatTool.Controller.RoundController;
import CombatTool.Controller.UI_Controller;
import CombatTool.Model.Characters.Characters;
import CombatTool.Model.Abilities.Ability;

public class UI_RoundMenu extends UI_Panel 
{
   private javax.swing.JScrollPane abilityScrollPane;
   private javax.swing.JButton btn_Exit;
   private javax.swing.JButton btn_Save;
   private javax.swing.JButton btn_Load;
   private javax.swing.JButton btn_StartRound;
   private javax.swing.JScrollPane characterScrollPane;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JLabel lbl_Error;
   private javax.swing.JList<Ability> list_Ability;
   private javax.swing.JList<Characters> list_Character;
   private javax.swing.JTextField txt_SaveFile;

   private RoundController roundController;

   public UI_RoundMenu(UI_Controller roundController) 
   {
      super();
      this.roundController = (RoundController)roundController;
      initComponents();
      roundController.setUI(this);
   }
    
   /** Display all characters */
   public void showCharacter()
   {
      list_Character = roundController.setUpCharacters();

      characterScrollPane.setViewportView(list_Character);
   }

   /** Show all abilities of the selected Character */
   public void showAbilities(Characters character)
   {      
      list_Ability = roundController.setUpAbility(character);
      
      abilityScrollPane.setViewportView(list_Ability);
   }

   /** Display the error */
   public void setError(String error)
   {
      lbl_Error.setText(error);
   }

   /** Set the saveFile name */
   public void setFileName(String name)
   {
      txt_SaveFile.setText(name);
   }

   @Override
   protected UI_Controller getController() {
      return roundController;
   }

   /** Trigger startTurns when button is acted upon */
   private void btn_StartRoundActionPerformed(java.awt.event.ActionEvent evt) 
   {
      roundController.startTurns();
   }

   /** Trigger saveGame when button is acted upon */
   private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) 
   {
      roundController.saveGame(txt_SaveFile.getText());
   }

   /** Trigger exitGame when button is acted upon */
   private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) 
   {
      roundController.exitGame();
   }

   /** Trigger loadGame when button is acted upon */
   private void btn_LoadActionPerformed(java.awt.event.ActionEvent evt) 
   {
      roundController.loadGame();
   }
     
   /** Generate all GUI components */
   private void initComponents() 
   {
      btn_StartRound = new javax.swing.JButton();
      btn_Save = new javax.swing.JButton();
      btn_Exit = new javax.swing.JButton();
      jLabel5 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      txt_SaveFile = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      lbl_Error = new javax.swing.JLabel();
      btn_Load = new javax.swing.JButton();
      jPanel1 = new javax.swing.JPanel();
      characterScrollPane = new javax.swing.JScrollPane();
      list_Character = new javax.swing.JList<>();
      jPanel2 = new javax.swing.JPanel();
      abilityScrollPane = new javax.swing.JScrollPane();
      list_Ability = new javax.swing.JList<>();

      setBackground(new java.awt.Color(40, 40, 40));
      setMaximumSize(new java.awt.Dimension(1000, 600));
      setMinimumSize(new java.awt.Dimension(1000, 600));
      setPreferredSize(new java.awt.Dimension(1000, 600));
      setRequestFocusEnabled(false);

      btn_StartRound.setBackground(java.awt.SystemColor.controlDkShadow);
      btn_StartRound.setText("Start Round");
      btn_StartRound.setAutoscrolls(true);
      btn_StartRound.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_StartRoundActionPerformed(evt);
         }
      });

      btn_Save.setText("Save");
      btn_Save.setAutoscrolls(true);
      btn_Save.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_SaveActionPerformed(evt);
         }
      });

      btn_Exit.setText("Exit");
      btn_Exit.setAutoscrolls(true);
      btn_Exit.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_ExitActionPerformed(evt);
         }
      });

      jLabel5.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
      jLabel5.setForeground(new java.awt.Color(56, 185, 31));
      jLabel5.setText("Characters:");

      jLabel7.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
      jLabel7.setForeground(new java.awt.Color(56, 185, 31));
      jLabel7.setText("Abilities:");

      jLabel1.setForeground(new java.awt.Color(254, 254, 254));
      jLabel1.setText("Savefile name: ");

      txt_SaveFile.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
      txt_SaveFile.setText("myGame");

      jLabel2.setForeground(new java.awt.Color(254, 254, 254));
      jLabel2.setText(".sve");

      lbl_Error.setForeground(new java.awt.Color(255, 0, 0));
      lbl_Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lbl_Error.setText("**error**");

      btn_Load.setText("Load");
      btn_Load.setAutoscrolls(true);
      btn_Load.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_LoadActionPerformed(evt);
         }
      });

      jPanel1.setBackground(new java.awt.Color(56, 185, 31));
      jPanel2.setBackground(new java.awt.Color(56, 185, 31));

      characterScrollPane.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N

      list_Character.setBackground(new java.awt.Color(254, 254, 254));
      list_Character.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
      list_Character.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      characterScrollPane.setViewportView(list_Character);

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(characterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(3, 3, 3))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(characterScrollPane)
            .addGap(3, 3, 3))
      );

      list_Ability.setBackground(new java.awt.Color(254, 254, 254));
      list_Ability.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
      abilityScrollPane.setViewportView(list_Ability);

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(abilityScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addGap(3, 3, 3))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(abilityScrollPane)
            .addGap(3, 3, 3))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(btn_Load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btn_Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel1)
                     .addComponent(txt_SaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel2))
               .addComponent(btn_Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btn_StartRound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel5)
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel7)
                  .addGap(0, 273, Short.MAX_VALUE))
               .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_Error, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(167, 167, 167))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btn_StartRound, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jLabel1)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(txt_SaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel2))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                  .addComponent(btn_Load, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(32, 32, 32))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addComponent(lbl_Error)
            .addGap(30, 30, 30))
      );
   }               
}
