package br.puc.molic.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.LabelLocator;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MolicExtNodeLabelEditPart extends LabelEditPart {

	/**
	 * @generated
	 */
	public MolicExtNodeLabelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	/*public void refreshBounds() {
		IFigure refFigure = ((GraphicalEditPart) getParent()).getFigure();
		int dx = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getLocation_X())).intValue();
		int dy = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getLocation_Y())).intValue();
		Point offset = new Point(dx, dy);
		getFigure().getParent().setConstraint(getFigure(),
				new LabelLocator(refFigure, offset, getKeyPoint()) {

					public void relocate(IFigure target) {
						Point location = getReferencePoint().getTranslated(
								getOffset());
						location.translate(-target.getBounds().width / 2, 0);
						target.setLocation(location);
						target.setSize(new Dimension(
								target.getPreferredSize().width, target
										.getPreferredSize().height));
					}

					protected Point getReferencePoint() {
						return getLabelLocation(parent);
					}
				});
	}*/
    public void refreshBounds() {
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
	public Point getReferencePoint() {
		return getLabelLocation(((GraphicalEditPart) getParent()).getFigure());
	}

	/**
	 * @generated
	 */
	protected Point getLabelLocation(IFigure parent) {
		return parent.getBounds().getBottom();
	}
}
