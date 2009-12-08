package br.puc.molic.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.swt.graphics.Color;
import br.puc.molic.diagram.edit.policies.SystemProcessItemSemanticEditPolicy;
import br.puc.molic.diagram.providers.MolicElementTypes;

/**
 * @generated
 */
public class SystemProcessEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2008;

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
	public SystemProcessEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SystemProcessItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
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
	 * @generated
	 */
	protected IFigure createNodeShape() {
		SystemProcessFigure figure = new SystemProcessFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SystemProcessFigure getPrimaryShape() {
		return (SystemProcessFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(30, 30);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.NONE);
		}
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
		if (targetEditPart instanceof br.puc.molic.diagram.edit.parts.SystemProcessEditPart) {
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
		if (targetEditPart instanceof SketchEditPart) {
			types.add(MolicElementTypes.Utterance_4001);
		}
		if (targetEditPart instanceof SceneEditPart) {
			types.add(MolicElementTypes.BRTUtterance_4002);
		}
		if (targetEditPart instanceof br.puc.molic.diagram.edit.parts.SystemProcessEditPart) {
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
		if (targetEditPart instanceof SketchEditPart) {
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
	 * @generated
	 */
	public class SystemProcessFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		public SystemProcessFigure() {
			this.setLineWidth(1);
			this.setBackgroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(30),
					getMapMode().DPtoLP(30)));
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
