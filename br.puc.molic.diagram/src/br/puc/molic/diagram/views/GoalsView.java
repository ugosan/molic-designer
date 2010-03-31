package br.puc.molic.diagram.views;


import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.Shape;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.NoteAttachmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
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
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

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

public class GoalsView extends ViewPart implements IPartListener2, EditPartListener{
	private CheckboxTableViewer viewer;
	private Action highlight;
	private Action newGoal;
	private Action remove;
	private Action runGoal;
	private Action help;
	
	private Action changeColor;
	
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
			return null; //PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
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
		Table table = new Table(parent, SWT.CHECK | SWT.BORDER | SWT.MULTI);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		
		
		viewer = new CheckboxTableViewer(table);		
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(null);
		viewer.addCheckStateListener(new ICheckStateListener(){
			public void checkStateChanged(CheckStateChangedEvent ev)
			{

				if(ev.getChecked()){
					String goal = (String) ev.getElement();

					EditingDomain eDomain = activeEditor.getEditingDomain();

					
					Iterator it = activeEditor.getDiagramEditPart().getPrimaryEditParts().iterator();
					while(it.hasNext()) {

						EditPart o = (EditPart)it.next();

						if(o.getSelected()>0){

							if(o instanceof ShapeNodeEditPart) {
								ShapeNodeEditPart n = (ShapeNodeEditPart) o;
								Element e = (Element)((NodeImpl)n.getModel()).basicGetElement();

								EAttribute feature = MolicPackage.eINSTANCE.getElement_Goals();

								eDomain.getCommandStack().execute(SetCommand.create(eDomain, e, feature , getCheckedGoals()));

							}else{
								ConnectionNodeEditPart n = (ConnectionNodeEditPart) o;  


								Connection e = (Connection)((EdgeImpl)n.getModel()).basicGetElement();
								EAttribute feature = MolicPackage.eINSTANCE.getConnection_Goals();

								eDomain.getCommandStack().execute(SetCommand.create(eDomain, e, feature , getCheckedGoals()));


							}
						}
					}
				}

				highlightSelected();
			}
		});
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				selectedGoals = (IStructuredSelection) event.getSelection();
				highlightSelected();
				
				if(selectedGoals.size()>0){
					runGoal.setEnabled(true);
	        		remove.setEnabled(true);
				}else{
					runGoal.setEnabled(false);
	        		remove.setEnabled(false);
				}
				
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
	
	protected List<ShapeNodeEditPart> getNodes(String goal){
		ArrayList<ShapeNodeEditPart> l = new ArrayList<ShapeNodeEditPart>();
		
		Iterator it = activeEditor.getDiagramEditPart().getChildren().iterator();
	    while(it.hasNext()){
	    	ShapeNodeEditPart n = (ShapeNodeEditPart) it.next();
	    	
            Element e = (Element)((NodeImpl)n.getModel()).basicGetElement();
            Iterator<String> goals = e.getGoals().iterator();
            while(goals.hasNext()){
            	String g = goals.next();
            	if(g.equals(goal)){
            		l.add(n);                   
            	}            	
            }
	    }
	    return l;
	}
	
	protected List<ConnectionNodeEditPart> getConnections(String goal){
		ArrayList<ConnectionNodeEditPart> l = new ArrayList<ConnectionNodeEditPart>();
		
		Iterator it = activeEditor.getDiagramEditPart().getConnections().iterator();
		    while(it.hasNext()){
		    	ConnectionNodeEditPart n = (ConnectionNodeEditPart) it.next();  
		    				
		    	Connection e = (Connection)((EdgeImpl)n.getModel()).basicGetElement();
	            Iterator<String> goals = e.getGoals().iterator();
	            while(goals.hasNext()){
	            	String g = goals.next();
	            	if(g.equals(goal)){
	            		l.add(n);                     
	            	}            	
	            }
		    }
		return l;
	}

	
	public void highlightSelected(){
		if(highlight.isChecked()){

			clearHighlighted();

			Iterator<String> goals = selectedGoals.iterator();
			while(goals.hasNext()){
				String goal = goals.next();

				List<ShapeNodeEditPart> nodesWithGoal = getNodes(goal);
				List<ConnectionNodeEditPart> connectionsWithGoal = getConnections(goal);

				for(int i=0;i<nodesWithGoal.size();i++){

					if(nodesWithGoal.get(i).getFigure().getChildren().get(0) instanceof Shape){
						Shape s = (Shape)nodesWithGoal.get(i).getFigure().getChildren().get(0);          	  
						s.setLineWidth(3);            	  
						s.setForegroundColor(DiagramColorConstants.darkBlue);  
					}
				}

				for(int i=0;i<connectionsWithGoal.size();i++){

					PolylineConnectionEx s = (PolylineConnectionEx)connectionsWithGoal.get(i).getFigure();
					s.setLineWidth(3);               
					s.setForegroundColor(DiagramColorConstants.darkBlue);  
				}


			}

		}

	}
	
	public void clearHighlighted(){
		Iterator it = activeEditor.getDiagramEditPart().getChildren().iterator();
	    while(it.hasNext()){
	    	ShapeNodeEditPart n = (ShapeNodeEditPart) it.next();
	    	
	    	if(n.getFigure().getChildren().get(0) instanceof Shape){
	    		Shape s = (Shape)n.getFigure().getChildren().get(0);                	 
	    		s.setLineWidth(2);            	  
	    		s.setForegroundColor(DiagramColorConstants.black);                     
	    	}
	    }
	    it = activeEditor.getDiagramEditPart().getConnections().iterator();
	    while(it.hasNext()){
	    	ConnectionNodeEditPart n = (ConnectionNodeEditPart) it.next();  

            PolylineConnectionEx s = (PolylineConnectionEx)n.getFigure();
            s.setLineWidth(1);               
        	s.setForegroundColor(DiagramColorConstants.black);                  
        	
        	//get model from note attachments causes NullPointerException
        	if(!(n instanceof NoteAttachmentEditPart)){
        		if(((EdgeImpl)n.getModel()).basicGetElement().eClass() == MolicPackage.eINSTANCE.getBRTUtterance()){        		
        			//Breakdowns have thicker lines
        			s.setLineWidth(2);
        		}
        	}

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
		//fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}
/*
	private void fillLocalPullDown(IMenuManager manager) {
		//manager.add(newGoal);		
		manager.add(remove);
		manager.add(new Separator());
		manager.add(runGoal);
		manager.add(new Separator());
		manager.add(help);
	}
	*/

	private void fillContextMenu(IMenuManager manager) {
		manager.add(runGoal);
		manager.add(remove);		
		manager.add(new Separator());		
		manager.add(changeColor);

		
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {		
		manager.add(newGoal);
		manager.add(remove);
		manager.add(new Separator());
		manager.add(highlight);
		manager.add(new Separator());
		manager.add(runGoal);
		manager.add(new Separator());
		manager.add(help);
	}

	private void makeActions() {
		highlight = new Action("Highlight", Action.AS_CHECK_BOX ){
			public void run() {
				if(this.isChecked()){
					highlightSelected();
				}else{
					clearHighlighted();
				}
			}
		};
		highlight.setToolTipText("On/Off Goal Highlighing");
		highlight.setImageDescriptor(getImage("/icons/highlight.png"));
		highlight.setChecked(true);
		
		
		newGoal = new Action("New Goal") {
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
				
			}
		};		
		newGoal.setToolTipText("Adds a new goal");
		
		newGoal.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
		
		remove = new Action("Remove") {
			public void run() {
				Diagram d = (Diagram) ((DiagramImpl)activeEditor.getDiagramEditPart().getModel()).basicGetElement();
							
				List list = new ArrayList(d.getGoals());
				List goalsToRemove = new ArrayList(selectedGoals.toList());
				
				list.removeAll(goalsToRemove);
					
				
				
				MessageBox messageBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING | SWT.YES | SWT.NO);
		        
		        messageBox.setText("Remove Goal");
		        
		        messageBox.setMessage("Are you sure to delete the selected goals?");
		        	        
		        if(messageBox.open() == SWT.YES){
		        	removeGoalFromElements(goalsToRemove);
		        	EAttribute feature = MolicPackage.eINSTANCE.getDiagram_Goals();
					activeEditor.getEditingDomain().getCommandStack().execute(SetCommand.create(activeEditor.getEditingDomain(), d, feature , list));
					setInput(activeRef);
					
		        }

			}
		};		
		remove.setToolTipText("Remove the selected goal");
		remove.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		
		runGoal = new Action() {
			public void run() {
				
				if((selectedGoals.size()!=0)&&(selectedGoals.size()>1)){
				
					MessageBox messageBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING | SWT.OK);
			        
			        messageBox.setText("Sorry");
			        
			        messageBox.setMessage("It's only possible to run one goal on each simulation. \n Please select just one goal");
			        	        
			        messageBox.open(); 

				}else{
					String goal = (String) selectedGoals.getFirstElement();
					//Iterator<String> goals = checkedGoals.iterator();
				
					RunGoal r = new RunGoal();
					r.run(getNodes(goal),getConnections(goal));
				}
			}
		};
		runGoal.setText("Run");
		runGoal.setToolTipText("Run the selected goal");
		runGoal.setImageDescriptor(getImage("/icons/run.gif"));
		
		help = new Action() {
			public void run() {
				showMessage("This will have help content");

			}
		};
		help.setText("Help");
		help.setToolTipText("Help");
		help.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_LCL_LINKTO_HELP));
		
		
		changeColor = new Action() {
			public void run() {
				

			}
		};
				
		changeColor.setText("Change Highlight Color");			
		changeColor.setImageDescriptor(getImage("/icons/changecolor.gif"));
		

		
		doubleClickAction = new Action() {
			public void run() {
				//ISelection selection = viewer.getSelection();
				//Object obj = ((IStructuredSelection)selection).getFirstElement();
				//showMessage("Double-click detected on "+obj.toString());
			}
		};
		
		runGoal.setEnabled(false);
		remove.setEnabled(false);
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

	public ImageDescriptor getImage(String p) {
		
		Bundle bundle = Platform.getBundle("br.puc.molic.diagram");
		IPath path = new Path(p);
		URL imageUrl = FileLocator.find(bundle, path, null);
		
		return  ImageDescriptor.createFromURL(imageUrl);
	}

	
	private void removeGoalFromElements(List<String> goals){
		
		Diagram d = (Diagram) ((DiagramImpl)activeEditor.getDiagramEditPart().getModel()).basicGetElement();
		EditingDomain eDomain = activeEditor.getEditingDomain();
		
		Iterator<Element> elements = d.getElement().iterator();
		while(elements.hasNext()){
			Element e = elements.next();
						
			List<String> list = new ArrayList<String>(e.getGoals());
			list.removeAll(goals);
						
			EAttribute feature = MolicPackage.eINSTANCE.getElement_Goals();

			eDomain.getCommandStack().execute(SetCommand.create(eDomain, e, feature , list));

		}
		
		Iterator<Connection> connections = d.getUtterance().iterator();
		while(connections.hasNext()){
			Connection c = connections.next();
			List<String> list = new ArrayList<String>(c.getGoals());
			
			list.removeAll(goals);
						
			EAttribute feature = MolicPackage.eINSTANCE.getConnection_Goals();

			eDomain.getCommandStack().execute(SetCommand.create(eDomain, c, feature , list));
		}

		
		
	}
	
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
		setInput(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePartReference());
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
			MolicDiagramEditor editor = (MolicDiagramEditor) partRef.getPart(true);			
			viewer.setInput(editor.getDiagramEditPart().getDiagramView().getElement());
			activeEditor = editor;
			activeRef = partRef;
			
			//adds listeners to ALL the editparts
			activeEditor.getDiagramEditPart().addEditPartListener(this);
			Iterator it = activeEditor.getDiagramEditPart().getPrimaryEditParts().iterator();
 		   	while(it.hasNext()) {	
 		   		EditPart o = (EditPart)it.next();
				o.addEditPartListener(this);
 		   	}
		}
	}

	@Override
	public void childAdded(EditPart arg0, int arg1) {
		arg0.addEditPartListener(this);		
	}

	@Override
	public void partActivated(EditPart arg0) {
		// TODO Auto-generated method stub
		//System.out.println("active "+arg0);
	}

	@Override
	public void partDeactivated(EditPart arg0) {
		// TODO Auto-generated method stub
		//System.out.println("de-active "+arg0);
	}

	@Override
	public void removingChild(EditPart arg0, int arg1) {
		// TODO Auto-generated method stub
		arg0.removeEditPartListener(this);
	}

	@Override
	public void selectedStateChanged(EditPart arg0) {
		// TODO Auto-generated method stub
		//System.out.println("select change "+arg0.getSelected()+" "+arg0.getModel());
		viewer.setSelection(null);
		//viewer.setAllChecked(false);
		checkGoals(arg0);
		
		
	}


	private void checkGoals(EditPart p){
		Iterator<String> goals = null;
		if(p instanceof ShapeNodeEditPart){
	    	
            Element e = (Element)((NodeImpl)p.getModel()).basicGetElement();
            goals = e.getGoals().iterator();
		}else if(p instanceof ConnectionNodeEditPart){
			Connection e = (Connection)((EdgeImpl)p.getModel()).basicGetElement();
            goals = e.getGoals().iterator();           
		}
		
		if(goals!=null)
		while(goals.hasNext()){
            String goal = goals.next();
            viewer.setChecked(goal, true);
        }
		
	}
	
	
	
}