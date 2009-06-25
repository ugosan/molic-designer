/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import br.puc.molic.Diagram;
import br.puc.molic.MolicFactory;
import br.puc.molic.MolicPackage;
import br.puc.molic.Scene;
import br.puc.molic.SystemProcess;
import br.puc.molic.Utterance;

/**
 * <!-- begin-user-doc -->
 * A sample utility for the '<em><b>molic</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MolicExample {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "MoLIC Designer (c) 2009 \nThis software is part of the MSc work of Ugo Braga Sangiorgi and may be freely distributed\nunder the terms of GNU General Public License v2\nhttp://www.gnu.org/licenses/gpl-2.0.html\n\nDeveloped at Semiotic Engineering Research Lab (SERG) - http://serg.inf.puc-rio.br\nPontifical Catholic University of Rio de Janeiro, PUCRio\n\n\nAuthor: Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br";

	/**
	 * <!-- begin-user-doc -->
	 * Load all the argument file paths or URIs as instances of the model.
	 * <!-- end-user-doc -->
	 * @param args the file paths or URIs.
	 * @generated NOT
	 */
	public static void main(String[] args) throws Exception{
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file extensions.
		//
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, 
				new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put(MolicPackage.eNS_URI, MolicPackage.eINSTANCE);

		Resource resource = resourceSet.createResource(URI.createURI("http:///My.molic"));

		//creates a Diagram
		Diagram diagram = MolicFactory.eINSTANCE.createDiagram();

		//creates a Scene
		Scene scene = MolicFactory.eINSTANCE.createScene();
		scene.setTopic("View All News");
		scene.setDialogue("d+u: news{ *title, *content, *category}");

		//creates a System Process
		SystemProcess sysProcess = MolicFactory.eINSTANCE.createSystemProcess();

		//creates a Utterance
		Utterance userUT = MolicFactory.eINSTANCE.createUtterance();
		userUT.setLabel("u: select news item");
		userUT.setSource(scene);
		userUT.setTarget(sysProcess);

		//creates a goal and reference it in all elements
				String goal = "List Front Page";
				diagram.getGoals().add(goal);
				scene.getGoals().add(goal);
				userUT.getGoals().add(goal);
				sysProcess.getGoals().add(goal);
		 

		//inserts the elements on the diagram
		diagram.getElement().add(scene);
		diagram.getElement().add(sysProcess);				
		diagram.getUtterance().add(userUT);

		//saves the resource
		resource.getContents().add(diagram);
		resource.save(System.out, null);
		
		
			 /*
			//to load
			for (int i = 0; i < args.length; ++i) {
				// Construct the URI for the instance file.
				// The argument is treated as a file path only if it denotes an existing file.
				// Otherwise, it's directly treated as a URL.
				//
				File file = new File(args[i]);
				URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()): URI.createURI(args[0]);

				try {
					// Demand load resource for this file.
					//
					Resource resource = resourceSet.getResource(uri, true);
					System.out.println("Loaded " + uri);

					// Validate the contents of the loaded resource.
					//
					for (EObject eObject : resource.getContents()) {
						Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
						if (diagnostic.getSeverity() != Diagnostic.OK) {
							printDiagnostic(diagnostic, "");
						}
					}
				}
				catch (RuntimeException exception) {
					System.out.println("Problem loading " + uri);
					exception.printStackTrace();
				}
			}
		*/

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

} //MolicExample
