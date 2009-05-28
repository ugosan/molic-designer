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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import br.puc.molic.MolicPackage;
import br.puc.molic.Scene;
import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scene</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.puc.molic.impl.SceneImpl#getID <em>ID</em>}</li>
 *   <li>{@link br.puc.molic.impl.SceneImpl#getGoals <em>Goals</em>}</li>
 *   <li>{@link br.puc.molic.impl.SceneImpl#getTopic <em>Topic</em>}</li>
 *   <li>{@link br.puc.molic.impl.SceneImpl#getDialogue <em>Dialogue</em>}</li>
 *   <li>{@link br.puc.molic.impl.SceneImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SceneImpl extends EObjectImpl implements Scene {
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
     * The default value of the '{@link #getTopic() <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTopic()
     * @generated
     * @ordered
     */
	protected static final String TOPIC_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTopic() <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTopic()
     * @generated
     * @ordered
     */
	protected String topic = TOPIC_EDEFAULT;

	/**
     * The default value of the '{@link #getDialogue() <em>Dialogue</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDialogue()
     * @generated
     * @ordered
     */
	protected static final String DIALOGUE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getDialogue() <em>Dialogue</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDialogue()
     * @generated
     * @ordered
     */
	protected String dialogue = DIALOGUE_EDEFAULT;

	/**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "Scene";

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
	protected SceneImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
    protected EClass eStaticClass() {
        return MolicPackage.Literals.SCENE;
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
            goals = new EDataTypeUniqueEList<String>(String.class, this, MolicPackage.SCENE__GOALS);
        }
        return goals;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTopic() {
        return topic;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTopic(String newTopic) {
        String oldTopic = topic;
        topic = newTopic;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.SCENE__TOPIC, oldTopic, topic));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getDialogue() {
        return dialogue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDialogue(String newDialogue) {
        String oldDialogue = dialogue;
        dialogue = newDialogue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.SCENE__DIALOGUE, oldDialogue, dialogue));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getName() {
        return name + " "+topic;
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
            case MolicPackage.SCENE__ID:
                return getID();
            case MolicPackage.SCENE__GOALS:
                return getGoals();
            case MolicPackage.SCENE__TOPIC:
                return getTopic();
            case MolicPackage.SCENE__DIALOGUE:
                return getDialogue();
            case MolicPackage.SCENE__NAME:
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
            case MolicPackage.SCENE__GOALS:
                getGoals().clear();
                getGoals().addAll((Collection<? extends String>)newValue);
                return;
            case MolicPackage.SCENE__TOPIC:
                setTopic((String)newValue);
                return;
            case MolicPackage.SCENE__DIALOGUE:
                setDialogue((String)newValue);
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
            case MolicPackage.SCENE__GOALS:
                getGoals().clear();
                return;
            case MolicPackage.SCENE__TOPIC:
                setTopic(TOPIC_EDEFAULT);
                return;
            case MolicPackage.SCENE__DIALOGUE:
                setDialogue(DIALOGUE_EDEFAULT);
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
            case MolicPackage.SCENE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case MolicPackage.SCENE__GOALS:
                return goals != null && !goals.isEmpty();
            case MolicPackage.SCENE__TOPIC:
                return TOPIC_EDEFAULT == null ? topic != null : !TOPIC_EDEFAULT.equals(topic);
            case MolicPackage.SCENE__DIALOGUE:
                return DIALOGUE_EDEFAULT == null ? dialogue != null : !DIALOGUE_EDEFAULT.equals(dialogue);
            case MolicPackage.SCENE__NAME:
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
        result.append(", topic: ");
        result.append(topic);
        result.append(", dialogue: ");
        result.append(dialogue);
        result.append(", name: ");
        if (nameESet) result.append(name); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //SceneImpl