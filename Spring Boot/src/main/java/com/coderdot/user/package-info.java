

/**
 * This package holds all functionality related to user management for CarRental.
 * @author [Yogeshkumar Ghanshyambhai Lakhani]
 *
 * <h1>Package Overview</h1>
 *
 * <h2>User</h2>
 * <ul>
 *     <li><strong>User Entity:</strong> Represents the user data within the application. It includes properties such as <em>id</em>, <em>name</em>, <em>email</em>, <em>password</em>, and <em>userRole</em>. Annotated with <code>@Entity</code> and mapped to the "users" table in the database.</li>
 *     <li><strong>UserDto:</strong> A Data Transfer Object for User, used to transfer user data between layers without exposing sensitive information like passwords.</li>
 *     <li><strong>UserRole:</strong> An enumeration representing different roles a user can have, such as <code>ADMIN</code> and <code>CUSTOMER</code>.</li>
 *     <li><strong>SignupRequest:</strong> A model representing the data required to sign up a new user, including <em>email</em>, <em>name</em>, and <em>password</em>.</li>
 * </ul>
 *
 * <h3>LOMBOK Usage:</h3>
 *
 * <ul>
 *     <li><code>@Data</code> - Generates getters, setters, <code>toString</code>, <code>equals</code>, and <code>hashCode</code> methods for the class.</li>
 *     <li><code>@Entity</code> - Specifies that the class is a JPA entity.</li>
 *     <li><code>@Table</code> - Specifies the table name in the database.</li>
 *     <li><code>@Id</code>, <code>@GeneratedValue</code> - Used to specify the primary key and its generation strategy.</li>
 *     <li><code>@Enumerated(EnumType.STRING)</code> - Indicates that the <em>userRole</em> field should be persisted as a string in the database.</li>
 * </ul>
 *
 * ///////////////////////////////////
 *
 * <h2>UserRepository</h2>
 * <ul>
 *     <li><strong>UserRepository:</strong> Extends <code>JpaRepository</code> to provide CRUD operations for User entities.</li>
 *     <li>Includes a method <code>findFirstByEmail(String email)</code> to find a user by their email address.</li>
 * </ul>
 *
 * <h3>Spring Data JPA Usage:</h3>
 *
 * <ul>
 *     <li><code>@Repository</code> - Indicates that the class is a Spring Data Repository.</li>
 *     <li><code>JpaRepository</code> - Provides JPA related methods such as saving, deleting, and finding entities.</li>
 * </ul>
 *
 * ///////////////////////////////////
 */


package com.coderdot.user;


