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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scene</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.puc.molic.Scene#getTopic <em>Topic</em>}</li>
 *   <li>{@link br.puc.molic.Scene#getDialogue <em>Dialogue</em>}</li>
 *   <li>{@link br.puc.molic.Scene#getName <em>Name</em>}</li>
 *   <li>{@link br.puc.molic.Scene#getSketch <em>Sketch</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.puc.molic.MolicPackage#getScene()
 * @model kind="class"
 * @generated
 */
public class Scene extends EObjectImpl implements Element {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "MoLIC Designer (c) 2009 \nThis software is part of the MSc work of Ugo Braga Sangiorgi and can be copied freely\n\nDeveloped at Semiotic Engineering Research Lab (SERG)\nPontifical Catholic University of Rio de Janeiro, PUCRio\n\nAuthor: Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br";

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
	 * The cached value of the '{@link #getSketch() <em>Sketch</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSketch()
	 * @generated
	 * @ordered
	 */
	protected EList<Sketch> sketch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Scene() {
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
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see br.puc.molic.MolicPackage#getElement_ID()
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
	 * @see br.puc.molic.MolicPackage#getElement_Goals()
	 * @model
	 * @generated
	 */
	public EList<String> getGoals() {
		if (goals == null) {
			goals = new EDataTypeUniqueEList<String>(String.class, this, MolicPackage.SCENE__GOALS);
		}
		return goals;
	}

	/**
	 * Returns the value of the '<em><b>Topic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topic</em>' attribute.
	 * @see #setTopic(String)
	 * @see br.puc.molic.MolicPackage#getScene_Topic()
	 * @model
	 * @generated
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Sets the value of the '{@link br.puc.molic.Scene#getTopic <em>Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topic</em>' attribute.
	 * @see #getTopic()
	 * @generated
	 */
	public void setTopic(String newTopic) {
		String oldTopic = topic;
		topic = newTopic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.SCENE__TOPIC, oldTopic, topic));
	}

	/**
	 * Returns the value of the '<em><b>Dialogue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dialogue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dialogue</em>' attribute.
	 * @see #setDialogue(String)
	 * @see br.puc.molic.MolicPackage#getScene_Dialogue()
	 * @model
	 * @generated
	 */
	public String getDialogue() {
		return dialogue;
	}

	/**
	 * Sets the value of the '{@link br.puc.molic.Scene#getDialogue <em>Dialogue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dialogue</em>' attribute.
	 * @see #getDialogue()
	 * @generated
	 */
	public void setDialogue(String newDialogue) {
		String oldDialogue = dialogue;
		dialogue = newDialogue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MolicPackage.SCENE__DIALOGUE, oldDialogue, dialogue));
	}

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Scene"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see br.puc.molic.MolicPackage#getScene_Name()
	 * @model default="Scene" unsettable="true" changeable="false"
	 * @generated NOT
	 */
	public String getName() {
		return name +" "+topic;
	}

	/**
	 * Returns whether the value of the '{@link br.puc.molic.Scene#getName <em>Name</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Sketch</b></em>' containment reference list.
	 * The list contents are of type {@link br.puc.molic.Sketch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sketch</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sketch</em>' containment reference list.
	 * @see br.puc.molic.MolicPackage#getScene_Sketch()
	 * @model containment="true"
	 * @generated
	 */
	public EList<Sketch> getSketch() {
		if (sketch == null) {
			sketch = new EObjectContainmentEList<Sketch>(Sketch.class, this, MolicPackage.SCENE__SKETCH);
		}
		return sketch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MolicPackage.SCENE__SKETCH:
				return ((InternalEList<?>)getSketch()).basicRemove(otherEnd, msgs);
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
			case MolicPackage.SCENE__SKETCH:
				return getSketch();
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
			case MolicPackage.SCENE__SKETCH:
				getSketch().clear();
				getSketch().addAll((Collection<? extends Sketch>)newValue);
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
			case MolicPackage.SCENE__SKETCH:
				getSketch().clear();
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
			case MolicPackage.SCENE__SKETCH:
				return sketch != null && !sketch.isEmpty();
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

} // Scene
