package br.puc.molic.tests;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import br.puc.molic.MolicPackage;
public class MolicLoadTest {

	public static void main(String[] args) throws Exception{

		ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, 
				new XMIResourceFactoryImpl());

		resourceSet.getPackageRegistry().put(MolicPackage.eNS_URI, MolicPackage.eINSTANCE);

		File file = new File("/home/ugo/default28.molic_diagram");
		URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()): URI.createURI(args[0]);

		Resource resource = resourceSet.getResource(uri, true);
		Map options = new HashMap();
		options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		resource.load(options); 
			
			// Validate the contents of the loaded resource.
			//
			for (EObject eObject : resource.getContents()) {
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					printDiagnostic(diagnostic, "");
				}
			}
		
		
		
	}
	
		
		/**
		 * <!-- begin-user-doc -->
		 * Prints diagnostics with indentation.
		 * <!-- end-user-doc -->
		 * @param diagnostic the diagnostic to print.
		 * @param indent the indentation for printing.
		 * @generated
		 */
		protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
			System.out.print(indent);
			System.out.println(diagnostic.getMessage());
			for (Diagnostic child : diagnostic.getChildren()) {
				printDiagnostic(child, indent + "  ");
			}
		}
}
