/*
* @Author:     Jonathon Winter
* @Student ID: 1885 6204
* @Created On: 2017-10-10 22:09:44
* @Last Modified: 2017-10-12 00:10:00
* @File Name:  UI_Controller
* @Purpose:    Interface that all UI Controller will use
*/
 
package CombatTool.Controller;

import CombatTool.View.UI_Panel;

public interface UI_Controller
{
   public void start();
   public void setUI(UI_Panel panel);
}