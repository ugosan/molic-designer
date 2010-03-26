/*
 * Teste de nota de copyright do Molic
 */
package br.puc.molic.diagram.application;

import java.io.File;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import br.puc.molic.diagram.part.Messages;

/**
 * @generated
 */
public class DiagramEditorWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	@Override
	public void postWindowClose() {
		// TODO Auto-generated method stub
		super.postWindowClose();
		
		
		this.cleanGalleryTempFiles();

	}

	private void cleanGalleryTempFiles() {
		System.out.println("Cleaning temporary files...");
		
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();

		File dir = myWorkspaceRoot.getLocation().toFile();

		if (!dir.exists()) {
			System.out.println(myWorkspaceRoot.getFullPath().toFile()
					+ " does not exist");
			return;
		}
		String patt = "gallerytemp";

		String[] info = dir.list();
		for (int i = 0; i < info.length; i++) {
			File n = new File(dir + dir.separator + info[i]);
			if (!n.isFile()) { // skip ., .., other directories, etc.
				continue;
			}
			if (info[i].indexOf(patt) == -1) { // name doesn't match
				continue;
			}
			// System.out.println("removing " + n.getPath());
			if (!n.delete())
				System.err.println("Couldn't remove " + n.getPath());
		}
	}

	/**
	 * @generated
	 */
	public DiagramEditorWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	/**
	 * @generated
	 */
	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new DiagramEditorActionBarAdvisor(configurer);
	}

	/**
	 * @generated
	 */
	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(1000, 700));
		configurer.setTitle(Messages.DiagramEditorWorkbenchWindowAdvisor_Title);
	}

	/**
	 * @generated NOT
	 */
	public void postWindowCreate() {
		IContributionItem[] mItems, mSubItems;
		IMenuManager mm = getWindowConfigurer().getActionBarConfigurer()
				.getMenuManager();
		mItems = mm.getItems();
		for (int i = 0; i < mItems.length; i++) {
			if (mItems[i] instanceof MenuManager) {
				mSubItems = ((MenuManager) mItems[i]).getItems();
				for (int j = 0; j < mSubItems.length; j++) {
					if (mItems[i].getId().equals("file"))
						((MenuManager) mItems[i])
								.remove("org.eclipse.ui.openLocalFile");
					else if (mItems[i].getId().equals("help")) {
						((MenuManager) mItems[i]).remove("group.updates");
						((MenuManager) mItems[i])
								.remove("org.eclipse.update.ui.updateMenu");
						((MenuManager) mItems[i])
								.remove("org.eclipse.ui.actions.showKeyAssistHandler");
					}
				}
			}
		}
	}

}
