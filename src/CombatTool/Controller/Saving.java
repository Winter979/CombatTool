/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-11 02:31:05
* @Last Modified: 2017-10-12 10:39:12
* @Purpose:    To Save and load a saveState through serialization
*/

package CombatTool.Controller;

import CombatTool.Exceptions.GameLoadException;
import CombatTool.Exceptions.GameSaveException;
import CombatTool.Exceptions.InvalidSaveFileException;
import CombatTool.Model.SaveState;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Saving
{
   private final JFileChooser fileChooser; //The fileChooser to select a save file

   public Saving()
   {
      fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      fileChooser.setPreferredSize(new Dimension(800, 500));
   }
      
   /** Save a savestate with inported filename */
   public void saveGame(SaveState saveState, String filename) throws GameSaveException
   {
      FileOutputStream fileStrm = null;
      ObjectOutputStream objStrm = null;
      try
      {
         /** Can only select a location, cannot select other files */
         fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         fileChooser.setAcceptAllFileFilterUsed(false);

         int returnVal = fileChooser.showOpenDialog(null);

         if(returnVal == JFileChooser.APPROVE_OPTION)
         {
            String directory = fileChooser.getSelectedFile().getPath();
            
            fileStrm = new FileOutputStream(directory + "/" + filename);
            objStrm = new ObjectOutputStream(fileStrm);

            /** Write saveState to file */
            objStrm.writeObject(saveState);
            objStrm.close();
            fileStrm.close();
         }
      }
      catch (IOException e)
      {
         throw new GameSaveException("Unable to save game to file '" + filename +"'");
      }
   }

   /** Load a saveState object through de-serialization */
   public SaveState loadGame(File saveFile) throws GameLoadException
   {
      FileInputStream fileStrm = null;
      ObjectInputStream objStrm = null;
      SaveState saveState = null;

      try
      {
         String filename = saveFile.getName();


         /** Check that file ends with correct extension */
         if(!filename.endsWith(".sve"))
            throw new InvalidSaveFileException("File: " + filename + " is not a .sve file");
         
         fileStrm = new FileInputStream(saveFile); 
         objStrm = new ObjectInputStream(fileStrm);

         /** Read saveState from file */
         saveState = (SaveState)objStrm.readObject(); 
         objStrm.close();
         fileStrm.close();

         if(saveState == null)
            throw new GameLoadException();
      }
      catch (ClassNotFoundException | IOException e)
      {
         throw new GameLoadException("Error loading file '"+saveFile.getName()+"'. Try another one. ");
      }
      catch(InvalidSaveFileException e)
      {
         throw new GameLoadException(e.getMessage());
      }

      return saveState;
   }
}