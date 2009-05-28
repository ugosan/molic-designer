/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import br.puc.molic.MolicPackage;
import br.puc.molic.UbiquitousAccess;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ubiquitous Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.puc.molic.impl.UbiquitousAccessImpl#getID <em>ID</em>}</li>
 *   <li>{@link br.puc.molic.impl.UbiquitousAccessImpl#getGoals <em>Goals</em>}</li>
 *   <li>{@link br.puc.molic.impl.UbiquitousAccessImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link br.puc.molic.impl.UbiquitousAccessImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UbiquitousAccessImpl extends EObjectImpl implements UbiquitousAccess {
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
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "Ubiquitous Access";
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
	protected UbiquitousAccessImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
    protected EClass eStaticClass() {
        return MolicPackage.Literals.UBIQUITOUS_ACCESS;
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
            goals = new EDataTypeUniqueEList<String>(String.class, this, MolicPackage.UBIQUITOUS_ACCESS__GOALS);
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
            eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.UBIQUITOUS_ACCESS__LABEL, oldLabel, label));
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
            case MolicPackage.UBIQUITOUS_ACCESS__ID:
                return getID();
            case MolicPackage.UBIQUITOUS_ACCESS__GOALS:
                return getGoals();
            case MolicPackage.UBIQUITOUS_ACCESS__LABEL:
                return getLabel();
            case MolicPackage.UBIQUITOUS_ACCESS__NAME:
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
            case MolicPackage.UBIQUITOUS_ACCESS__GOALS:
                getGoals().clear();
                getGoals().addAll((Collection<? extends String>)newValue);
                return;
            case MolicPackage.UBIQUITOUS_ACCESS__LABEL:
                setLabel((String)newValue);
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
            case MolicPackage.UBIQUITOUS_ACCESS__GOALS:
                getGoals().clear();
                return;
            case MolicPackage.UBIQUITOUS_ACCESS__LABEL:
                setLabel(LABEL_EDEFAULT);
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
            case MolicPackage.UBIQUITOUS_ACCESS__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case MolicPackage.UBIQUITOUS_ACCESS__GOALS:
                return goals != null && !goals.isEmpty();
            case MolicPackage.UBIQUITOUS_ACCESS__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case MolicPackage.UBIQUITOUS_ACCESS__NAME:
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
        result.append(" (ID: ");
        result.append(id);
        result.append(", goals: ");
        result.append(goals);
        result.append(", label: ");
        result.append(label);
        result.append(", name: ");
        if (nameESet) result.append(name); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //UbiquitousAccessImpl