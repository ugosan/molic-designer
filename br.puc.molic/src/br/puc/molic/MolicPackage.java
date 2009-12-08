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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see br.puc.molic.MolicFactory
 * @model kind="package"
 * @generated
 */
public class MolicPackage extends EPackageImpl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "MoLIC Designer (c) 2009 \nThis software is part of the MSc work of Ugo Braga Sangiorgi and can be copied freely\n\nDeveloped at Semiotic Engineering Research Lab (SERG)\nPontifical Catholic University of Rio de Janeiro, PUCRio\n\nAuthor: Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "molic";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "molic";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "molic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MolicPackage eINSTANCE = br.puc.molic.MolicPackage.init();

	/**
	 * The meta object id for the '{@link br.puc.molic.Diagram <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.Diagram
	 * @see br.puc.molic.MolicPackage#getDiagram()
	 * @generated
	 */
	public static final int DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Utterance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM__UTTERANCE = 1;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM__GOALS = 2;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.puc.molic.Element <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.Element
	 * @see br.puc.molic.MolicPackage#getElement()
	 * @generated
	 */
	public static final int ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT__GOALS = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.puc.molic.Connection <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.Connection
	 * @see br.puc.molic.MolicPackage#getConnection()
	 * @generated
	 */
	public static final int CONNECTION = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION__TARGET = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION__ID = 3;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION__GOALS = 4;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link br.puc.molic.Scene <em>Scene</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.Scene
	 * @see br.puc.molic.MolicPackage#getScene()
	 * @generated
	 */
	public static final int SCENE = 3;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SCENE__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SCENE__GOALS = ELEMENT__GOALS;

	/**
	 * The feature id for the '<em><b>Topic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SCENE__TOPIC = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dialogue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SCENE__DIALOGUE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SCENE__NAME = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sketch</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SCENE__SKETCH = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Scene</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SCENE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link br.puc.molic.Utterance <em>Utterance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.Utterance
	 * @see br.puc.molic.MolicPackage#getUtterance()
	 * @generated
	 */
	public static final int UTTERANCE = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UTTERANCE__LABEL = CONNECTION__LABEL;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UTTERANCE__SOURCE = CONNECTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UTTERANCE__TARGET = CONNECTION__TARGET;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UTTERANCE__ID = CONNECTION__ID;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UTTERANCE__GOALS = CONNECTION__GOALS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UTTERANCE__NAME = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Utterance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UTTERANCE_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.puc.molic.BRTUtterance <em>BRT Utterance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.BRTUtterance
	 * @see br.puc.molic.MolicPackage#getBRTUtterance()
	 * @generated
	 */
	public static final int BRT_UTTERANCE = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BRT_UTTERANCE__LABEL = CONNECTION__LABEL;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BRT_UTTERANCE__SOURCE = CONNECTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BRT_UTTERANCE__TARGET = CONNECTION__TARGET;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BRT_UTTERANCE__ID = CONNECTION__ID;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BRT_UTTERANCE__GOALS = CONNECTION__GOALS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BRT_UTTERANCE__NAME = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BRT Utterance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BRT_UTTERANCE_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.puc.molic.SystemProcess <em>System Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.SystemProcess
	 * @see br.puc.molic.MolicPackage#getSystemProcess()
	 * @generated
	 */
	public static final int SYSTEM_PROCESS = 6;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_PROCESS__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_PROCESS__GOALS = ELEMENT__GOALS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_PROCESS__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_PROCESS_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.puc.molic.UbiquitousAccess <em>Ubiquitous Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.UbiquitousAccess
	 * @see br.puc.molic.MolicPackage#getUbiquitousAccess()
	 * @generated
	 */
	public static final int UBIQUITOUS_ACCESS = 7;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UBIQUITOUS_ACCESS__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UBIQUITOUS_ACCESS__GOALS = ELEMENT__GOALS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UBIQUITOUS_ACCESS__LABEL = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UBIQUITOUS_ACCESS__NAME = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ubiquitous Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UBIQUITOUS_ACCESS_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link br.puc.molic.OpeningPoint <em>Opening Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.OpeningPoint
	 * @see br.puc.molic.MolicPackage#getOpeningPoint()
	 * @generated
	 */
	public static final int OPENING_POINT = 8;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OPENING_POINT__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OPENING_POINT__GOALS = ELEMENT__GOALS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OPENING_POINT__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Opening Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OPENING_POINT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.puc.molic.ClosingPoint <em>Closing Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.ClosingPoint
	 * @see br.puc.molic.MolicPackage#getClosingPoint()
	 * @generated
	 */
	public static final int CLOSING_POINT = 9;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLOSING_POINT__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLOSING_POINT__GOALS = ELEMENT__GOALS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLOSING_POINT__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Closing Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLOSING_POINT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.puc.molic.Sketch <em>Sketch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.puc.molic.Sketch
	 * @see br.puc.molic.MolicPackage#getSketch()
	 * @generated
	 */
	public static final int SKETCH = 10;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SKETCH__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SKETCH__GOALS = ELEMENT__GOALS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SKETCH__IMAGE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sketch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SKETCH_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sceneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass utteranceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass brtUtteranceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ubiquitousAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openingPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closingPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sketchEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see br.puc.molic.MolicPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MolicPackage() {
		super(eNS_URI, MolicFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MolicPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MolicPackage init() {
		if (isInited) return (MolicPackage)EPackage.Registry.INSTANCE.getEPackage(MolicPackage.eNS_URI);

		// Obtain or create and register package
		MolicPackage theMolicPackage = (MolicPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MolicPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MolicPackage());

		isInited = true;

		// Create package meta-data objects
		theMolicPackage.createPackageContents();

		// Initialize created meta-data
		theMolicPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMolicPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MolicPackage.eNS_URI, theMolicPackage);
		return theMolicPackage;
	}


	/**
	 * Returns the meta object for class '{@link br.puc.molic.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see br.puc.molic.Diagram
	 * @generated
	 */
	public EClass getDiagram() {
		return diagramEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link br.puc.molic.Diagram#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see br.puc.molic.Diagram#getElement()
	 * @see #getDiagram()
	 * @generated
	 */
	public EReference getDiagram_Element() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link br.puc.molic.Diagram#getUtterance <em>Utterance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Utterance</em>'.
	 * @see br.puc.molic.Diagram#getUtterance()
	 * @see #getDiagram()
	 * @generated
	 */
	public EReference getDiagram_Utterance() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute list '{@link br.puc.molic.Diagram#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Goals</em>'.
	 * @see br.puc.molic.Diagram#getGoals()
	 * @see #getDiagram()
	 * @generated
	 */
	public EAttribute getDiagram_Goals() {
		return (EAttribute)diagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link br.puc.molic.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see br.puc.molic.Element
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.Element#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see br.puc.molic.Element#getID()
	 * @see #getElement()
	 * @generated
	 */
	public EAttribute getElement_ID() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute list '{@link br.puc.molic.Element#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Goals</em>'.
	 * @see br.puc.molic.Element#getGoals()
	 * @see #getElement()
	 * @generated
	 */
	public EAttribute getElement_Goals() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link br.puc.molic.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see br.puc.molic.Connection
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.Connection#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see br.puc.molic.Connection#getLabel()
	 * @see #getConnection()
	 * @generated
	 */
	public EAttribute getConnection_Label() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link br.puc.molic.Connection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see br.puc.molic.Connection#getSource()
	 * @see #getConnection()
	 * @generated
	 */
	public EReference getConnection_Source() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the reference '{@link br.puc.molic.Connection#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see br.puc.molic.Connection#getTarget()
	 * @see #getConnection()
	 * @generated
	 */
	public EReference getConnection_Target() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.Connection#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see br.puc.molic.Connection#getID()
	 * @see #getConnection()
	 * @generated
	 */
	public EAttribute getConnection_ID() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the attribute list '{@link br.puc.molic.Connection#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Goals</em>'.
	 * @see br.puc.molic.Connection#getGoals()
	 * @see #getConnection()
	 * @generated
	 */
	public EAttribute getConnection_Goals() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for class '{@link br.puc.molic.Scene <em>Scene</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scene</em>'.
	 * @see br.puc.molic.Scene
	 * @generated
	 */
	public EClass getScene() {
		return sceneEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.Scene#getTopic <em>Topic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Topic</em>'.
	 * @see br.puc.molic.Scene#getTopic()
	 * @see #getScene()
	 * @generated
	 */
	public EAttribute getScene_Topic() {
		return (EAttribute)sceneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.Scene#getDialogue <em>Dialogue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dialogue</em>'.
	 * @see br.puc.molic.Scene#getDialogue()
	 * @see #getScene()
	 * @generated
	 */
	public EAttribute getScene_Dialogue() {
		return (EAttribute)sceneEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.Scene#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.puc.molic.Scene#getName()
	 * @see #getScene()
	 * @generated
	 */
	public EAttribute getScene_Name() {
		return (EAttribute)sceneEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link br.puc.molic.Scene#getSketch <em>Sketch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sketch</em>'.
	 * @see br.puc.molic.Scene#getSketch()
	 * @see #getScene()
	 * @generated
	 */
	public EReference getScene_Sketch() {
		return (EReference)sceneEClass.getEStructuralFeatures().get(3);
	}


	/**
	 * Returns the meta object for class '{@link br.puc.molic.Utterance <em>Utterance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Utterance</em>'.
	 * @see br.puc.molic.Utterance
	 * @generated
	 */
	public EClass getUtterance() {
		return utteranceEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.Utterance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.puc.molic.Utterance#getName()
	 * @see #getUtterance()
	 * @generated
	 */
	public EAttribute getUtterance_Name() {
		return (EAttribute)utteranceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link br.puc.molic.BRTUtterance <em>BRT Utterance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BRT Utterance</em>'.
	 * @see br.puc.molic.BRTUtterance
	 * @generated
	 */
	public EClass getBRTUtterance() {
		return brtUtteranceEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.BRTUtterance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.puc.molic.BRTUtterance#getName()
	 * @see #getBRTUtterance()
	 * @generated
	 */
	public EAttribute getBRTUtterance_Name() {
		return (EAttribute)brtUtteranceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link br.puc.molic.SystemProcess <em>System Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Process</em>'.
	 * @see br.puc.molic.SystemProcess
	 * @generated
	 */
	public EClass getSystemProcess() {
		return systemProcessEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.SystemProcess#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.puc.molic.SystemProcess#getName()
	 * @see #getSystemProcess()
	 * @generated
	 */
	public EAttribute getSystemProcess_Name() {
		return (EAttribute)systemProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link br.puc.molic.UbiquitousAccess <em>Ubiquitous Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ubiquitous Access</em>'.
	 * @see br.puc.molic.UbiquitousAccess
	 * @generated
	 */
	public EClass getUbiquitousAccess() {
		return ubiquitousAccessEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.UbiquitousAccess#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see br.puc.molic.UbiquitousAccess#getLabel()
	 * @see #getUbiquitousAccess()
	 * @generated
	 */
	public EAttribute getUbiquitousAccess_Label() {
		return (EAttribute)ubiquitousAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.UbiquitousAccess#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.puc.molic.UbiquitousAccess#getName()
	 * @see #getUbiquitousAccess()
	 * @generated
	 */
	public EAttribute getUbiquitousAccess_Name() {
		return (EAttribute)ubiquitousAccessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link br.puc.molic.OpeningPoint <em>Opening Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opening Point</em>'.
	 * @see br.puc.molic.OpeningPoint
	 * @generated
	 */
	public EClass getOpeningPoint() {
		return openingPointEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.OpeningPoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.puc.molic.OpeningPoint#getName()
	 * @see #getOpeningPoint()
	 * @generated
	 */
	public EAttribute getOpeningPoint_Name() {
		return (EAttribute)openingPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link br.puc.molic.ClosingPoint <em>Closing Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Closing Point</em>'.
	 * @see br.puc.molic.ClosingPoint
	 * @generated
	 */
	public EClass getClosingPoint() {
		return closingPointEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.ClosingPoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.puc.molic.ClosingPoint#getName()
	 * @see #getClosingPoint()
	 * @generated
	 */
	public EAttribute getClosingPoint_Name() {
		return (EAttribute)closingPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link br.puc.molic.Sketch <em>Sketch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sketch</em>'.
	 * @see br.puc.molic.Sketch
	 * @generated
	 */
	public EClass getSketch() {
		return sketchEClass;
	}


	/**
	 * Returns the meta object for the attribute '{@link br.puc.molic.Sketch#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see br.puc.molic.Sketch#getImage()
	 * @see #getSketch()
	 * @generated
	 */
	public EAttribute getSketch_Image() {
		return (EAttribute)sketchEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public MolicFactory getMolicFactory() {
		return (MolicFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		diagramEClass = createEClass(DIAGRAM);
		createEReference(diagramEClass, DIAGRAM__ELEMENT);
		createEReference(diagramEClass, DIAGRAM__UTTERANCE);
		createEAttribute(diagramEClass, DIAGRAM__GOALS);

		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__ID);
		createEAttribute(elementEClass, ELEMENT__GOALS);

		connectionEClass = createEClass(CONNECTION);
		createEAttribute(connectionEClass, CONNECTION__LABEL);
		createEReference(connectionEClass, CONNECTION__SOURCE);
		createEReference(connectionEClass, CONNECTION__TARGET);
		createEAttribute(connectionEClass, CONNECTION__ID);
		createEAttribute(connectionEClass, CONNECTION__GOALS);

		sceneEClass = createEClass(SCENE);
		createEAttribute(sceneEClass, SCENE__TOPIC);
		createEAttribute(sceneEClass, SCENE__DIALOGUE);
		createEAttribute(sceneEClass, SCENE__NAME);
		createEReference(sceneEClass, SCENE__SKETCH);

		utteranceEClass = createEClass(UTTERANCE);
		createEAttribute(utteranceEClass, UTTERANCE__NAME);

		brtUtteranceEClass = createEClass(BRT_UTTERANCE);
		createEAttribute(brtUtteranceEClass, BRT_UTTERANCE__NAME);

		systemProcessEClass = createEClass(SYSTEM_PROCESS);
		createEAttribute(systemProcessEClass, SYSTEM_PROCESS__NAME);

		ubiquitousAccessEClass = createEClass(UBIQUITOUS_ACCESS);
		createEAttribute(ubiquitousAccessEClass, UBIQUITOUS_ACCESS__LABEL);
		createEAttribute(ubiquitousAccessEClass, UBIQUITOUS_ACCESS__NAME);

		openingPointEClass = createEClass(OPENING_POINT);
		createEAttribute(openingPointEClass, OPENING_POINT__NAME);

		closingPointEClass = createEClass(CLOSING_POINT);
		createEAttribute(closingPointEClass, CLOSING_POINT__NAME);

		sketchEClass = createEClass(SKETCH);
		createEAttribute(sketchEClass, SKETCH__IMAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sceneEClass.getESuperTypes().add(this.getElement());
		utteranceEClass.getESuperTypes().add(this.getConnection());
		brtUtteranceEClass.getESuperTypes().add(this.getConnection());
		systemProcessEClass.getESuperTypes().add(this.getElement());
		ubiquitousAccessEClass.getESuperTypes().add(this.getElement());
		openingPointEClass.getESuperTypes().add(this.getElement());
		closingPointEClass.getESuperTypes().add(this.getElement());
		sketchEClass.getESuperTypes().add(this.getElement());

		// Initialize classes and features; add operations and parameters
		initEClass(diagramEClass, Diagram.class, "Diagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagram_Element(), this.getElement(), null, "element", null, 0, -1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagram_Utterance(), this.getConnection(), null, "utterance", null, 0, -1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagram_Goals(), ecorePackage.getEString(), "goals", null, 0, -1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_ID(), ecorePackage.getEString(), "ID", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement_Goals(), ecorePackage.getEString(), "goals", null, 0, -1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnection_Label(), ecorePackage.getEString(), "label", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnection_Source(), this.getElement(), null, "source", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnection_Target(), this.getElement(), null, "target", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_ID(), ecorePackage.getEString(), "ID", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_Goals(), ecorePackage.getEString(), "goals", null, 0, -1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sceneEClass, Scene.class, "Scene", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScene_Topic(), ecorePackage.getEString(), "topic", null, 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScene_Dialogue(), ecorePackage.getEString(), "dialogue", null, 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScene_Name(), ecorePackage.getEString(), "name", "Scene", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScene_Sketch(), this.getSketch(), null, "sketch", null, 0, -1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(utteranceEClass, Utterance.class, "Utterance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUtterance_Name(), ecorePackage.getEString(), "name", "Utterance", 0, 1, Utterance.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(brtUtteranceEClass, BRTUtterance.class, "BRTUtterance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBRTUtterance_Name(), ecorePackage.getEString(), "name", "Breakdown Utterance", 0, 1, BRTUtterance.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemProcessEClass, SystemProcess.class, "SystemProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystemProcess_Name(), ecorePackage.getEString(), "name", "System Process", 0, 1, SystemProcess.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ubiquitousAccessEClass, UbiquitousAccess.class, "UbiquitousAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUbiquitousAccess_Label(), ecorePackage.getEString(), "label", null, 0, 1, UbiquitousAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUbiquitousAccess_Name(), ecorePackage.getEString(), "name", "Ubiquitous Access", 0, 1, UbiquitousAccess.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openingPointEClass, OpeningPoint.class, "OpeningPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpeningPoint_Name(), ecorePackage.getEString(), "name", "Opening Point", 0, 1, OpeningPoint.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(closingPointEClass, ClosingPoint.class, "ClosingPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClosingPoint_Name(), ecorePackage.getEString(), "name", "Closing Point", 0, 1, ClosingPoint.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sketchEClass, Sketch.class, "Sketch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSketch_Image(), ecorePackage.getEString(), "image", null, 0, 1, Sketch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link br.puc.molic.Diagram <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.Diagram
		 * @see br.puc.molic.MolicPackage#getDiagram()
		 * @generated
		 */
		public static final EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM__ELEMENT = eINSTANCE.getDiagram_Element();

		/**
		 * The meta object literal for the '<em><b>Utterance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM__UTTERANCE = eINSTANCE.getDiagram_Utterance();

		/**
		 * The meta object literal for the '<em><b>Goals</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM__GOALS = eINSTANCE.getDiagram_Goals();

		/**
		 * The meta object literal for the '{@link br.puc.molic.Element <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.Element
		 * @see br.puc.molic.MolicPackage#getElement()
		 * @generated
		 */
		public static final EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ELEMENT__ID = eINSTANCE.getElement_ID();

		/**
		 * The meta object literal for the '<em><b>Goals</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ELEMENT__GOALS = eINSTANCE.getElement_Goals();

		/**
		 * The meta object literal for the '{@link br.puc.molic.Connection <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.Connection
		 * @see br.puc.molic.MolicPackage#getConnection()
		 * @generated
		 */
		public static final EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION__LABEL = eINSTANCE.getConnection_Label();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference CONNECTION__SOURCE = eINSTANCE.getConnection_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference CONNECTION__TARGET = eINSTANCE.getConnection_Target();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION__ID = eINSTANCE.getConnection_ID();

		/**
		 * The meta object literal for the '<em><b>Goals</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION__GOALS = eINSTANCE.getConnection_Goals();

		/**
		 * The meta object literal for the '{@link br.puc.molic.Scene <em>Scene</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.Scene
		 * @see br.puc.molic.MolicPackage#getScene()
		 * @generated
		 */
		public static final EClass SCENE = eINSTANCE.getScene();

		/**
		 * The meta object literal for the '<em><b>Topic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute SCENE__TOPIC = eINSTANCE.getScene_Topic();

		/**
		 * The meta object literal for the '<em><b>Dialogue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute SCENE__DIALOGUE = eINSTANCE.getScene_Dialogue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute SCENE__NAME = eINSTANCE.getScene_Name();

		/**
		 * The meta object literal for the '<em><b>Sketch</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SCENE__SKETCH = eINSTANCE.getScene_Sketch();

		/**
		 * The meta object literal for the '{@link br.puc.molic.Utterance <em>Utterance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.Utterance
		 * @see br.puc.molic.MolicPackage#getUtterance()
		 * @generated
		 */
		public static final EClass UTTERANCE = eINSTANCE.getUtterance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute UTTERANCE__NAME = eINSTANCE.getUtterance_Name();

		/**
		 * The meta object literal for the '{@link br.puc.molic.BRTUtterance <em>BRT Utterance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.BRTUtterance
		 * @see br.puc.molic.MolicPackage#getBRTUtterance()
		 * @generated
		 */
		public static final EClass BRT_UTTERANCE = eINSTANCE.getBRTUtterance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BRT_UTTERANCE__NAME = eINSTANCE.getBRTUtterance_Name();

		/**
		 * The meta object literal for the '{@link br.puc.molic.SystemProcess <em>System Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.SystemProcess
		 * @see br.puc.molic.MolicPackage#getSystemProcess()
		 * @generated
		 */
		public static final EClass SYSTEM_PROCESS = eINSTANCE.getSystemProcess();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute SYSTEM_PROCESS__NAME = eINSTANCE.getSystemProcess_Name();

		/**
		 * The meta object literal for the '{@link br.puc.molic.UbiquitousAccess <em>Ubiquitous Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.UbiquitousAccess
		 * @see br.puc.molic.MolicPackage#getUbiquitousAccess()
		 * @generated
		 */
		public static final EClass UBIQUITOUS_ACCESS = eINSTANCE.getUbiquitousAccess();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute UBIQUITOUS_ACCESS__LABEL = eINSTANCE.getUbiquitousAccess_Label();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute UBIQUITOUS_ACCESS__NAME = eINSTANCE.getUbiquitousAccess_Name();

		/**
		 * The meta object literal for the '{@link br.puc.molic.OpeningPoint <em>Opening Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.OpeningPoint
		 * @see br.puc.molic.MolicPackage#getOpeningPoint()
		 * @generated
		 */
		public static final EClass OPENING_POINT = eINSTANCE.getOpeningPoint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute OPENING_POINT__NAME = eINSTANCE.getOpeningPoint_Name();

		/**
		 * The meta object literal for the '{@link br.puc.molic.ClosingPoint <em>Closing Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.ClosingPoint
		 * @see br.puc.molic.MolicPackage#getClosingPoint()
		 * @generated
		 */
		public static final EClass CLOSING_POINT = eINSTANCE.getClosingPoint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CLOSING_POINT__NAME = eINSTANCE.getClosingPoint_Name();

		/**
		 * The meta object literal for the '{@link br.puc.molic.Sketch <em>Sketch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.puc.molic.Sketch
		 * @see br.puc.molic.MolicPackage#getSketch()
		 * @generated
		 */
		public static final EClass SKETCH = eINSTANCE.getSketch();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute SKETCH__IMAGE = eINSTANCE.getSketch_Image();

	}

} //MolicPackage
