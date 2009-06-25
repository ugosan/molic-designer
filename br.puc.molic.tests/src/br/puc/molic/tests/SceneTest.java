/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import br.puc.molic.MolicFactory;
import br.puc.molic.Scene;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Scene</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SceneTest extends TestCase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "MoLIC Designer (c) 2009 \nThis software is part of the MSc work of Ugo Braga Sangiorgi and may be freely distributed\nunder the terms of GNU General Public License v2\nhttp://www.gnu.org/licenses/gpl-2.0.html\n\nDeveloped at Semiotic Engineering Research Lab (SERG) - http://serg.inf.puc-rio.br\nPontifical Catholic University of Rio de Janeiro, PUCRio\n\n\nAuthor: Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br";
	/**
	 * The fixture for this Scene test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Scene fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SceneTest.class);
	}

	/**
	 * Constructs a new Scene test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SceneTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Scene test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Scene fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Scene test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Scene getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MolicFactory.eINSTANCE.createScene());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //SceneTest
