/*
 * Teste de nota de copyright do Molic
 */
package br.puc.molic.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import br.puc.molic.diagram.providers.MolicElementTypes;

/**
 * @generated
 */
public class BRTUtteranceItemSemanticEditPolicy extends
		MolicBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public BRTUtteranceItemSemanticEditPolicy() {
		super(MolicElementTypes.BRTUtterance_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
