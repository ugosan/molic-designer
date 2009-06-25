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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see br.puc.molic.MolicPackage
 * @generated
 */
public class MolicFactory extends EFactoryImpl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "MoLIC Designer (c) 2009 \nThis software is part of the MSc work of Ugo Braga Sangiorgi and may be freely distributed\nunder the terms of GNU General Public License v2\nhttp://www.gnu.org/licenses/gpl-2.0.html\n\nDeveloped at Semiotic Engineering Research Lab (SERG) - http://serg.inf.puc-rio.br\nPontifical Catholic University of Rio de Janeiro, PUCRio\n\n\nAuthor: Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MolicFactory eINSTANCE = init();

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MolicFactory init() {
		try {
			MolicFactory theMolicFactory = (MolicFactory)EPackage.Registry.INSTANCE.getEFactory("molic"); 
			if (theMolicFactory != null) {
				return theMolicFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MolicFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MolicFactory() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MolicPackage.DIAGRAM: return createDiagram();
			case MolicPackage.SCENE: return createScene();
			case MolicPackage.UTTERANCE: return createUtterance();
			case MolicPackage.BRT_UTTERANCE: return createBRTUtterance();
			case MolicPackage.SYSTEM_PROCESS: return createSystemProcess();
			case MolicPackage.UBIQUITOUS_ACCESS: return createUbiquitousAccess();
			case MolicPackage.OPENING_POINT: return createOpeningPoint();
			case MolicPackage.CLOSING_POINT: return createClosingPoint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram createDiagram() {
		Diagram diagram = new Diagram();
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scene createScene() {
		Scene scene = new Scene();
		return scene;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Utterance createUtterance() {
		Utterance utterance = new Utterance();
		return utterance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BRTUtterance createBRTUtterance() {
		BRTUtterance brtUtterance = new BRTUtterance();
		return brtUtterance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemProcess createSystemProcess() {
		SystemProcess systemProcess = new SystemProcess();
		return systemProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UbiquitousAccess createUbiquitousAccess() {
		UbiquitousAccess ubiquitousAccess = new UbiquitousAccess();
		return ubiquitousAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpeningPoint createOpeningPoint() {
		OpeningPoint openingPoint = new OpeningPoint();
		return openingPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClosingPoint createClosingPoint() {
		ClosingPoint closingPoint = new ClosingPoint();
		return closingPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MolicPackage getMolicPackage() {
		return (MolicPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MolicPackage getPackage() {
		return MolicPackage.eINSTANCE;
	}

} //MolicFactory
