/**
 */
package org.ecsoya.eclipse.tutorial.library.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.ecsoya.eclipse.tutorial.library.LibraryFactory;
import org.ecsoya.eclipse.tutorial.library.Writer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Writer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WriterTest extends TestCase {

	/**
	 * The fixture for this Writer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Writer fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(WriterTest.class);
	}

	/**
	 * Constructs a new Writer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WriterTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Writer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Writer fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Writer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Writer getFixture() {
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
		setFixture(LibraryFactory.eINSTANCE.createWriter());
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

} //WriterTest
