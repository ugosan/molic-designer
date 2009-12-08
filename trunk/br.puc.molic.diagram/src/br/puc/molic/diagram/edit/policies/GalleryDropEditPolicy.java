package br.puc.molic.diagram.edit.policies;

import java.io.File;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.PlatformUI;

import br.puc.molic.MolicFactory;
import br.puc.molic.MolicPackage;
import br.puc.molic.Scene;
import br.puc.molic.Sketch;
import br.puc.molic.diagram.providers.MolicElementTypes;


public class GalleryDropEditPolicy extends DragDropEditPolicy {

	public GalleryDropEditPolicy() {
		super();
	}

	/**
	 * Creates the Sketch model and view, based on the dropped image
	 */
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
					
					command = new CompoundCommand();
					
					final Sketch sketch = MolicFactory.eINSTANCE.createSketch();
					sketch.eSet(MolicPackage.Literals.SKETCH__IMAGE, f.getAbsolutePath());
					
					CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(
							new EObjectAdapter(sketch), Node.class, ((IHintedType)MolicElementTypes.Sketch_3001).getSemanticHint(), true,
							editor.getDiagramEditPart().getDiagramPreferencesHint()); 
					
					viewDescriptor.setPersisted(true);
					
					CreateViewRequest createRequest = new CreateViewRequest(viewDescriptor);
					createRequest.setLocation(request.getLocation());
				
					Command c = new Command(){

						@Override
						public void execute() {
							AbstractEMFOperation emfOp = new AbstractEMFOperation(editor.getEditingDomain(), "Add sketch model") {

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
					
				
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}

			}
		}
		return command;
	}
		
}
