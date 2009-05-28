/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import br.puc.molic.Element;
import br.puc.molic.MolicPackage;
import br.puc.molic.Utterance;
import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Utterance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.puc.molic.impl.UtteranceImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link br.puc.molic.impl.UtteranceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link br.puc.molic.impl.UtteranceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link br.puc.molic.impl.UtteranceImpl#getID <em>ID</em>}</li>
 *   <li>{@link br.puc.molic.impl.UtteranceImpl#getGoals <em>Goals</em>}</li>
 *   <li>{@link br.puc.molic.impl.UtteranceImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UtteranceImpl extends EObjectImpl implements Utterance {
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
    protected static final String NAME_EDEFAULT = "Utterance";

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
	protected UtteranceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
    protected EClass eStaticClass() {
        return MolicPackage.Literals.UTTERANCE;
    }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getID() {
        
        
        return eResource().getURIFragment(this);
    }
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getGoals() {
        if (goals == null) {
            goals = new EDataTypeUniqueEList<String>(String.class, this, MolicPackage.UTTERANCE__GOALS);
        }
        return goals;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getLabel() {
        return label;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.UTTERANCE__LABEL, oldLabel, label));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Element getSource() {
        if (source != null && source.eIsProxy()) {
            InternalEObject oldSource = (InternalEObject)source;
            source = (Element)eResolveProxy(oldSource);
            if (source != oldSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MolicPackage.UTTERANCE__SOURCE, oldSource, source));
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
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSource(Element newSource) {
        Element oldSource = source;
        source = newSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.UTTERANCE__SOURCE, oldSource, source));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Element getTarget() {
        if (target != null && target.eIsProxy()) {
            InternalEObject oldTarget = (InternalEObject)target;
            target = (Element)eResolveProxy(oldTarget);
            if (target != oldTarget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MolicPackage.UTTERANCE__TARGET, oldTarget, target));
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
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTarget(Element newTarget) {
        Element oldTarget = target;
        target = newTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.UTTERANCE__TARGET, oldTarget, target));
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
            case MolicPackage.UTTERANCE__LABEL:
                return getLabel();
            case MolicPackage.UTTERANCE__SOURCE:
                if (resolve) return getSource();
                return basicGetSource();
            case MolicPackage.UTTERANCE__TARGET:
                if (resolve) return getTarget();
                return basicGetTarget();
            case MolicPackage.UTTERANCE__ID:
                return getID();
            case MolicPackage.UTTERANCE__GOALS:
                return getGoals();
            case MolicPackage.UTTERANCE__NAME:
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
            case MolicPackage.UTTERANCE__LABEL:
                setLabel((String)newValue);
                return;
            case MolicPackage.UTTERANCE__SOURCE:
                setSource((Element)newValue);
                return;
            case MolicPackage.UTTERANCE__TARGET:
                setTarget((Element)newValue);
                return;
            case MolicPackage.UTTERANCE__GOALS:
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
            case MolicPackage.UTTERANCE__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case MolicPackage.UTTERANCE__SOURCE:
                setSource((Element)null);
                return;
            case MolicPackage.UTTERANCE__TARGET:
                setTarget((Element)null);
                return;
            case MolicPackage.UTTERANCE__GOALS:
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
            case MolicPackage.UTTERANCE__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case MolicPackage.UTTERANCE__SOURCE:
                return source != null;
            case MolicPackage.UTTERANCE__TARGET:
                return target != null;
            case MolicPackage.UTTERANCE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case MolicPackage.UTTERANCE__GOALS:
                return goals != null && !goals.isEmpty();
            case MolicPackage.UTTERANCE__NAME:
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

} //UtteranceImpl