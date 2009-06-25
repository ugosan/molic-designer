/*
 * MoLIC Designer (c) 2009 
 * This software is part of the MSc work of Ugo Braga Sangiorgi and may be freely distributed
 * under the terms of GNU General Public License v2
 * http://www.gnu.org/licenses/gpl-2.0.html
 * 
 * Developed at Semiotic Engineering Research Lab (SERG) - http://serg.inf.puc-rio.br
 * Pontifical Catholic University of Rio de Janeiro, PUCRio
 * 
 * 
 * Author: Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br
 */
package br.puc.molic.diagram.part;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @generated
 */
public class LoadResourceAction extends AbstractHandler {
	/**
	 * @generated
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
		Shell shell = diagramEditor.getEditorSite().getShell();
		assert diagramEditor instanceof DiagramEditor;
		TransactionalEditingDomain editingDomain = ((DiagramEditor) diagramEditor)
				.getEditingDomain();
		org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog loadResourceDialog = new org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog(
				shell, editingDomain);
		loadResourceDialog.open();
		return null;
	}

}
