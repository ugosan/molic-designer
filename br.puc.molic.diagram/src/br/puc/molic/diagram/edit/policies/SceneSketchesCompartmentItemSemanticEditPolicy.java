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
package br.puc.molic.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import br.puc.molic.diagram.edit.commands.SketchCreateCommand;
import br.puc.molic.diagram.providers.MolicElementTypes;

/**
 * @generated
 */
public class SceneSketchesCompartmentItemSemanticEditPolicy extends
		MolicBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SceneSketchesCompartmentItemSemanticEditPolicy() {
		super(MolicElementTypes.Scene_2007);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (MolicElementTypes.Sketch_3001 == req.getElementType()) {
			return getGEFWrapper(new SketchCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		System.out.println("pow right in the kitchen");
		return super.getCreateRelationshipCommand(req);
	}

}
