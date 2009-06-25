/**
 * MoLIC Designer (c) 2009 
 * This software is part of the MSc work of Ugo Braga Sangiorgi and can be copied freely
 * 
 * Developed at Semiotic Engineering Research Lab (SERG)
 * Pontifical Catholic University of Rio de Janeiro, PUCRio
 * 
 * Author: Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br
 *
 * $Id$
 */
package br.puc.molic;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BRT Utterance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.puc.molic.BRTUtterance#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.puc.molic.MolicPackage#getBRTUtterance()
 * @model kind="class"
 * @generated
 */
public class BRTUtterance extends EObjectImpl implements Connection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "MoLIC Designer (c) 2009 \nThis software is part of the MSc work of Ugo Braga Sangiorgi and may be freely distributed\nunder the terms of GNU General Public License v2\nhttp://www.gnu.org/licenses/gpl-2.0.html\n\nDeveloped at Semiotic Engineering Research Lab (SERG) - http://serg.inf.puc-rio.br\nPontifical Catholic University of Rio de Janeiro, PUCRio\n\n\nAuthor: Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br";

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Element source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Element target;

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "Breakdown Utterance";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * This is true if the Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nameESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BRTUtterance() {
		super();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MolicPackage.Literals.BRT_UTTERANCE;
	}

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see br.puc.molic.MolicPackage#getConnection_Label()
	 * @model
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the value of the '{@link br.puc.molic.BRTUtterance#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.BRT_UTTERANCE__LABEL, oldLabel, label));
	}

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Element)
	 * @see br.puc.molic.MolicPackage#getConnection_Source()
	 * @model
	 * @generated
	 */
	public Element getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Element)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MolicPackage.BRT_UTTERANCE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetSource() {
		return source;
	}

	/**
	 * Sets the value of the '{@link br.puc.molic.BRTUtterance#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	public void setSource(Element newSource) {
		Element oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.BRT_UTTERANCE__SOURCE, oldSource, source));
	}

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Element)
	 * @see br.puc.molic.MolicPackage#getConnection_Target()
	 * @model
	 * @generated
	 */
	public Element getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Element)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MolicPackage.BRT_UTTERANCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetTarget() {
		return target;
	}

	/**
	 * Sets the value of the '{@link br.puc.molic.BRTUtterance#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	public void setTarget(Element newTarget) {
		Element oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.BRT_UTTERANCE__TARGET, oldTarget, target));
	}

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see br.puc.molic.MolicPackage#getConnection_ID()
	 * @model id="true" changeable="false"
	 * @generated NOT
	 */
	public String getID() {
		return eResource().getURIFragment(this);
	}

	/**
	 * Returns the value of the '<em><b>Goals</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' attribute list.
	 * @see br.puc.molic.MolicPackage#getConnection_Goals()
	 * @model
	 * @generated
	 */
	public EList<String> getGoals() {
		if (goals == null) {
			goals = new EDataTypeUniqueEList<String>(String.class, this, MolicPackage.BRT_UTTERANCE__GOALS);
		}
		return goals;
	}

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Breakdown Utterance"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see br.puc.molic.MolicPackage#getBRTUtterance_Name()
	 * @model default="Breakdown Utterance" unsettable="true" changeable="false"
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns whether the value of the '{@link br.puc.molic.BRTUtterance#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #getName()
	 * @generated
	 */
	public boolean isSetName() {
		return nameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MolicPackage.BRT_UTTERANCE__LABEL:
				return getLabel();
			case MolicPackage.BRT_UTTERANCE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MolicPackage.BRT_UTTERANCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case MolicPackage.BRT_UTTERANCE__ID:
				return getID();
			case MolicPackage.BRT_UTTERANCE__GOALS:
				return getGoals();
			case MolicPackage.BRT_UTTERANCE__NAME:
				return getName();
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
			case MolicPackage.BRT_UTTERANCE__LABEL:
				setLabel((String)newValue);
				return;
			case MolicPackage.BRT_UTTERANCE__SOURCE:
				setSource((Element)newValue);
				return;
			case MolicPackage.BRT_UTTERANCE__TARGET:
				setTarget((Element)newValue);
				return;
			case MolicPackage.BRT_UTTERANCE__GOALS:
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
			case MolicPackage.BRT_UTTERANCE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case MolicPackage.BRT_UTTERANCE__SOURCE:
				setSource((Element)null);
				return;
			case MolicPackage.BRT_UTTERANCE__TARGET:
				setTarget((Element)null);
				return;
			case MolicPackage.BRT_UTTERANCE__GOALS:
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
			case MolicPackage.BRT_UTTERANCE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case MolicPackage.BRT_UTTERANCE__SOURCE:
				return source != null;
			case MolicPackage.BRT_UTTERANCE__TARGET:
				return target != null;
			case MolicPackage.BRT_UTTERANCE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case MolicPackage.BRT_UTTERANCE__GOALS:
				return goals != null && !goals.isEmpty();
			case MolicPackage.BRT_UTTERANCE__NAME:
				return isSetName();
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
		result.append(" (label: ");
		result.append(label);
		result.append(", ID: ");
		result.append(id);
		result.append(", goals: ");
		result.append(goals);
		result.append(", name: ");
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} // BRTUtterance
