/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic;


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
 * </ul>
 * </p>
 *
 * @see br.puc.molic.MolicPackage#getScene()
 * @model
 * @generated
 */
public interface Scene extends Element {
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
	String getTopic();

	/**
	 * Sets the value of the '{@link br.puc.molic.Scene#getTopic <em>Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topic</em>' attribute.
	 * @see #getTopic()
	 * @generated
	 */
	void setTopic(String value);

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
	String getDialogue();

	/**
	 * Sets the value of the '{@link br.puc.molic.Scene#getDialogue <em>Dialogue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dialogue</em>' attribute.
	 * @see #getDialogue()
	 * @generated
	 */
	void setDialogue(String value);

} // Scene