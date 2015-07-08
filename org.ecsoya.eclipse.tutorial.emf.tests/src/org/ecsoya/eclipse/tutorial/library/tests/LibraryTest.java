/**
 */
package org.ecsoya.eclipse.tutorial.library.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.ecsoya.eclipse.tutorial.library.Library;
import org.ecsoya.eclipse.tutorial.library.LibraryFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LibraryTest extends TestCase {

	/**
	 * The fixture for this Library test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Library fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LibraryTest.class);
	}

	/**
	 * Constructs a new Library test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Library test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Library fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Library test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Library getFixture() {
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
		setFixture(LibraryFactory.eINSTANCE.createLibrary());
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

} //LibraryTest
