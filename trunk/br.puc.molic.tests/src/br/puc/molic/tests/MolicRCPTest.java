package br.puc.molic.tests;

import junit.framework.TestCase;

import org.eclipse.swtbot.eclipse.finder.SWTBotEclipseTestCase;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
 
/**
 * 
 * This is a sample swtbot testcase for an eclipse application.
 * 
 */
public class MolicRCPTest extends SWTBotEclipseTestCase {
 

	  public void testCreateJavaProject() {
		  
		  
		// Change the perspective via the Open Perspective dialog
		  bot.menu("Window").menu("Open Perspective").menu("Other...").click();
		  SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
		  openPerspectiveShell.activate();
		  

		  bot.table().select("Debug");
		  bot.button("OK").click();
		  
		    try {
		      bot.view("Welcome").close() ;
		    } catch (WidgetNotFoundException e) {
		      fail("Welcome window not found.");
		    }
		 
		    //This will open the the menu File > New > Project wizard
		    bot.menu("File").menu("New").menu("Project...").click();
		    bot.sleep(1000);
		 
		    //Select the java project from the wizard tree.
		    SWTBotTree projectSelectionTree = bot.tree();
		    projectSelectionTree.select("Java Project");
		    bot.sleep(1000);
		 
		    //Click Next button
		    bot.button("Next >").click();
		    bot.sleep(1000);
		 
		    //'com.swtbot.test.project' is the java project name to create
		    bot.textWithLabel("File:").setText("com.swtbot.test.project");
		    bot.sleep(1000);
		 
		    //Click the Finish button
		    bot.button("Finish").click();
		    bot.sleep(1000);
		    
		  //Now the diagram is created and should be opened on the workspace
			

		  }
		 
		  /**
		   * This testcase will set the focus on a view.
		   */
		  public void testFocusView() {
		    try {
		      bot.view("Welcome").close() ;
		    } catch (WidgetNotFoundException e) {
		      fail("Welcome window not found.");
		    }
		 
		    //This will set focus on the Problems view
		    //The view is identified using the title of the view.
		    bot.view("Problems").setFocus();
		 
		    //The sleep command can be used to slow down the testcase 
		    //execution so that you can see it or you can wait for a
		    //background process to complete.
		    bot.sleep(2000);
		  }
		
	}