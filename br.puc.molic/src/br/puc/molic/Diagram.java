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
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.puc.molic.Diagram#getElement <em>Element</em>}</li>
 *   <li>{@link br.puc.molic.Diagram#getUtterance <em>Utterance</em>}</li>
 *   <li>{@link br.puc.molic.Diagram#getGoals <em>Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.puc.molic.MolicPackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends EObject {
	/**
     * Returns the value of the '<em><b>Element</b></em>' containment reference list.
     * The list contents are of type {@link br.puc.molic.Element}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Element</em>' containment reference list.
     * @see br.puc.molic.MolicPackage#getDiagram_Element()
     * @model containment="true"
     * @generated
     */
	EList<Element> getElement();

	/**
     * Returns the value of the '<em><b>Utterance</b></em>' containment reference list.
     * The list contents are of type {@link br.puc.molic.Connection}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utterance</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Utterance</em>' containment reference list.
     * @see br.puc.molic.MolicPackage#getDiagram_Utterance()
     * @model containment="true"
     * @generated
     */
	EList<Connection> getUtterance();

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
     * @see br.puc.molic.MolicPackage#getDiagram_Goals()
     * @model
     * @generated
     */
    EList<String> getGoals();

} // Diagram