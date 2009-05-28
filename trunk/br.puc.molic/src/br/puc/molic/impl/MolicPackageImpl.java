/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import br.puc.molic.BRTUtterance;
import br.puc.molic.ClosingPoint;
import br.puc.molic.Connection;
import br.puc.molic.Diagram;
import br.puc.molic.Element;

import br.puc.molic.MolicFactory;
import br.puc.molic.MolicPackage;
import br.puc.molic.Monologue;
import br.puc.molic.OpeningPoint;
import br.puc.molic.Scene;
import br.puc.molic.SystemProcess;
import br.puc.molic.UbiquitousAccess;
import br.puc.molic.Utterance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MolicPackageImpl extends EPackageImpl implements MolicPackage {
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
	private EClass sceneEClass = null;

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
	private EClass utteranceEClass = null;

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
	private EClass monologueEClass = null;

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
	private EClass connectionEClass = null;

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
	private MolicPackageImpl() {
        super(eNS_URI, MolicFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
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
        MolicPackageImpl theMolicPackage = (MolicPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MolicPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MolicPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theMolicPackage.createPackageContents();

        // Initialize created meta-data
        theMolicPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMolicPackage.freeze();

        return theMolicPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDiagram() {
        return diagramEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDiagram_Element() {
        return (EReference)diagramEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDiagram_Utterance() {
        return (EReference)diagramEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagram_Goals() {
        return (EAttribute)diagramEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getScene() {
        return sceneEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getScene_Topic() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getScene_Dialogue() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_Name() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getElement() {
        return elementEClass;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getElement_ID() {
        return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getElement_Goals() {
        return (EAttribute)elementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getUtterance() {
        return utteranceEClass;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUtterance_Name() {
        return (EAttribute)utteranceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSystemProcess() {
        return systemProcessEClass;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSystemProcess_Name() {
        return (EAttribute)systemProcessEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMonologue() {
        return monologueEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMonologue_Label() {
        return (EAttribute)monologueEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getBRTUtterance() {
        return brtUtteranceEClass;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBRTUtterance_Name() {
        return (EAttribute)brtUtteranceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getUbiquitousAccess() {
        return ubiquitousAccessEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getUbiquitousAccess_Label() {
        return (EAttribute)ubiquitousAccessEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUbiquitousAccess_Name() {
        return (EAttribute)ubiquitousAccessEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOpeningPoint() {
        return openingPointEClass;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOpeningPoint_Name() {
        return (EAttribute)openingPointEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getClosingPoint() {
        return closingPointEClass;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getClosingPoint_Name() {
        return (EAttribute)closingPointEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getConnection() {
        return connectionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConnection_Label() {
        return (EAttribute)connectionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConnection_Source() {
        return (EReference)connectionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConnection_Target() {
        return (EReference)connectionEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnection_ID() {
        return (EAttribute)connectionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnection_Goals() {
        return (EAttribute)connectionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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

        monologueEClass = createEClass(MONOLOGUE);
        createEAttribute(monologueEClass, MONOLOGUE__LABEL);

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
        monologueEClass.getESuperTypes().add(this.getElement());
        utteranceEClass.getESuperTypes().add(this.getConnection());
        brtUtteranceEClass.getESuperTypes().add(this.getConnection());
        systemProcessEClass.getESuperTypes().add(this.getElement());
        ubiquitousAccessEClass.getESuperTypes().add(this.getElement());
        openingPointEClass.getESuperTypes().add(this.getElement());
        closingPointEClass.getESuperTypes().add(this.getElement());

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

        initEClass(monologueEClass, Monologue.class, "Monologue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMonologue_Label(), ecorePackage.getEString(), "label", null, 0, 1, Monologue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

        // Create resource
        createResource(eNS_URI);
    }

} //MolicPackageImpl
