/**
 */
package org.ecsoya.eclipse.tutorial.library;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ecsoya.eclipse.tutorial.library.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link org.ecsoya.eclipse.tutorial.library.Book#getWriter <em>Writer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ecsoya.eclipse.tutorial.library.LibraryPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.ecsoya.eclipse.tutorial.library.LibraryPackage#getBook_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.ecsoya.eclipse.tutorial.library.Book#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Writer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writer</em>' containment reference.
	 * @see #setWriter(Writer)
	 * @see org.ecsoya.eclipse.tutorial.library.LibraryPackage#getBook_Writer()
	 * @model containment="true"
	 * @generated
	 */
	Writer getWriter();

	/**
	 * Sets the value of the '{@link org.ecsoya.eclipse.tutorial.library.Book#getWriter <em>Writer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Writer</em>' containment reference.
	 * @see #getWriter()
	 * @generated
	 */
	void setWriter(Writer value);

} // Book
