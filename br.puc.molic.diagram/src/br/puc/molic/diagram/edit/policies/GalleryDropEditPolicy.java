package br.puc.molic.diagram.edit.policies;

import java.io.File;
import java.util.Iterator;



import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;


public class GalleryDropEditPolicy extends DragDropEditPolicy {

	public GalleryDropEditPolicy() {
		super();
	}

	protected Command getDropObjectsCommand(DropObjectsRequest request) {
		CompositeCommand cm = new CompositeCommand("Drop Objects Command");
		
		System.out.println(request.getObjects());
		Iterator elements = request.getObjects().iterator();
		while (elements.hasNext()) {
			Object obj = elements.next();

			if (obj instanceof IFile) {
				ICommand cmd = getDropFileCommand((IFile) obj);
				if (cmd != null)
					cm.add(cmd);

			}

		}

		return new ICommandProxy(cm);
	}

	protected ICommand getDropFileCommand(IFile file) {
		
		IGraphicalEditPart host = (IGraphicalEditPart) getHost();
		EObject element = host.resolveSemanticElement();
		String filePath = file.getLocationURI().getPath().toString();
		
		
		SetRequest request = new SetRequest(element, null, new File(filePath));
		
		
		
		return new SetValueCommand(request);
		//return null;
	}

}
