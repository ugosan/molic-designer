/*
 * SERG - Semiotic Engineering Research Group
 * This work is part of MSc thesis of Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br
 */
package br.puc.molic.diagram.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;

import br.puc.molic.MolicPackage;
import br.puc.molic.diagram.edit.parts.DiagramEditPart;
import br.puc.molic.diagram.expressions.MolicAbstractExpression;
import br.puc.molic.diagram.expressions.MolicOCLFactory;
import br.puc.molic.diagram.part.MolicDiagramEditorPlugin;
import br.puc.molic.diagram.part.MolicVisualIDRegistry;
import br.puc.molic.diagram.part.ValidateAction;

/**
 * @generated
 */
public class MolicValidationProvider {

	/**
	 * @generated
	 */
	private static boolean constraintsActive = false;

	/**
	 * @generated
	 */
	public static boolean shouldConstraintsBePrivate() {
		return false;
	}

	/**
	 * @generated
	 */
	public static void runWithConstraints(
			TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {
			public void run() {
				try {
					constraintsActive = true;
					op.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		if (editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				MolicDiagramEditorPlugin.getInstance().logError(
						"Validation failed", e); //$NON-NLS-1$
			}
		} else {
			task.run();
		}
	}

	/**
	 * @generated
	 */
	static boolean isInDefaultEditorContext(Object object) {
		if (shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if (object instanceof View) {
			return constraintsActive
					&& DiagramEditPart.MODEL_ID.equals(MolicVisualIDRegistry
							.getModelID((View) object));
		}
		return true;
	}

}
