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
package br.puc.molic.diagram.edit.parts;

import java.beans.PropertyChangeEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import br.puc.molic.diagram.edit.policies.GalleryDropEditPolicy;
import br.puc.molic.diagram.edit.policies.SceneSketchesCompartmentCanonicalEditPolicy;
import br.puc.molic.diagram.edit.policies.SceneSketchesCompartmentItemSemanticEditPolicy;
import br.puc.molic.diagram.part.Messages;

/**
 * @generated
 */
public class SceneSketchesCompartmentEditPart extends ShapeCompartmentEditPart {


	@Override
	protected void setCollapsed(boolean collapsed, boolean animate) {
		if(collapsed){
			//System.out.println("collapsed");
			
		}else{
			//System.out.println("opened");
		}
		
		super.setCollapsed(collapsed, animate);
		
		
	}


	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7001;

	/**
	 * @generated
	 */
	public SceneSketchesCompartmentEditPart(View view) {
		super(view);
		
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.SceneSketchesCompartmentEditPart_title;
	}

	/**
	 * @generated NOT
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		result.setToolTip("Drag images from the Gallery to here");
		return result;
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new ResizableCompartmentEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SceneSketchesCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());

		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new SceneSketchesCompartmentCanonicalEditPolicy());

		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new GalleryDropEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

}
