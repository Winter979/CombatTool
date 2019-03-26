/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 02:29:32
* @Last Modified: 2017-10-12 01:13:56
* @Purpose:    GUI that will interact with the MainMenu controller
*/

package CombatTool.View;

import CombatTool.Controller.MainMenuController;
import CombatTool.Controller.UI_Controller;

public class UI_MainMenu extends UI_Panel 
{
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
   private javax.swing.JLabel jLabel12;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JButton btn_LoadGame;           //Button that will trigger loading
   private javax.swing.JButton btn_NewGame;            //Button that will trigger New Game
   private javax.swing.JButton btn_SelectAbilityFile;  //Button that will trigger Ability File Selection
   private javax.swing.JButton btn_SelectCharacterFile;//Button that will trigger Character File Selection
   private javax.swing.JButton btn_SelectSaveFile;     //Button that will trigger Save File Selection
   private javax.swing.JLabel lbl_AbilityFile;        //Label to show selected Ability file
   private javax.swing.JLabel lbl_CharacterFile;      //Label to show selected Characgter file
   private javax.swing.JLabel lbl_SaveFile;           //Label to show selected Save file
   private javax.swing.JLabel lbl_Error;              //Label to display errors to
   
   private MainMenuController mainMenuController;     //Controller that the UI interacts with

   public UI_MainMenu(UI_Controller mainMenuController) 
   {
      super();
      this.mainMenuController = (MainMenuController)mainMenuController;
      mainMenuController.setUI(this);
      initComponents();
   }

   /** Set up the UI for a new view */
   public void setup()
   {
      lbl_Error.setText("");
   }
   
   /** Trigger loadGame when button is acted upon */
   private void btn_LoadGameActionPerformed(java.awt.event.ActionEvent evt) 
   {
      mainMenuController.loadGame();
   }

   /** Trigger selectFile when button is acted upon */
   private void btn_SelectSaveFileActionPerformed(java.awt.event.ActionEvent evt) 
   {
      mainMenuController.selectFile("Save");
   }

   /** Trigger createGame when button is acted upon */
   private void btn_NewGameActionPerformed(java.awt.event.ActionEvent evt) 
   {
      mainMenuController.createGame();
   }

   /** Trigger selectFile when button is acted upon */
   private void btn_SelectCharacterFileActionPerformed(java.awt.event.ActionEvent evt) 
   {
      mainMenuController.selectFile("Character");
   }

   /** Trigger selectFile when button is acted upon */
   private void btn_SelectAbilityFileActionPerformed(java.awt.event.ActionEvent evt) 
   {
      mainMenuController.selectFile("Ability");
   }

   /** Display selected Characer File */
   public void setCharacterFile(String filename)
   {
      lbl_CharacterFile.setText(filename);
   }
   
   /** Display selecgted ability file */
   public void setAbilityFile(String filename)
   {
      lbl_AbilityFile.setText(filename);
   }
   
   /** Displa selected saveFile */
   public void setSaveFile(String filename)
   {
      lbl_SaveFile.setText(filename);
   }

   /** Set the error label */
   public void setError(String error)
   {
      lbl_Error.setText(error);
   }

   @Override
   protected UI_Controller getController() 
   {
      return mainMenuController;
   }

   /** Generate all components for the GUI */
   private void initComponents() 
   {
      jLabel1 = new javax.swing.JLabel();
      jPanel3 = new javax.swing.JPanel();
      btn_NewGame = new javax.swing.JButton();
      jLabel10 = new javax.swing.JLabel();
      lbl_CharacterFile = new javax.swing.JLabel();
      btn_SelectCharacterFile = new javax.swing.JButton();
      jLabel12 = new javax.swing.JLabel();
      lbl_AbilityFile = new javax.swing.JLabel();
      btn_SelectAbilityFile = new javax.swing.JButton();
      jLabel4 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      jPanel2 = new javax.swing.JPanel();
      btn_LoadGame = new javax.swing.JButton();
      jLabel8 = new javax.swing.JLabel();
      lbl_SaveFile = new javax.swing.JLabel();
      btn_SelectSaveFile = new javax.swing.JButton();
      jLabel3 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      lbl_Error = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();

      setBackground(new java.awt.Color(40, 40, 40));
      setMaximumSize(new java.awt.Dimension(1000, 600));
      setMinimumSize(new java.awt.Dimension(1000, 600));
      setPreferredSize(new java.awt.Dimension(1000, 600));

      jLabel1.setForeground(new java.awt.Color(254, 254, 254));
      jLabel1.setText("WELCOME TO THE");

      jPanel3.setBackground(new java.awt.Color(149, 153, 254));
      jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
      jPanel3.setPreferredSize(new java.awt.Dimension(420, 362));

      btn_NewGame.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
      btn_NewGame.setForeground(new java.awt.Color(22, 0, 0));
      btn_NewGame.setText("Create");
      btn_NewGame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
      btn_NewGame.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_NewGameActionPerformed(evt);
         }
      });

      jLabel10.setForeground(new java.awt.Color(38, 38, 38));
      jLabel10.setText("Character file:");

      lbl_CharacterFile.setForeground(new java.awt.Color(38, 38, 38));
      lbl_CharacterFile.setText("--Select File--");

      btn_SelectCharacterFile.setForeground(new java.awt.Color(38, 38, 38));
      btn_SelectCharacterFile.setText("<");
      btn_SelectCharacterFile.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_SelectCharacterFileActionPerformed(evt);
         }
      });

      jLabel12.setForeground(new java.awt.Color(38, 38, 38));
      jLabel12.setText("Ability file:");

      lbl_AbilityFile.setForeground(new java.awt.Color(38, 38, 38));
      lbl_AbilityFile.setText("--Select File--");

      btn_SelectAbilityFile.setForeground(new java.awt.Color(38, 38, 38));
      btn_SelectAbilityFile.setText("<");
      btn_SelectAbilityFile.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_SelectAbilityFileActionPerformed(evt);
         }
      });

      jLabel4.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
      jLabel4.setForeground(new java.awt.Color(20, 106, 3));
      jLabel4.setText("Create Game");

      jLabel7.setIcon(new javax.swing.ImageIcon("images/small.png")); // NOI18N

      javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel12)
               .addComponent(jLabel10))
            .addGap(18, 18, 18)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(lbl_CharacterFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(lbl_AbilityFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(btn_SelectCharacterFile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(btn_SelectAbilityFile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel4)
            .addGap(89, 89, 89))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addGap(34, 34, 34)
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
            .addComponent(btn_NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29))
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addComponent(jLabel4)
            .addGap(18, 18, 18)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel10)
               .addComponent(lbl_CharacterFile)
               .addComponent(btn_SelectCharacterFile))
            .addGap(18, 18, 18)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel12)
               .addComponent(lbl_AbilityFile)
               .addComponent(btn_SelectAbilityFile))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(btn_NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(29, 29, 29))
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(18, 18, 18)
                  .addComponent(jLabel7)
                  .addContainerGap(25, Short.MAX_VALUE))))
      );

      jPanel2.setBackground(new java.awt.Color(149, 153, 254));
      jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
      jPanel2.setPreferredSize(new java.awt.Dimension(420, 362));

      btn_LoadGame.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
      btn_LoadGame.setForeground(new java.awt.Color(22, 0, 0));
      btn_LoadGame.setText("Load");
      btn_LoadGame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
      btn_LoadGame.setMaximumSize(new java.awt.Dimension(56, 33));
      btn_LoadGame.setMinimumSize(new java.awt.Dimension(56, 33));
      btn_LoadGame.setPreferredSize(new java.awt.Dimension(56, 33));
      btn_LoadGame.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_LoadGameActionPerformed(evt);
         }
      });

      jLabel8.setForeground(new java.awt.Color(38, 38, 38));
      jLabel8.setText("Save File: ");

      lbl_SaveFile.setForeground(new java.awt.Color(38, 38, 38));
      lbl_SaveFile.setText("--Select File--");

      btn_SelectSaveFile.setForeground(new java.awt.Color(38, 38, 38));
      btn_SelectSaveFile.setText("<");
      btn_SelectSaveFile.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_SelectSaveFileActionPerformed(evt);
         }
      });

      jLabel3.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(20, 106, 3));
      jLabel3.setText("Load Game");

      jLabel6.setIcon(new javax.swing.ImageIcon("images/small.png")); // NOI18N

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3)
            .addGap(105, 105, 105))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lbl_SaveFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(btn_SelectSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addComponent(btn_LoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
            .addComponent(jLabel6)
            .addGap(36, 36, 36))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addComponent(jLabel3)
            .addGap(45, 45, 45)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel8)
               .addComponent(lbl_SaveFile)
               .addComponent(btn_SelectSaveFile))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                  .addComponent(btn_LoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(31, 31, 31))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                  .addComponent(jLabel6)
                  .addGap(22, 22, 22))))
      );

      lbl_Error.setBackground(new java.awt.Color(255, 0, 0));
      lbl_Error.setForeground(new java.awt.Color(255, 0, 0));
      lbl_Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lbl_Error.setText("");

      jLabel2.setFont(new java.awt.Font("Open Sans", 0, 80)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(254, 254, 254));
      jLabel2.setText("COMBAT TOOL");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2)
            .addGap(218, 218, 218))
         .addGroup(layout.createSequentialGroup()
            .addGap(48, 48, 48)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(43, 43, 43))
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(207, 207, 207)
                  .addComponent(lbl_Error, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(432, 432, 432)
                  .addComponent(jLabel1)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(lbl_Error)
            .addContainerGap(27, Short.MAX_VALUE))
      );
   }
}
