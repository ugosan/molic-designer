package br.puc.molic.diagram.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Shape;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.IViewDescriptor;

import br.puc.molic.Connection;
import br.puc.molic.Diagram;
import br.puc.molic.Element;
import br.puc.molic.MolicPackage;
import br.puc.molic.diagram.edit.parts.BRTUtteranceEditPart;
import br.puc.molic.diagram.part.MolicDiagramEditor;
import br.puc.molic.diagram.views.GoalsView;



public class BindGoalAction implements IObjectActionDelegate {

	boolean DEBUG = false;
	IWorkbenchPart selectedPart;
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
		selectedPart = targetPart;
		//System.out.println(selectedPart);
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		//System.out.println("binding "+mySelectedElements);

		/*
        Shell dialog = new Shell (myShell.getDisplay(), SWT.DIALOG_TRIM);

    	Table table = new Table(dialog, SWT.CHECK | SWT.BORDER );
    	table.setHeaderVisible(false);
    	table.setLinesVisible(false);

    	CheckboxTableViewer viewer = new CheckboxTableViewer(table);

    	Button okButton = new Button (dialog, SWT.PUSH);
    	okButton.setText ("&OK");
    	Button cancelButton = new Button (dialog, SWT.PUSH);
    	cancelButton.setText ("&Cancel");

    	FormLayout form = new FormLayout ();
    	form.marginWidth = form.marginHeight = 8;
    	dialog.setLayout (form);
    	FormData okData = new FormData ();
    	okData.top = new FormAttachment (table, 8);
    	okButton.setLayoutData (okData);
    	FormData cancelData = new FormData ();
    	cancelData.left = new FormAttachment (okButton, 8);
    	cancelData.top = new FormAttachment (okButton, 0, SWT.TOP);
    	cancelButton.setLayoutData (cancelData);

    	dialog.setDefaultButton (okButton);
    	dialog.pack ();
    	dialog.open ();

    	while (!myShell.getDisplay().isDisposed ()) {
    		if (!myShell.getDisplay().readAndDispatch ()) myShell.getDisplay().sleep ();
    	}
    	//display.dispose ();
		 */

		try{
			MolicDiagramEditor editor = (MolicDiagramEditor)selectedPart;

			Diagram d = (Diagram)editor.getDiagramEditPart().getDiagramView().getElement();
			GoalsView view = (GoalsView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("br.puc.molic.diagram.views.GoalsView");   

			//editor.getSite().getPage().g
			Iterator it = mySelectedElements.iterator();
			while(it.hasNext()) {

				Object o = it.next();
				if(DEBUG) System.out.println(o);
				if(o instanceof ShapeNodeEditPart) {
					ShapeNodeEditPart n = (ShapeNodeEditPart) o;
					Element e = (Element)((NodeImpl)n.getModel()).basicGetElement();



					EAttribute feature = MolicPackage.eINSTANCE.getElement_Goals();
					DiagramEditor activeEditor = (DiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					activeEditor.getEditingDomain().getCommandStack().execute(SetCommand.create(activeEditor.getEditingDomain(), e, feature , view.getCheckedGoals()));


					if(DEBUG)System.out.println(e.getID());


				}else{
					ConnectionNodeEditPart n = (ConnectionNodeEditPart) o;  


					Connection e = (Connection)((EdgeImpl)n.getModel()).basicGetElement();
					EAttribute feature = MolicPackage.eINSTANCE.getConnection_Goals();
					DiagramEditor activeEditor = (DiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					activeEditor.getEditingDomain().getCommandStack().execute(SetCommand.create(activeEditor.getEditingDomain(), e, feature , view.getCheckedGoals()));



					if(DEBUG)System.out.println(e.getID());

				}

			}
			view.highlightChecked();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


	protected Object openDialogBox(){
		/*  InputDialog dialog = new MultiLineInputDialog(myShell,EMFEditUIPlugin.INSTANCE.getString
           ("_UI_FeatureEditorDialog_title", new Object [] { getDisplayName(), getEditLabelProvider().getText(object) }),
         EMFEditUIPlugin.INSTANCE.getString("_UI_MultiLineInputDialog_message"),
         valueHandler.toString(getValue()),
         valueHandler);
      return dialog.open() == Window.OK ? valueHandler.toValue(dialog.getValue()) : null;
		 */
		return null;
	}

	private void changeColor(IGraphicalEditPart part, Color c){
		try {
			ChangePropertyValueRequest req = new ChangePropertyValueRequest( 
					StringStatics.BLANK,Properties.ID_LINECOLOR,FigureUtilities.colorToInteger(c));

			final Command cmd = (Command) part.getCommand(req);

			AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart) part).getEditingDomain(),
					StringStatics.BLANK, null) {
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					cmd.execute();
					return Status.OK_STATUS;
				}
			};


			operation.execute(new NullProgressMonitor(), null);
		} catch (Exception ex) {
			ex.printStackTrace();
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
		//  if(!selection.isEmpty())
		//action.setEnabled(isEnabled());


	}

	/**
	 * @generated
	 */
	private boolean isEnabled() {
		return mySelectedElements != null;
	}

}
