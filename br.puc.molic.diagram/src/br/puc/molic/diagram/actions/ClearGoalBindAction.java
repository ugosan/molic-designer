package br.puc.molic.diagram.actions;

import java.util.Iterator;

import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class ClearGoalBindAction implements IObjectActionDelegate {

    /**
     * @generated
     */
    private IStructuredSelection mySelectedElements;

    /**
     * @generated
     */
    private Shell myShell;

    /**
     * @generated
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        myShell = targetPart.getSite().getShell();
    }

    /**
     * @generated
     */
    public void run(IAction action) {
       System.out.println("binding "+mySelectedElements);
       Iterator it = mySelectedElements.iterator();
       while(it.hasNext()) {
           Object o = it.next();
           if(o instanceof NodeImpl) {
               NodeImpl n = (NodeImpl) o;
           
           }else {
               EdgeImpl n = (EdgeImpl) o;
           }
           
       }
    }

    /**
     * @generated
     */
    public void selectionChanged(IAction action, ISelection selection) {
       
        mySelectedElements = null;
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            mySelectedElements = structuredSelection;
        }
        //System.out.println(selection);
        action.setEnabled(isEnabled());
         
         
    }

    /**
     * @generated
     */
    private boolean isEnabled() {
        return mySelectedElements != null;
    }

}
