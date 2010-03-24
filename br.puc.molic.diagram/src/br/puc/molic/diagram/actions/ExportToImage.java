package br.puc.molic.diagram.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

import br.puc.molic.BRTUtterance;
import br.puc.molic.Scene;
import br.puc.molic.UbiquitousAccess;
import br.puc.molic.Utterance;
import br.puc.molic.diagram.SaveDialog;
import br.puc.molic.diagram.edit.parts.DiagramEditPart;
import br.puc.molic.diagram.part.MolicDiagramEditor;
import br.puc.molic.diagram.part.MolicDiagramEditorPlugin;


/**
 * 
 * 
 * @author ugo
 *
 */
public class ExportToImage implements IWorkbenchWindowActionDelegate {

   
	protected String filename = "";
	
	protected ImageFileFormat format = null;
	
	private IWorkbenchWindow window;
	
    public void init(IWorkbenchWindow window) {
    	this.window = window;       	
    }

    public void run(IAction action) {       
    	  MolicDiagramEditor editor = (MolicDiagramEditor)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
          DiagramEditPart diagram = (DiagramEditPart) editor.getDiagramEditPart();
             
          SaveDialog dlg = new SaveDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), filename);
          String path = dlg.open();
          
          CopyToImageUtil util = new CopyToImageUtil();
          
          
          try {
  			util.copyToImage(diagram,new Path(path),format,new NullProgressMonitor());
  		
          } catch (CoreException e) {
  			e.printStackTrace();
  		  } 
        
    }
      
    
    public void selectionChanged(IAction action, ISelection selection) {}

    public void dispose() {}
}