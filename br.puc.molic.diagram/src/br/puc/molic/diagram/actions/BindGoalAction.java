package br.puc.molic.diagram.actions;

import java.util.Iterator;

import org.eclipse.draw2d.FrameBorder;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import br.puc.molic.Connection;
import br.puc.molic.Element;



public class BindGoalAction implements IObjectActionDelegate {

    boolean DEBUG = true;
    
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
       //System.out.println("binding "+mySelectedElements);
       Iterator it = mySelectedElements.iterator();
       while(it.hasNext()) {
          
           
           Object o = it.next();
           if(o instanceof ShapeNodeEditPart) {
               ShapeNodeEditPart n = (ShapeNodeEditPart) o;
               Element e = (Element)((NodeImpl)n.getModel()).basicGetElement();
               if(DEBUG)System.out.println(e.getID());
               
               /*Color c = new Color(n.getFigure().getForegroundColor().getDevice(),200,0,0);
               org.eclipse.draw2d.LineBorder border = new LineBorder();
               border.setWidth(2);
               n.getFigure().setBorder(border);
               */
              
           }else {
               ConnectionNodeEditPart n = (ConnectionNodeEditPart) o;  

               
               Connection e = (Connection)((EdgeImpl)n.getModel()).basicGetElement();
               if(DEBUG)System.out.println(e.getID());
               /*
               org.eclipse.draw2d.LineBorder border = new LineBorder();
               border.setWidth(2);
               n.getFigure().setBorder(border);
               */
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
