package br.puc.molic.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TransferData;

public class GalleryDropTargetListener extends DiagramDropTargetListener {

	public GalleryDropTargetListener(EditPartViewer viewer) {
		super(viewer, LocalSelectionTransfer.getTransfer());
	}

    protected Object getJavaObject(TransferData data) {
        return LocalSelectionTransfer.getTransfer().nativeToJava(data);
    }

    @Override
    protected List getObjectsBeingDropped() {
        /*  Get the selection from the transfer agent */
        List fileList = new ArrayList();
        
        fileList.add(LocalSelectionTransfer.getTransfer().getSelection());
       
        //System.out.println("ObjectsBeingDropped:"+fileList);
       
        if (fileList.size() > 0)
            return fileList;
       
        return null;
    }
/*
	@Override
	protected void handleDrop() {
		DiagramEditor editor = (DiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
		CreateViewRequest createRequest = CreateViewRequestFactory.getCreateShapeRequest(MolicElementTypes.Sketch_3001,editor.getDiagramEditPart().getDiagramPreferencesHint());
		//System.out.println(createRequest.getNewObject());
		
		createRequest.setLocation(getDropLocation());
		
		
		Command c = getTargetEditPart().getCommand(createRequest);
		//getViewer().getEditDomain().getCommandStack().execute(c);
		
		

		super.handleDrop();
	}
*/
	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener#
	 * createTargetRequest()
	 */
	/**
	 * Overrides the default request creation by adding it a MOVE operation in
	 * case that the selection is valid. FIXME if only I knew why this is needed
	 * !!!!!
	 */
	@Override
	protected Request createTargetRequest() {
		DropObjectsRequest req = (DropObjectsRequest) super
				.createTargetRequest();
		req.setRequiredDetail(DND.DROP_COPY);
		
		return req;
	}
}