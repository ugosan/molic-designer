package br.puc.molic.diagram.part;

import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

public class GalleryDropTargetListener extends DiagramDropTargetListener {

	public GalleryDropTargetListener(EditPartViewer viewer) {
		super(viewer, LocalSelectionTransfer.getInstance());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener#
	 * getObjectsBeingDropped()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List getObjectsBeingDropped() {
		ISelection selection = LocalSelectionTransfer.getInstance()
				.getSelection();
		if (selection instanceof IStructuredSelection) {
			return ((IStructuredSelection) selection).toList();
		}
		System.out.println(selection);
		return null;
	}

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