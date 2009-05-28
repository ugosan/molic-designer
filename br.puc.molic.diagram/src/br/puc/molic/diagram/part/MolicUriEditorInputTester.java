/*
 * SERG - Semiotic Engineering Research Group
 * This work is part of MSc thesis of Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br
 */
package br.puc.molic.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.common.ui.URIEditorInput;

/**
 * @generated
 */
public class MolicUriEditorInputTester extends PropertyTester {

    /**
     * @generated
     */
    public boolean test(Object receiver, String method, Object[] args,
            Object expectedValue) {
        if (false == receiver instanceof URIEditorInput) {
            return false;
        }
        URIEditorInput editorInput = (URIEditorInput) receiver;
        return "molic_diagram".equals(editorInput.getURI().fileExtension()); //$NON-NLS-1$
    }

}
