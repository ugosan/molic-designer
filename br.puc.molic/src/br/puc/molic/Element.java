/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.puc.molic.Element#getID <em>ID</em>}</li>
 *   <li>{@link br.puc.molic.Element#getGoals <em>Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.puc.molic.MolicPackage#getElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Element extends EObject {

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
     * @generated
     */
    String getID();

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
    EList<String> getGoals();
} // Element