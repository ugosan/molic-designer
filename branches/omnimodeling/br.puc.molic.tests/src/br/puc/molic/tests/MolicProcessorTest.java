/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import br.puc.molic.MolicPackage;
import br.puc.molic.impl.DiagramImpl;

/**
 * <!-- begin-user-doc --> A sample utility for the '<em><b>molic</b></em>'
 * package. <!-- end-user-doc -->
 * 
 * @generated
 */
public class MolicProcessorTest {
    /**
     * <!-- begin-user-doc --> Load all the argument file paths or URIs as
     * instances of the model. <!-- end-user-doc -->
     * 
     * @param args
     *            the file paths or URIs.
     * @generated
     */
    public static void main(String[] args) throws Exception {
        
        System.out.println("Wait..");
        // Create a resource set to hold the resources.
        //
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register the appropriate resource factory to handle all file
        // extensions.
        //
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                        new XMIResourceFactoryImpl());

        // Register the package to ensure it is available during loading.
        //
        resourceSet.getPackageRegistry().put(MolicPackage.eNS_URI,
                MolicPackage.eINSTANCE);

        URI uri = URI.createFileURI("/home/ugo/default14.molic_diagram");

        // Demand load resource for this file.
        //
        Resource resource = resourceSet.createResource(uri);

        Map options = new HashMap();
        options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
        options.put(XMIResource.OPTION_USE_XMI_TYPE,  Boolean.TRUE); 
        resource.load(options);
        System.out.println("Loaded " + uri);

        
        // Show the contents of the loaded resource.
        //
        br.puc.molic.impl.DiagramImpl diagram = (DiagramImpl) resource.getContents().get(0);
       
        for (Iterator j = diagram.eAllContents(); j.hasNext();) {
            EObjectImpl impl = (EObjectImpl) j.next();
            
           
            System.out.println(j.next());
        }

    }

    /**
     * <!-- begin-user-doc --> Prints diagnostics with indentation. <!--
     * end-user-doc -->
     * 
     * @param diagnostic
     *            the diagnostic to print.
     * @param indent
     *            the indentation for printing.
     * @generated
     */
    protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
        System.out.print(indent);
        System.out.println(diagnostic.getMessage());
        for (Iterator i = diagnostic.getChildren().iterator(); i.hasNext();) {
            printDiagnostic((Diagnostic) i.next(), indent + "  ");
        }
    }

} // MolicExample
