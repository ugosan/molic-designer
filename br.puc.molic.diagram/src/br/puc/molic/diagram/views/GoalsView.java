package br.puc.molic.diagram.views;


import java.util.List;
import java.util.Properties;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.part.*;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;


import br.puc.molic.Diagram;
import br.puc.molic.MolicFactory;
import br.puc.molic.MolicPackage;
import br.puc.molic.diagram.edit.parts.DiagramEditPart;
import br.puc.molic.diagram.part.MolicDiagramEditor;



/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class GoalsView extends ViewPart implements IPartListener2{
	private CheckboxTableViewer viewer;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	
	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class ViewContentProvider implements IStructuredContentProvider {
	    public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	    	
		}
		public void dispose() {
		}
		 public Object[] getElements(Object parent) {       	         
			 if(parent != null){   				                              
				 return ((Diagram)parent).getGoals().toArray();
	         }
	         return new String[]{""};
		 }
	}
	
	
	
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		public Image getImage(Object obj) {
			return null;//PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public GoalsView() {
		
	}

	public void setContentProvider(IStructuredContentProvider p) {
	    viewer.setContentProvider(p);
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		Table table = new Table(parent, SWT.CHECK | SWT.BORDER );
		table.setHeaderVisible(true);
		table.setLinesVisible(false);
		  
		viewer = new CheckboxTableViewer(table);		
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(null);
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
			    System.out.println(sel.size() + " items selected, " +viewer.getCheckedElements().length + " items checked");
			   }
			  });
		
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "br.puc.molic.diagram.viewer");
		getSite().getPage().addPartListener(this);

		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				GoalsView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
			   
			    
			    
			    GoalsDialog d = new GoalsDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),"llala","lalalal","lalala",null);
			    d.open();
			    /*
			    try {
			    MolicDiagramEditor editor = ( MolicDiagramEditor )PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		        
			    
		        MolicFactory factory = MolicFactory.eINSTANCE;
		        Goal goal = factory.createGoal();
		        goal.setName("aaa");
		        

		        
		        
		        
		        DiagramImpl diagram = (DiagramImpl)((org.eclipse.gmf.runtime.notation.impl.DiagramImpl)editor.getDiagramEditPart().getModel()).basicGetElement();

		        
		        editor.getDiagramEditPart().getEditingDomain().getCommandStack().execute(AddCommand.create(
		                editor.getDiagramEditPart().getEditingDomain(), diagram, MolicPackage.Literals.DIAGRAM__GOAL, goal)); 
		        
		        
			    }catch(Exception e) {
			        e.printStackTrace();
			    }
			    */
			}
		};
		action1.setText("New Goal");
		action1.setToolTipText("Adds a new goal");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("This is supposed to happen..");
			}
		};
		action2.setText("Run");
		action2.setToolTipText("Runs the selected goal");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Goals",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}



	
	public void partActivated(IWorkbenchPartReference partRef) {		
		if(partRef.getPart(false) instanceof MolicDiagramEditor){
			MolicDiagramEditor editor = (MolicDiagramEditor) partRef.getPart(false);
			viewer.setInput(editor.getDiagramEditPart().getDiagramView().getElement()); 						
		}
	}

	
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	
	public void partClosed(IWorkbenchPartReference partRef) {
		viewer.setInput(null);

	}

	
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	public void partHidden(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	public void partInputChanged(IWorkbenchPartReference partRef) {
		if(partRef.getPart(false) instanceof MolicDiagramEditor){
			MolicDiagramEditor editor = (MolicDiagramEditor) partRef.getPart(false);
			viewer.setInput(editor.getDiagramEditPart().getDiagramView().getElement()); 					
		}
	}

	public void partOpened(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	public void partVisible(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}


}