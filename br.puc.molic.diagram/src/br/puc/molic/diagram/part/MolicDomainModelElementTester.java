/*
 * SERG - Semiotic Engineering Research Group
 * This work is part of MSc thesis of Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br
 */
package br.puc.molic.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import br.puc.molic.MolicPackage;

/**
 * @generated
 */
public class MolicDomainModelElementTester extends PropertyTester {

    /**
     * @generated
     */
    public boolean test(Object receiver, String method, Object[] args,
            Object expectedValue) {
        if (false == receiver instanceof EObject) {
            return false;
        }
        EObject eObject = (EObject) receiver;
        EClass eClass = eObject.eClass();
        if (eClass == MolicPackage.eINSTANCE.getDiagram()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getElement()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getConnection()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getScene()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getMonologue()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getUtterance()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getBRTUtterance()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getSystemProcess()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getUbiquitousAccess()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getOpeningPoint()) {
            return true;
        }
        if (eClass == MolicPackage.eINSTANCE.getClosingPoint()) {
            return true;
        }
        return false;
    }

}
