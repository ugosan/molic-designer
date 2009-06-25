/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.puc.molic.tests;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.textui.TestRunner;
import br.puc.molic.MolicFactory;
import br.puc.molic.Scene;
import br.puc.molic.Utterance;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Utterance</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UtteranceTest extends TestCase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "MoLIC Designer (c) 2009 \nThis software is part of the MSc work of Ugo Braga Sangiorgi and may be freely distributed\nunder the terms of GNU General Public License v2\nhttp://www.gnu.org/licenses/gpl-2.0.html\n\nDeveloped at Semiotic Engineering Research Lab (SERG) - http://serg.inf.puc-rio.br\nPontifical Catholic University of Rio de Janeiro, PUCRio\n\n\nAuthor: Ugo Braga Sangiorgi - usangiorgi@inf.puc-rio.br";
	/**
	 * The fixture for this Utterance test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Utterance fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UtteranceTest.class);
	}

	/**
	 * Constructs a new Utterance test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UtteranceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Utterance test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Utterance fixture) {
		this.fixture = fixture;
	}

	//Utterance cant do a loop
	public void testLoop() {
		Scene s = MolicFactory.eINSTANCE.createScene();
		fixture.setSource(s);
		fixture.setTarget(s);		
		
		System.out.println(fixture.getSource());
		System.out.println(fixture.getTarget());
		
		assertTrue(fixture.getSource() == fixture.getTarget());		
	}

	/**
	 * Returns the fixture for this Utterance test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Utterance getFixture() {
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
		setFixture(MolicFactory.eINSTANCE.createUtterance());
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

} //UtteranceTest
