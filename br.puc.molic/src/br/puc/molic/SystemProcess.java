/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.puc.molic.SystemProcess#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.puc.molic.MolicPackage#getSystemProcess()
 * @model
 * @generated
 */
public interface SystemProcess extends Element {

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * The default value is <code>"System Process"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #isSetName()
     * @see br.puc.molic.MolicPackage#getSystemProcess_Name()
     * @model default="System Process" unsettable="true" changeable="false"
     * @generated
     */
    String getName();

    /**
     * Returns whether the value of the '{@link br.puc.molic.SystemProcess#getName <em>Name</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Name</em>' attribute is set.
     * @see #getName()
     * @generated
     */
    boolean isSetName();
} // SystemProcess