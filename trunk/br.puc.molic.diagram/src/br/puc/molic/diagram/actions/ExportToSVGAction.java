package br.puc.molic.diagram.actions;

import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;


/**
 * 
 * 
 * @author ugo
 *
 */
public class ExportToSVGAction extends ExportToImage {

  
    public void init(IWorkbenchWindow window) {}

    public void run(IAction action) {       
        filename = "diagram.svg";
        format = ImageFileFormat.SVG;
        
    	super.run(action);    	
    }

    
    public void selectionChanged(IAction action, ISelection selection) {}

    public void dispose() {}
}