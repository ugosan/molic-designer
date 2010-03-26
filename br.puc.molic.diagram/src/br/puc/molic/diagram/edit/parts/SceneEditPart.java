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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import br.puc.molic.diagram.edit.policies.SceneItemSemanticEditPolicy;
import br.puc.molic.diagram.part.MolicVisualIDRegistry;
import br.puc.molic.diagram.providers.MolicElementTypes;

/**
 * @generated
 */
public class SceneEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2007;

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
	public SceneEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SceneItemSemanticEditPolicy());
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
	 * This is a workaround for the resize limitation if the figure has a child (such as a label)
	 */
	protected void refreshBounds() {
        int width = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
        int height = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
        Dimension size = new Dimension(width, height);

               getFigure().setMinimumSize(size) ; //This is a workaround for the resize limitation if the figure has a child (such as a label)
        int x = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
        int y = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
        Point loc = new Point(x, y);
        ((GraphicalEditPart) getParent()).setLayoutConstraint(
            this,
            getFigure(),
            new Rectangle(loc, size));
    } 
    
	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		SceneFigure figure = new SceneFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SceneFigure getPrimaryShape() {
		return (SceneFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SceneTopicEditPart) {
			((SceneTopicEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureSceneTopicFigure());
			return true;
		}
		if (childEditPart instanceof SceneDialogueEditPart) {
			((SceneDialogueEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureDialogueFigure());
			return true;
		}
		if (childEditPart instanceof SceneSketchesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureSketchesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((SceneSketchesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SceneTopicEditPart) {
			return true;
		}
		if (childEditPart instanceof SceneDialogueEditPart) {
			return true;
		}
		if (childEditPart instanceof SceneSketchesCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureSketchesCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((SceneSketchesCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof SceneSketchesCompartmentEditPart) {
			return getPrimaryShape().getFigureSketchesCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(150, 100);
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
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
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
	protected void setForegroundColor(org.eclipse.swt.graphics.Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(org.eclipse.swt.graphics.Color color) {
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(MolicVisualIDRegistry
				.getType(SceneTopicEditPart.VISUAL_ID));
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
		if (targetEditPart instanceof br.puc.molic.diagram.edit.parts.SceneEditPart) {
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
		if (targetEditPart instanceof SketchEditPart) {
			types.add(MolicElementTypes.Utterance_4001);
		}
		if (targetEditPart instanceof br.puc.molic.diagram.edit.parts.SceneEditPart) {
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
	public class SceneFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureSceneTopicFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDialogueFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureSketchesCompartmentFigure;

		/**
		 * @generated
		 */
		public SceneFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setLineWidth(2);
			this.setForegroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(150),
					getMapMode().DPtoLP(100)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureSceneTopicFigure = new WrappingLabel();
			fFigureSceneTopicFigure.setText("Untitled Scene");

			fFigureSceneTopicFigure.setFont(FFIGURESCENETOPICFIGURE_FONT);

			GridData constraintFFigureSceneTopicFigure = new GridData();
			constraintFFigureSceneTopicFigure.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSceneTopicFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureSceneTopicFigure.horizontalIndent = 0;
			constraintFFigureSceneTopicFigure.horizontalSpan = 1;
			constraintFFigureSceneTopicFigure.verticalSpan = 1;
			constraintFFigureSceneTopicFigure.grabExcessHorizontalSpace = true;
			constraintFFigureSceneTopicFigure.grabExcessVerticalSpace = false;
			this
					.add(fFigureSceneTopicFigure,
							constraintFFigureSceneTopicFigure);

			RectangleFigure dialogueRectangle0 = new RectangleFigure();
			dialogueRectangle0.setFill(false);
			dialogueRectangle0.setOutline(false);
			dialogueRectangle0.setLineWidth(1);

			GridData constraintDialogueRectangle0 = new GridData();
			constraintDialogueRectangle0.verticalAlignment = GridData.BEGINNING;
			constraintDialogueRectangle0.horizontalAlignment = GridData.FILL;
			constraintDialogueRectangle0.horizontalIndent = 0;
			constraintDialogueRectangle0.horizontalSpan = 0;
			constraintDialogueRectangle0.verticalSpan = 0;
			constraintDialogueRectangle0.grabExcessHorizontalSpace = true;
			constraintDialogueRectangle0.grabExcessVerticalSpace = true;
			this.add(dialogueRectangle0, constraintDialogueRectangle0);

			GridLayout layoutDialogueRectangle0 = new GridLayout();
			layoutDialogueRectangle0.numColumns = 1;
			layoutDialogueRectangle0.makeColumnsEqualWidth = true;
			dialogueRectangle0.setLayoutManager(layoutDialogueRectangle0);

			RectangleFigure line1 = new RectangleFigure();
			//line1.setSize(400, 1);
			line1.setFill(false);
			line1.setLineWidth(2);
			line1.setForegroundColor(ColorConstants.black);
			line1.setPreferredSize(new Dimension(getMapMode().DPtoLP(100),
					getMapMode().DPtoLP(1)));

			GridData constraintLine1 = new GridData();
			constraintLine1.verticalAlignment = GridData.BEGINNING;
			constraintLine1.horizontalAlignment = GridData.FILL;
			constraintLine1.horizontalIndent = 0;
			constraintLine1.horizontalSpan = 0;
			constraintLine1.verticalSpan = 0;
			constraintLine1.grabExcessHorizontalSpace = true;
			constraintLine1.grabExcessVerticalSpace = false;
			dialogueRectangle0.add(line1, constraintLine1);

			fFigureDialogueFigure = new WrappingLabel();
			fFigureDialogueFigure.setTextWrap(true);
			fFigureDialogueFigure.setText("Click to edit...");
			fFigureDialogueFigure.setPreferredSize(new Dimension(getMapMode()
					.DPtoLP(100), getMapMode().DPtoLP(100)));

			GridData constraintFFigureDialogueFigure = new GridData();
			constraintFFigureDialogueFigure.verticalAlignment = GridData.FILL;
			constraintFFigureDialogueFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureDialogueFigure.horizontalIndent = 0;
			constraintFFigureDialogueFigure.horizontalSpan = 1;
			constraintFFigureDialogueFigure.verticalSpan = 1;
			constraintFFigureDialogueFigure.grabExcessHorizontalSpace = true;
			constraintFFigureDialogueFigure.grabExcessVerticalSpace = true;
			dialogueRectangle0.add(fFigureDialogueFigure,
					constraintFFigureDialogueFigure);

			fFigureSketchesCompartmentFigure = new org.eclipse.draw2d.RectangleFigure();
			fFigureSketchesCompartmentFigure.setLineWidth(1);
			fFigureSketchesCompartmentFigure
					.setForegroundColor(org.eclipse.draw2d.ColorConstants.lightGray);

			org.eclipse.draw2d.GridData constraintFFigureSketchesCompartmentFigure = new org.eclipse.draw2d.GridData();
			//constraintFFigureSketchesCompartmentFigure.verticalAlignment = org.eclipse.draw2d.GridData.FILL;
			constraintFFigureSketchesCompartmentFigure.horizontalAlignment = org.eclipse.draw2d.GridData.FILL;
			constraintFFigureSketchesCompartmentFigure.horizontalIndent = 0;
			constraintFFigureSketchesCompartmentFigure.horizontalSpan = 1;
			constraintFFigureSketchesCompartmentFigure.verticalSpan = 1;
			constraintFFigureSketchesCompartmentFigure.grabExcessHorizontalSpace = true;
			//constraintFFigureSketchesCompartmentFigure.grabExcessVerticalSpace = true;
			this.add(fFigureSketchesCompartmentFigure,
					constraintFFigureSketchesCompartmentFigure);

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

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSceneTopicFigure() {
			return fFigureSceneTopicFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDialogueFigure() {
			return fFigureDialogueFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureSketchesCompartmentFigure() {
			return fFigureSketchesCompartmentFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURESCENETOPICFIGURE_FONT = new Font(Display
			.getCurrent(), "sans", 10, SWT.NORMAL);

}
