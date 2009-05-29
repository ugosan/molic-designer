/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import br.puc.molic.Connection;
import br.puc.molic.Diagram;
import br.puc.molic.Element;

import br.puc.molic.MolicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.puc.molic.impl.DiagramImpl#getElement <em>Element</em>}</li>
 *   <li>{@link br.puc.molic.impl.DiagramImpl#getUtterance <em>Utterance</em>}</li>
 *   <li>{@link br.puc.molic.impl.DiagramImpl#getGoals <em>Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramImpl extends EObjectImpl implements Diagram {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> element;

	/**
	 * The cached value of the '{@link #getUtterance() <em>Utterance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtterance()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> utterance;

	/**
	 * The cached value of the '{@link #getGoals() <em>Goals</em>}' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getGoals()
	 * @generated
	 * @ordered
	 */
    protected EList<String> goals;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
    protected EClass eStaticClass() {
		return MolicPackage.Literals.DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getElement() {
		if (element == null) {
			element = new EObjectContainmentEList<Element>(Element.class, this, MolicPackage.DIAGRAM__ELEMENT);
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getUtterance() {
		if (utterance == null) {
			utterance = new EObjectContainmentEList<Connection>(Connection.class, this, MolicPackage.DIAGRAM__UTTERANCE);
		}
		return utterance;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<String> getGoals() {
		if (goals == null) {
			goals = new EDataTypeUniqueEList<String>(String.class, this, MolicPackage.DIAGRAM__GOALS);
		}
		return goals;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MolicPackage.DIAGRAM__ELEMENT:
				return ((InternalEList<?>)getElement()).basicRemove(otherEnd, msgs);
			case MolicPackage.DIAGRAM__UTTERANCE:
				return ((InternalEList<?>)getUtterance()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MolicPackage.DIAGRAM__ELEMENT:
				return getElement();
			case MolicPackage.DIAGRAM__UTTERANCE:
				return getUtterance();
			case MolicPackage.DIAGRAM__GOALS:
				return getGoals();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MolicPackage.DIAGRAM__ELEMENT:
				getElement().clear();
				getElement().addAll((Collection<? extends Element>)newValue);
				return;
			case MolicPackage.DIAGRAM__UTTERANCE:
				getUtterance().clear();
				getUtterance().addAll((Collection<? extends Connection>)newValue);
				return;
			case MolicPackage.DIAGRAM__GOALS:
				getGoals().clear();
				getGoals().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case MolicPackage.DIAGRAM__ELEMENT:
				getElement().clear();
				return;
			case MolicPackage.DIAGRAM__UTTERANCE:
				getUtterance().clear();
				return;
			case MolicPackage.DIAGRAM__GOALS:
				getGoals().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MolicPackage.DIAGRAM__ELEMENT:
				return element != null && !element.isEmpty();
			case MolicPackage.DIAGRAM__UTTERANCE:
				return utterance != null && !utterance.isEmpty();
			case MolicPackage.DIAGRAM__GOALS:
				return goals != null && !goals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (goals: ");
		result.append(goals);
		result.append(')');
		return result.toString();
	}

} //DiagramImpl