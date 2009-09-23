/*
 * Teste de nota de copyright do Molic
 */
package br.puc.molic.diagram.application;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import br.puc.molic.diagram.views.GoalsView;

/**
 * @generated
 */
public class DiagramEditorPerspective implements IPerspectiveFactory {
	/**
	 * @generated false
	 */
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout
				.addPerspectiveShortcut(DiagramEditorWorkbenchAdvisor.PERSPECTIVE_ID);
		IFolderLayout right = layout.createFolder(
				"right", IPageLayout.RIGHT, 0.6f, layout.getEditorArea()); //$NON-NLS-1$
		right.addView(IPageLayout.ID_OUTLINE);
		right.addView("br.puc.molic.diagram.views.GoalsView");
		right.addView("br.puc.molic.diagram.views.GalleryView");

		IFolderLayout bottomRight = layout.createFolder(
				"bottomRight", IPageLayout.BOTTOM, 0.6f, "right"); //$NON-NLS-1$	//$NON-NLS-2$
		bottomRight.addView(IPageLayout.ID_PROP_SHEET);
		bottomRight.addView(IPageLayout.ID_PROBLEM_VIEW);
	}
}
