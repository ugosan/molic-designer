package br.puc.molic.diagram.views;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Shape;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import br.puc.molic.Connection;
import br.puc.molic.Diagram;
import br.puc.molic.Element;
import br.puc.molic.MolicPackage;
import br.puc.molic.diagram.part.MolicDiagramEditor;
import br.puc.molic.diagram.part.MolicDiagramEditorPlugin;



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
	private Action newGoal;
	private Action remove;
	private Action doubleClickAction;
	
	private DiagramEditor activeEditor;
	private IStructuredSelection selectedGoals;

	
	private IWorkbenchPartReference activeRef;
	
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
		table.setLinesVisible(true);

		
		
		viewer = new CheckboxTableViewer(table);		
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(null);
		viewer.addCheckStateListener(new ICheckStateListener(){
	           public void checkStateChanged(CheckStateChangedEvent e)
	           {

	               highlightChecked();
	           }
		});
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				selectedGoals = (IStructuredSelection) event.getSelection();
			   
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

	public List<String> getCheckedGoals(){
		List<String> list = new ArrayList<String>(); 
		
		for(int i=0;i<viewer.getCheckedElements().length;i++){
			list.add(""+viewer.getCheckedElements()[i]);
		}
		
		return list;
	}
	
	public void highlightChecked(){
		List<String> list = getCheckedGoals();
		
		clearHighlighted();
		
		Iterator it = activeEditor.getDiagramEditPart().getChildren().iterator();
	    while(it.hasNext()){
	    	ShapeNodeEditPart n = (ShapeNodeEditPart) it.next();
	    	
            Element e = (Element)((NodeImpl)n.getModel()).basicGetElement();
            Iterator<String> goals = e.getGoals().iterator();
            while(goals.hasNext()){
            	String goal = goals.next();
            	if(list.contains(goal)){
            		 Shape s = (Shape)n.getFigure().getChildren().get(0);
                	  
                     s.setLineWidth(3);            	  
                     s.setForegroundColor(DiagramColorConstants.red);                     
            	}            	
            }

           
           
	    }
	    
	    it = activeEditor.getDiagramEditPart().getConnections().iterator();
	    while(it.hasNext()){
	    	ConnectionNodeEditPart n = (ConnectionNodeEditPart) it.next();  

	    	
			
	    	Connection e = (Connection)((EdgeImpl)n.getModel()).basicGetElement();
            Iterator<String> goals = e.getGoals().iterator();
            while(goals.hasNext()){
            	String goal = goals.next();
            	if(list.contains(goal)){
            		PolylineConnectionEx s = (PolylineConnectionEx)n.getFigure();
        			s.setLineWidth(3);               
        			s.setForegroundColor(DiagramColorConstants.red);                     
            	}            	
            }

           
           
	    }
	    			
	}
	
	public void clearHighlighted(){
		Iterator it = activeEditor.getDiagramEditPart().getChildren().iterator();
	    while(it.hasNext()){
	    	ShapeNodeEditPart n = (ShapeNodeEditPart) it.next();

            Shape s = (Shape)n.getFigure().getChildren().get(0);                	 
            s.setLineWidth(2);            	  
            s.setForegroundColor(DiagramColorConstants.black);                     
  
	    }
	    it = activeEditor.getDiagramEditPart().getConnections().iterator();
	    while(it.hasNext()){
	    	ConnectionNodeEditPart n = (ConnectionNodeEditPart) it.next();  

            PolylineConnectionEx s = (PolylineConnectionEx)n.getFigure();
            s.setLineWidth(1);               
        	s.setForegroundColor(DiagramColorConstants.black);                     

	    }
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
		manager.add(newGoal);		
		manager.add(remove);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(newGoal);
		manager.add(remove);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(newGoal);
		manager.add(remove);
	}

	private void makeActions() {
		newGoal = new Action() {
			public void run() {
			   
				Diagram d = (Diagram) ((DiagramImpl)activeEditor.getDiagramEditPart().getModel()).basicGetElement();

				EAttribute feature = MolicPackage.eINSTANCE.getDiagram_Goals();

				
				List list = new ArrayList(d.getGoals());
				ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
						MolicDiagramEditorPlugin.getInstance()
								.getItemProvidersAdapterFactory());
				
				FeatureEditorDialog dialog = new FeatureEditorDialog(
						getSite().getShell(), labelProvider,
						d, feature,"Goals",null);
																	
				if (dialog.open() == Window.OK) {

					list.addAll(dialog.getResult());
						
					activeEditor.getEditingDomain().getCommandStack().execute(SetCommand.create(activeEditor.getEditingDomain(), d, feature , list));
					setInput(activeRef);					
				}

				/*
				 
			    Iterator it = activeEditor.getDiagramEditPart().getChildren().iterator();
			    while(it.hasNext()){
			    	ShapeNodeEditPart n = (ShapeNodeEditPart) it.next();
			    	
		            Element e = (Element)((NodeImpl)n.getModel()).basicGetElement();
		            Iterator<String> goals = e.getGoals().iterator();
		            while(goals.hasNext()){
		            	String goal = goals.next();
		            	System.out.println("i have "+goal);
		            	System.out.println(selectedGoals.toList().indexOf(goal));
		            }
		            
		           // Shape s = (Shape)n.getFigure().getChildren().get(0);
		            	  
		            //s.setLineWidth(3);            	  
		           // s.setForegroundColor(DiagramColorConstants.red);
			    }
			    
			    it = activeEditor.getDiagramEditPart().getConnections().iterator();
			    while(it.hasNext()){
			    	//System.out.println(it.next());
			    	
			    }
			    
			    */
				
				
			}
		};
		newGoal.setText("New Goal");
		newGoal.setToolTipText("Adds a new goal");
		
		newGoal.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
		
		remove = new Action() {
			public void run() {
				Diagram d = (Diagram) ((DiagramImpl)activeEditor.getDiagramEditPart().getModel()).basicGetElement();
				
				List list = new ArrayList(d.getGoals());				
				list.removeAll(selectedGoals.toList());
					
				MessageBox messageBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING | SWT.YES | SWT.NO);
		        
		        messageBox.setText("Remove Goal");
		        
		        messageBox.setMessage("Are you sure to delete the selected goals?");
		        	        
		        if(messageBox.open() == SWT.YES){
		        	EAttribute feature = MolicPackage.eINSTANCE.getDiagram_Goals();
					activeEditor.getEditingDomain().getCommandStack().execute(SetCommand.create(activeEditor.getEditingDomain(), d, feature , list));
					setInput(activeRef);
		        }

			}
		};
		remove.setText("Remove");
		remove.setToolTipText("Remove the selected goal");
		remove.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
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
		setInput(partRef);
	}
	
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		setInput(partRef);
	}
	
	public void partClosed(IWorkbenchPartReference partRef) {
		//viewer.setInput(null);
	}

	
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub		
	}

	public void partHidden(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	public void partInputChanged(IWorkbenchPartReference partRef) {
		setInput(partRef);
	}

	public void partOpened(IWorkbenchPartReference partRef) {
		setInput(partRef);
	}

	public void partVisible(IWorkbenchPartReference partRef) {
		setInput(partRef);
	}

	private void setInput(IWorkbenchPartReference partRef){
		if(partRef.getPart(false) instanceof MolicDiagramEditor){
			MolicDiagramEditor editor = (MolicDiagramEditor) partRef.getPart(false);			
			viewer.setInput(editor.getDiagramEditPart().getDiagramView().getElement());
			activeEditor = editor;
			activeRef = partRef;
		}
	}


	/**
	 * This class validates a String. It makes sure that the String is between 5 and 8
	 * characters
	 */
	class LengthValidator implements IInputValidator {
	  /**
	   * Validates the String. Returns null for no error, or an error message
	   * 
	   * @param newText the String to validate
	   * @return String
	   */
	  public String isValid(String newText) {
	    int len = newText.length();

	    // Determine if input is too short or too long
	    if (len < 1) return "Too short";
	    
	    // Input must be OK
	    return null;
	  }
	}

	
}