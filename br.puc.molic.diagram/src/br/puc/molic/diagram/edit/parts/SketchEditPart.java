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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.swt.graphics.Color;
import org.osgi.framework.Bundle;

import br.puc.molic.Sketch;
import br.puc.molic.diagram.edit.policies.SketchItemSemanticEditPolicy;
import br.puc.molic.diagram.providers.MolicElementTypes;

/**
 * @generated
 */
public class SketchEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public SketchEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SketchItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {

		URL url = null;
		Bundle bundle = Platform.getBundle("br.puc.molic.diagram");
		try {

			NodeImpl n = (NodeImpl) getModel();
			Sketch s = (Sketch) n.basicGetElement();

			if (s.getImage() != null) {

				url = FileLocator.resolve(new URL("file://" + s.getImage()));
				primaryShape = new SketchFigure(RenderedImageFactory
						.getInstance(url));
				

			} else {
				primaryShape = new SketchFigure(RenderedImageFactory
						.getInstance(bundle.getEntry("/icons/imgmiss.gif")));
			}

		} catch (IOException e) {

			e.printStackTrace();
			primaryShape = new SketchFigure(RenderedImageFactory
					.getInstance(bundle.getEntry("/icons/imgmiss.gif")));
		}

		return primaryShape;
	}

	/**
	 * @generated NOT
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.NSEW);
		}
		return result;
	}

	/**
	 * @generated
	 */
	public SketchFigure getPrimaryShape() {
		return (SketchFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(80, 80);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(MolicElementTypes.Utterance_4001);
		types.add(MolicElementTypes.BRTUtterance_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof SceneEditPart) {
			types.add(MolicElementTypes.Utterance_4001);
		}
		if (targetEditPart instanceof SystemProcessEditPart) {
			types.add(MolicElementTypes.Utterance_4001);
		}
		if (targetEditPart instanceof UbiquitousAccessEditPart) {
			types.add(MolicElementTypes.Utterance_4001);
		}
		if (targetEditPart instanceof OpeningPointEditPart) {
			types.add(MolicElementTypes.Utterance_4001);
		}
		if (targetEditPart instanceof ClosingPointEditPart) {
			types.add(MolicElementTypes.Utterance_4001);
		}
		if (targetEditPart instanceof br.puc.molic.diagram.edit.parts.SketchEditPart) {
			types.add(MolicElementTypes.Utterance_4001);
		}
		if (targetEditPart instanceof SceneEditPart) {
			types.add(MolicElementTypes.BRTUtterance_4002);
		}
		if (targetEditPart instanceof SystemProcessEditPart) {
			types.add(MolicElementTypes.BRTUtterance_4002);
		}
		if (targetEditPart instanceof UbiquitousAccessEditPart) {
			types.add(MolicElementTypes.BRTUtterance_4002);
		}
		if (targetEditPart instanceof OpeningPointEditPart) {
			types.add(MolicElementTypes.BRTUtterance_4002);
		}
		if (targetEditPart instanceof ClosingPointEditPart) {
			types.add(MolicElementTypes.BRTUtterance_4002);
		}
		if (targetEditPart instanceof br.puc.molic.diagram.edit.parts.SketchEditPart) {
			types.add(MolicElementTypes.BRTUtterance_4002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.Scene_2007);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.SystemProcess_2008);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.UbiquitousAccess_2010);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.OpeningPoint_2011);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.ClosingPoint_2012);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.Sketch_3001);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.Scene_2007);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.SystemProcess_2008);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.UbiquitousAccess_2010);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.OpeningPoint_2011);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.ClosingPoint_2012);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.Sketch_3001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(MolicElementTypes.Utterance_4001);
		types.add(MolicElementTypes.BRTUtterance_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.Scene_2007);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.SystemProcess_2008);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.UbiquitousAccess_2010);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.OpeningPoint_2011);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.ClosingPoint_2012);
		}
		if (relationshipType == MolicElementTypes.Utterance_4001) {
			types.add(MolicElementTypes.Sketch_3001);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.Scene_2007);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.SystemProcess_2008);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.UbiquitousAccess_2010);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.OpeningPoint_2011);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.ClosingPoint_2012);
		}
		if (relationshipType == MolicElementTypes.BRTUtterance_4002) {
			types.add(MolicElementTypes.Sketch_3001);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public class SketchFigure extends ScalableImageFigure {

		/**
		 * @generated NOT
		 */
		public SketchFigure(RenderedImage i) {
			super(i, false, true, true);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			try {
				Sketch sketch = (Sketch) ((Node) SketchEditPart.this.getModel())
						.getElement();
				if (sketch.getImage() != null) {
					URL url = FileLocator.resolve(new URL("file://"
							+ sketch.getImage()));
					RenderedImage image = RenderedImageFactory.getInstance(url);
					
					//Dimension d = new Dimension(image.getRenderInfo().getWidth(), image.getRenderInfo().getHeight());
					//d.scale(0.5);
					//this.setSize(d);
					this.setRenderedImage(image);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

}
