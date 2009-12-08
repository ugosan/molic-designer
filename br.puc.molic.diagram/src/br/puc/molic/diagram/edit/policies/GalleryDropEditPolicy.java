package br.puc.molic.diagram.edit.policies;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RefreshConnectionsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.util.INotationType;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.PlatformUI;

import br.puc.molic.MolicFactory;
import br.puc.molic.MolicPackage;
import br.puc.molic.Scene;
import br.puc.molic.Sketch;
import br.puc.molic.diagram.edit.parts.SketchEditPart;
import br.puc.molic.diagram.providers.MolicElementTypes;


public class GalleryDropEditPolicy extends DragDropEditPolicy {

	public GalleryDropEditPolicy() {
		super();
	}

	protected Command getDropObjectsCommand(DropObjectsRequest request) {
		
		CompoundCommand command = null;
		if(request.getObjects()!=null){

			Iterator elements = request.getObjects().iterator();
			
			while (elements.hasNext()) {
				Object obj = elements.next();
			
				if(obj instanceof StructuredSelection){
					try{
					StructuredSelection s = (StructuredSelection)obj;					
					final File f = (File)s.getFirstElement();
					
					
					final DiagramEditor editor = (DiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					/* funcionando 
					CreateViewRequest createRequest = createViewRequest(MolicElementTypes.Sketch_3001,editor.getDiagramEditPart().getDiagramPreferencesHint());					
					createRequest.setLocation(request.getLocation());
				
					command = new CompoundCommand();
					Command createSketch = getHost().getCommand(createRequest);
					
					command.add(createSketch);
					  */
					
					command = new CompoundCommand();
					final Sketch sketch = MolicFactory.eINSTANCE.createSketch();
					sketch.eSet(MolicPackage.Literals.SKETCH__IMAGE, f.getAbsolutePath());
					ArrayList<Sketch> list = new ArrayList<Sketch>();
					list.add(sketch);
					
					CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(
							new EObjectAdapter(sketch), Node.class, ((IHintedType)MolicElementTypes.Sketch_3001).getSemanticHint(), true,
							editor.getDiagramEditPart().getDiagramPreferencesHint()); 
					viewDescriptor.setPersisted(true);
					
					CreateViewRequest createRequest = new CreateViewRequest(viewDescriptor);

					
					
					Command c = new Command(){

						@Override
						public void execute() {
							AbstractEMFOperation emfOp = new AbstractEMFOperation(editor.getEditingDomain(), "Location setting") {

						@Override
						protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							NodeImpl n = (NodeImpl)getHost().getParent().getModel();
							Scene s = (Scene) n.basicGetElement();
							s.getSketch().add(sketch);
							
							return Status.OK_STATUS;
						}

					};

				
					try {
						OperationHistoryFactory.getOperationHistory().execute(emfOp, null, null);
					} catch (ExecutionException e) {}
					}
					};
					
					command.add(c);
					command.add(getHost().getCommand(createRequest));
					
					/*
					Sketch sketch = MolicFactory.eINSTANCE.createSketch();
					sketch.eSet(MolicPackage.Literals.SKETCH__IMAGE, f.getAbsolutePath());

					CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(
		                    new EObjectAdapter(sketch), Node.class,  ((IHintedType)MolicElementTypes.Sketch_3001).getSemanticHint(), true,
		                    editor.getDiagramEditPart().getDiagramPreferencesHint()); 
					
					CreateViewRequest req = new CreateViewRequest(viewDescriptor);
					command = new CompoundCommand();
					command.add(getHost().getCommand(req));
					
					ArrayList<Sketch> list = new ArrayList<Sketch>();
					list.add(sketch);
					
					//SetRequest sreq = new SetRequest(
					
					SetCommand operation3 = new SetCommand(editor.getEditingDomain(),(EObject)getHost().getModel(),MolicPackage.Literals.SCENE__SKETCH,list);
					//command.add(new ICommandProxy(operation3));
					operation3.execute();*/
					//editor.getDiagramEditDomain().getDiagramCommandStack().execute(operation3);
					
					//SetCommand setCommand = new SetCommand(editor.getEditingDomain(),(EObject)getHost().getModel(),MolicPackage.Literals.SCENE__SKETCH,list);
					//setCommand.execute();
					
					//command.add(setCommand);
					/*					
					final Object[] list1 = getHost().getChildren().toArray(); 

					
					
					Command c = new Command(){

						@Override
						public void execute() {
							final Object[] list2 = getHost().getChildren().toArray(); 
							
							for(int i=0;i<list2.length;i++){
								Object o = list2[i];
								boolean match = false;
								for(int j=0;j<list1.length;j++){
									if(list1[j]==o){
										match = true;
									}										
								}
								if(match==false){
									SketchEditPart part = (SketchEditPart)o;
									
									NodeImpl n = (NodeImpl)part.getModel();
									
									n.basicGetElement().eSet(MolicPackage.Literals.SKETCH__IMAGE, f.getAbsolutePath());
									
									
									System.out.println(part.getFigure());
									
								}
							}
							
							
							//super.execute();
						}
						
					};
					command.add(c);
					*/
					
					
					//Command create2 = getHost().getCommand(new CreateElementRequest(MolicElementTypes.Sketch_3001));
					
					
				
					
					// Creating the CreateElementRequestAdapter from the type above
					//CreateElementRequestAdapter elementReqAdapter = new CreateElementRequestAdapter(new CreateElementRequest(MolicElementTypes.Sketch_3001));
					//Sketch sketch = MolicFactory.eINSTANCE.createSketch();
					//sketch.setImage(f.getAbsolutePath());
					//elementReqAdapter.setNewElement(sketch);
					
				
					
				//reateViewRequest req = createViewRequest(MolicElementTypes.Sketch_3001,editor.getDiagramEditPart().getDiagramPreferencesHint()) ;
					 
				//return this.getCreateElementAndViewCommand((CreateViewAndElementRequest)req);
					
					
					
					// Creating the element and view request
					//CreateViewAndElementRequest req = new CreateViewAndElementRequest(MolicElementTypes.Sketch_3001,editor.getDiagramEditPart().getDiagramPreferencesHint());
					//command = new CompoundCommand();
					//Command c = this.getCreateElementAndViewCommand(req);
					//System.out.println(c.canExecute());
					//command.add(c);
					//return c;
					
					
					/*
					DiagramEditor editor = (DiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					
					// Creating the CreateElementRequestAdapter from the type above
					CreateElementRequestAdapter elementReqAdapter = new CreateElementRequestAdapter(new CreateElementRequest(MolicElementTypes.Sketch_3001));
					Sketch sketch = MolicFactory.eINSTANCE.createSketch();
					sketch.setImage(f.getAbsolutePath());
					elementReqAdapter.setNewElement(sketch);
					
					// Creating the View and Element Descriptor
					ViewAndElementDescriptor viewDescriptor = new ViewAndElementDescriptor(elementReqAdapter, editor.getDiagramEditPart().getDiagramPreferencesHint());
					

					// Creating the element and view request
					CreateViewAndElementRequest createRequest = new CreateViewAndElementRequest(viewDescriptor);
					
					//CreateViewRequest createRequest = CreateViewRequestFactory.getCreateShapeRequest(MolicElementTypes.Sketch_3001,editor.getDiagramEditPart().getDiagramPreferencesHint());
					createRequest.setLocation(request.getLocation());

					command = getHost().getCommand(createRequest);
*/
					}catch(Exception e){
						e.printStackTrace();
					}
					//if (cmd != null)
					//	cm.add(cmd);

				}

			}
		}
		return command;
	}
	
	
	public CreateViewRequest createViewRequest(IElementType type, PreferencesHint preferencesHint) {
		if (type instanceof INotationType) {
			ViewDescriptor viewDescriptor = new ViewDescriptor(null,
				Node.class, ((INotationType) type).getSemanticHint(), preferencesHint);
			
			return new CreateViewRequest(viewDescriptor);
		} else if (type instanceof IHintedType) {
			CreateElementRequestAdapter elementReqAdapter = new CreateElementRequestAdapter(new CreateElementRequest(type));
			Sketch sketch = MolicFactory.eINSTANCE.createSketch();
			sketch.eSet(MolicPackage.Literals.SKETCH__IMAGE, "what i want to be able to set");

			elementReqAdapter.setNewElement(sketch);
			
			
			ViewAndElementDescriptor viewDescriptor = new ViewAndElementDescriptor(
			elementReqAdapter,
				Node.class, ((IHintedType) MolicElementTypes.getElementType(SketchEditPart.VISUAL_ID)).getSemanticHint(), preferencesHint);
				

			/*
			ViewAndElementDescriptor viewDescriptor = new ViewAndElementDescriptor(
				//new CreateElementRequestAdapter(new CreateElementRequest(type)),
					elementReqAdapter,Node.class, ((IHintedType) type).getSemanticHint(), preferencesHint);
			*/
			
			
			return new CreateViewAndElementRequest(viewDescriptor);
		} else {
			
			return new CreateViewAndElementRequest(type, preferencesHint);
		}
	}
	
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		// get the element descriptor
		CreateElementRequestAdapter requestAdapter =
			request.getViewAndElementDescriptor().getCreateElementRequestAdapter();

		// get the semantic request
		CreateElementRequest createElementRequest =
			(CreateElementRequest) requestAdapter.getAdapter(
				CreateElementRequest.class);

		if (createElementRequest.getContainer() == null) {
			// complete the semantic request by filling in the host's semantic
			// element as the context
			View view = (View)getHost().getModel();
			EObject hostElement = ViewUtil.resolveSemanticElement(view);

			
			if (hostElement == null && view.getElement() == null) {
				hostElement = view;
			}			

			// Returns null if host is unresolvable so that trying to create a
			// new element in an unresolved shape will not be allowed.
			if (hostElement == null) {
				return null;
			}
			createElementRequest.setContainer(hostElement);
		}

		// get the create element command based on the elementdescriptor's
		// request
		Command createElementCommand =
			getHost().getCommand(
				new EditCommandRequestWrapper(
					(CreateElementRequest)requestAdapter.getAdapter(
						CreateElementRequest.class), request.getExtendedData()));

		
		if (createElementCommand == null) { 
			return UnexecutableCommand.INSTANCE;
		}		
		if(!createElementCommand.canExecute()){
			return createElementCommand;
		}
		// create the semantic create wrapper command
		SemanticCreateCommand semanticCommand =
			new SemanticCreateCommand(requestAdapter, createElementCommand);
		Command viewCommand = getCreateCommand(request);
		
		Command refreshConnectionCommand =
			getHost().getCommand(
				new RefreshConnectionsRequest(((List)request.getNewObject())));


		// form the compound command and return
        CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
		cc.compose(semanticCommand);
		cc.compose(new CommandProxy(viewCommand));
		if ( refreshConnectionCommand != null ) {
			cc.compose(new CommandProxy(refreshConnectionCommand));
		}

		return new ICommandProxy(cc);
	}

	protected Command getCreateCommand(CreateViewRequest request) {

        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
            .getEditingDomain();
        CompositeTransactionalCommand cc = new CompositeTransactionalCommand(
            editingDomain, DiagramUIMessages.AddCommand_Label);
        
        Iterator descriptors = request.getViewDescriptors().iterator();

		while (descriptors.hasNext()) {
			CreateViewRequest.ViewDescriptor descriptor =
				(CreateViewRequest.ViewDescriptor)descriptors.next();

			Sketch sketch = MolicFactory.eINSTANCE.createSketch();
			sketch.eSet(MolicPackage.Literals.SKETCH__IMAGE, "/home/ugo/Icones/combination.png");

			DiagramEditor editor = (DiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(
                    new EObjectAdapter(sketch), Node.class, ((IHintedType) MolicElementTypes
                            .getElementType(SketchEditPart.VISUAL_ID)).getSemanticHint(), true,
                   editor.getDiagramEditPart().getDiagramPreferencesHint()); 
			
			CreateCommand createCommand =
				new CreateCommand(editingDomain,
					viewDescriptor, 
					(View)(getHost().getModel()));

			cc.compose(createCommand);
		}
		
		return new ICommandProxy(cc.reduce());

	}

}
